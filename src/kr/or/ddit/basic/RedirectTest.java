package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectTest.do")
public class RedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// redirect로 넘어온 데이터 구하기
		String userName = request.getParameter("username");
		String tel = request.getParameter("tel");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>리다이렉트 연습</title></head>");
		out.println("<body><h2>response Redirect 결과</h2>");
		out.println("<table border='1'>");
		out.println("<tr><td>이름</td><td>" + userName + "</td></tr>");
		out.println("<tr><td>전화</td><td>" + tel + "</td></tr>");
		out.println("</table>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
