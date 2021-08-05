package find.vo;

import java.util.Date;

public class FindBoard {
	private Long BoardNum;
	private String title;
	private String writer;
	private Date writeDate;
	private String kind;
	private String gender;
	private String location;
	private String character;
	private String img;
	private String email;
	private String phone;
	private Date findDate;
	private String memo;
	private int meet;
	private int hit;
 
 public FindBoard() {}

	public FindBoard(String title, String writer, Date writeDate, String kind, String gender, String location,
			String character, String img, String email, String phone, Date findDate, String memo, int meet, int hit) {
		this.title = title;
		this.writer = writer;
		this.writeDate = writeDate;
		this.kind = kind;
		this.gender = gender;
		this.location = location;
		this.character = character;
		this.img = img;
		this.email = email;
		this.phone = phone;
		this.findDate = findDate;
		this.memo = memo;
		this.meet = meet;
		this.hit = hit;
	}
	
	public Long getBoardNum() {
		return BoardNum;
	}
	
	public void setBoardNum(Long boardNum) {
		BoardNum = boardNum;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Date getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCharacter() {
		return character;
	}
	
	public void setCharacter(String character) {
		this.character = character;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getFindDate() {
		return findDate;
	}
	
	public void setFindDate(Date findDate) {
		this.findDate = findDate;
	}
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getMeet() {
		return meet;
	}
	
	public void setMeet(int meet) {
		this.meet = meet;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	} 
}
