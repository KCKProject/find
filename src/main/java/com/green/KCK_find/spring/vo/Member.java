package com.green.KCK_find.spring.vo;

public class Member {
	
	private long memberNumber;
	private String userId;
	private String userPassword;
	private String userName;
	private String phone;
	
	
	
	public Member(String userId, String userPassword, String userName, String phone) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.phone = phone;
	}
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

	
	
}
