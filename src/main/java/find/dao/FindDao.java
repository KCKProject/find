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
import find.vo.Criteria;
import find.vo.CriteriaQnABoard;
import find.vo.FindBoard;
import find.vo.LostBoard;
import find.vo.Member;
import find.vo.MemberAuthInfo;
import find.vo.QnABoard;

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
						rs.getDate("lostDate"),
						rs.getInt("meet"),
						rs.getString("memo"),
						rs.getString("originalFile"),
						rs.getString("originalFileExtension"),
						rs.getString("storedFileName")
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
						rs.getString("img"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getDate("findDate"),
						rs.getString("memo"),
						rs.getInt("meet")
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
		
	
			/*
			 * public List<Member> selectAll() { List<Member> results = jdbcTemplate.query(
			 * "SELECT * FROM member order by membernumber ASC",rowMapper); return results;
			 * }
			 */
	
	public List<Member> selectAll(Criteria cri) {
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
	
	public int memberCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(memberNumber) FROM Member where memberNumber > 0",Integer.class);
		return cnt;
	}
	public int qnaCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM qnaboard where boardnum > 0",Integer.class);
		return cnt;
	}
	public int lostCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM qnaboard where boardnum > 0",Integer.class);
		return cnt;
	}
	public int findCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM qnaboard where boardnum > 0",Integer.class);
		return cnt;
	}
	
	
	public List<LostBoard> selectAllLostBoard() {
		List<LostBoard> results = jdbcTemplate.query(
				"SELECT * FROM lostBoard order by boardNum ASC",lostBoardRowMapper);
		return results;
	}
	
	public List<FindBoard> selectAllFindBoard() {
		List<FindBoard> results = jdbcTemplate.query(
				"SELECT * FROM findBoard order by boardNum ASC",findBoardRowMapper);
		return results;
	}
	
	public List<QnABoard> selectAllQnABoard(Criteria cri) {
		List<QnABoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, CONTENTS, OPEN " + 
				"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, CONTENTS, OPEN, row_number() " + 
				"over(order by boardnum desc) as rNum " + 
				"from qnaboard) mb where rNum between ? and ? order by boardnum asc"
				,qnABoardRowMapper,cri.getRowStart(), cri.getRowEnd());
		return results;
	}
	public List<QnABoard> selectAllQnABoard(CriteriaQnABoard cri) {
		List<QnABoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, CONTENTS, OPEN " + 
				"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, CONTENTS, OPEN, row_number() " + 
				"over(order by boardnum asc) as rNum " + 
				"from qnaboard) mb where rNum between ? and ? and open='1' order by boardnum asc"
				,qnABoardRowMapper,cri.getRowStart(), cri.getRowEnd());
		return results;
	}

	public Admin selectByAdminId(String adminId) {
		String sql = "SELECT * FROM ADMIN WHERE adminId=?";
//		System.out.println("�뼱�뱶誘� 異쒕젰 �솗�씤");
		List<Admin> results = jdbcTemplate.query(sql, adminRowMapper, adminId);
//		System.out.println("�뼱�뱶誘� 異쒕젰 �솗�씤 2");
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

	public void insertMember(Member member) {
		KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
						PreparedStatement psmt = con.prepareStatement(
							"INSERT INTO member VALUES(member_seq.nextval,?,?,?,?,?)",
							new String[] {"membernumber"});
						
						psmt.setString(1,member.getUserId());
						psmt.setString(2,member.getUserPassword());
						psmt.setString(3,member.getUserName());
						psmt.setString(4,member.getPhone());
						psmt.setString(5,member.getEmail());					
						
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
								"INSERT INTO QnABoard VALUES(QNABoard_seq.nextval,?,?,?,?,?)",
								new String[] {"boardNum"});
						
						psmt.setString(1,qnABoard.getTitle());
						psmt.setString(2,qnABoard.getWriter());
						psmt.setDate(3,qnABoard.getWriteDate());
						psmt.setString(4,qnABoard.getContents());
						psmt.setInt(5, qnABoard.getOpen());
						
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
	
	public void deleteByLostBoardNum(long boardNum) {
		String sql="DELETE FROM lostBoard WHERE boardNum=?";
		jdbcTemplate.query(sql,lostBoardRowMapper,boardNum);
	}
	
	public void deleteByFindBoardNum(long boardNum) {
		String sql="DELETE FROM findBoard WHERE boardNum=?";
		jdbcTemplate.query(sql,findBoardRowMapper,boardNum);
	}

	public void deleteByQnABoardNum(long boardNum) {
		String sql="DELETE FROM QnABoard WHERE boardNum=?";
		jdbcTemplate.query(sql,qnABoardRowMapper,boardNum);
	}
	
	public void updateMeet(long boardNum, int meet, String board) {
		String sql = "";
		
		if(meet==0) {
			System.out.println("meet媛� 0");
			sql = "UPDATE "+board+" SET meet=1 WHERE boardNum=?"; 
		}
		if(meet==1) {
			System.out.println("meet媛� 1");
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

	
	public void writeLostBoard(LostBoard lb) {
		
		System.out.println(lb.getCharacter());
//		KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update("INSERT INTO lostBoard (boardNum, title, writer, writeDate, kind, location, character, animal,"
				+ " gender, email, phone, lostDate, meet, memo, originalFile, originalFileExtension, storedFileName) VALUES(lostBoard_seq.nextval,?,?,sysdate,?,?,?,?,?,?,?,?,0,?,?,?,?)",
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
		
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
//				PreparedStatement psmt = con.prepareStatement(
//						"INSERT INTO lostBoard VALUES(lostBoard_seq.nextval,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,0);");
//						
//				psmt.setString(1,lb.getTitle());
//				psmt.setString(2,lb.getWriter());
//				psmt.setString(3,lb.getLocation());
//				psmt.setString(4,lb.getCharacter());
//				psmt.setString(5,lb.getAnimal());
//				psmt.setString(6,lb.getKind());
//				psmt.setString(7,lb.getGender());
//				psmt.setString(8,lb.getImg());
//				psmt.setString(9,lb.getEmail());
//				psmt.setString(10,lb.getPhone());
//				psmt.setDate(11,lb.getLostDate());
//				psmt.setString(12,lb.getMemo());
//				
//				return psmt;
//			}
//		},key);
//		Number keyValue = key.getKey();
//		lb.setBoardNum(keyValue.longValue());
	}
	
	
	
	
	//�씪�떒 蹂댁〈
//	//李얠븘二쇱꽭�슂 寃뚯떆湲� �벑濡� - �뿉�윭�굹硫� 二쇱꽍泥섎━
//	public void writeLostBoard(MemberAuthInfo member, LostBoardWriteCommand lC) {
//		LostBoard lostBoard = null;
//		System.out.println(lC.getCharacter());
//		KeyHolder key = new GeneratedKeyHolder();
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
//				PreparedStatement psmt = con.prepareStatement(
//						"INSERT INTO lostBoard VALUES(lostBoard_seq.nextval,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,0)",
//						new String[] {"boardNum"});
//						
//				psmt.setString(1,lC.getTitle());
//				psmt.setString(2,member.getUserId());
//				psmt.setString(3,lC.getLocation());
//				psmt.setString(4,lC.getCharacter());
//				psmt.setString(5,lC.getAnimal());
//				psmt.setString(6,lC.getKind());
//				psmt.setString(7,lC.getGender());
//				psmt.setString(8,null);
//				psmt.setString(9,member.getEmail());
//				psmt.setString(10,member.getPhone());
//				psmt.setDate(11,lC.getLostDate());
//				psmt.setString(12,lC.getMemo());
//				
//				return psmt;
//			}
//		},key);
//		Number keyValue = key.getKey();
//		lostBoard.setBoardNum(keyValue.longValue());
//	}



}
