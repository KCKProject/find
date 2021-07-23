package spring.service;

import spring.dao.FindDao;
import spring.exception.IdPasswordNotMatchingException;
import spring.vo.Admin;
import spring.vo.AdminAuthInfo;

public class AdminAuthService {
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
