package find.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import find.vo.Admin;
import find.vo.CommentVo;
import find.vo.FindBoard;
import find.vo.LostBoard;
import find.vo.Member;
import find.vo.MemberAuthInfo;
import find.vo.MyPageFindPostCommand;
import find.vo.MyPageLostPostCommand;
import find.vo.QnABoard;
import find.vo.SearchCriteria;
import find.vo.SearchCriteriaMainBoard;
import find.vo.SearchCriteriaQnABoard;
import find.vo.UploadImgVo;

@Component
public class FindDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// RowMapper
		private RowMapper<Member> rowMapper = new RowMapper<Member>() {
			
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
				Member m = new Member(
							rs.getString("userId"),
							rs.getString("userPassword"),
							rs.getString("userName"),
							rs.getString("phone"),
							rs.getString("email")
						);
				m.setMemberNumber(rs.getLong("membernumber"));
				return m;
			}
		};
		
		private RowMapper<MemberAuthInfo> rowMapper1 = new RowMapper<MemberAuthInfo>() {
			
			@Override
			public MemberAuthInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
				MemberAuthInfo m = new MemberAuthInfo(
						rs.getString("userId"),
						rs.getString("userPassword"),
						rs.getString("userName"),
						rs.getString("phone"),
						rs.getString("email")
						);
				m.setMemberNumber(rs.getLong("membernumber"));
				return m;
			}
		};
		
		private RowMapper<Member> saltRowMapper = new RowMapper<Member>() {
			
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
				Member m = new Member(
							rs.getString("userId"),
							rs.getString("userPassword"),
							rs.getString("userName"),
							rs.getString("salt")
						);
				m.setMemberNumber(rs.getLong("membernumber"));
				return m;
			}
		};
		
//		private RowMapper<Member> saltRowMapper = new RowMapper<Member>() {
//			
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
//				Member m = new Member(
//						rs.getString("salt")
//						);
//				return m;
//			}
//		};
		
		private RowMapper<Admin> adminRowMapper = new RowMapper<Admin>() {
				
				public Admin mapRow(ResultSet rs, int rowNum) throws SQLException{
					Admin m = new Admin(
								rs.getString("adminId"),
								rs.getString("adminPassword"),
								rs.getString("adminName")
							);
					return m;
				}
			};
		
		private RowMapper<LostBoard> lostBoardRowMapper = new RowMapper<LostBoard>() {
			
			public LostBoard mapRow(ResultSet rs, int rowNum) throws SQLException{
				LostBoard lb = new LostBoard(
						rs.getString("title"),
						rs.getString("writer"),
						rs.getDate("writeDate"),
						rs.getString("location"),
						rs.getString("character"),
						rs.getString("animal"),
						rs.getString("kind"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("lostDate"),
						rs.getInt("meet"),
						rs.getString("memo"),
						rs.getString("originalFile"),
						rs.getString("originalFileExtension"),
						rs.getString("storedFileName"),
						rs.getInt("hit"),
						rs.getString("review")
						);
				lb.setBoardNum(rs.getLong("boardNum"));
				return lb;		
			}
		};
		
		private RowMapper<FindBoard> findBoardRowMapper = new RowMapper<FindBoard>() {

			public FindBoard mapRow(ResultSet rs, int rowNum) throws SQLException{
				FindBoard f = new FindBoard(
						rs.getString("title"),
						rs.getString("writer"),
						rs.getDate("writeDate"),
						rs.getString("kind"),
						rs.getString("gender"),
						rs.getString("location"),
						rs.getString("character"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("findDate"),
						rs.getString("memo"),
						rs.getInt("meet"),
						rs.getString("originalFile"),
						rs.getString("originalFileExtension"),
						rs.getString("storedFileName"),
						rs.getInt("hit"),
						rs.getString("review")
						);
				f.setBoardNum(rs.getLong("boardNum"));
				return f;
			}
		};
	
		private RowMapper<QnABoard> qnABoardRowMapper = new RowMapper<QnABoard>() {
			
			public QnABoard mapRow(ResultSet rs, int rowNum) throws SQLException{
				QnABoard m = new QnABoard(
							rs.getString("title"),
							rs.getString("writer"),
							rs.getDate("writeDate"),
							rs.getString("contents"),
							rs.getInt("open")
						);
				m.setBoardNum(rs.getLong("boardNum"));
				return m;
			}
		};
		
		private RowMapper<UploadImgVo> uploadImgMapper = new RowMapper<UploadImgVo>() {
			public UploadImgVo mapRow(ResultSet rs, int rowNum) throws SQLException{
				UploadImgVo i = new UploadImgVo(
							rs.getLong("lostNum"),
							rs.getLong("findNum"),
							rs.getString("originalFile"),
							rs.getString("originalFileExtension"),
							rs.getString("storedFileName")
						);
				i.setiNum(rs.getLong("iNum"));
				return i;
			}
		};
		
		private RowMapper<CommentVo> commentRowMapper = new RowMapper<CommentVo>() {
			
			public CommentVo mapRow(ResultSet rs, int rowNum) throws SQLException{
				CommentVo c = new CommentVo(
							rs.getLong("bNum"),
							rs.getString("writer"),
							rs.getDate("writeDate"),
							rs.getString("content")
						);
				c.setcNum(rs.getLong("cNum"));
				return c;
			}
		};

		private RowMapper<MyPageLostPostCommand> userLostPostMapper = new RowMapper<MyPageLostPostCommand>() {
			
			@Override
			public MyPageLostPostCommand mapRow(ResultSet rs, int rowNum) throws SQLException{
				System.out.println("mypage-lost");
				MyPageLostPostCommand p = new MyPageLostPostCommand(
							rs.getInt("boardNum"),
							rs.getString("title"),
							rs.getDate("writeDate"),
							rs.getInt("meet"),
							rs.getInt("commentNum")
						);
				p.setBoardNum(rs.getLong("BoardNum")); 
				return p;
			}
		};
		
		private RowMapper<MyPageFindPostCommand> userFindPostMapper = new RowMapper<MyPageFindPostCommand>() {
			
			@Override
			public MyPageFindPostCommand mapRow(ResultSet rs, int rowNum) throws SQLException{
				System.out.println("mypage-find");
				MyPageFindPostCommand p = new MyPageFindPostCommand(
						rs.getInt("boardNum"),
						rs.getString("title"),
						rs.getDate("writeDate"),
						rs.getInt("meet"),
						rs.getInt("commentNum")
						);
//				p.setBoardNum(rs.getLong("BoardNum"));
				return p;
			}
		};
		
	
			/*
			 * public List<Member> selectAll() { List<Member> results = jdbcTemplate.query(
			 * "SELECT * FROM member order by membernumber ASC",rowMapper); return results;
			 * }
			 */

	// ?????????
	
//	public int memberCount() {
//		Integer cnt = jdbcTemplate.queryForObject(
//				"SELECT count(memberNumber) FROM Member where memberNumber > 0",Integer.class);
//		return cnt;
//	}
	public int searchMemberCount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(memberNumber) FROM Member where userName like '%' || ? || '%' and memberNumber > 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int searchLostCount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardNum) FROM lostBoard where title like '%' || ? || '%' and boardNum > 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int searchLostCount(SearchCriteriaMainBoard cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardNum) FROM lostBoard where meet like '%' || ? || '%' and boardNum > 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int searchFindCount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardNum) FROM findBoard where title like '%' || ? || '%' and boardNum > 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int searchFindCount(SearchCriteriaMainBoard cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardNum) FROM findBoard where meet like '%' || ? || '%' and boardNum > 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int searchQnACount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardNum) FROM qnaBoard where title like '%' || ? || '%' and boardNum > 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int qnaCount(SearchCriteriaQnABoard cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM qnaboard where title like '%' || ? || '%' and open = 1 and boardnum > 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	
	public int qnaAllCount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM qnaboard where title like '%' || ? || '%' and boardnum > 0",Integer.class,cri.getKeyword());
		return cnt;
	}
