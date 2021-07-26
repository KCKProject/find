package find.vo;

public class SignUpCommand {
	private String userId;
	private String userPassword;
	private String userPwdChk;
	private String userName;
	private String phone;
	private String email;
	
	public SignUpCommand(String userId, String userPassword, String userPwdChk, String userName, String phone,
			String email) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userPwdChk = userPwdChk;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
	}

	// 비밀번호 확인용 메서드
	public boolean isPasswordEqual() {
		return userPassword.equals(userPwdChk);
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPwdChk() {
		return userPwdChk;
	}

	public void setUserPwdChk(String userPwdChk) {
		this.userPwdChk = userPwdChk;
	}
}
