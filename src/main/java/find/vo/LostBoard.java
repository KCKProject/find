package find.vo;

import java.sql.Date;

public class LostBoard {

	private long boardNum;
	private String title;
	private String writer;
	private Date writeDate;
	private String kind;
	private String location;
	private String character;
	private String animal;
	private String gender;
	private String email;
	private String phone;
	private String lostDate;
	private String memo;
	private int meet;
	private String originalFile;
	private String originalFileExtension;
	private String storedFileName;
	private int hit;
	private String review;
	
	public LostBoard() {}

	public LostBoard(String title, String writer, Date writeDate, String location, String character, String animal,
			String kind, String gender, String email, String phone, String lostDate, int meet, String memo,
			String originalFile, String originalFileExtension, String storedFileName, int hit, String review) {
		this.title = title;
		this.writer = writer;
		this.writeDate = writeDate;
		this.location = location;
		this.character = character;
		this.animal = animal;
		this.kind = kind;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.lostDate = lostDate;
		this.memo = memo;
		this.meet = meet;
		this.originalFile = originalFile;
		this.originalFileExtension = originalFileExtension;
		this.storedFileName = storedFileName;
		this.hit = hit;
		this.review = review;
	}

	public long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(long boardNum) {
		this.boardNum = boardNum;
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
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
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
	public String getLostDate() {
		return lostDate;
	}
	public void setLostDate(String lostDate) {
		this.lostDate = lostDate;
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

	// ????????? ????????? ??????
	public String getOriginalFileExtension() {
		return originalFileExtension;
	}

	public void setOriginalFileExtension(String originalFileExtension) {
		this.originalFileExtension = originalFileExtension;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}
	
	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	 public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
