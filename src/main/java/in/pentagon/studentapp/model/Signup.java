package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImp1();
		Student s=new Student();
		
		System.out.println("<--Welcome to Signup Page-->");
		System.out.println("enter the name");
		s.setName(sc.next());
		
		System.out.println("phone");
		s.setPhone(sc.nextLong());
		
		System.out.println("mail");
		s.setMail(sc.next());
		
		System.out.println("branch");
		s.setBranch(sc.next());
		
		System.out.println("location");
		s.setLoc(sc.next());
		
		System.out.println("password");
		String Password=sc.next();
		
		System.out.println("confirmpassword");
		String confirmPassword=sc.next();
		
		if(Password.equals(confirmPassword)) {
			s.setPassword(confirmPassword);
			boolean res=sdao.insertStudent(s);
			if(res) {
				System.out.println("data added successfully");
			}
			else {
				System.out.println("failed to add data");
			}
		}
		else {
			System.out.println("password miss matched");
			
		}
	}

}
