package find.vo;

public class Member {
	
	private long memberNumber;
	private String userId;
	private String userPassword;
	private String userName;
	private String phone;
	private String email;
	private String pwdQ;
	private String pwdA;
	private String userPasswordCurrentChk;
	private String userPasswordNew;
	private String userPasswordNewConfirm;
	private String salt;
	
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}


	public String getUserPasswordNew() {
		return userPasswordNew;
	}


	public void setUserPasswordNew(String userPasswordNew) {
		this.userPasswordNew = userPasswordNew;
	}


	public String getUserPasswordNewConfirm() {
		return userPasswordNewConfirm;
	}


	public void setUserPasswordNewConfirm(String userPasswordNewConfirm) {
		this.userPasswordNewConfirm = userPasswordNewConfirm;
	}


	public Member() {};


	public Member(String userId, String userPassword, String userName, String phone, String email,
			String pwdQ, String pwdA, String salt) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.pwdQ = pwdQ;
		this.pwdA = pwdA;
		this.salt = salt;
	}

	public Member(String userId, String userPassword, String userName, String phone, String email, String salt) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.salt = salt;
	}
	
	public Member(String userName, String phone, String email) {
		this.userName = userName;
		this.phone = phone;
		this.email = email;
	}
	public Member(String phone, String email) {
		this.phone = phone;
		this.email = email;
	}
	public Member(String userId) {
		this.userId = userId;
	}
//	public Member(String salt) {
//		this.salt = salt;
//	}
	
	public long getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(long memberNumber) {
		this.memberNumber = memberNumber;
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

	public String getPwdQ() {
		return pwdQ;
	}

	public void setPwdQ(String pwdQ) {
		this.pwdQ = pwdQ;
	}

	public String getPwdA() {
		return pwdA;
	}

	public void setPwdA(String pwdA) {
		this.pwdA = pwdA;
	}
	public String getUserPasswordCurrentChk() {
		return userPasswordCurrentChk;
	}


	public void setUserPasswordCurrentChk(String userPasswordCurrentChk) {
		this.userPasswordCurrentChk = userPasswordCurrentChk;
	}
	
}
