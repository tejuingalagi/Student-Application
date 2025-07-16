package in.pentagon.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class Signup extends HttpServlet{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//creation of pojo class object
		 Student s=new Student();
		 StudentDAO sdao=new StudentDAOImp1();
		 PrintWriter out=resp.getWriter();
		 
		 //collecting the data from the UI
		 //String name=req.getParameter("name");
		 //s.setName("name");
		 s.setName(req.getParameter("name"));
		 
		 //String phone=req.getParameter("phone");
		 //long phone_no=Long.parseLong(phone);
		 //s.setPhone(phone_no);
		 
		 s.setPhone(Long.parseLong(req.getParameter("phone")));
		 s.setMail(req.getParameter("mail"));
		 s.setBranch(req.getParameter("branch"));
		 s.setLoc(req.getParameter("location"));
		 
		 if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			 s.setPassword(req.getParameter("password"));
			 boolean res=sdao.insertStudent(s);
			 if(res) {
				 //out.println("<h1>Data saved successfully</h1>");
				 req.setAttribute("success", "Account Created Successfully");//package
				 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");//destination
				 rd.forward(req, resp);//delivery guy
			 }
			 else {
				 //out.println("<h1>Failed to add the data</h1>");
				 req.setAttribute("error", "Failed to create an Account");
				 RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				 rd.forward(req, resp);
			 }
		 }
		 
		else {
			//out.println("<h1>Password mismatch</h1>");
			req.setAttribute("error", "Password Mismatched");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
		}
		 }
		 
		 
	} 


