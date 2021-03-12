package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/JSONServlet.do")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String choice = request.getParameter("choice");
		
		Gson gson = new Gson();
		//JSON으로 변환될 데이터가 저장될 변수
		String jsonData = null;
		
		switch(choice) {
		case "str" : 
			String str = "안녕하세요";
			jsonData = gson.toJson(str);
			break;

		case "array" : 
			int[] array = {1 , 2, 3, 4};
			jsonData = gson.toJson(array);
			break;
		
		case "obj" : 
			SampleVO obj = new SampleVO("a001", "abc123", 20);
			jsonData = gson.toJson(obj);
			break;
			
		case "list" : 
			List<SampleVO> list = new ArrayList<>();
			list.add(new SampleVO("b001", "b123", 30));
			list.add(new SampleVO("c001", "e123", 40));
			list.add(new SampleVO("d001", "d123", 50));
			list.add(new SampleVO("e001", "c123", 60));
			jsonData = gson.toJson(list);
			break;
			
		case "map" : 
			HashMap<String, String> map = new HashMap<>();
			map.put("name", "성춘향");
			map.put("tel", "010-1234-4567");
			map.put("주소", "대전시 중구 대흥동");
			jsonData = gson.toJson(map);
			break;
			
		}
		
		System.out.println("jsonData: " + jsonData);
		
		//변환될 JSON데이터를 응답으로 보내준다.
		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8"); 
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
