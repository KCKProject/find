package find.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.vo.FindBoard;
import find.vo.FindBoardWriteCommand;
import find.vo.MemberAuthInfo;

@Service
public class FindBoardWriteService {

	@Autowired
	private FindDao dao;

	public FindBoardWriteService(FindDao dao) {
		this.dao = dao; 
	}
	
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

		MultipartFile img = fc.getImg();
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
	
			System.out.println(filePath+" : 저장된 경로");
	
			// 썸네일 만들기 → 서버 구동 최적화를 위하여
			// 기존 파일의 축소판인 썸네일을 생성하여 게시글 목록에서 보여지도록 구현
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
		fb.setOriginalFile(originalFile);
		fb.setOriginalFileExtension(originalFileExtension);
		fb.setStoredFileName(storedFileName);

		dao.writeFindBoard(fb);
	}

	// 후기 등록
	public void writeReview(String review, long boardNum) {
		dao.writeReview(review, boardNum);
	}

	// 글 수정
	public void modifyFind(FindBoardWriteCommand fc, FindBoard detail, 
			MemberAuthInfo member, MultipartHttpServletRequest request) throws IOException {
		String originalFile = null;
		String originalFileExtension = null;
		String storedFileName = null;
		MultipartFile img = fc.getImg();
		long boardNum = detail.getBoardNum();
		
		// 첨부파일 처리
		// 더 간결한 방법은 없을까...
		String fileName = fc.getOriginalFile();
		System.out.println("넘어온 fileName : "+fileName);
		if(fileName!=null) {
			// 기존파일 그대로 넘어온 경우
			originalFile = detail.getOriginalFile();
			originalFileExtension = detail.getOriginalFileExtension();
			storedFileName = detail.getStoredFileName();
		}		
		if(fileName==null) {
			if(detail.getOriginalFile()!=null) {
				// 기존파일 넘어온 경우 제외하고 기존파일이 있는 경우, 무조건 삭제
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
			if(originalFile!="") {
				// 추가 파일 등록
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
		fb.setOriginalFile(originalFile);
		fb.setOriginalFileExtension(originalFileExtension);
		fb.setStoredFileName(storedFileName);

		dao.modifyFindBoard(fb, boardNum);
		
	}
}
