import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class Registerdata extends HttpServlet {
	
	public static HashMap<String,SmartPortableUser> hm_user = new HashMap<String,SmartPortableUser>();
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
	HttpSession session = request.getSession();
   
	//String fname=(String)session.getAttribute("fname");
	//String type = (String)session.getAttribute("type");
	
	//Header starts from here
	
    out.println("<html>");
		out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
			out.println("<title>Smart Portables</title>");
			out.println("<link rel='shortcut icon' href='images/title.png'/>");
			out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
		out.println("</head>");
		out.println("<body>");
			out.println("<div id='container'>");
			out.println("<header>");
			out.println("<h1><a href='Home'>SMARTPORTABLES</a></h1>");
			
		/*	if(fname!=null)
			{
				out.println("<h3 align='right' color:'black'>Hello  "+fname+"</h3>");
				out.println("<div align='right'>");
				out.println("<a href ='SignOut'>Sign out</a>");
				out.println("</div>");
			}*/
			
			out.println("</header>");
			out.println("<nav>");
			out.println("<ul>");
			out.println("<li  class='start selected'><a id='home' href='Home'>Home</a></li>");			
			out.println("<li  class=''><a href='ProductServlet?param1=smartwatches'>Smart Watches</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=speakers'>Speakers</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=headphones'>Headphones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=phones'>Phones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=laptops'>Laptops</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=externalstorages'>External Storage</a></li>");
			out.println("<li class='' ><a href='Login'>Sign in</a></li>");
				
			
			out.println("<li class='' ><a href='Vieworder '>View Orders</a></li>");
					
			
			out.println("<div align='right'>");
			out.println("<form action='Viewcart'>");
			out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</nav>");
			
    String category = request.getParameter("category");
    String fname = request.getParameter("firstname");
    String lname = request.getParameter("lastname");
    String userid = request.getParameter("userid");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
   //SmartPortableUser newuser = new SmartPortableUser(fname,lname,userid,email,password,category);
    //hm_user.put(userid, newuser);
    
	//HashMap<String, User> hm=new HashMap<String, User>();
	/*try
	{
	hm=MySqlDataStoreUtilities.selectUser();
	}
	catch(Exception e){}*/	
	
	//User user = new User(userid,password,category);
	
	//if(hm.containsKey(userid))
	//{
	//out.println("User id exists!");	
	//}	
	
//	else
	//{
	//hm.put(userid, user);	
	MySqlDataStoreUtilities.insertUser(fname,lname,email,userid,password,category);   	
  
    out.println("<html>");
    out.println("<h3>You are successfully registered as a "+category+" !!</h3>");
    out.println("</html>");
	out.println("<a href='Login'>Click Here to Login");}
    //response.sendRedirect("Home");

	
	
    
  //}
  
  /* static void  writeUserDataStore(){

	    try{
	    File userDataStore=new File("C:/data_from_forms/UserDataStore");
	    FileOutputStream fos=new FileOutputStream(userDataStore);
	    ObjectOutputStream oos=new ObjectOutputStream(fos);

		
	        oos.writeObject(hm_user);
	        oos.flush();
	        oos.close();
	        fos.close();
		
	    }catch(Exception e){
			
		}

	}
  
  static void readUserDataStore() {

	   
	    try{
	        File userDataStore=new File("C:/data_from_forms/UserDataStore");
	        FileInputStream fis=new FileInputStream(userDataStore);
	        ObjectInputStream ois=new ObjectInputStream(fis);

	        HashMap<String,SmartPortableUser> mapInFile=(HashMap<String,SmartPortableUser>)ois.readObject();
	        ois.close();
	        fis.close();
	        
	    }catch(Exception e){
	    	
	    }

	} */

}

	
	//response.sendRedirect("Home");
	

