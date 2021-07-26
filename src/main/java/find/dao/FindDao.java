package find.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import find.vo.Admin;
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
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
				"SELECT * FROM member order by membernumber asc",rowMapper);
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

	public void insertMember(Member newMember) {
		// TODO Auto-generated method stub
		
	}

	public Member selectByEmail(String email) {
		
		return null;
	}

}
