package kr.or.ddit.basic.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/downloadServlet.do")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int buffer_size = 1024 * 100;
		request.setCharacterEncoding("utf-8");
		String fileName = request.getParameter("filename");
		String downloadPath = "d:/d_other/uploadFiles";
		String filePath = downloadPath + File.separator + fileName;

		File file = new File(filePath);
		OutputStream outstream = null;
		FileInputStream fin = null;
		if (file.exists()) { // Download할 파일이 있는지 검사
			// Download진행 순서
			// 1. ContentType 설정
			response.setContentType("application/octet-stream; charset=utf-8");

			// 2. Response객체의 헤더에 'Content-Disposition'속성을 설정한다.
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=\"" + getDisposition(file.getName(), getBrowser(request))
					+ "\";";
			response.setHeader(headerKey, headerValue);

			// 3. 디스크에서 파일을 읽어서 클라이언트로 전송
			try {
				// 출력용 스트림 객체 생성
				outstream = response.getOutputStream();

				// 파일 입력용 스트림 객체 생성
				fin = new FileInputStream(file);
				byte[] buffer = new byte[buffer_size];
				int len = -1;

				// byte배열을 이용해서 파일 내용을 읽어와 출력용 스트림으로 출력한다.
				while ((len = fin.read(buffer)) > 0) {
					outstream.write(buffer, 0, len);
				}

			} catch (IOException e) {
				System.out.println("입출력 오류" + e.getMessage());
			} finally {
				outstream.flush();
				if (fin != null) {
					fin.close();
				}
				if (outstream != null) {
					outstream.close();
				}
			}
		} else {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + fileName + " 파일은 존재하지 않습니다.</h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 사용자의 웹브라우저 종류를 구분하는 메서드
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) { // 익스플로러
			return "MSIE";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		} else if (header.indexOf("Trident/7.0") > -1) { // 익스플로러
			return "MSIE";
		}
		return "firefox";
	}

	// 웹브라우저 별로 파일명을 인코딩하는 메서드
	private String getDisposition(String filename, String browser) {
		String encodedFilename = null; // 인코딩 된 파일명이 저장될 변수
		try {
			switch (browser) {
			case "MSIE":
				encodedFilename = URLEncoder.encode(filename, "utf-8").replace("\\+", "%20");
				break;
			case "Chrome":
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < filename.length(); i++) {
					char c = filename.charAt(i);
					if (c > '~') {// 영문자를 골라서
						sb.append(URLEncoder.encode("" + c, "utf-8"));
					} else {
						sb.append(c);
					}
				}
				encodedFilename = sb.toString();
				break;
			case "firefox":
				encodedFilename = "\"" + new String(filename.getBytes("utf-8"), "8859_1") + "\"";
				break;
			default:
				throw new RuntimeException("Notsupported Browser");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encodedFilename;
	}

}
