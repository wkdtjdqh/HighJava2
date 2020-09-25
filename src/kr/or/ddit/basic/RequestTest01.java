package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest01
 * 
 * Request객체 관련 예제
 */
@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 전달되는 데이터의 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		// getParameter("파라미터명") ==> 해당 파라미터에 설정된 '값'을 가져온다.
		//						   ==> 가져오는 '값'의 자료형은 String이다.
		// 이 '파라미터명'은 <form>태그의 하위 태그에 만들어진 태그의 'name속성값'을 말한다.
		String userName = request.getParameter("userName");
		String job = request.getParameter("job");
		
		// getParameterValues("파라미터명) ==> 파라미터명이 같은 것이 여러개 일 경우에 사용한다.
		//								==> 가져오는 '값'의 자료형은 'String[]' 이다.
		String[] hobby = request.getParameterValues("hobby");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Request 객체 연습</title></head>");
		out.println("<body><h2>request 객체 테스트 결과 </h2><hr>");
		out.println("<table border='1'><tr><td>이름</td><td>" + userName + "</td></tr>"
					+ "<tr><td>직업</td><td>" + job + "</td></tr>");
		out.println("<tr><td>취미</td><td>"); 
		for(String hob : hobby){
			out.println(hob + "<br>");
		}
		out.println("</td></tr></table>");
		
		out.println("<hr>");
		out.println("<h2>request객체 기타 메서드 결과</h2>");
		out.println("<table border='1'><tr><td>1. 클라이언트의 IP 주소 : " + request.getRemoteAddr() + "<br>");
		out.println("2. 요청 메서드 : " + request.getMethod() + "<br>");
		out.println("3. ContextPath : " + request.getContextPath() + "<br>");
		out.println("4. 프로토콜 : " + request.getProtocol() + "<br>");
		out.println("5. 요청 URL : " + request.getRequestURL() + "<br>");
		out.println("6. 요청 URI : " + request.getRequestURI() + "<br>"); // ContextPath부터 나온다.
		out.println("</td></tr></table>");
		
		// getParameterNames()메서드 ==> 파라미터명들만 반환한다.
		// 		반환되는 값들은 Enumeration객체형으로 반환한다. Enumeration은 이터레이터와 비슷하다.
		out.println("<hr><h2>getParameterName() 메서드 결과 값들...</h2>");
		Enumeration<String> params = request.getParameterNames();
		out.println("<ul>");
		while(params.hasMoreElements()){	// 다음 데이터가 있는지 확인(있으면 true, 없으면 false)
			String paraName = params.nextElement();	// 포인터를 다음으로 이동하고 그 자리의 데이터를 반환한다.
			out.println("<li>" + paraName + "</li>");
		}
		out.println("</ul>");
		
		// getParameterMap()메서드 ==> 전송된 모든 파라미터를 Map객체에 담아서 반환한다.
		//			이 Map객체의 key값은 '파라미터명'이며 자료형은 String형이고, value값은 해당 파라미터의 '값'이며 자료형은 String[]형 이다.
		out.println("<h2>getParameterMap() 메서드 처리 결과</h2>");
		out.println("<table border=1>");
		out.println("<tr><td>파라미터 Name</td><td>파라미터 value</td></tr>");
		
		Map<String, String[]> paramMap = request.getParameterMap();
		
		// Map의 key값들을 Iterator로 가져온다.
		Iterator<String> it = paramMap.keySet().iterator();
		
		while(it.hasNext()){
			String paramName = it.next();	// key값 즉, 파라미터명을 구한다.
			out.println("<tr><td>" + paramName + "</td><td>");
			
			String[] paramValues = paramMap.get(paramName);	// Map의 value값 즉, 파라미터 값을 구한다.
			
			if(paramValues == null || paramValues.length == 0){	// 파라미터가 없는 경우
				
			} else if(paramValues.length == 1){	// 파라미터가 배열이 아닌 경우 (즉, 파라미터명이 1개인 경우)
				out.println(paramValues[0]);
			} else {	// 파라미터가 배열인 경우(즉, 파라미터명이 2개 이상인 경우)
				for(int i=0; i<paramValues.length; i++){
					if(i>0) out.println(", ");	// 값과 값 사이에 쉼표 넣기
					out.println(paramValues[i]);
				}
			}
			out.println("</td></tr>");
		}
		
		out.println("</table>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
