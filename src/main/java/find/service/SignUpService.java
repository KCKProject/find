package find.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import find.dao.FindDao;
import find.utils.SHA256Util;
import find.vo.Member;
import find.vo.SignUpCommand;

@Service
public class SignUpService {
	
	@Autowired
	private FindDao dao;
	
	public SignUpService(FindDao dao) {
		this.dao = dao;
	}
	
	public void regist(SignUpCommand signUpCommand){
		// 암호화를 위한 salt 생성
		String salt = SHA256Util.getSalt();
		
		try {
			// SHA-256을 위한 해시설정
			signUpCommand.setUserPassword(SHA256Util.SHA256Encrypt(signUpCommand.getUserPassword(),salt));
		} catch (Exception e) {			
			e.printStackTrace();
			return;
		}
		Member newMember = new Member(
				signUpCommand.getUserId(),signUpCommand.getUserPassword(),
				signUpCommand.getUserName(),signUpCommand.getPhone(),signUpCommand.getEmail()
				,signUpCommand.getPwdQ(),signUpCommand.getPwdA(), salt);
		
		dao.insertMember(newMember);
	}
	
	// 아이디 중복 체크
	public int signUpIdChk(String userId) {
		int result = dao.signUpIdChk(userId);
		return result;
	}
}
