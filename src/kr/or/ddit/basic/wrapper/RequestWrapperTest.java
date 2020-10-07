package kr.or.ddit.basic.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Wrapper ==> 요청(Request)객체나 응답(response)객체를 포장하는 것
 * 		   ==> 요청객체나 응답객체의 메서드들을 재정의할 때 사용한다.
 * 
 * 요청객체 포장 ==> HttpServletRequestWrapper클래스를 상속받아서 작성한다.
 * 응답객체 포장 ==> HttpServletResponseWrapper클래스를 상속받아서 작성한다.
 * 
 * Wrapper클래스를 작성한 후 이 Wrapper클래스를 사용하려면 Filter를 사용해서 Wrapper클래스를 등록한다.
 */

// 예) RequestWrapper 연습
public class RequestWrapperTest extends HttpServletRequestWrapper{
	// 생성자
	public RequestWrapperTest(HttpServletRequest request) {
		super(request);	// 반드시 조상클래스의 생성자에 요청(request)객체를 넘겨줘야 한다.
	}
	
	// Request객체의 메서드 중에서 작업에 필요한 메서드를 재정의한다.
	
	// 예) getRemoteAddr()메서드 재정의
	public String getRemoteAddr(){
		String ip = super.getRemoteAddr();	// 원래의 명령 실행
		if("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)){
			return "주인님 반가워요";
		}
		return ip;
	}

	// 예) getParameter()메서드 재정의
	//		회원ID는 admin은 사용 불가 ==> 사용자가 admin을 입력하면 '사용불가' 반환
	//		회원이름은 없거나 null이면 '아무게'로 반환
	//		패스워드는 대문자로 반환해서 변환
	
	// getParameter()메서드를 재정의 할 때는 getParameterValues()메서드와 gerParameterMap()메서드로 재정의 해야만 될 경우가 대부분이다.
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if ("mem_id".equals(name)) {	// 회원ID에 대한 처리
			if ("admin".equals(value)) {
				return "사용불가";
			}
			
		}else if("mem_name".equals(name)){
			if (value == null || "".equals(value.trim())) {
				return "아무게";
			}
		}else if("mem_pass".equals(name)){	// 패스워드에 대한 처리
			if (value != null) {
				return value.toUpperCase();
			}
		}
		
		return value;
	}
}
