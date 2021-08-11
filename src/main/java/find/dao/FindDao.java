package find.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import find.vo.Admin;
import find.vo.Criteria;
import find.vo.CriteriaMainBoard;
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
						rs.getString("storedFileName"),
						rs.getInt("hit")
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
						rs.getInt("meet"),
						rs.getInt("hit")
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
	
	// 카운터
	
	public int memberCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(memberNumber) FROM Member where memberNumber > 0",Integer.class);
		return cnt;
	}
	public int qnaCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM qnaboard where open = 1 and boardnum > 0",Integer.class);
		return cnt;
	}
	
	public int qnaAllCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM qnaboard where boardnum > 0",Integer.class);
		return cnt;
	}
	public int lostCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM lostboard where boardnum > 0",Integer.class);
		return cnt;
	}
	public int findCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM findboard where boardnum > 0",Integer.class);
		return cnt;
	}
	public int findCompleteCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM findboard where boardnum > 0 and meet= 1",Integer.class);
		return cnt;
	}
	public int findIncompleteCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM findboard where boardnum > 0 and meet= 0",Integer.class);
		return cnt;
	}
	public int lostCompleteCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM lostboard where boardnum > 0 and meet= 1",Integer.class);
		return cnt;
	}
	public int lostIncompleteCount() {
		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(boardnum) FROM lostboard where boardnum > 0 and meet= 0",Integer.class);
		return cnt;
	}
	// 카운터 끝

	
	
	public List<LostBoard> selectAllLostBoard(Criteria cri) {
		List<LostBoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
				+ " PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE , ORIGINALFILEEXTENSION , STOREDFILENAME, HIT " + 
						"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
						+ "PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE , ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, row_number() " + 
						"over(order by boardnum desc) as rNum " + 
						"from lostBoard) mb where rNum between ? and ? order by boardnum desc"
						,lostBoardRowMapper,cri.getRowStart(), cri.getRowEnd());
		return results;
	}
	
	public List<LostBoard> selectAllLostBoard(CriteriaMainBoard cri) {
		List<LostBoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
				+ " PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE , ORIGINALFILEEXTENSION , STOREDFILENAME, HIT " + 
						"from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, LOCATION, CHARACTER, ANIMAL, GENDER, EMAIL, "
						+ "PHONE, LOSTDATE, MEET, MEMO, ORIGINALFILE, ORIGINALFILEEXTENSION , STOREDFILENAME, HIT, row_number() " + 
						"over(order by boardnum desc) as rNum " + 
						"from lostBoard) mb where rNum between ? and ? order by boardnum desc"
						,lostBoardRowMapper,cri.getRowStart(), cri.getRowEnd());
		return results;
	}
	
	public List<FindBoard> selectAllFindBoard(Criteria cri) {
		List<FindBoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, IMG, EMAIL, "
						+ " FINDDATE, MEET, MEMO, PHONE, HIT " 
						+ "from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, IMG, EMAIL, "
						+ "FINDDATE, MEET, MEMO, PHONE, HIT, row_number() " 
						+ "over(order by boardnum desc) as rNum " 
						+ "from FindBoard) mb where rNum between ? and ? order by boardnum desc",
						findBoardRowMapper,cri.getRowStart(), cri.getRowEnd());
		return results;
	}
	
	
	public List<FindBoard> selectAllFindBoard(CriteriaMainBoard cri) {
		List<FindBoard> results = jdbcTemplate.query(
				"select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, IMG, EMAIL, "
						+ " FINDDATE, MEET, MEMO, PHONE, HIT " 
						+ "from(select BOARDNUM, TITLE, WRITER, WRITEDATE, KIND, GENDER, LOCATION, CHARACTER, IMG, EMAIL, "
						+ "FINDDATE, MEET, MEMO, PHONE, HIT, row_number() " 
						+ "over(order by boardnum desc) as rNum " 
						+ "from FindBoard) mb where rNum between ? and ? order by boardnum desc",
						findBoardRowMapper,cri.getRowStart(), cri.getRowEnd());
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

	
	public void writeLostBoard(LostBoard lb) {
		
		System.out.println(lb.getCharacter());
//		KeyHolder key = new GeneratedKeyHolder();
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

	public void writeFindBoard() {
		// find 게시판 업로드
		System.out.println("dao까지 넘어옴");
	}

	public ResponseEntity<byte[]> disPlay(LostBoard detail, HttpServletRequest request) throws Exception{
        //fileName 은 /년/월/일/파일명의 형태로 입력을 받는다.
        System.out.println("서비스까지 이동");
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/imgUpload");
		System.out.println("uploadPath : "+uploadPath);
		
        InputStream in=null;
        //ResponseEntity<byte[]> 로 결과는 실제로 파일의 데이터가 된다.
        //컨트롤에서 @ResponseBody 를 이용해야 하며 
        //byte[] 데이터가 그대로 전송될 것임을 명시한다.
        ResponseEntity<byte[]> entity=null;
         
        try{
//        	String formatName =fileName.substring(fileName.lastIndexOf(".")+1);
//            
//           MediaType mType =MediaUtils.getMediaType(formatName);
        	String fileName = detail.getStoredFileName();
    		String mType = detail.getOriginalFileExtension();
            System.out.println("fileName : "+fileName);
            HttpHeaders headers =new HttpHeaders();
            //   경로 +/년/월/일 /파일이름
            in =new FileInputStream(uploadPath+fileName);
            
            //실제로 데이터를 읽는 부분은 commons 라이브러리의 기능을 활용해서 대상
            // 파일에서 데이터를 읽어내는 IOUtils.toByteArray() 이다.
            entity=new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
             
        }catch(Exception e){
            e.printStackTrace();
            entity=new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        }finally{
            in.close();
        }
        System.out.println("entity : "+entity);
        return entity;
    }
}
