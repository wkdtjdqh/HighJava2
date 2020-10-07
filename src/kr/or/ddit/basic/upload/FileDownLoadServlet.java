package kr.or.ddit.basic.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownLoadServlet
 */
@WebServlet("/FileDownLoadServlet.do")
public class FileDownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "d:/d_other/uploadFiles";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일명을 파라미터로 받는다.
		String fileName = request.getParameter("fileName");
		
		String filePath = UPLOAD_DIR + File.separator + fileName;
		
		File file = new File(filePath);
		if (file.exists()) {
			FileInputStream fis = null;
			OutputStream os = null;
			try {
				// ContentType 설정
				response.setContentType("application/octet-stream; charset=utf-8");
				
				String encodeFileName = getFileNameEncoding(fileName, getBrowser(request));
				
				// Response의 Header에 content-disposition속성 설정
				response.setHeader("Content-Disposition", "attachment; filename=\"" + encodeFileName + "\"");
				
				// 출력용 스트림 객체 생성 ==> Response객체 이용
				os = response.getOutputStream();
				
				// 파일 입력용 스트림 객체 생성
				fis = new FileInputStream(file);
				
				byte[] buffer = new byte[8192];
				int bytesRead = -1;
				
				// byte배열을 이용해서 파일 내용을 읽어와 출력용 스트림으로 출력한다.
				while((bytesRead = fis.read(buffer)) != -1){
					os.write(buffer, 0, bytesRead);
				}
				os.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if(fis != null) fis.close();
				if(os != null) os.close();
			}
		} else {	// 파일이 없을 경우의 처리
			response.setContentType("text/html charset=utf-8");
			response.getWriter().println("<h3>파일이 존재하지 않습니다.</h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	// 사용중인 웹브라우저 종류를 반환하는 메서드
	private String getBrowser(HttpServletRequest request){
		String header = request.getHeader("User-Agent");	// 웹브라우저에 헤더가 존재하는데 헤더에 User-Agent라는 속성이 있다. User-Agent에 웹브라우저의 종류에 대한 데이터가 들어있다.
		
		if(header.indexOf("MSIE") > -1){
			return "MSIE";
		} else if(header.indexOf("Chrome") > -1){
			return "Chrome";
		} else if(header.indexOf("Opera") > -1){
			return "Opera";
		} else if(header.indexOf("Trident/7.0") > -1){	// IE 11.0 이상
			return "MSIE";
		}
		
		return "Firefox";
	}
	
	// 웹브라우저별로 한글 파일명을 encoding해서 반환하는 메서드
	private String getFileNameEncoding(String fileName, String borwser) throws Exception{
		String encodedFileName = null;
		
		if ("MSIE".equals(borwser)) {
			encodedFileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");	// 인코딩을하면 공백이 +로 바뀌게 되는데 다시 공백으로 바꾸는 작업. (%20 ==> 코드값 32 : 공백)
		} else if("Firefox".equals(borwser) || "Opera".equals(borwser)){
			encodedFileName = "\"" + new String(fileName.getBytes("utf-8"), "8859_1") + "\"";
		} else if("Chrome".equals(borwser)){
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<fileName.length(); i++){
				char c = fileName.charAt(i);
				if (c > '~') {	// c의 코드값이 ~보다 크면
					// '~'문자는 ASCII문자 중 제일 마지막 위치의 문자이다.
					sb.append(URLEncoder.encode(""+c, "utf-8"));
				} else{
					sb.append(c);
				}
			}
			encodedFileName = sb.toString();
		}else {
			throw new RuntimeException("Not supported Borowser");
		}
		return encodedFileName;
	}

}
