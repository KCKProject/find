package find.vo;

import java.util.Date;

public class MyPageFindPostCommand {

		private Long BoardNum;
		private String title;
		private Date writeDate;
		private int meet;
		
		public MyPageFindPostCommand() {}

		public MyPageFindPostCommand(String title, Date writeDate, int meet) {
			this.title = title;
			this.writeDate = writeDate;
			this.meet = meet;
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

}
