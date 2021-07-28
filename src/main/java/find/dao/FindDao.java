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
import find.vo.LostBoard;
import find.vo.Member;

@Component
public class FindDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<Member> rowMapper = new RowMapper<Member>() {
		
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
			System.out.println("출력 확인");
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
				System.out.println("출력 확인");
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
					rs.getString("img"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getDate("lostDate"),
					rs.getString("memo"),
					rs.getInt("meet")
					);
			lb.setBoardNum(rs.getLong("boardNum"));
			return lb;		
		}
	};
	
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
				"SELECT * FROM member order by membernumber ASC",rowMapper);
		return results;
	}
	
	public List<LostBoard> selectAllLostBoard() {
		List<LostBoard> results = jdbcTemplate.query(
				"SELECT * FROM lostBoard order by boardNum ASC",lostBoardRowMapper);
		return results;
	}
	
	public Admin selectByAdminId(String adminId) {
		String sql = "SELECT * FROM ADMIN WHERE adminId=?";
//		System.out.println("어드민 출력 확인");
		List<Admin> results = jdbcTemplate.query(sql, adminRowMapper, adminId);
//		System.out.println("어드민 출력 확인 2");
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
	
	public void deleteByBoardNum(long boardNum) {
		String sql="DELETE FROM lostBoard WHERE boardNum=?";
		jdbcTemplate.query(sql,lostBoardRowMapper,boardNum);
	}
	
	public void updateMeet(long boardNum, int meet) {
		String sql = "";
		if(meet==0) {
			System.out.println("meet가 0");
			sql = "UPDATE lostBoard SET meet=1 WHERE boardNum=?"; 
		}
		if(meet==1) {
			System.out.println("meet가 1");
			sql = "UPDATE lostBoard SET meet=0 WHERE boardNum=?";
		}
		jdbcTemplate.update(sql,boardNum);
	}

}