//	public int lostCount() {
//		Integer cnt = jdbcTemplate.queryForObject(
//				"SELECT count(boardnum) FROM lostboard where boardnum > 0",Integer.class);
//		return cnt;
//	}
//	public int findCount() {
//		Integer cnt = jdbcTemplate.queryForObject(
//				"SELECT count(boardnum) FROM findboard where boardnum > 0",Integer.class);
//		return cnt;
//	}
	public int findCompleteCount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM findboard where title like '%' || ? || '%' and boardnum > 0 and meet= 1",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int findIncompleteCount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM findboard where title like '%' || ? || '%' and boardnum > 0 and meet= 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int lostCompleteCount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM lostboard where title like '%' || ? || '%' and boardnum > 0 and meet= 1",Integer.class,cri.getKeyword());
		return cnt;
	}
	public int lostIncompleteCount(SearchCriteria cri) {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM lostboard where title like '%' || ? || '%' and boardnum > 0 and meet= 0",Integer.class,cri.getKeyword());
		return cnt;
	}
	// ????????? ???

	// 
	public List<Member> selectMember(){
		String sql = "SELECT * FROM member";
		List<Member> results = jdbcTemplate.query(sql, rowMapper);
		return results;
	}
	// ????????? ??????
	public List<Member> selectMember(Member m){
		String sql = "SELECT * FROM member WHERE PHONE= ? and EMAIL = ? ";
		List<Member> results = jdbcTemplate.query(sql, rowMapper, m.getPhone(), m.getEmail());
		return results;
	}

	// ????????? ????????????
	public int signUpIdChk(String userId) {
		String sql = "SELECT * FROM member WHERE userId=?";
		List<Member> results = jdbcTemplate.query(sql, rowMapper, userId);
		return results.isEmpty() ? 0 : 1;
	}
	
	// ???????????? ??????
	public List<Member> selectMemberForPwd(Member m){
		String sql = "SELECT * FROM member WHERE userId= ? and pwdq = ? and pwda = ? ";
		List<Member> results = jdbcTemplate.query(sql, rowMapper, m.getUserId(), m.getPwdQ(), m.getPwdA());
		return results;
	}

	// ?????? ????????? ?????????
