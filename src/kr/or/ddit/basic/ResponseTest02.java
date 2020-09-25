package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward용 서블릿
		// forward - 특정 서블릿에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
		// 			 (이때 파라미터를 넘길 수 있다.)
		// 상대방에게 페이지 주소를 숨길 때 사용할 수 있으며, redirect보다 성능이 좋다.
		// URL주소는 바뀌지 않으며, 내부에서만 접근이 가능하다.
		
		// 이때 사용하는 객체는 RequestDispatcher객체이다.
		
		// 이동되는 페이지로 값을  넘기려면 request객체의 setAttribute()메서드로 데이터를 세팅하여 보내고
		// 받는 쪽에서는 getAttribute()메서드로 데이터를 읽어온다.
		// 형식)setAttribute("key", "value"); key값은 문자열, value값은 모든 데이터를 다 사용할 수 있다.
		request.setAttribute("tel", "010-1234-1234");
		
		// getRequestDispatcher("forward할 서블릿 또는 문서명");
//		RequestDispatcher rd = request.getRequestDispatcher("/ForwardTest.do");
		RequestDispatcher rd = request.getRequestDispatcher("/basic/01/jspTest.jsp");
		
		rd.forward(request, response);	// forward를 할 때 Request객체와 Response객체를 넘겨준다.
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
