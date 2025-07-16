package in.pentagon.studentapp.model;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;

public class Search {
	public static void search() {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImp1();
		
		System.out.println("enter the user name");
		String name= sc.next();
		ArrayList<Student> list = sdao.getStudent(name);
		if(list.isEmpty()) {
			System.out.println("No such user found with the given name");
		}
		for(Student s:list) {
		 System.out.println("Details of the user ");
       	 System.out.println("Id : "+s.getId());
       	 System.out.println("Name : "+s.getName());
       	 System.out.println("Branch : "+s.getBranch());
       	 System.out.println("--------------------");
			
		}
		
		
	}

}
