package find.vo;

import org.springframework.web.multipart.MultipartFile;

public class FindBoardWriteCommand { // Find 작성시 받아올 내용
	private String title;
	private String kind;
	private String gender;
	private String location;
	private String character;
	private MultipartFile img;
	private String findDate;
	private String memo;
	private String term;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public String getFindDate() {
		return findDate;
	}
	public void setFindDate(String findDate) {
		this.findDate = findDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
}
