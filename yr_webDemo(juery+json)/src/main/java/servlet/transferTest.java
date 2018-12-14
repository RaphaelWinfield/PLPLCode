package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.BookDaoImpl;
import dao.IBookDAO;
import entity.Book;

public class transferTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		PrintWriter out = response.getWriter();
		
		IBookDAO bookDAO = new BookDaoImpl();
		List<Book> bookAll = bookDAO.getUserAll();
		
		Gson gson = new Gson();
		String info = gson.toJson(bookAll);
		System.out.println(info);
		out.write(info);

		/*
		 * Gson gson = new Gson(); ArrayList<User> arraylistUsers = new
		 * ArrayList<User>(); User user1=new User(); user1.setUsername("1");
		 * user1.setPassword("2");
		 * 
		 * User user2=new User(); user2.setUsername("3"); user2.setPassword("4");
		 * 
		 * arraylistUsers.add(user1); arraylistUsers.add(user2);
		 * 
		 * String info=gson.toJson(arraylistUsers);
		 */

//		String username = request.getParameter("name");
//		String password = request.getParameter("pwd");
//
//		System.out.println("UserName:" + username + ";" + "PassWord:" + password);
//		String info = gson.toJson("name=" + username + " pwd=" + password);
//		System.out.println(info);
//
//		out.write(info);
//		out.flush();
//		out.close();

//		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		/** 璁剧疆鍝嶅簲澶村厑璁竌jax璺ㄥ煙璁块棶 **/
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		/* 鏄熷彿琛ㄧず鎵�鏈夌殑寮傚煙璇锋眰閮藉彲浠ユ帴鍙楋紝 */ response.setHeader("Access-Control-Allow-Methods", "GET,POST");
//		/**
//		 * 鎺ユ敹json
//		 */
//		String name = request.getParameter("name");
//		String pwd = request.getParameter("pwd");
//		System.out.println(name);
//		System.out.println(pwd);
//		/**
//		 * 杩斿洖json
//		 */
//		/*PrintWriter out = response.getWriter();
//		String title = "鎴愭灉";
//		String docType = "<!DOCTYPE html> \n";
//		out.println(
//				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
//						+ "<h1 align=\"center\">" + title + "</h1>\n" + "鐧婚檰鎴愬姛\r\n" + "</body>\r\n" + "</html>");						
//		out.close();*/
//		
//
//		request.setAttribute("connection","OK");
//		request.getRequestDispatcher("/index.jsp").forward(request, response);//杞彂鍒版垚鍔熼〉闈�
//		//response.sendRedirect("index.jsp");
	}

}
