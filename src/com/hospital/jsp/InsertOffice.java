package com.hospital.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.dao.GuideDao;
import com.hospital.dao.OfficeDao;

public class InsertOffice extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertOffice() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String oid=request.getParameter("office.oid");
		String oname=request.getParameter("office.oname");
		String docname=request.getParameter("office.docname");
		String content=request.getParameter("office.content");
		String phone=request.getParameter("office.phone");
		String ontime=request.getParameter("office.ontime");
		String need=request.getParameter("office.need");
		
		OfficeDao dao=new OfficeDao();
		int pd=0;
		if(oid.length()>0){
			 pd=dao.update(Integer.parseInt(oid), oname, docname, content, phone, ontime, Integer.parseInt(need));
		}else{
			 pd=dao.add(oname, docname, content, phone, ontime, Integer.parseInt(need));
		}
		if (pd>0) {
			response.sendRedirect("../selectoffice.jsp");
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