//	public List<LostBoard> selectMainLostBoard(){
//		String sql = "SELECT * FROM (SELECT * FROM lostBoard ORDER BY boardNum DESC) WHERE rowNum<=10 AND meet=0";
//		List<LostBoard> results = jdbcTemplate.query(sql, lostBoardRowMapper);
//		return results;
//	}
	
	// ?????? ????????? ?????????
	public List<LostBoard> selectMainLostBoard(){
		String sql = "SELECT boardNum, title, writer, writeDate, location, character, animal, kind, gender, " +
				"email, phone, lostDate, meet, memo, originalFile, originalFileExtension, sub.storedFileName, hit, review " +
				" FROM lostBoard l JOIN " + 
				" (SELECT a.inum, a.lostnum, a.storedFileName " + 
				" FROM uploadImg a join (SELECT min(inum) as num, lostnum " + 
				"				 FROM uploadImg GROUP BY lostNum " + 
				"                HAVING lostNum>0 ORDER BY num) " + 
				" ON a.inum = num ORDER BY lostNum DESC) sub " + 
				" ON l.boardNum=sub.lostNum AND l.meet=0 AND rowNum <= 10 " + 
				" ORDER BY boardNum DESC";
		List<LostBoard> results = jdbcTemplate.query(sql, lostBoardRowMapper);
		return results;
	}
	
	public List<LostBoard> selectMainReviewBoard(){ // ?????? ??????
		String sql = "SELECT boardNum, title, writer, writeDate, location, character, animal, kind, gender, " +
				"email, phone, lostDate, meet, memo, originalFile, originalFileExtension, sub.storedFileName, hit, review " +
				" FROM lostBoard l JOIN " + 
				" (SELECT a.inum, a.lostnum, a.storedFileName " + 
				" FROM uploadImg a join (SELECT min(inum) as num, lostnum " + 
				"				 FROM uploadImg GROUP BY lostNum " + 
				"                HAVING lostNum>0 ORDER BY num) " + 
				" ON a.inum = num ORDER BY dbms_random.value) sub " + 
				" ON l.boardNum=sub.lostNum AND l.meet=1 AND rowNum <= 5 " + 
				" ORDER BY boardNum DESC";
		List<LostBoard> results = jdbcTemplate.query(sql, lostBoardRowMapper);
		return results;
	}
	
	
	// ????????? ?????? ????????????(+cri)
	public List<Member> selectAll(SearchCriteria cri) {
		List<Member> results = jdbcTemplate.query(
				"SELECT memberNumber, userId, userPassword, UserName, phone, email " + 
				"    FROM(" + 
				"    SELECT memberNumber, userId, userPassword, UserName, phone, email, " + 
				"    row_number() over(order by memberNumber ASC) as rNum " + 
				"    from member" +
				"    ) mb" + 
				"    where rNum between ? and ? " + 
				"    order by memberNumber ASC",
				rowMapper,cri.getRowStart() ,cri.getRowEnd());
		return results;
	}
	public List<Member> searchSelectAll(SearchCriteria cri) {
		List<Member> results = jdbcTemplate.query(
				"SELECT memberNumber, userId, userPassword, UserName, phone, email " + 
				"    FROM(" + 
				"    SELECT memberNumber, userId, userPassword, UserName, phone, email, " + 
				"    row_number() over(order by memberNumber ASC) as rNum " + 
				"    from member where userName like '%' || ? || '%'" + 
				"    ) mb" + 
				"    where rNum between ? and ? " + 
				"    order by memberNumber ASC",
				rowMapper,cri.getKeyword(),cri.getRowStart() ,cri.getRowEnd());
		return results;
	}
	
//	public List<LostBoard> selectByLostWriteDate(Date from,Date to){
//		List<LostBoard> result = jdbcTemplate.query(
//				"SELECT * FROM LOSTBOARD WHERE WRITEDATE BETWEEN ? AND ? ORDER BY WRITEDATE ASC", lostBoardRowMapper,from,to);
//		return result;	
//	}
//	public List<LostBoard> selectAllLostBoard(SearchCriteria cri, DateSearchCommand dsc) {
//		List<LostBoard> results = jdbcTemplate.query(
//				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
//				+ " PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE , ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW " + 
//						"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
//						+ "PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE , ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW, row_number() " + 
//						"over(order by boardnum desc) as rNum " + 
//						"from lostBoard) mb where rNum between ? and ? and WRITEDATE BETWEEN ? AND ? ORDER BY WRITEDATE ASC"
//						,lostBoardRowMapper,cri.getRowStart(), cri.getRowEnd(),dsc.getFrom(),dsc.getTo());
//		return results;
//	}
	
	public List<LostBoard> selectAllLostBoard(SearchCriteriaMainBoard cri) {
		List<LostBoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
				+ " PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE, ORIGINALFILEEXTENSION , sub.STOREDFILENAME, HIT, REVIEW "
				+ " from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
				+ " PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE, ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW, row_number() "
				+ " over(order by boardnum desc) as rNum " 
				+ " from lostBoard where MEET like '%' || ? || '%') mb left join (SELECT a.inum, a.lostnum, a.storedFileName "
				+ " FROM uploadImg a join (SELECT min(inum) as num, lostnum "
				+ " FROM uploadImg GROUP BY lostNum	ORDER BY min(inum)) " 
				+ " ON a.inum = num	ORDER BY lostNum) sub "
				+ " ON mb.boardNum = sub.lostNum where rNum between ? and ? order by boardnum DESC"
				,lostBoardRowMapper,cri.getKeyword(),cri.getRowStart(), cri.getRowEnd());
				
