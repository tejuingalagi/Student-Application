package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.connection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImp1 implements StudentDAO {
private Connection con;

public StudentDAOImp1() {
	this.con=Connector.requestConnection();
}
    //TO SIGNUP
	@Override
	public boolean insertStudent(Student s) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="INSERT INTO  STUDENT VALUES (0,?,?,?,?,?,?,SYSDATE())";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			
			int res=ps.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		String query="UPDATE STUDENT SET NAME=?,PHONE=?,MAIL=?,BRANCH=?,LOCATION=?,PASSWORD=?,DATE=SYSDATE() where Id=?";
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getId());
			res=ps.executeUpdate();			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(res>0) {
			return true;
		}
		else {
		
		return false;
	}
	}
    
	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="Dlete from Student where id=? and id!=1 ";
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			res=ps.executeUpdate();
			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(res>0) {
			return true;
		}
		else {
		
		return false;
		}
	}
    //TO LOGIN 
	@Override
	public Student getStudent(String mail, String password) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="select * from Student where mail=? and password=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				int id=rs.getInt("id");
				s.setId(id);
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("Name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		}
		catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
				 }

		return s;
	}
    //TO RESET THE PASSWORD
	@Override
	public Student getStudent(long phone, String mail) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="Select * from Student where phone=? and mail=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("Name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
    //TO SEARCH THE USER BY USING THEIR NAME
	@Override
	public ArrayList<Student> getStudent(String name) {
		// TODO Auto-generated method stub
		ArrayList<Student> students=new ArrayList<>();
		Student s=null;
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE NAME=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("Location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				students.add(s);
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return students;
	}
	
    //TO VIEW  THE USER DATA
	@Override
	public ArrayList<Student> getStudent() {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT";
		ArrayList<Student> list=new ArrayList();
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setBranch(rs.getString("Branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				list.add(s);
			}
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

}
