import java.io.*;
import java.util.*;
public class SmartPortableUser {
	 String fname;
	 String lname;
	 String userid;
	 String email;
	 String password;
	 String category;
	 //ArrayList<Order> orders = new ArrayList<Order>();
	
	 public SmartPortableUser(String fname,String lname, String userid, String email, String password, String category)
	 {
		 this.fname=fname;
		 this.lname=lname;
		 this.userid=userid;
		 this.email=email;
		 this.password=password;
		 this.category=category;
		 
	 }
	 
	 
	 
	 public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
		
		
		
		
}