//				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
//				+ " PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE , ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW " + 
//						"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
//						+ "PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE, ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW, row_number() " + 
//						"over(order by boardnum desc) as rNum " + 
//						"from lostBoard where TITLE like '%' || ? || '%') mb where rNum between ? and ? order by boardnum desc"
//						,lostBoardRowMapper,cri.getKeyword(),cri.getRowStart(), cri.getRowEnd());
		return results;
	}
	public List<LostBoard> selectAllLostBoard(SearchCriteria cri) {
		List<LostBoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
				+ " PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE , ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW " + 
						"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
						+ "PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE, ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW, row_number() " + 
						"over(order by boardnum desc) as rNum " + 
						"from lostBoard where TITLE like '%' || ? || '%') mb where rNum between ? and ? order by boardnum desc"
						,lostBoardRowMapper,cri.getKeyword(),cri.getRowStart(), cri.getRowEnd());
		return results;
	}

	
	
	public List<FindBoard> selectAllFindBoard(SearchCriteria cri) {
		List<FindBoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, EMAIL, "
						+ " FINDDATE, MEET, MEMO, PHONE,  ORIGINALFILE, ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW " 
						+ "from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, EMAIL, "
						+ "FINDDATE, MEET, MEMO, PHONE, ORIGINALFILE, ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW, row_number() " 
						+ "over(order by boardnum desc) as rNum " 
						+ "from FindBoard where TITLE like '%' || ? || '%') mb where rNum between ? and ? order by boardnum desc",
						findBoardRowMapper,cri.getKeyword(), cri.getRowStart(), cri.getRowEnd());
		return results;
	}
	
	public List<FindBoard> selectAllFindBoard(SearchCriteriaMainBoard cri) {
		List<FindBoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, EMAIL, "
						+ " FINDDATE, MEET, MEMO, PHONE, ORIGINALFILE, ORIGINALFILEEXTENSION , sub.STOREDFILENAME, HIT, REVIEW "
						+ " from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, EMAIL, "
						+ " FINDDATE, MEET, MEMO, PHONE, ORIGINALFILE, ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, REVIEW, row_number() "
						+ " over(order by boardnum desc) as rNum " 
						+ " FROM FindBoard where MEET like '%' || ? || '%') mb left join (SELECT a.inum, a.findNum, a.storedFileName "
						+ " FROM uploadImg a join (SELECT min(inum) as num, findNum"
						+ " FROM uploadImg GROUP BY findNum	ORDER BY min(inum)) " 
						+ " ON a.inum = num	ORDER BY findNum)sub "
						+ " ON mb.boardNum = sub.findNum where rNum between ? and ? order by boardnum DESC",
						findBoardRowMapper, cri.getKeyword(), cri.getRowStart(), cri.getRowEnd());
		return results;
	}
	
	public List<QnABoard> selectAllQnABoard(SearchCriteria cri) {
		List<QnABoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, CONTENTS, OPEN " + 
				"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, CONTENTS, OPEN, row_number() " + 
				"over(order by boardnum desc) as rNum " + 
				"from qnaboard where TITLE like '%' || ? || '%') mb where rNum between ? and ? order by boardnum asc"
				,qnABoardRowMapper,cri.getKeyword(),cri.getRowStart(), cri.getRowEnd());
		return results;
	}
	
	public List<QnABoard> selectAllQnABoard(SearchCriteriaQnABoard cri) {
		List<QnABoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, CONTENTS, OPEN " + 
				"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, CONTENTS, OPEN, row_number() " + 
				"over(order by boardnum asc) as rNum " + 
				"from qnaboard where TITLE like '%' || ? || '%') mb where rNum between ? and ? and open='1' order by boardnum asc"
				,qnABoardRowMapper,cri.getKeyword(),cri.getRowStart(), cri.getRowEnd());
		return results;
	}

	public Admin selectByAdminId(String adminId) {
		String sql = "SELECT * FROM ADMIN WHERE adminId=?";
		List<Admin> results = jdbcTemplate.query(sql, adminRowMapper, adminId);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<Admin> selectAllAdmin() {
		List<Admin> results = jdbcTemplate.query(
				"SELECT * FROM admin ORDER BY id ASC",adminRowMapper);
		return results;
	}
	
	public Member selectByUserId(String userId) {
		String sql = "SELECT * FROM member WHERE userId=?";
		List<Member> results = jdbcTemplate.query(sql, rowMapper, userId);
		return results.isEmpty() ? null : results.get(0);	
	}
	public List<Member> selectByUserId2(String userId) {
		String sql = "SELECT * FROM member WHERE userId=?";
		List<Member> results = jdbcTemplate.query(sql, rowMapper, userId);
		return results;		
	}
	

	public void insertMember(Member member) {
		KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
						PreparedStatement psmt = con.prepareStatement(
							"INSERT INTO member VALUES(member_seq.nextval,?,?,?,?,?,?,?,?)",
							new String[] {"membernumber"});
						psmt.setString(1,member.getUserId());
						psmt.setString(2,member.getUserPassword());
						psmt.setString(3,member.getUserName());
						psmt.setString(4,member.getPhone());
						psmt.setString(5,member.getEmail());
						psmt.setString(6,member.getPwdQ());					
						psmt.setString(7,member.getPwdA());
						psmt.setString(8,member.getSalt());
						return psmt;
					}
				},key);
		Number keyValue = key.getKey();
		member.setMemberNumber(keyValue.longValue());
	}
	
	public void insertQnA(QnABoard qnABoard) {
		KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement psmt = con.prepareStatement(
								"INSERT INTO QnABoard VALUES(QNABoard_seq.nextval,?,?,sysdate,?,?)",
								new String[] {"boardNum"});
						
						psmt.setString(1,qnABoard.getTitle());
						psmt.setString(2,qnABoard.getWriter());
						psmt.setString(3,qnABoard.getContents());
						psmt.setInt(4, qnABoard.getOpen());
						
						return psmt;
					}
				},key);
		Number keyValue = key.getKey();
		qnABoard.setBoardNum(keyValue.longValue());
	}

