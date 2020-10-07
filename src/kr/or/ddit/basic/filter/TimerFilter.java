package kr.or.ddit.basic.filter;

import java.awt.SecondaryLoop;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TimerFilter implements Filter{
	private double start;
	private double end;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		double start = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		HttpServletRequest req = (HttpServletRequest)request;
		double end = System.currentTimeMillis();
		double time = (end-start)/1000;

		System.out.println(req.getRequestURI() + " : " + time + "s");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
