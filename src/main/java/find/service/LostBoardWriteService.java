package find.service;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import find.vo.LostBoard;
import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;

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

		MultipartFile img = lc.getImg();
		String originalFile = img.getOriginalFilename();
		String originalFileExtension=null;
		String storedFileName = null;
		String filePath = null;
		
		if(originalFile!="") { // 사진 등록했을 때
			originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
			storedFileName = UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
			filePath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
			File file = new File(filePath,storedFileName);
			img.transferTo(file);
			
			// 썸네일 만들기 → 서버 구동 최적화를 위하여
			// 기존 파일의 축소판인 썸네일을 생성하여 게시글 목록에서 보여지도록 구현
			// 화소를 높이지 못한다면 생략해야할듯
			BufferedImage sourceImg = ImageIO.read(new File(filePath,storedFileName));

			BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);

			String thumbnailName = filePath+File.separator+"s_"+storedFileName;

			File newFile = new File(thumbnailName);
			String formatName = storedFileName.substring(storedFileName.lastIndexOf(".")+1);

			ImageIO.write(destImg, formatName.toUpperCase(), newFile);
			thumbnailName.substring(filePath.length()).replace(File.separatorChar, '/');
		}else { // 사진 등록 안 했을 때
			originalFile = null;
		}

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
		lb.setOriginalFile(originalFile);
		lb.setOriginalFileExtension(originalFileExtension);
		lb.setStoredFileName(storedFileName);

		dao.writeLostBoard(lb);
	}

	// 후기 등록
	public void writeReview(String review, long boardNum) {
		dao.writeReview2(review, boardNum);		
	}

	// 글 수정
	public void modifyLost(LostBoardWriteCommand lc, LostBoard detail,
				MemberAuthInfo member, MultipartHttpServletRequest request) throws IOException {		
		String originalFile = null;
		String originalFileExtension = null;
		String storedFileName = null;
		MultipartFile img = lc.getImg();
		long boardNum = detail.getBoardNum();
		
		// 첨부파일 처리
		String fileName = lc.getOriginalFile();
		System.out.println("넘어온 fileName : "+fileName);
		if(fileName!=null) {
			// 기존파일 그대로 넘어온 경우
			System.out.println("-----기존파일 그대로 넘어온 경우");
			originalFile = detail.getOriginalFile();
			originalFileExtension = detail.getOriginalFileExtension();
			storedFileName = detail.getStoredFileName();
		}
		
		if(fileName==null) {
			if(detail.getOriginalFile()!=null) {
				// 기존파일 넘어온 경우 제외하고 기존파일이 있는 경우, 무조건 삭제
				System.out.println("-----기존파일 넘어온 경우 제외하고 기존파일이 있는 경우, 무조건 삭제");
				System.out.println("원래 파일 이름 : "+detail.getOriginalFile());
				String image = detail.getStoredFileName();
				String path = request.getSession().getServletContext().getRealPath("resources/imgUpload");
				File file = new File(path,image);
				File thumb = new File(path,"s_"+image);
					if(file.exists()) {
						file.delete();
						thumb.delete();
					}					
				System.out.println("삭제 성공");
			}
			originalFile = img.getOriginalFilename();
			System.out.println("파일 이름 : "+originalFile);
			if(originalFile!="") {
				// 추가 파일 등록
				System.out.println("-----추가 파일 등록");
				System.out.println("파일 이름 : "+originalFile);
				originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
				storedFileName = UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
				String filePath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
				File file = new File(filePath,storedFileName);
				img.transferTo(file);
				
				// 기존 파일의 축소판인 썸네일을 생성하여 게시글 목록에서 보여지도록 구현
				BufferedImage sourceImg = ImageIO.read(new File(filePath,storedFileName));
	
				BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
	
				String thumbnailName = filePath+File.separator+"s_"+storedFileName;
	
				File newFile = new File(thumbnailName);
				String formatName = storedFileName.substring(storedFileName.lastIndexOf(".")+1);
	
				ImageIO.write(destImg, formatName.toUpperCase(), newFile);
				thumbnailName.substring(filePath.length()).replace(File.separatorChar, '/');
	
				System.out.println(filePath+" : 저장된 경로");
			}
		}
		
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
		lb.setOriginalFile(originalFile);
		lb.setOriginalFileExtension(originalFileExtension);
		lb.setStoredFileName(storedFileName);

		dao.modifyLostBoard(lb, boardNum);
	}
	
}
