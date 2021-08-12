package find.service;
 
import java.awt.PageAttributes.MediaType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	public void boardRegist(LostBoardWriteCommand lc, 
			HttpSession session,
			MultipartHttpServletRequest request) throws IOException {
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		
		String term = lc.getTerm();
		System.out.println("받아온 term : "+term);
		
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
		String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		String storedFileName = UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
		String filePath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
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

		// System.out.println("formatName : "+formatName);
		// System.out.println("thumbnailName : "+thumbnailName);
  
		lb.setTitle(lc.getTitle());
		lb.setWriter(member.getUserId());
		lb.setLocation(lc.getLocation());
		lb.setCharacter(lc.getCharacter());
		lb.setAnimal(lc.getAnimal());
		lb.setKind(lc.getKind());
		lb.setGender(lc.getGender());
		lb.setEmail(member.getEmail());
		lb.setPhone(member.getPhone());
		//lb.setLostDate(lc.getLostDate());
		lb.setMemo(lc.getMemo());
		lb.setOriginalFile(originalFile);
		lb.setOriginalFileExtension(originalFileExtension);
		lb.setStoredFileName(storedFileName);

		dao.writeLostBoard(lb);
	}


	public void writeReview(String review, long boardNum) {
		dao.writeReview2(review, boardNum);	
		
	}

	public void modifyLost(LostBoard lb, MemberAuthInfo member) {		
		LostBoard lostBoard = new LostBoard();
		
		lostBoard.setTitle(lb.getTitle());
		lostBoard.setWriter(member.getUserId());
		lostBoard.setLocation(lb.getLocation());
		lostBoard.setCharacter(lb.getCharacter());
		lostBoard.setAnimal(lb.getAnimal());
		lostBoard.setKind(lb.getKind());
		lostBoard.setGender(lb.getGender());
		lostBoard.setEmail(member.getEmail());
		lostBoard.setPhone(member.getPhone());
		//lb.setLostDate(lc.getLostDate());
//		lb.setMemo(lc.getMemo());
//		lb.setOriginalFile(originalFile);
//		lb.setOriginalFileExtension(originalFileExtension);
//		lb.setStoredFileName(storedFileName);

		dao.writeLostBoard(lb);
	}
}
