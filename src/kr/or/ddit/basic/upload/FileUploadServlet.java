package kr.or.ddit.basic.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,	// 10M
		maxFileSize = 1024 * 1024 * 30,			// 30M
		maxRequestSize = 1024 * 1024 * 50		// 50M
)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 업로드된 파일이 저장될 폴더
	private static final String UPLOAD_DIR = "d:/d_other/uploadFiles";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 업로드에서는 GET방식을 선택할 수 없다.
		 					
		/*
		 	Servlet 3.0에서는 업로드 데이터 작업을 지원하는 API를 제공한다.
			- Servlet 3.0에서 Multipart 요청을 사용하려면 해당 Servlet에 @MultipartConfig 어노테이션을 설정해야 한다.
			- @MultipartConfig 어노테이션 : multipart/form-data 요청을처리하는 변수를 갖는 어노테이션이다.
				@MultipartConfig의 속성들
			 		1. fileSizeThreshold : 임계값
			 				==> 지정된 임계값보다 큰 파일이 전송되면 메모리에 저장하는 대신 디스크에 직접 기록한다.
			 		2. maxFileSize : 1개의 파일의 최대 용량 (단위 : byte)
			 		3. maxRequestSize : multipart/form-data로 보낼 수 있는 전체 용량 (단위 : byte)
			 		4. location : Part.write()메서드로 저장할 때 저장할 디렉토리
			- Part 객체 => multipart/form-data로 보내는 데이터의 각 part부분을 나타내는 객체
				part객체의 메서드
					1. getInputStream() : part의 내용을 읽는데 사용할 InputStream객체 반환
					2. getSize() : 해당 part의 전체 용량 (즉, 파일의 용량 크기와 같다.)
					3. write("저장할 파일 경로 및 파일명") : 지정한 위치에 해당 part에 속한 파일을 저장한다.
					
			------------------------------------------------------------------------------------------------
			- Part객체를 구하는 방법 (Request객체를 이용한다.)
				1. Request객체.getParts() : 전체 Part가 저장된 컬렉션은 반환한다.
				2. Requset객체.getPart("part 이름") : 지정된 이름을 가진 개별 Part객체를 반환한다.
			
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장될 폴더가 없으면 해당 폴더를 생성한다.
		File fileUploadDirectory = new File(UPLOAD_DIR);
		if (!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}
		
		String fileName = "";	// 업로드한 파일명이 저장될 변수
		
		List<UploadDetail> fileList = new ArrayList<>();
		
		// Part 개수만큼 반복
		for(Part part : request.getParts()){
			fileName = getFileName(part);	// 파일명 구하기
			
			if("".equals(fileName)) continue;	// 파일이름이 없으면 건너뛴다. (파일이 아닌 경우에 속한다.)
			
			UploadDetail details = new UploadDetail();	// 파일 정보가 저장될 객체 생성
			details.setFileName(fileName);
			details.setFileSize(part.getSize() / 1024);	// Kb단위로 변환
			
			try {
				part.write(UPLOAD_DIR + File.separator + fileName);	// 파일 저장
				details.setUploadStatus("Success");
			} catch (IOException e) {
				details.setUploadStatus("Fail : " + e.getMessage());
			}
			fileList.add(details);	// 리스트에 파일정보가 저장될 객체 추가
		}
		request.setAttribute("uploadFileList", fileList);
		
		String view = "/basic/04/fileList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}
	
	// Part 영역에서 업로드한 파일 이름을 구해서 반환하는 메서드
	private String getFileName(Part part){
		/*
			- Part의 구조
			1) 파일이 아닌 경우
				-------- adkmwdddkw29312djdoas	==> Part의 구분선
				Content-Disposition: form-data; name="memid"	==> 파라미터명
									==> 빈줄
				a001				==> 파라미터 값
			
			2) 파일인 경우
				-------- adkmwdddkw29312djdoas	==> Part의 구분선
				Content-Disposition: form-data; name="memid"; filename="test1.txt"	==> 파일정보
				Content-Type: text/plain	==> 파일 종류
											==> 빈줄
				abcdef1234가나다				==> 파일 내용
				
		*/
		
		String fileName = "";
		
		// key값으로 value값을 구해와야 한다.
		String contentDisposition = part.getHeader("content-disposition");	// content-disposition: 옆에 있는 데이터들이 문자열로 저장된다.
		String[] items = contentDisposition.split(";");
		for(String item : items){
			if (item.trim().startsWith("filename")) {	// filename으로 시작하는지?
				fileName = item.substring(item.indexOf("=") + 2, item.length()-1);
			}
		}
		
		return fileName;
	}

}
