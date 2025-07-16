package in.pentagon.studentapp.servlets;

import java.io.IOException;
import java.util.ArrayList;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchuser")
public class SearchUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImp1();
		ArrayList<Student> users=sdao.getStudent(req.getParameter("search"));
		
		req.setAttribute("users", users);
		RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
		rd.forward(req, resp);

	}
	

}
