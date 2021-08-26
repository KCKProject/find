package find.service;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import
org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.vo.CommentVo;
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
					dao.writeLostBoardImg(uVo, BoardNum, board);
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
		//lb.setOriginalFile(originalFile);
		//lb.setOriginalFileExtension(originalFileExtension);
		//lb.setStoredFileName(storedFileName);

		dao.modifyLostBoard(lb, boardNum);
		
		MultipartFile[] img = lc.getImg();		 
		String originalFile = null;
		String originalFileExtension = null;
		String storedFileName = null;
		String filePath = null;		
		
		for(MultipartFile f : img) {
			UploadImgVo uVo = new UploadImgVo();
			// 기존 저장 파일 전부 삭제
			for(UploadImgVo i : imgs) {
				String image = i.getStoredFileName();
				String path = request.getSession().getServletContext().getRealPath("resources/imgUpload");
				File file = new File(path,image);
					if(file.exists()) {
						file.delete();
					}					
				System.out.println("삭제 성공");
			}				
					
			// 추가 파일 등록
			System.out.println("-----추가 파일 등록");
			System.out.println("파일 이름 : "+originalFile);
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
			dao.writeLostBoardImg(uVo, boardNum, board);
		}		
	}	
}
