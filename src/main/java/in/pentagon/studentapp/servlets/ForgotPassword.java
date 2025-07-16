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

@WebServlet("/forgotpassword")
public class ForgotPassword extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImp1();
		PrintWriter out=resp.getWriter();
		
		
		//s.setPhone(Long.parseLong(req.getParameter("phone")));
		//s.setMail(req.getParameter("mail"));
		s=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("mail"));
		
		if(s!=null) {		     
		
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.updateStudent(s);
			if(res) {
			   //out.println("<h1>Password updated!</h1>");
				 req.setAttribute("success", "Password updated Successfully");//package
				 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");//destination
				 rd.forward(req, resp);//delivery guy
			}
			else {
			   //out.println("<h1>Failed to update the password</h1>");
				req.setAttribute("error", "Failed to update an password");
				 RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
				 rd.forward(req, resp);
			}
		}
		else {
			  //out.println("<h1>Password Mismatch</h1>");
			 req.setAttribute("error", "Password Mismatched");
			 RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
			 rd.forward(req, resp);
				
		}
	}
	else {
		//out.println("<h1>Student not Found</h1>");
		 req.setAttribute("error", "Student not found");
		 RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
		 rd.forward(req, resp);
			
		}
		
	}
	
}
	


