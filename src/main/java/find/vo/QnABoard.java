package find.vo;

import java.sql.Date;

public class QnABoard {

	private long boardNum;
	private String title;
	private String writer;
	private Date writeDate;
	private String contents;
	private int open;
	
	public QnABoard() {}

	
	public QnABoard(String title, String writer, Date writeDate, String contents, int open) {
		this.title = title;
		this.writer = writer;
		this.writeDate = writeDate;
		this.contents = contents;
		this.open = open;
	}
	
	public QnABoard(String title, String writer, String contents, int open) {
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.open = open;
	}


	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	};
	
	
	
	
	
}
