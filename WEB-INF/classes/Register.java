import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;




public class Register extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  
    PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
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
			out.println("<li class='' ><a href='ViewOrders'>View Orders</a></li>");
			out.println("<li class='' ><a href='Login'>Sign in</a></li>");
	
	
	out.println("<div align='right'>");
	out.println("<form action='Viewcart'>");
	out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
	out.println("</form>");
	out.println("</div>");
	out.println("</ul>");
	out.println("</nav>");	

//Registration	
		 
	out.println("<h3>Please fill form to register new customer!</h3>");
	out.println("<form action='Registerdata'>");
	out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("First Name :");
		out.println("<input type='text' name='firstname' placeholder='Enter First Name' required/></td>");
		out.println("</tr>");
	
		out.println("<tr>");
		out.println("<td>");
		out.println("Last Name  :");
		out.println("<input type='text' name='lastname' placeholder='Enter Last Name' required/></td>");
		out.println("</tr>");
	
		out.println("<tr>");
		out.println("<td>");
		out.println("Email Id&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :");
		out.println("<input type='text' name='email' placeholder='Enter email id' required/></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Category&nbsp&nbsp&nbsp&nbsp :");
		out.println("<select name='category' required>");
		out.println("<option value='default' selected='selected' required>Choose from below-</option>");
		out.println("<option value='storemanager' required>Storemanager</option>");
		out.println("<option value='customer' required>Customer</option>");
		out.println("<option value='salesman' required>Salesman</option>");
		out.println("</select>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("User Id &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :");
		out.println("<input type='text' name='userid' placeholder='Enter user id' required/></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Password&nbsp&nbsp&nbsp:");
		out.println("<input type='password' name='password' placeholder='Enter password' required/></td>");
		out.println("</tr>");
		
		out.println("<tr><td ><input type='submit' value='Register'></td></tr>");
	out.println("</table/>");
	out.println("</form>");
	
	out.println("</body>");
	out.println("</html>");
	
	  }
}
	