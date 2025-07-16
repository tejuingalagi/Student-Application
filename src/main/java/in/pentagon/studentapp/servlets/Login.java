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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImp1();
		//PrintWriter out=resp.getWriter();
		
		//Creating session object
		HttpSession session=req.getSession(true);
		
		
		//s.setMail(req.getParameter("mail"));
		//`s.setPassword(req.getParameter("password"));
		s=sdao.getStudent(req.getParameter("mail"), req.getParameter("password"));
		if(s!=null) {
			//out.println("<h1>login successful, Welcome " +s.getName()+ "</h1> ");
			 //req.setAttribute("student", s);
			 session.setAttribute("student", s);
			 req.setAttribute("success", "logged in Successfully");//package
			 RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");//destination
			 rd.forward(req, resp);
			
		}
		else {
			//out.println("<h1>failed to login</h1>");
			req.setAttribute("error", "Failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
