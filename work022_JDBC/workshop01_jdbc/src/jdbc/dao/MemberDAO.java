package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dto.Member;

public interface MemberDAO {
	
// 비즈니스 로직 템플릿
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;
	void insertMember(Member member) throws SQLException;
	void deleteMember(int id) throws SQLException;
	void updateMember(Member member) throws SQLException;
	Member getMember(int id) throws SQLException;
	ArrayList<Member> getMember() throws SQLException;
	ArrayList<Member> getMember(String name) throws SQLException;
	
	
}
