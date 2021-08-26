package find.vo;

import org.springframework.web.multipart.MultipartFile;

public class FindBoardWriteCommand { // Find 글 등록시 넘겨줄 객체
	private String title;
	private String location;
	private String character;
	private String kind;
	private String gender;
	private MultipartFile[] img;
	private String findDate;
	private String memo;
	private String term;
	private String review;
	private String email;
	private String phone;
	private String[] originalFile;
	
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
	public MultipartFile[] getImg() {
		return img;
	}
	public void setImg(MultipartFile[] img) {
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
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
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
	public String[] getOriginalFile() {
		return originalFile;
	}
	public void setOriginalFile(String[] originalFile) {
		this.originalFile = originalFile;
	}
}
