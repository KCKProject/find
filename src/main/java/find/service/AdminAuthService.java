package find.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import find.dao.FindDao;
import find.exception.IdPasswordNotMatchingException;
import find.vo.Admin;
import find.vo.AdminAuthInfo;

@Service
public class AdminAuthService {
	
	@Autowired
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	public AdminAuthInfo authenticate(String adminId, String adminPassword) {
		Admin admin = dao.selectByAdminId(adminId);
		
		if(admin == null) {
			throw new IdPasswordNotMatchingException();
		}
		
		if(!admin.getAdminPassword().equals(adminPassword)) {
			throw new IdPasswordNotMatchingException();
		}
		
		return new AdminAuthInfo(admin.getAdminId(),admin.getAdminName());
		
	}
}
