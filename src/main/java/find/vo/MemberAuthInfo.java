package find.vo;

public class MemberAuthInfo { // 회원 로그인 정보를 기억할 클래스
	private String userId;
	private String userPassword;
	private String userName;
	private String phone;
	private String email;
	
	public MemberAuthInfo(String userId, String userPassword, String userName, String phone, String email) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
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

	
	
}
