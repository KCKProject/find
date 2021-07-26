package find.service;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.exception.AlreadyExistionMemberException;
import find.validator.SignUpCommandValidator;
import find.vo.Member;
import find.vo.SignUpCommand;

public class SignUpService {
	private FindDao dao;
	
	public SignUpService(FindDao dao) {
		this.dao = dao;
	}
	
	public void regist(SignUpCommand suCommand) {
		Member m = dao.selectByEmail(suCommand.getEmail());
		System.out.println("m 이메일 : "+m.getEmail());
		
		if(m!=null) {
			throw new AlreadyExistionMemberException("이메일 중복 : "+suCommand.getEmail());
		}
		Member newMember = new Member(
				suCommand.getUserId(),suCommand.getUserPassword(),suCommand.getUserName(),
				suCommand.getPhone(),suCommand.getEmail());
		dao.insertMember(newMember);
	}
	
}
