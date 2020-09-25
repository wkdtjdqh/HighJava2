package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieLoginServlet
 */
@WebServlet("/CookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpass");
		String rm = request.getParameter("chkid");	// ok(value 값), null

		Cookie idCk = new Cookie("id", URLEncoder.encode(id, "utf-8"));
		
		if (rm == null) {
			idCk.setMaxAge(0);
		}
		response.addCookie(idCk);
		
		// 로그인 여부 처리
		if (id != null && pw != null) {
			if (id.equals("admin") && pw.equals("1234")) {	// 로그인 성공
				response.sendRedirect(request.getContextPath() + "/basic/02/cookieMain.jsp");
			} else {	// 로그인 실패
				response.sendRedirect(request.getContextPath() + "/basic/02/cookieMain.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/basic/02/cookieMain.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
