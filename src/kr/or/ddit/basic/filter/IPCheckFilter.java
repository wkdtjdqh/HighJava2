package kr.or.ddit.basic.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 현재 컴퓨터에서만 접속이 가능하고 다른 컴퓨터에서는 접속이 불가능하도록 한다.
 * 적용 범위 : jsp파일만
 * 
 * 현재 컴퓨터를 나타내는 IP주소
 *  - 127.0.0.1
 *  - 0:0:0:0:0:0:0:1
 *  - 각 컴퓨터에 설정된 IP주소 예) 192.168.43.39
 */
public class IPCheckFilter implements Filter{
	private static Map<String, String> ipMap;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String ip = request.getRemoteAddr();	// 접속한 IP주소
		System.out.println("접속 IP : " + ip);
		if (ip != null && ipMap.containsKey(ip)) {	// 목록에서 찾기
			if ("T".equals(ipMap.get(ip))) {	// 허용되는지 여부 확인
				chain.doFilter(request, response);
			} else{
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				
				out.print("<h2>접근이 거부되었습니다.<br>");
				out.print("관리자에게 문의하세요.</h2>");
			}
		} else{	// 목록에 없으면
			// 무조건 특정한 페이지로 이동시킨다.
			HttpServletResponse res = (HttpServletResponse)response;
			HttpServletRequest rq = (HttpServletRequest)request;
			
			res.sendRedirect(rq.getContextPath() + "/basic/01/doBasicServlet.jsp");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// 허용 또는 불허되는 IP주소 정보를 구성한다.
		ipMap = new HashMap<>();
		ipMap.put("127.0.0.1", "T");	// 허용
		ipMap.put("0:0:0:0:0:0:0:1", "T");
		ipMap.put("192.168.43.39", "T");
		ipMap.put("192.168.43.38", "F");
	}

}
