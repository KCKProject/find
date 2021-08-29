package find.vo;

public class MyPasswordUpdateCommand {
	private String userId;
	private String userPasswordCurrent;
	private String userPasswordNew;
	private String userPasswordNewConfirm;
	private String userPasswordCurrentChk;
	private String salt;
	
	public String getUserPasswordCurrentChk() {
		return userPasswordCurrentChk;
	}
	public void setUserPasswordCurrentChk(String userPasswordCurrentChk) {
		this.userPasswordCurrentChk = userPasswordCurrentChk;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPasswordCurrent() {
		return userPasswordCurrent;
	}
	public void setUserPasswordCurrent(String userPasswordCurrent) {
		this.userPasswordCurrent = userPasswordCurrent;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	

}


