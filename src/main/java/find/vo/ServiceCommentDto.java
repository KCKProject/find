package find.vo;

import java.util.Date;

public class ServiceCommentDto {
	
	private long cnum;
	private Date writeDate;
	private String content;
	
	public ServiceCommentDto() {}
	
	public ServiceCommentDto(Date writeDate, String content) {
//		this.cnum = cnum;
		this.writeDate = writeDate;
		this.content = content;
	}
	
	public long getCnum() {
		return cnum;
	}
	public void setCnum(long cnum) {
		this.cnum = cnum;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

	
	

}
