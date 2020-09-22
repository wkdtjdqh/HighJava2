package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Servlet implementation class ServletTest04
 */
@WebServlet("/servletTest04.action")
public class ServletTest04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletTest04() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		Servlet클래스나 JSP페이지의 환경에 관한 정보는 ServletContext인터페이스 타입의 객체를 이용해서 구할 수 있다.
		 
		*/
		ServletContext context = this.getServletContext();
		
		String serverInfo = context.getServerInfo();	// Servlet이 속한 웹 서버의 종류 구하기
		
		// 웹 컨테이너가 지원하는 Servlet규격서의 메이저 버전과 마이너 버전 구하기
		int majorVersion = context.getMajorVersion();
		int minorVersion = context.getMinorVersion();
		
		String servletName = this.getServletName();	// 서블릿 이름 구하기
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>웹 서버의 정보</title></head>");
		out.println("<body>");
		out.println("웹서버의 종류(ServerInfo) : " + serverInfo + "<br>");
		out.println("servletName : " + servletName + "<br>");
		out.printf("지원하는 Servlet 버전(MagerVersion, MinorVersion) : (%d, %d)<br>", majorVersion, minorVersion);
		
		/*
			웹 애플리케이션의 초기화 파라미터(web.xml에 설정한 값)
			특정 Servlet에 속하는 초기화 파라미터가 아닌 웹 애플리케이션 전체에 속하는 초기화 파라미터이다.
			
			이 초기화 파라미터는 web.xml파일이 속한 웹 애플리케이션 디렉토리의 모든 웹 컴포넌트에서 읽기가 가능하다.
			
			Servlet클래스에서는 getServletContext()메서드를 통해 ServletContext객체를 구하고,
			이 객체의 getInitParameter()메서드를 이용해서 구할 수 있다.
			
			JSP페이지에서는 application이라는 내장 객체변수의 getInitParameter()메서드를 이용해서 구한다.
			
			형식) getInitParameter("param-name값");
		*/
		String fileName = context.getInitParameter("FileName");
		out.println("web.xml에 설정한 파라미터 : " + fileName + "<br>");
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
