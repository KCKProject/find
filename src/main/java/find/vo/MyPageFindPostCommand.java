package find.vo;

import java.util.Date;

public class MyPageFindPostCommand {

		private Long BoardNum;
		private String title;
		private Date writeDate;
		private int meet;
		private int commentNum;
		
		public MyPageFindPostCommand() {}

		public MyPageFindPostCommand(long boardNum, String title, Date writeDate, int meet, int commentNum) {
			this.BoardNum = boardNum;
			this.title = title;
			this.writeDate = writeDate;
			this.meet = meet;
			this.commentNum = commentNum;
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

		public Date getWriteDate() {
			return writeDate;
		}

		public void setWriteDate(Date writeDate) {
			this.writeDate = writeDate;
		}

		public int getMeet() {
			return meet;
		}

		public void setMeet(int meet) {
			this.meet = meet;
		}

		public int getCommentNum() {
			return commentNum;
		}

		public void setCommentNum(int commentNum) {
			this.commentNum = commentNum;
		}

}
