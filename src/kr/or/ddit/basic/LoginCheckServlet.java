package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet.do")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		RequestDispatcher disp = null;
		if ("admin".equals(userid) && "1234".equals(userPass)) {
			request.setAttribute("userid", userid);
			disp = request.getRequestDispatcher("/basic/01/main.jsp");
		}else{
			disp = request.getRequestDispatcher("/basic/01/loginfail.jsp");
		}
		
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