//	public Member selectByEmail(String email) {
//		String sql = "SELECT * FROM member WHERE email=?";
//		
//		List<Member> results = jdbcTemplate.query(
//				sql,rowMapper,email);
//		return results.isEmpty() ? null : results.get(0);
//	}

	public Member selectByMemberNumber(long memberNumber) {
		String sql="SELECT * FROM member WHERE memberNumber=?";
		List<Member> results = jdbcTemplate.query(sql, rowMapper, memberNumber);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	public MemberAuthInfo selectByMemberNumber1(long memberNumber) {
		String sql="SELECT * FROM member WHERE memberNumber=?";
		List<MemberAuthInfo> results = jdbcTemplate.query(sql, rowMapper1, memberNumber);
		
		return results.isEmpty() ? null : results.get(0);
	}

	public LostBoard selectByBoardNum(long boardNum) {
		String sql="SELECT * FROM lostBoard WHERE boardNum=?";
		List<LostBoard> results = jdbcTemplate.query(sql, lostBoardRowMapper, boardNum);
		
		return results.isEmpty() ? null : results.get(0);
	}
	

	public FindBoard selectByFindBoardNum(long boardNum) {
		String sql="SELECT * FROM findBoard WHERE boardNum=?";
		List<FindBoard> results = jdbcTemplate.query(sql, findBoardRowMapper, boardNum);
		
		return results.isEmpty() ? null : results.get(0);
	}

	public QnABoard selectByQuestionBoardNum(long boardNum) {
		String sql="SELECT * FROM QnABoard WHERE boardNum=?";
		List<QnABoard> results = jdbcTemplate.query(sql, qnABoardRowMapper, boardNum);
		
		return results.isEmpty() ? null : results.get(0);	
	}
	
	public List<MyPageLostPostCommand> userLostPost(String id) {
		String sql="SELECT boardNum, title, writeDate, meet, (SELECT COUNT(*) FROM lostComment WHERE bNum=boardNum) AS commentNum FROM lostBoard WHERE writer=? group by boardNum, title, writeDate, meet";
		List<MyPageLostPostCommand> results = jdbcTemplate.query(sql, userLostPostMapper, id);
		
		return results.isEmpty() ? null : results;
	}
	
	public List<MyPageFindPostCommand> userFindPost(String id) {
		String sql="SELECT boardNum, title, writeDate, meet, (SELECT COUNT(*) FROM findComment WHERE bNum=boardNum) AS commentNum FROM findBoard WHERE writer=? group by boardNum, title, writeDate, meet ORDER BY boardNum";
		List<MyPageFindPostCommand> results = jdbcTemplate.query(sql, userFindPostMapper, id);
		
		return results.isEmpty() ? null : results;
	}
	
	
	// ????????? ?????????
	public void updateLostHit(long boardNum) {
		jdbcTemplate.update(
				new PreparedStatementCreator() {
			
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement psmt = con.prepareStatement(
							"UPDATE lostBoard SET HIT=HIT+1 WHERE boardNum=?");
					psmt.setLong(1,boardNum);
					return psmt;
					}
				});
	}
	
	public void updateFindHit(long boardNum) {
		jdbcTemplate.update("UPDATE findBoard SET HIT=HIT+1 WHERE boardNum=?",
				boardNum);
	}
	
	
	// ????????? ??????
	public void deleteByLostBoardNum(long boardNum) {
		String sql="DELETE FROM lostBoard WHERE boardNum=?";
		jdbcTemplate.update(sql,boardNum);
	}
	
	public void deleteByFindBoardNum(long boardNum) {
		String sql="DELETE FROM findBoard WHERE boardNum=?";
		jdbcTemplate.update(sql,boardNum);
	}

	public void deleteByQnABoardNum(long boardNum) {
		String sql="DELETE FROM QnABoard WHERE boardNum=?";
		jdbcTemplate.update(sql,boardNum);
	}
	
	public void deleteCommentByBoardNum(long boardNum, String board) {
		String sql="DELETE FROM "+board+" WHERE bNum=?";
		jdbcTemplate.update(sql,boardNum);		
	}
	
	
	// ????????? ???????????? ?????? & ?????? ??????
	public void updateMeet(long boardNum, int meet, String board) {
		String sql = "";
		
		if(meet==0) {
			sql = "UPDATE "+board+" SET meet=1 WHERE boardNum=?"; 
		}
		if(meet==1) {
			sql = "UPDATE "+board+" SET meet=0 WHERE boardNum=?";
		}
		jdbcTemplate.update(sql,boardNum);
	}
	
	
	public void updateOpen(long boardNum, int open, String board) {
		String sql = "";
		
		if(open==0) {
			sql = "UPDATE "+board+" SET open=1 WHERE boardNum=?"; 
		}
		if(open==1) {
			sql = "UPDATE "+board+" SET open=0 WHERE boardNum=?";
		}
		jdbcTemplate.update(sql,boardNum);
	}

	public void updateByQnABoardNum(long boardNum, QnABoard qnABoard) {
		String sql="update QnABoard set title=?, writer=?, writedate=sysdate, contents=?, open=? where boardNum=?";
		jdbcTemplate.update(sql,qnABoard.getTitle(),qnABoard.getWriter(),qnABoard.getContents(),qnABoard.getOpen(),boardNum);
	}
	
	public void updateByMember(long memeberNumber, Member member) {
		String sql="update member set USERNAME=?, phone=?, email=? where memberNumber=?";
		jdbcTemplate.update(sql,member.getUserName(), member.getPhone(),member.getEmail(),memeberNumber);
	}
	
	public List<LostBoard> writeLostBoard(LostBoard lb) {
		jdbcTemplate.update("INSERT INTO lostBoard (boardNum, title, writer, writeDate, kind, location, character, animal,"
				+ " gender, email, phone, lostDate, meet, memo, originalFile, originalFileExtension, storedFileName, hit) VALUES(lostBoard_seq.nextval,?,?,sysdate,?,?,?,?,?,?,?,?,0,?,?,?,?,0)",
				lb.getTitle(),
				lb.getWriter(),
				lb.getKind(),
				lb.getLocation(),
				lb.getCharacter(),
				lb.getAnimal(),
				lb.getGender(),
				lb.getEmail(),
				lb.getPhone(),
				lb.getLostDate(),
				lb.getMemo(),
				lb.getOriginalFile(),
				lb.getOriginalFileExtension(),
				lb.getStoredFileName());
		
		List<LostBoard> results = jdbcTemplate.query("SELECT * FROM lostBoard WHERE rowNum=1  ORDER BY boardNum DESC", lostBoardRowMapper);
		return results;
	}
