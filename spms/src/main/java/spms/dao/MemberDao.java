package spms.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import spms.vo.Member;

public class MemberDao {
	Connection connection;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	
	public int insert(Member member) throws Exception {
		int resultset = 0;
		String sql = "INSERT INTO MEMBERS(EMAIL,PWD,MNAME,CRE_DATE,MOD_DATE) VALUES (?,?,?,NOW(),NOW())";
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getName());
			resultset = stmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
		}
		return resultset;
	}
	
	public int delete(Member member) throws Exception {
		int resultset = 0;
		String sql = "DELETE FROM MEMBERS WHERE MNO=?";
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, member.getNo());
			resultset = stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
		}
		return resultset;
	}

	public List<Member> selectList() throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT MNO,MNAME,EMAIL,CRE_DATE FROM MEMBERS ORDER BY MNO ASC");
			
			ArrayList<Member> members = new ArrayList<Member>();
			
			// �����ͺ��̽����� ȸ�� ������ ������ Member�� ��´�.
			// �׸��� Member��ü�� ArrayList�� �߰��Ѵ�.
			while(rs.next()) {
				members.add(new Member()
							.setNo(rs.getInt("MNO"))
							.setName(rs.getString("MNAME"))
							.setEmail(rs.getString("EMAIL"))
							.setCreatedDate(rs.getDate("CRE_DATE"))	);
			}
			return members;
		}catch(Exception e){
			throw e;
		}finally{
			try {if (rs != null) rs.close();} catch(Exception e) {}
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			
		}
		
		
	}
}
