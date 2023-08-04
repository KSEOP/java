package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.MemberDAO;
import jdbc.dto.Member;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl dao = new MemberDAOImpl();

	private MemberDAOImpl() {
		System.out.println("MemberDAOImpl Creating... Using Singleton");
	}

	public static MemberDAOImpl getInstance() {
		return dao;
	}

///---------- 공통적으로 반복되는 로직 ------------///
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if (ps != null) ps.close();
		if (conn != null) ps.close();
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (rs != null)
			rs.close();
		ps.close();
		conn.close();
	}
///---------------------------------------///
	/*public boolean idExists(int id, Connection conn) throws SQLException {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
			
			String query = "SELECT ID FROM CUSTOM WHERE ID=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			return rs.next(); // next 했는데 있으면 자체적으로 true, 없으면 false임.					

		
	}
*/
	@Override
	public void insertMember(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
				conn = getConnect();
				String query = "INSERT INTO MEMBER (ID, NAME, EMAIL, PHONE) VALUES(seq_id,?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, member.getName());
				ps.setString(2, member.getEmail());
				ps.setString(3, member.getPhone());
				
				System.out.println(ps.executeUpdate()+" 명 회원 등록.");
	
				
		}finally{
			closeAll(conn, ps);
		}
	}

	@Override
	public void deleteMember(int id) {
		
	}

	@Override
	public void updateMember(Member member) {
		
	}

	@Override
	public Member getMember(int id) {
		return null;
	}

	@Override
	public ArrayList<Member> getMember() {
		return null;
	}

	@Override
	public ArrayList<Member> getMember(String name) {
		return null;
	}

	

	
	
	
	
	
}