//		KeyHolder key = new GeneratedKeyHolder();
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
//				PreparedStatement psmt = con.prepareStatement(
//						"INSERT INTO lostBoard (boardNum, title, writer, writeDate, kind, location, character, animal,"
//								+ " gender, email, phone, lostDate, meet, memo, originalFile, originalFileExtension, storedFileName, hit) VALUES(lostBoard_seq.nextval,?,?,sysdate,?,?,?,?,?,?,?,?,0,?,?,?,?,0)");
//				
//				psmt.setString(1,lb.getTitle());
//				psmt.setString(2,lb.getWriter());
//				psmt.setString(3,lb.getKind());
//				psmt.setString(4,lb.getLocation());
//				psmt.setString(5,lb.getCharacter());
//				psmt.setString(6,lb.getAnimal());
//				psmt.setString(7,lb.getGender());
//				psmt.setString(8,lb.getEmail());
//				psmt.setString(9,lb.getPhone());
//				psmt.setString(10,lb.getLostDate());
//				psmt.setString(11,lb.getMemo());
//				psmt.setString(12,lb.getOriginalFile());
//				psmt.setString(13,lb.getOriginalFileExtension());
//				psmt.setString(14,lb.getStoredFileName());
//				
//				return psmt;
//			}
//		},key);
//		Number keyValue = key.getKey();
//		lb.setBoardNum(keyValue.longValue());
//		}	

	public List<FindBoard> writeFindBoard(FindBoard fb) {
		// find ????????? ?????????
		jdbcTemplate.update("INSERT INTO findBoard (BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, "
				+ " EMAIL, FINDDATE, MEET, MEMO, PHONE, originalFile, ORIGINALFILEEXTENSION, STOREDFILENAME, HIT) "
				+ " VALUES(findBoard_seq.nextval,?,?,sysdate,?,?,?,?,?,?,0,?,?,?,?,?,0)",
				fb.getTitle(),
				fb.getWriter(),
				fb.getKind(),
				fb.getGender(),
				fb.getLocation(),
				fb.getCharacter(),
				fb.getEmail(),
				fb.getFindDate(),
				fb.getMemo(),
				fb.getPhone(),
				fb.getOriginalFile(),
				fb.getOriginalFileExtension(),
				fb.getStoredFileName());
		
		List<FindBoard> results = jdbcTemplate.query("SELECT * FROM findBoard WHERE rowNum=1  ORDER BY boardNum DESC", findBoardRowMapper);
		return results;
	}
	
	// ?????? ?????? ?????????
		public void writeBoardImg(UploadImgVo uVo, long boardNum, String board) {
			String sql="";
			if(board.equals("lostBoard")) {
				sql = "INSERT INTO uploadImg VALUES (upload_seq.nextval,?,'',?,?,?)";
			}
			if(board.equals("findBoard")) {
				sql = "INSERT INTO uploadImg VALUES (upload_seq.nextval,'',?,?,?,?)";
			}
			jdbcTemplate.update(sql,boardNum,uVo.getOriginalFile(),uVo.getOriginalFileExtension(),uVo.getStoredFileName());
			
		}

