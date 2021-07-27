package find.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import find.dao.FindDao;
import find.exception.AlreadyExistionMemberException;
import find.vo.Member;
import find.vo.SignUpCommand;

@Service
public class SignUpService {
	
	@Autowired
	private FindDao dao;
	
	public SignUpService(FindDao dao) {
		this.dao = dao;
	}
	
	public void regist(SignUpCommand signUpCommand) {
		Member m = dao.selectByUserId(signUpCommand.getUserId());
		
		if(m!=null) {
			throw new AlreadyExistionMemberException("아이디 중복 : "+signUpCommand.getUserName());
		}

		Member newMember = new Member(
				signUpCommand.getUserId(),signUpCommand.getUserPassword(),
				signUpCommand.getUserName(),signUpCommand.getPhone(),signUpCommand.getEmail());
		
		dao.insertMember(newMember);
	}
	
}
