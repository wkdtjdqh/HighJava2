package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 저장된 쿠키를 읽어오는 서블릿
 */
@WebServlet("/CookieReadServlet.do")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		/*
			저장된 쿠키 읽어오기
			1) 전체 쿠키 정보를 request객체를 통해서 가져온다.
				==> 이때 가져온 쿠키 정보들은 배열에 저장된다.
			형식) Cookie[] 쿠키배열변수 = request.getCookie();
		*/
		Cookie[] cookieArr = request.getCookies();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><head><meta charset='utf-8'><title>Cookie 연습</title></head>");
		out.println("<body><h2>저장된 Cookie 데이터 확인하기</h2><br><br>");
		
		if(cookieArr == null || cookieArr.length == 0){
			out.println("<h2>저장된 쿠키 정보가 하나도 없습니다.</h2>");
		}
		// 2) 쿠키 배열에서 해당 쿠키 정보를 구해온다.
		for(Cookie cookie : cookieArr){
			String name = cookie.getName();		// '쿠키변수' 가져오기
			
			// 쿠키값으로 저장된 데이터가 한글일 경우 디코딩해서 사용한다.
			// URLDecoder.decode()메서드 사용
			String value = URLDecoder.decode(cookie.getValue(), "utf-8");	// '쿠키값' 가져오기
			out.println("쿠키변수 : " + name + "<br>");
			out.println("쿠키값 : " + value + "<hr>");
		}
		
		out.println("<br><a href='" + request.getContextPath() + "/basic/02/cookieTest.jsp'>시작 문서로 이동</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