///////////////////////// ?????? (comment)
		// ?????? ?????? ????????????	
		public List<CommentVo> selectAllComment(long bNum, String board) {
			String sql="SELECT * FROM "+board+" WHERE bNum=?";
			List<CommentVo> results = jdbcTemplate.query(sql, commentRowMapper, bNum);
			
			return results.isEmpty() ? null : results;
		}
		
		// ?????? ??????
		public int insertLostComment(CommentVo cVo) {
			String sql="INSERT INTO LostComment VALUES(lost_c_seq.nextval, ?, ?, sysdate, ?)";
			jdbcTemplate.update(sql,cVo.getbNum(),cVo.getWriter(),cVo.getContent());
			return 1;
		}
				
		public int insertFindComment(CommentVo cVo) {
			String sql="INSERT INTO FindComment VALUES(find_c_seq.nextval, ?, ?, sysdate, ?)";
			jdbcTemplate.update(sql,cVo.getbNum(),cVo.getWriter(),cVo.getContent());
			return 1;
		}
		
		// ?????? ??????
		public int modifyComment(long cNum, String content, String board) {
			String sql="UPDATE "+board+" SET content=? WHERE cNum=?";
			jdbcTemplate.update(sql,content,cNum);
			return 1;
		}
	
		// ?????? ??????
		public int deleteComment(long cNum, String board) {
			String sql="DELETE FROM "+board+" WHERE cNum=?";
			jdbcTemplate.update(sql,cNum);
			return 1;
		}

	// ?????????????????? ?????? ????????????
	public List<UploadImgVo> selectUploadImgByBoardNum(long boardNum, String where) {
		String sql = "SELECT * FROM uploadImg WHERE "+where+"=?";
		List<UploadImgVo> results = jdbcTemplate.query(sql, uploadImgMapper, boardNum);
		return results;
	}
	
	// ?????????????????? ?????? ????????????
	public List<UploadImgVo> selectOneImage() {
		List<UploadImgVo> results = jdbcTemplate.query("SELECT lostNum,max(storedFileName) FROM uploadImg GROUP BY lostnum",uploadImgMapper);
		return results;
	}
	
	// ?????????????????? ??????(????????? ?????????)
	public void deleteImgByBoardNum(long boardNum, String where) {
		String sql = "DELETE FROM  uploadImg WHERE "+where+"=?";
		jdbcTemplate.update(sql,boardNum);
	}
	
	// ?????????????????? ??????(????????? ?????????)
	public void deleteImgByiNum(long iNum) {
		String sql = "DELETE FROM uploadImg WHERE iNum=?";
		jdbcTemplate.update(sql,iNum);
	}
		
	// ????????? ??????
	public void modifyLostBoard(LostBoard lb, long boardNum) {
		jdbcTemplate.update("UPDATE lostBoard SET title=?, kind=?, location=?, character=?, animal=?, gender=?, email=?, phone=?, lostDate=?, memo=?, originalFile=?, originalFileExtension=?, storedFileName=? WHERE boardNum=?",
				lb.getTitle(),
				lb.getKind(),
				lb.getLocation(),
				lb.getCharacter(),
				lb.getAnimal(),
				lb.getGender(),
				lb.getEmail(),
				lb.getPhone(),
				lb.getLostDate(),
				lb.getMemo(),
				lb.getOriginalFile(),
				lb.getOriginalFileExtension(),
				lb.getStoredFileName(),
				boardNum);		
	}
	
	public void modifyFindBoard(FindBoard fb, long boardNum) {
		System.out.println("dao??? ????????? boardNum : "+boardNum);
		jdbcTemplate.update("UPDATE findBoard SET title=?, kind=?, location=?, character=?, gender=?, email=?, phone=?, findDate=?, memo=?, originalFile=?, originalFileExtension=?, storedFileName=? WHERE boardNum=?",
				fb.getTitle(),
				fb.getKind(),
				fb.getLocation(),
				fb.getCharacter(),
				fb.getGender(),
				fb.getEmail(),
				fb.getPhone(),
				fb.getFindDate(),
				fb.getMemo(),
				fb.getOriginalFile(),
				fb.getOriginalFileExtension(),
				fb.getStoredFileName(),
				boardNum);		
	}
	
	
	// ?????? ??????
	public void writeReview(String review, long boardNum) {
		System.out.println("???????????? ??????-find");
		jdbcTemplate.update("UPDATE findBoard SET REVIEW=? WHERE boardNum=?", review, boardNum);
	}
	
	public void writeReview2(String review, long boardNum) {
		System.out.println("???????????? ??????-lost");
		jdbcTemplate.update("UPDATE lostBoard SET REVIEW=? WHERE boardNum=?", review, boardNum);
	}
	
	// ??????????????? ?????? ?????? ??????
	public void myInfoUpdate(long memberNumber, MemberAuthInfo myInfoUpdate) {
		System.out.println("??????????????? ???????????? ??????");
		String sql="update member set username=?, phone=?, email=? where membernumber=?";
		jdbcTemplate.update(sql,myInfoUpdate.getUserName(), myInfoUpdate.getPhone(), myInfoUpdate.getEmail(), memberNumber);
	}
	
	
	// ?????? ??? ?????? 
