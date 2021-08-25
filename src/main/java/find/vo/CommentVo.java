package find.vo;

import java.util.Date;

public class CommentVo {
	private long cNum;
	private long bNum;
	private String writer;
	private Date writeDate;
	private String content;
	
	public CommentVo() {}

	public CommentVo(long bNum, String writer, Date writeDate, String content) {
		this.bNum = bNum;
		this.writer = writer;
		this.writeDate = writeDate;
		this.content = content;
	}

	public long getcNum() {
		return cNum;
	}

	public void setcNum(long cNum) {
		this.cNum = cNum;
	}

	public long getbNum() {
		return bNum;
	}

	public void setbNum(long bNum) {
		this.bNum = bNum;
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

	public String getContent() {
		return content.replaceAll("(?i)<script", "&lt;script");
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
