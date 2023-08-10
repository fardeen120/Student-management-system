package practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to student management system");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 to Add student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to display student");
			System.out.println("PRESS 4 to update records");
			System.out.println("PRESS 5 to exit application");
			int c=Integer.parseInt(br.readLine());
			
			if(c==1) {
				
				
				
				System.out.println("Enter student name");
				String name=br.readLine();
				
				System.out.println("Enter student mobile no");
				String phone=br.readLine();
				
				System.out.println("Enter student city");
				String city=br.readLine();
				
				Student st=new Student(name, phone, city);
				boolean answer=StudentDao.Insertstudenttodb(st);
				if(answer) {
					System.out.println("sucessfully added");
				}
				else {
					System.out.println("something went wrong");
				}
				
				System.out.println(st);
			}
			else if(c==2) {
				System.out.println("Enter student id to delete");
				int userid=Integer.parseInt(br.readLine());
				boolean f=StudentDao.Deletestudenttodb(userid);
				if(f) {
					System.out.println("deleted successfully");
				}
				else {
					System.out.println("something went wrong");
				}
			}
			else if(c==3) {
				StudentDao.Displaystudenttodb();
				
			}
			else if(c==4) {
				
				
				boolean answer1=StudentDao.Updatetstudenttodb();
				if(answer1) {
					System.out.println("sucessfully updated");
				}
				else {
					System.out.println("something went wrong");
				}
				
				
				
			}
			else if(c==5) {
				break;
			}
			else {
				System.out.println("Enter correct option");
			}
			
		}
		System.out.println("Thanks for using my application");
		System.out.println("see you soon......bye");
	}
}


