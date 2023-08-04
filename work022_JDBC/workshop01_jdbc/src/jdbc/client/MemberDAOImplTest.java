package jdbc.client;

import java.sql.SQLException;

import config.ServerInfo;
import jdbc.dao.impl.MemberDAOImpl;
import jdbc.dto.Member;

public class MemberDAOImplTest {

	public static void main(String[] args) throws SQLException {

		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		dao.insertMember(new Member("김김김","k@naver.com","010"));
		
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail...");
		}
	}


}
