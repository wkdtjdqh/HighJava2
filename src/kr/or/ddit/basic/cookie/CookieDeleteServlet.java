package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 쿠키를 삭제하는 서블릿
 */
@WebServlet("/CookieDeleteServlet.do")
public class CookieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		/*
			저장된 쿠키 삭제하기
			==> 쿠키 데이터의 삭제는 쿠키의 유지시간을 0으로 설정하는 방법을 사용한다.
				형식) cookie객체변수.setMaxAge(시간);  --> 시간은 초 단위로 지정한다.
					==> 시간이 0이면 쿠키가 바로 삭제되고 시간이 음수이면 웹브라우저가 끝날 때 쿠키가 삭제된다.
					==> 시간이 양수이면 '지정된 시간' 동안 저장된 후 지정된 시간이 경과하면 자동으로 삭제된다.
		*/
		
		// 예제) 쿠키변수가 'name'인 쿠키 삭제하기
		Cookie[] cookieArr = request.getCookies();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head><meta charset='utf-8'><title>Cookie 연습</title></head>");
		out.println("<body><h2>저장된 Cookie 데이터 삭제하기</h2><br><br>");
		
		if(cookieArr == null || cookieArr.length == 0){
			out.println("<h2>저장된 쿠키 정보가 하나도 없습니다.</h2>");
		}
		
		for(Cookie cookie : cookieArr){
			String name = cookie.getName();	// 쿠키변수 가져오기
			if(name.equals("name")){	// 삭제할 쿠키변수인지 검사
				// 삭제하려는 쿠키변수와 같은 이름의 쿠키를 새로 생성한다.
				Cookie nameCookie = new Cookie("name", "any");
				nameCookie.setMaxAge(0);	// 유지시간을 0으로 변경한다.
				response.addCookie(nameCookie);
			}
		}
		
		out.println("<br><a href='" + request.getContextPath() + "/basic/02/cookieTest.jsp'>시작 문서로 이동</a>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
