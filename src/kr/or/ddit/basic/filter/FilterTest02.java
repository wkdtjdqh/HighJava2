package kr.or.ddit.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest02 implements Filter{

	@Override
	public void destroy() {
		System.out.println("두번째 Filter - destroy()메서드 호출...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("두번째 Filter - doFilter()메서드 호출전...");
		
		chain.doFilter(request, response);
		
		System.out.println("두번째 Filter - doFilter()메서드 호출후...");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("두번째 Filter - init()메서드 호출...");
		
		// 초기화 파라미터 정보 가져오기
		String param1 = filterConfig.getInitParameter("tester");
		System.out.println("test : " + param1);
		
		String param2 = filterConfig.getInitParameter("date");
		System.out.println("date : " + param2);
	}

}
