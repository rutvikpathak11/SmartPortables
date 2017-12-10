import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.*;

public class Login extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  
    //Common Header
	
    PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	out.println("<html><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
		out.println("<title>Smartportables</title>");
		out.println("<link rel='shortcut icon' href='cart/icon.jpg'/>");
		out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
		out.println("</head>");
		out.println("<body>");
			out.println("<div id='container'>");
			out.println("<header>");
			out.println("<h1><a href='Home'>SmartPortables</a></h1>");
			out.println("</header>");
			out.println("<nav>");
			out.println("<ul>");
			out.println("<li  class='start selected'><a href='Home'>Home</a></li>");
			out.println("<li class=''><a href='Smartwatches'>Smart Watches</a></li>");
			out.println("<li class=''><a href='Speakers'>Speakers</a></li>");;
			out.println("<li class=''><a href='Headphones'>Headphones</a></li>");
			out.println("<li class=''><a href='Phones'>Phones</a></li>");
			out.println("<li class=''><a href='Laptops'>Laptops</a></li>");
			out.println("<li class=''><a href='ExternalStorage'>External Storage</a></li>");
			out.println("<li class=''><a href='Vieworders'>View Orders</a></li>");
			
	//HttpSession session = request.getSession();
	//String fname=(String)session.getAttribute("fname");
	
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Sign in</a></li>");
	
	
		//out.println("<li class=''><a href='#'>Hello  "+fname1+"</a></li>");
		//out.println("<li class='' ><a href='SignOut'>Sign Out</a></li>");


	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</ul>");
	out.println("</nav>");
	
	//Login page starts here
	
	out.println("<form action='Validation'>");
	out.println("<table>");

	out.println("<tr>");
	out.println("<td>");
	out.println("Login as&nbsp&nbsp :");
	out.println("<input type='radio' name='category' value='storemanager' required> Storemanager ");
    out.println("<input type='radio' name='category' value='customer' required> Customer ");
    out.println("<input type='radio' name='category' value='salesman' required> Salesman");
    out.println("</td>");
	out.println("</tr>");
	
	out.println("<td>");
	out.println("User Id &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :");
	out.println("<input type='text' name='userid' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>");
	out.println("Password&nbsp&nbsp&nbsp:");
	out.println("<input type='password' name='password' required/></td>");
	out.println("</tr>");
	out.println("<tr><td><input type='submit' value='Login'></td></tr>");
	
	out.println("<tr><td><h5>New User ? </h5><a href='Register'><h3>Register here !</h3></td></tr>");
	out.println("</table>");
	out.println("</form>");
	out.println("</body>");
	out.println("</html>");
	
	  }
	}

/*public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

	//Common Header
	
    PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
	out.println("<html><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
		out.println("<title>Smartportables</title>");
		out.println("<link rel='shortcut icon' href='cart/icon.jpg'/>");
		out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
		out.println("</head>");
		out.println("<body>");
			out.println("<div id='container'>");
			out.println("<header>");
			out.println("<h1><a href='Home'>SmartPortables</a></h1>");
			out.println("</header>");
			out.println("<nav>");
			out.println("<ul>");
			out.println("<li  class='start selected'><a href='Home'>Home</a></li>");
			out.println("<li class=''><a href='Smartwatches'>Smart Watches</a></li>");
			out.println("<li class=''><a href='Speakers'>Speakers</a></li>");;
			out.println("<li class=''><a href='Headphones'>Headphones</a></li>");
			out.println("<li class=''><a href='Phones'>Phones</a></li>");
			out.println("<li class=''><a href='Laptops'>Laptops</a></li>");
			out.println("<li class=''><a href='ExternalStorage'>External Storage</a></li>");
			out.println("<li class=''><a href='Vieworders'>View Orders</a></li>");
			
	HttpSession session = request.getSession();
	String userid1=(String)session.getAttribute("userid");
	
	if (userid1 == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class=''><a href='Login'>Sign in</a></li>");
	}
	  else if (userid1.equals("SalesMngr")){
		  out.println("<li class=''><a href='register'>Register Customer</a></li>");
		  out.println("<li class=''><a href='#'>Hello  "+userid1+"</a></li>");
		  
		  
	  } else
	{
		out.println("<li class=''><a href='#'>Hello  "+userid1+"</a></li>");
		out.println("<li class='' ><a href='signout'>Sign Out</a></li>");
	}

	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</ul>");
	out.println("</nav>");

	String category=request.getParameter("category");
	String userid=request.getParameter("userid");
	String password=request.getParameter("password"); 
	
	FileInputStream fi = new FileInputStream(new File("D:/Input.txt"));
	ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			try
			{
				
			Input ir1 = (Input) oi.readObject();
					
			oi.close();
			fi.close();	
			
			
			if(ir1.userid.equals(userid) && ir1.password.equals(password) && ir1.category.equals(category) && category.equals("storemanager"))
			{
				response.sendRedirect("Home");
				//RequestDispatcher rd = request.getRequestDispatcher("Home");
				//rd.forward(request,response);
			}
			
			else if(ir1.userid.equals(userid) && ir1.password.equals(password) && ir1.category.equals(category) && category.equals("customer"))
			{
				response.sendRedirect("Home");
				//RequestDispatcher rd = request.getRequestDispatcher("Home");
				//rd.forward(request,response);
			}
			
			else if(ir1.userid.equals(userid) && ir1.password.equals(password) && ir1.category.equals(category) && category.equals("salesman"))
			{
				response.sendRedirect("Home");
				//RequestDispatcher rd = request.getRequestDispatcher("Home");
				//rd.forward(request,response);
			}
			
			else
			{
				out.println("<h3>Invalid user id or password or user type ! Please try again !<br></h3>");
				out.println("<h3><a href='Login'>Click here to login again</a></h3>");
				
			}
			}
			
			catch(Exception e)
			{
			}

}

}*/

