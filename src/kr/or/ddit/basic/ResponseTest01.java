package kr.or.ddit.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// redirect용 서블릿
		// redirect ==> 다른 페이지로 넘어가도록 한다.
		// 요청을 받게되면 url을 클라이언트에게 전달하고, 클라이언트(웹브라우저)가 새로운 url을 요청하고
		// 그에 따른 응답을 한다.
		// url값이 넘어가기 때문에 길이에 제한이 없다. (GET방식 규칙)
		String userName = request.getParameter("username");
		
		// 파라미터로 받아온 데이터와 tel파라미터에 전화번호를 넣어서 전송할 예정
		
		// 형식) sendRedirect("리다이렉트할 URL주소");
		//		전송할 데이터는 GET방식으로 보낼 수 있다.
//		response.sendRedirect("/servletTest/RedirectTest.do?username=" + userName + "&tel=010-1234-1234");
		response.sendRedirect("/servletTest/basic/01/jspTest.jsp?username=" + userName + "&tel=010-1234-1234");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
