package find.service;
 
import java.io.File;
import java.io.IOException;
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

@Service
public class LostBoardWriteService {

	@Autowired
	private FindDao dao;

	public LostBoardWriteService(FindDao dao) {
		this.dao = dao; 
	}
	
	public void boardRegist(LostBoardWriteCommand lc, 
			HttpSession session, MultipartHttpServletRequest request) throws IOException {
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		System.out.println("session id의 값 : "+member.getUserId());
		String userName = member.getUserName();
		
		String term = lc.getTerm();
		System.out.println("넘어온 term 의 값 : "+term);
		
		String email = member.getEmail();
		String phone = member.getPhone();
		if(lc.getTerm().equals("phoneAgree")) {
			member.setEmail("비공개");
		}
		if(lc.getTerm().equals("emailAgree")) {
			member.setPhone("비공개");
		}
		
		// 이미지파일업로드
		LostBoard lb = new LostBoard();
		
		MultipartFile img = lc.getImg();
		String originalFile = img.getOriginalFilename();
		String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		String storedFileName = UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
		String filePath = request.getSession().getServletContext().getRealPath("resources/img/upload");
		File file = new File(filePath+storedFileName);
		img.transferTo(file);
		
		System.out.println("업로드한 파일은 "+originalFile);
		System.out.println("이고, "+storedFileName+"으로 업로드됐다.");
		System.out.println(filePath+" 경로에 저장됐으니 확인.");
		System.out.println("파일 사이즈는 : "+img.getSize());

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
}
