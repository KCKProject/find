package find.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.vo.FindBoard;
import find.vo.FindBoardWriteCommand;
import find.vo.MemberAuthInfo;
import find.vo.UploadImgVo;

@Service
public class FindBoardWriteService {

	@Autowired
	private FindDao dao;

	public FindBoardWriteService(FindDao dao) {
		this.dao = dao; 
	}
	
	String where = "findNum";
	// 글 등록
	public void boardRegist(FindBoardWriteCommand fc, 
			HttpSession session,
			MultipartHttpServletRequest request) throws IOException {
		
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		
		String term = fc.getTerm();
		
		if(term==null) {
			member.setEmail("비공개");
			member.setPhone("비공개");
		}else if(term.equals("phoneAgree")) {
			member.setEmail("비공개");
		}else if(term.equals("emailAgree")) {
			member.setPhone("비공개");
		}

		// 이미지 업로드
		FindBoard fb = new FindBoard();

		MultipartFile[] img = fc.getImg();
		String originalFile = null;
		String originalFileExtension=null;
		String storedFileName = null;
		String filePath = null;

		int num = img.length;
		System.out.println("num : "+num);
		
		System.out.println();
		filePath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
	
		System.out.println(filePath+" : 저장된 경로");

		fb.setTitle(fc.getTitle());
		fb.setWriter(member.getUserId());
		fb.setLocation(fc.getLocation());
		fb.setCharacter(fc.getCharacter());
		fb.setKind(fc.getKind());
		fb.setGender(fc.getGender());
		fb.setEmail(member.getEmail());
		fb.setPhone(member.getPhone());
		fb.setFindDate(fc.getFindDate());
		fb.setMemo(fc.getMemo());
		//fb.setOriginalFile(originalFile);
		//fb.setOriginalFileExtension(originalFileExtension);
		//fb.setStoredFileName(storedFileName);

		List<FindBoard> findBoard = dao.writeFindBoard(fb);
		long BoardNum = findBoard.get(0).getBoardNum();
		
		if(num!=0) { // 사진 등록했을 때
			originalFile = img[0].getOriginalFilename();
			if(originalFile!="") {
				for(MultipartFile f : img) {
					UploadImgVo uVo = new UploadImgVo();
					originalFile = f.getOriginalFilename();
					originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
					storedFileName = UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
					File file = new File(filePath,storedFileName);
					f.transferTo(file);
					
					System.out.println("originalFile : "+originalFile);
					System.out.println("originalFileExtension : "+originalFileExtension);
					System.out.println("storedFileName : "+storedFileName);
					
					uVo.setOriginalFile(originalFile);
					uVo.setOriginalFileExtension(originalFileExtension);
					uVo.setStoredFileName(storedFileName);
					String board = "findBoard";
					dao.writeBoardImg(uVo, BoardNum, board);
				}
			}
		}
	}

	// 후기 등록
	public void writeReview(String review, long boardNum) {
		dao.writeReview(review, boardNum);
	}

	// 글 수정
	public void modifyFind(FindBoardWriteCommand fc, FindBoard detail, 
			MemberAuthInfo member, MultipartHttpServletRequest request, List<UploadImgVo> imgs) throws IOException {
		long boardNum = detail.getBoardNum();
		
		String email = fc.getEmail();
		String phone = fc.getPhone();
		if(email==null) {
			member.setEmail("비공개");
		}
		if(phone==null) {
			member.setPhone("비공개");
		}

		FindBoard fb = new FindBoard();

		fb.setTitle(fc.getTitle());
		fb.setWriter(member.getUserId());
		fb.setLocation(fc.getLocation());
		fb.setCharacter(fc.getCharacter());
		fb.setKind(fc.getKind());
		fb.setGender(fc.getGender());
		fb.setEmail(email);
		fb.setPhone(phone);
		fb.setFindDate(fc.getFindDate());
		fb.setMemo(fc.getMemo());

		dao.modifyFindBoard(fb, boardNum);
		
		// 이미지 수정
		// 기존 이미지 삭제 내역 확인
		List<UploadImgVo> prevImg = dao.selectUploadImgByBoardNum(boardNum, where);
		String[] maintain = fc.getOriginalFile();
		for(UploadImgVo pr : prevImg) {
			String chk = "";
			String prevName = pr.getStoredFileName();
			for(String m : maintain) {
				if(prevName.equals(m)) {
					chk = "same";
					break;
				}
			}
			// 새로 넘어온 리스트에서 기존 파일이 존재하지 않을 시, 삭제
			if(!chk.equals("same")) {
				String image = pr.getStoredFileName();
				String path = request.getSession().getServletContext().getRealPath("resources/imgUpload");
				File file = new File(path,image);
					if(file.exists()) {
						file.delete();
					}					
					Long iNum = pr.getiNum();
					dao.deleteImgByiNum(iNum);
					System.out.println("iNum : "+iNum);
					System.out.println("삭제 성공");
			}
		}

		MultipartFile[] img = fc.getImg();		 
		String originalFile = null;
		String originalFileExtension = null;
		String storedFileName = null;
		String filePath = null;
		
		if(img!=null) { // 사진 등록했을 때
			int num = img.length;
			System.out.println("num : "+num);
			
			for(MultipartFile f : img) {
				// 추가 파일 등록
				UploadImgVo uVo = new UploadImgVo();
				System.out.println("-----추가 파일 등록");
				
				originalFile = f.getOriginalFilename();
				originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
				storedFileName = UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
				filePath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
				File file = new File(filePath,storedFileName);
				f.transferTo(file);
				
				// 객체 저장
				uVo.setOriginalFile(originalFile);
				uVo.setOriginalFileExtension(originalFileExtension);
				uVo.setStoredFileName(storedFileName);
				String board = "findBoard";
				dao.writeBoardImg(uVo, boardNum, board);
			}
		}
	}	
}