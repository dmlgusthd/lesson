package spms.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

// ServletContext에 보관된 Connection 객체 사용  
//UI 출력 코드를 제거하고, UI 생성 및 출력을 JSP에게 위임한다.
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			ServletContext sc = this.getServletContext();
			Connection connection = (Connection)sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(connection);
			
			List<Member> members = memberDao.selectList();
			// request에 회원 목록 데이터 보관한다.
			request.setAttribute("members", members);
			
			// JSP로 출력을 위임한다.
			RequestDispatcher rd = request.getRequestDispatcher(
					"/member/MemberList.jsp");
			rd.include(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
			
		} 

	}
}