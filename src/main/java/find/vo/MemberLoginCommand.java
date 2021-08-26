package find.vo;

public class MemberLoginCommand {
	private String userId;
	private String userIdChk;
	private String userPassword;
	private String userPasswordChk;
	
	
	public String getUserIdChk() {
		return userIdChk;
	}
	public void setUserIdChk(String userIdChk) {
		this.userIdChk = userIdChk;
	}
	public String getUserPasswordChk() {
		return userPasswordChk;
	}
	public void setUserPasswordChk(String userPasswordChk) {
		this.userPasswordChk = userPasswordChk;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}	
}
