package find.service;
 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; import
org.springframework.stereotype.Service;

import find.dao.FindDao; import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;

@Service
public class LostBoardWriteService {

	@Autowired
	private FindDao dao;

	public LostBoardWriteService(FindDao dao) {
		this.dao = dao; 
	}
	
	public void boardRegist(LostBoardWriteCommand lostBoardWriteCommand, 
			HttpSession session) {
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		System.out.println("session id의 값 : "+member.getUserId());
		String userName = member.getUserName();
		
		String term = lostBoardWriteCommand.getTerm();
		System.out.println("넘어온 term 의 값 : "+term);
		
		String email = member.getEmail();
		String phone = member.getPhone();
		if(lostBoardWriteCommand.getTerm().equals("phoneAgree")) {
			member.setEmail(null);
		}
		if(lostBoardWriteCommand.getTerm().equals("emailAgree")) {
			member.setPhone(null);
		}
		
		dao.writeLostBoard(member,lostBoardWriteCommand);
	}
}
