package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;

public class Password {

	public static void forgot() {
		// TODO Auto-generated method stub
		StudentDAO sdao=new StudentDAOImp1();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Phone number");
		Long phone=sc.nextLong();
		System.out.println("Enter the mail Id ");
		String mail=sc.next();
		
		Student s=sdao.getStudent(phone, mail);
		if(s!=null) {
			System.out.println("Set the new Password");
			String Password=sc.next();
			System.out.println("Confirm the Password");
			String confirm=sc.next();
			if(Password.equals(confirm)) {
				s.setPassword(Password);
				boolean res=sdao.updateStudent(s);
				if(res) {
					System.out.println("Password updated!");
				}
				else {
					System.out.println("Failed to update the password");
				}
			}
			else {
				System.out.println("Password Mismatch");
					
			}
		}
		else {
			System.out.println("Student not Found");
				
			}
		}

	}


