package find.vo;

public class Admin {

	private String adminId;
	private String adminPassword;
	private String adminName;
	
	
	public Admin(String adminId, String adminPassword, String adminName) {
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
	}
	
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
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
	
}
