package kr.or.ddit.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 필터 클래스명 : CustomEncodingFilter
 * 필터의 기능 : 요청과 응답의 인코딩 방식을 필터의 <init-param>에 설정한 값으로 설정한다.
 * 필터의 적용 범위 : 모든 URL에 대해서 처리가 되도록 한다.
 */
public class CustomEncodingFilter implements Filter{
	private String encoding;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 요청에 대한 인코딩 설정
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
		// 응답에 대한 인코딩 설정
		response.setCharacterEncoding(encoding);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if (filterConfig.getInitParameter("encoding") == null) {
			encoding = "utf-8";
		} else{
			encoding = filterConfig.getInitParameter("encoding");
		}
	}

}
