package find.service;
 
import java.io.File;
import java.io.IOException;

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
			HttpSession session, MultipartHttpServletRequest request) {
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		System.out.println("session id의 값 : "+member.getUserId());
		String userName = member.getUserName();
		
		String[] term = lc.getTerm();
		System.out.println("넘어온 term 의 값 : "+term[1]);
		
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
		
//		MultipartFile mf = request.getFile("img");
//		String path = request.getSession().getServletContext().getRealPath("resources/img/board");
//		String fileName = mf.getOriginalFilename();
//		File uploadFile = new File(path+"//"+fileName);
//		try {
//			mf.transferTo(uploadFile);
//		}
//		catch(IllegalStateException e) {
//			e.printStackTrace();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		lb.setImg(fileName);
//		
		dao.writeLostBoard(member,lb);
	}
}
