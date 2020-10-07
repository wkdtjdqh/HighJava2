package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class JSONTestServlet
 */
@WebServlet("/JSONTestServlet.do")
public class JSONTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");	// JSON응답 설정
		
		// 문자열
		String str = "안녕하세요. 물자열만 있는 JSON입니다.";
		// 배열
		int[] intArr = {100, 200, 300, 400, 500};
		// 객체(Map도 이런 방법으로 함)
		Sample sample = new Sample(100, "홍길동");
		// 리스트 컬렉션
		List<Sample> samList = new ArrayList<>();
		samList.add(new Sample(101, "홍길동"));
		samList.add(new Sample(102, "홍길서"));
		samList.add(new Sample(103, "홍길남"));
		samList.add(new Sample(104, "홍길북"));
		
		// Gson객체 생성
		Gson gson = new Gson();
		
		// JSON형태의 문자열로 변환하기
		String jsonStr = gson.toJson(str);
		String jsonArr = gson.toJson(intArr);
		String jsonObj = gson.toJson(sample);
		String jsonList = gson.toJson(samList);
		
		PrintWriter out = response.getWriter();
//		out.write(jsonStr);	// 응답 데이터가 문자열인 경우
//		out.write(jsonArr);	// 응답 데이터가 배열인 경우
//		out.println(jsonObj);	// 응답 데이터가 객체인 경우
		out.println(jsonList);	// 응답 데이터가 리스트인 경우
		
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
