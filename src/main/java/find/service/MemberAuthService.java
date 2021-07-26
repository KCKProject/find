package find.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import find.dao.FindDao;
import find.exception.IdPasswordNotMatchingException;
import find.vo.Member;
import find.vo.MemberAuthInfo;

@Service
public class MemberAuthService {
	
	@Autowired
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	public MemberAuthInfo authenticate(String userId, String userPassword) {
		Member mem = dao.selectByUserId(userId);
		
		if(mem == null) {
			throw new IdPasswordNotMatchingException();
		}
		if(!mem.getUserPassword().equals(userPassword)) {
			throw new IdPasswordNotMatchingException();
		}
		
		return new MemberAuthInfo(mem.getUserId(),mem.getUserPassword(),mem.getUserName(),mem.getPhone(),mem.getEmail());
	}
}
