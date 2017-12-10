import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;


public class Validation extends HttpServlet {
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
			
			out.println("<li  class=''><a href='Register'>Register</a></li>");
			out.println("<li class='' ><a href='Login'>Sign in</a></li>");
				
			
			out.println("<li class='' ><a href='Vieworders'>View Orders</a></li>");
					
			
			out.println("<div align='right'>");
			out.println("<form action='Viewcart'>");
			out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</nav>");
			
	//String fname=request.getParameter("fname");		
    String userid=request.getParameter("userid");
    String password = request.getParameter("password");
    String category = request.getParameter("category");
    //System.out.println(uid);
    //System.out.println(password);
	
	String fname=MySqlDataStoreUtilities.ViewUsername(userid);
	//String type=MySqlDataStoreUtilities.ViewCategory(category);
	//out.println("1st-"+fname);
	 if(MySqlDataStoreUtilities.CheckUser(userid,password,category))
        {
			//out.println("Successfull "+fname);
			HttpSession hs=request.getSession();
			hs.setAttribute("fname",fname);
			hs.setAttribute("type",category);
            response.sendRedirect("Home");
			
        }
        else
        {
           out.println("<br><br><h2>Incorrect user id or password or category !</h2><br><br>");
		   out.println("<a href='Login'><h3>Click here to login again</h3>");
        }
	
		
    
  /* boolean userflag = false;
    for(String id : Registerdata.hm_user.keySet())
    {
    	//System.out.println("for loooooooooooooop");
    	if(id.equals(userid))
    	{
    		//System.out.println("inside if");
    		userflag=true;
    	}
    }
    if(Registerdata.hm_user.size()==0)
    {
    	//System.out.println("adw");
		out.println("Incorrect user id or password or category !<br><br>");
		out.println("<a href='Login'><h3>Click here to login again</h3>");
    	//response.sendRedirect("Login");
    }
    else if(userflag==false)
    {
    	//System.out.println("bwamdnwqdmk");
		out.println("Incorrect user id or password or category !<br><br>");
		out.println("<a href='Login'><h3>Click here to login again</h3>");
    	
    }
    else if( (Registerdata.hm_user.get(userid).getPassword().equals(password))  && (Registerdata.hm_user.get(userid).getCategory().equals(category)) )
    {
    	HttpSession hs=request.getSession();
    	hs.setAttribute("fname", Registerdata.hm_user.get(userid).getFname());
    	hs.setAttribute("type", Registerdata.hm_user.get(userid).getCategory());
    	response.sendRedirect("Home");
    }
    else
    {
    	out.println("Incorrect user id or password or category !<br><br>");
		out.println("<a href='Login'><h3>Click here to login again></h3>");
    
    
    
  }*/
  
  
	  
	  }
}