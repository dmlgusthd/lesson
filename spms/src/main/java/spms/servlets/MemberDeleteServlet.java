package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;

		try {
			ServletContext sc = this.getServletContext();
			Class.forName(sc.getInitParameter("driver"));
			conn = DriverManager.getConnection(
						sc.getInitParameter("url"),
						sc.getInitParameter("username"),
						sc.getInitParameter("password")); 
			stmt = conn.createStatement();
			stmt.executeUpdate(
					"DELETE FROM MEMBERS WHERE MNO=" + 
					request.getParameter("no"));
			
			response.sendRedirect("list");
			
		} catch (Exception e) {
			throw new ServletException(e);
			
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (conn != null) conn.close();} catch(Exception e) {}
		}

	}
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {MemberDao dao = new MemberDao();
	if(request.getParameter("no") != null){
		int no = Integer.parseInt(request.getParameter("no"));
		Member member = new Member();
		member.setNo(no);
		
		try {
			ServletContext sc = this.getServletContext();
			Connection connection = (Connection)sc.getAttribute("conn");
			dao.delete(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
}
}