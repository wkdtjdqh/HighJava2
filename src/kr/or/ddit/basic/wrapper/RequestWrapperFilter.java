package kr.or.ddit.basic.wrapper;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// RequestWrapper클래스를 등록하는 Filter
public class RequestWrapperFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// RequestWrapper객체 생성
		RequestWrapperTest requestWrapper = new RequestWrapperTest((HttpServletRequest)request);
		// 만약 ResponseWrapper객체도 등록하려면 이 곳에서 같이 생성한다.
		
		// 필터 체이닝에서 원래의 Request객체 대신 RequestWrapper객체를 인수로 넣어준다.
		chain.doFilter(requestWrapper, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
