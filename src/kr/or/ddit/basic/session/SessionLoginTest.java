package kr.or.ddit.basic.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class SessionLoginTest
 */
@WebServlet("/SessionLoginTest.do")
public class SessionLoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	static boolean login;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLoginTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String viewPage = "/basic/03/sessionLoginResult.jsp";
		
		String user = (String)session.getAttribute("id");
		if (user == null) {
			viewPage = "/basic/03/sessionLogin.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(viewPage);
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		String viewPage = "/basic/03/sessionLoginResult.jsp";
		
		HttpSession session = request.getSession();
		if (id != null || pass != null) {
			if (id.equals("admin") && pass.equals("1234")) {
				session.setAttribute("id", id);
			}
		}

		RequestDispatcher disp = request.getRequestDispatcher(viewPage);
		disp.forward(request, response);
	}

}
