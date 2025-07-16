package in.pentagon.studentapp.model;


import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;

public class Login {
	public static void login() {
	Scanner sc=new Scanner(System.in);
	StudentDAO sdao=new StudentDAOImp1();
    int choice=0;
	
    System.out.println("<--Welcome to Login Page-->");
	System.out.println("enter the mail");
	String mail=sc.next();
	
	System.out.println("enter the password");
	String password=sc.next();	
	Student s=sdao.getStudent(mail, password);
	if(s!=null) {
		System.out.println("login successful, Welcome "+s.getName());
		do {
			System.out.println("1. View Account");
			System.out.println("2. Update Account");
			System.out.println("3. Reset Password");
			System.out.println("4. Search user");
			System.out.println("5. Main Menu");
			if(s.getId()==1) {   //for admin purpose
				System.out.println("6. Delete User");
				System.out.println("7. View all Student");
			}
			choice=sc.nextInt();
			switch(choice) {
			case 1: System.out.println(s);
			break;
			case 2: Update.update(s);
			break;
			case 3: Password.forgot();
			break;
			case 4: Search.search();//logic for search
			break;
			case 5: System.out.println("Going back to main menu");
			break;
			case 6:System.out.println("enter the Student Id to be deleted");
			     boolean res=sdao.deleteStudent(sc.nextInt());
			     if(res) {
			    	 System.out.println("data deleted successfully");
			     }
			     else {
			    	 System.out.println("failed to delete data");
			    	 }
			     break;
			case 7: ArrayList<Student> studentList=sdao.getStudent();
			for(Student s1:studentList) {
				System.out.println(s1);
			
			 }
			default:System.out.println("Invalid choice ,choose the right one");
			break;
			}
		}while(choice!=4);
		
	}
	else {
		System.out.println("failed to login");
	}
	}
	
}
