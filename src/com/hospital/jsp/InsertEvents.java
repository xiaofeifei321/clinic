package com.hospital.jsp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hospital.dao.EventsDao;
import com.hospital.dao.GuideDao;
import com.hospital.dao.OfficeDao;
import com.hospital.util.CreateId;
import com.hospital.util.Events;

public class InsertEvents extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertEvents() {
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

		String mid = "";
		String mname = "";
		String mcontent = "";
		String mtype = "";
		String mtime = "";
		String username = "";
		String filename = CreateId.getId() ;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);//
	    if (isMultipart == true) {
	       FileItemFactory factory = new DiskFileItemFactory();
	       ServletFileUpload upload = new ServletFileUpload(factory);
	       upload.setHeaderEncoding("UTF-8");//  
	       List<FileItem> items;
		try {
			items = upload.parseRequest(request);
			  Iterator<FileItem> itr = items.iterator();
			   while (itr.hasNext()) {
		           FileItem item = (FileItem) itr.next();
		           if (item.isFormField()) {//
		        	   String fieldName = item.getFieldName();
		        	   if (fieldName.equals("events.mname")) {
		        		   mname = item.getString();
		        		   mname = new String(mname.getBytes("ISO8859_1"),"utf-8");
		        	   }
		        	   if (fieldName.equals("events.mid")) {
		        		   mid = item.getString();
		        	   }
		        	   if (fieldName.equals("events.mcontent")) {
		        		   mcontent = item.getString();
		        		   mcontent = new String(mcontent.getBytes("ISO8859_1"),"utf-8");
		        		   
		        	   }
		        	   if (fieldName.equals("events.username")) {
		        		   username = item.getString();
		        		   username = new String(username.getBytes("ISO8859_1"),"utf-8");
		        		   
		        	   }
		        	   if (fieldName.equals("events.mtype")) {
		        		   mtype = item.getString();
		        		   mtype = new String(mtype.getBytes("ISO8859_1"),"utf-8");
		        		   
		        	   }
		        	   mtime =new SimpleDateFormat("yyyy-MM-dd").format(new Date());
					           
		           } else {
		        	   String photoDir = this.getServletContext().getRealPath("") + "/upload";
		        		   filename+=".jpg";
		        	   File photoFile = new File(photoDir + "/" +filename);
		        	   item.write(photoFile);
		           }
		       }
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    
	    } 
	

		Events events = new Events();

		if (mid != null && !mid.equals("")) {
			events.setMid(Integer.parseInt(mid));
		}
		events.setMname(mname);
		events.setMcontent(mcontent);
		events.setMpic("upload" + "/" + filename);
		events.setMtime(mtime);
		events.setMtype(mtype);
		events.setUsername(username);
//		events.setKitchenid(Integer.parseInt(kitchenid));
		
		EventsDao dao = new EventsDao();
		if(events.getMid() >0){
			dao.update(Integer.parseInt(mid),mname,events.getMpic(),mcontent,mtype,username);
		}else{
			dao.add(mname, events.getMpic(), mcontent, mtype, mtime, username);
		}
		

		List<Events> list = new ArrayList<Events>();
		list = dao.getallte();
		request.setAttribute("list", list);
		// response.sendRedirect("admin/jingdian/find.jsp");
		request.getRequestDispatcher("../selectEvents.jsp").forward(
				request, response);
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
