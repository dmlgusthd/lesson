package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>ȸ�� ���</title></head>");
		out.println("<body><h1>ȸ�� ���</h1>");
		out.println("<form action='add' method='post'>");
		out.println("�̸�: <input type='text' name='name'><br>");
		out.println("�̸���: <input type='text' name='email'><br>");
		out.println("��ȣ: <input type='password' name='password'><br>");
		out.println("<input type='submit' value='�߰�'>");
		out.println("<input type='reset' value='���'>");
		out.println("</form>");
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// CharacterEncodingFilter���� ó��
		
		request.setCharacterEncoding("euc-kr");
		int resultset = 0;
		
		String email = request.getParameter("email");
		System.out.println("email�� : "+email);
		String password = request.getParameter("password");
		System.out.println("password�� : "+password);
		String name = request.getParameter("name");
		System.out.println("name �� : "+name);
		
		MemberDao dao = new MemberDao();
		try {
			ServletContext sc = this.getServletContext();
			Connection connection = (Connection)sc.getAttribute("conn");
			dao.setConnection(connection);
			
			Member member = new Member();
			member.setEmail(email);
			member.setPassword(password);
			member.setName(name);
			resultset = dao.insert(member);
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}