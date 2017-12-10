import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;


public class Input implements Serializable {

	private static final long serialVersionUID = 1L;
	String category;
	String userid;
	String password;

	Input(String category, String userid, String password) {
		this.category = category;
		this.userid = userid;
		this.password = password;
	}

	public String toString() {
		return "Category:" + category + "\nUserid: " + userid + "\nPW: " + password;
	}
	
		
	}