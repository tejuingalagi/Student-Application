package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImp1;
import in.pentagon.studentapp.dto.Student;

public class Update {

	public static void update(Student s) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImp1();
		int in=0;
		boolean status=false;
		do {
			System.out.println("Enter the name to be updated:");
			System.out.println("1. Name");
			System.out.println("2. Phone");
			System.out.println("3. Mail");
			System.out.println("4. Branch");
			System.out.println("5. Location");
			System.out.println("6. Back");
			in=sc.nextInt();
			switch(in) {
			case 1: System.out.println("enter the new name to be updated");
			s.setName(sc.next());
			break;
			case 2: System.out.println("enetr the new phone number");
			s.setPhone(sc.nextLong());
			break;
			case 3: System.out.println("enter the mail");
			s.setMail(sc.next());
			break;
			case 4: System.out.println("enter the branch");
			s.setBranch(sc.next());
			break;
			case 5: System.out.println("enetr the location");
			s.setLoc(sc.next());
			break;
			case 6: System.out.println("loading.......");
			break;
			default: System.out.println("eneter the valid option:");
			break;
			
			}
			status=sdao.updateStudent(s);
			if(status) {
				System.out.println("data updated successfully");
				
			}
			else {
				System.out.println("failed to updated the data");
			}
		}while(in!=6);
			
			
		}
	
		

	}


