package find.service;
 
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import
org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.vo.LostBoard;
import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;
import find.vo.UploadImgVo;

@Service
public class LostBoardWriteService {

	@Autowired
	private FindDao dao;

	public LostBoardWriteService(FindDao dao) {
		this.dao = dao; 
	}
	
	String where = "lostNum";
	
	// 글 등록
	public void boardRegist(LostBoardWriteCommand lc, 
			HttpSession session,
			MultipartHttpServletRequest request) throws IOException {
		
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		
		String term = lc.getTerm();
		
		if(term==null) {
			member.setEmail("비공개");
			member.setPhone("비공개");
		}else if(term.equals("phoneAgree")) {
			member.setEmail("비공개");
		}else if(term.equals("emailAgree")) {
			member.setPhone("비공개");
		}
		
		// 이미지 업로드
		LostBoard lb = new LostBoard();
		
		MultipartFile[] img = lc.getImg();		 
		String originalFile = null;
		String originalFileExtension = null;
		String storedFileName = null;
		String filePath = null;
		
		int num = img.length;
		System.out.println("num : "+num);
		
		System.out.println();
		filePath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
	
		System.out.println(filePath+" : 저장된 경로");

		lb.setTitle(lc.getTitle());
		lb.setWriter(member.getUserId());
		lb.setLocation(lc.getLocation());
		lb.setCharacter(lc.getCharacter());
		lb.setAnimal(lc.getAnimal());
		lb.setKind(lc.getKind());
		lb.setGender(lc.getGender());
		lb.setEmail(member.getEmail());
		lb.setPhone(member.getPhone());
		lb.setLostDate(lc.getLostDate());
		lb.setMemo(lc.getMemo());
	//	lb.setOriginalFile(originalFile);
	//	lb.setOriginalFileExtension(originalFileExtension);
	//	lb.setStoredFileName(storedFileName);

		
		List<LostBoard> lostBoard = dao.writeLostBoard(lb);
		long BoardNum = lostBoard.get(0).getBoardNum();

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
					String board = "lostBoard";
					dao.writeBoardImg(uVo, BoardNum, board);
				}
			
//			// 썸네일 만들기 → 서버 구동 최적화를 위하여
//			// 기존 파일의 축소판인 썸네일을 생성하여 게시글 목록에서 보여지도록 구현
//			// 화소를 높이지 못한다면 생략해야할듯
//			BufferedImage sourceImg = ImageIO.read(new File(filePath,storedFileName));
//
//			BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
//
//			String thumbnailName = filePath+File.separator+"s_"+storedFileName;
//
//			File newFile = new File(thumbnailName);
//			String formatName = storedFileName.substring(storedFileName.lastIndexOf(".")+1);
//
//			ImageIO.write(destImg, formatName.toUpperCase(), newFile);
//			thumbnailName.substring(filePath.length()).replace(File.separatorChar, '/');
			} /*
				 * else { // 사진 등록 안 했을 때 originalFile = null; }
				 */
		}
	}
	

	// 후기 등록
	public void writeReview(String review, long boardNum) {
		dao.writeReview2(review, boardNum);		
	}

	// 글 수정
	public void modifyLost(LostBoardWriteCommand lc, LostBoard detail,
				MemberAuthInfo member, MultipartHttpServletRequest request, List<UploadImgVo> imgs) throws IOException {		
		long boardNum = detail.getBoardNum();
		
		String email = lc.getEmail();
		String phone = lc.getPhone();
		if(email==null) {
			member.setEmail("비공개");
		}
		if(phone==null) {
			member.setPhone("비공개");
		}
			
		LostBoard lb = new LostBoard();
		
		lb.setTitle(lc.getTitle());
		lb.setWriter(member.getUserId());
		lb.setLocation(lc.getLocation());
		lb.setCharacter(lc.getCharacter());
		lb.setAnimal(lc.getAnimal());
		lb.setKind(lc.getKind());
		lb.setGender(lc.getGender());
		lb.setEmail(email);
		lb.setPhone(phone);
		lb.setLostDate(lc.getLostDate());
		lb.setMemo(lc.getMemo());

		dao.modifyLostBoard(lb, boardNum);
		
		// 이미지 수정
		// 기존 이미지 삭제 내역 확인
		List<UploadImgVo> prevImg = dao.selectUploadImgByBoardNum(boardNum, where);
		String[] maintain = lc.getOriginalFile();

		for(UploadImgVo pr : prevImg) {
			String chk = "";
			String prevName = pr.getStoredFileName();
			if(maintain!=null) {
				for(String m : maintain) {
					if(prevName.equals(m)) {
						chk = "same";
						break;
					}
				}
			}
			
			// 넘어온 리스트에서 존재하지 않는 기존 파일 삭제
			if(!chk.equals("same")) {
				String image = pr.getStoredFileName();
				System.out.println("image : "+image);
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

		MultipartFile[] img = lc.getImg();		 
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
				String board = "lostBoard";
				dao.writeBoardImg(uVo, boardNum, board);
			}
		}
	}	
}
