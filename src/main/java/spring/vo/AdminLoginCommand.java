package spring.vo;

public class AdminLoginCommand { //입력받은 아이디 비밀번호 전달용 클래스
	
	private String adminId;
	private String adminPassword;
	
	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
}