//	public List<FindBoard> selectByFindWriteDate(Date from,Date to){
//		List<FindBoard> result = jdbcTemplate.query(
//				"SELECT * FROM FINDBOARD WHERE WRITEDATE BETWEEN ? AND ? ORDER BY WRITEDATE ASC",findBoardRowMapper,from,to);
//		return result;			
//	}
//	public List<LostBoard> selectByLostWriteDate(Date from,Date to){
//		List<LostBoard> result = jdbcTemplate.query(
//				"SELECT * FROM LOSTBOARD WHERE WRITEDATE BETWEEN ? AND ? ORDER BY WRITEDATE ASC", lostBoardRowMapper,from,to);
//		return result;	
//	}
//	public List<QnABoard> selectByQnAWriteDate(Date from,Date to){
//		List<QnABoard> result = jdbcTemplate.query(
//				"SELECT * FROM LOSTBOARD WHERE WRITEDATE BETWEEN ? AND ? ORDER BY WRITEDATE ASC", qnABoardRowMapper,from,to);
//	return result;	
//	}

	// ??????????????? ?????? ???????????? ??????
	public void myPasswordUpdate(long memberNumber, MemberAuthInfo myPasswordUpdate) {
		String sql="update member set userpassword=? where memberNumber=?";
		jdbcTemplate.update(sql,myPasswordUpdate.getUserPassword(),memberNumber);
	}
	// ???????????? ?????? ??? ???????????? ??????
	public void myPasswordUpdate(MemberAuthInfo myPasswordUpdate, String salt) {
		String sql="update member set userpassword=?, salt=? where userId=?";
		jdbcTemplate.update(sql,myPasswordUpdate.getUserPassword(),salt,myPasswordUpdate.getUserId());
	}
	// db?????? id??? salt??? ????????????
	public String getSaltByMember(String userId) {
		String sql="SELECT * FROM member WHERE userId=?";
		List<Member> results = jdbcTemplate.query(sql,saltRowMapper,userId);
		return results.get(0).getSalt();
	}
	
	// ?????????????????? ????????? ??????
//	public void addServiceComment(ServiceCommentDto newComment) {
//		System.out.println("service comment");
//		
//		KeyHolder key = new GeneratedKeyHolder();
//		jdbcTemplate.update(
//				new PreparedStatementCreator() {
//					
//					@Override
//					public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
//						PreparedStatement psmt = con.prepareStatement(
//							"INSERT INTO SERVICECOMMENT VALUES(serviceComment_seq.nextval,?,?)",
//							new String[] {"serviceComment"});
//						
//						psmt.setDate(1,newComment.getWriteDate());
//						psmt.setString(2,newComment.getContent());					
//						return psmt;
//					}
//				},key);
//		Number keyValue = key.getKey();
//		serviceComment.setCnum(keyValue.longValue());
//	}
}

