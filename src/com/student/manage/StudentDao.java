package com.student.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean Insertstudenttodb(Student st) {
		
        boolean f=false;
		try {
//			jdbc code 
		Connection con = CP.Createc();
		
		String q="insert into students(sname,sphone,scity) values(?,?,?)";
		PreparedStatement pstm=con.prepareStatement(q);
//		set the value of parameter
		
		pstm.setString(1, st.getStudentname());
		pstm.setString(2, st.getStudentphone());
		pstm.setString(3, st.getStudentcity());
		
		pstm.executeUpdate();
		f=true;
		
		
	}
		catch (Exception e) { 
			e.printStackTrace();
		}
		return f;
		
		

	}
	
public static boolean Deletestudenttodb(int userid) {
		
        boolean f=false;
		try {
//			jdbc code 
		Connection con = CP.Createc();
		
		String q="delete from students where sid=?";
		PreparedStatement pstm=con.prepareStatement(q);
//		set the value of parameter
		
		pstm.setInt(1, userid);
		
		
		pstm.executeUpdate();
		f=true;
		
		
	}
		catch (Exception e) { 
			e.printStackTrace();
		}
		return f;
		
		

	}

public static void Displaystudenttodb() {
	
    
	try {
//		jdbc code 
	Connection con = CP.Createc();
	
	String q="select * from students;";
	Statement stsm=con.createStatement();
	
	ResultSet set=stsm.executeQuery(q);
	
	while(set.next()) {
		int id=set.getInt(1);
		String name=set.getString(2);
		String phone=set.getString(3);
		String city=set.getString(4);
		
		System.out.println("ID - " + id);
		System.out.println("NAME - " + name);
		System.out.println("PHONE - " + phone);
		System.out.println("CITY - " + city);
		System.out.println("--------------------");
	}

	
	
	
	
	
}
	catch (Exception e) { 
		e.printStackTrace();
	}
	
	
	

}
//public static boolean Updatetstudenttodb() {
//	
//    boolean f=false;
//	try {
////		jdbc code 
//	Connection con = CP.Createc();
//	
//	String q="UPDATE students set sname=?, set sphone=?, set scity=? WHERE sid=?";
//            
//	PreparedStatement pstm=con.prepareStatement(q);
////	set the value of parameter
//	
//	pstm.setString(1, st.getStudentname());
//	pstm.setString(2, st.getStudentphone());
//	pstm.setString(3, st.getStudentcity());
//	pstm.setInt(4, st.getStudentid());
//	
//	pstm.executeUpdate();
//	f=true;
//	
//	
//}
//	catch (Exception e) { 
//		e.printStackTrace();
//	}
//	return f;
//
//}

public static boolean Updatetstudenttodb() {
	boolean f=false;
	try {
//		jdbc code 
	Connection con = CP.Createc();
	
	String q= "UPDATE students SET sname = ?, sphone = ?, scity = ? WHERE sid = ?";
           
           
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("Enter new student name");
	String name=br.readLine();
	
	System.out.println("Enter new student mobile no");
	String phone=br.readLine();
	
	System.out.println("Enter new student city");
	String city=br.readLine();
	
	System.out.println("Enter the student id to be change");
	int id=Integer.parseInt(br.readLine());
            
	PreparedStatement pstm=con.prepareStatement(q);
	
	pstm.setString(1, name);
	pstm.setString(2, phone);
	pstm.setString(3, city);
	pstm.setInt(4, id);
	
	pstm.executeUpdate();
	f=true;
	}
catch (Exception e) {
	e.printStackTrace();
}
	return f;


}
}

