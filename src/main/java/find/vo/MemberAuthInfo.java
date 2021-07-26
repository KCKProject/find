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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
