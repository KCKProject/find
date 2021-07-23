package spring.vo;

public class AdminAuthInfo { // 어드민 로그인 정보를 기억할 클래스
	
	private String adminId;
	private String adminName;
	
	public AdminAuthInfo(String adminId, String adminName) {
		this.adminId = adminId;
		this.adminName = adminName;
	}
	
	public String getAdminId() {
		return adminId;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	
	
}
