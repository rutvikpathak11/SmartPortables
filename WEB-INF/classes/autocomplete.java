import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
import java.sql.SQLException;

public class autocomplete extends HttpServlet {

   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {						
		

		//System.out.println("In Autocomplete!");
		
		String action = request.getParameter("action");
		String searchId = request.getParameter("searchId");
		
		System.out.println(action);
		System.out.println(searchId);
		
        StringBuffer sb = new StringBuffer();
						
        boolean namesAdded = false;
		
        if (action.equals("complete")) 
		{		

            // check if user sent empty string
            if (!searchId.equals("")) 
			{
				AjaxUtility a=new AjaxUtility();
				
				try
				{
				sb=a.readdata(searchId);
				}
				
				catch(Exception e)				
				{
					e.printStackTrace();
				}
				if(sb!=null || !sb.equals(""))
					{
						namesAdded=true;
					}
            

				if (namesAdded) 
				{
					response.setContentType("text/xml");
				//	response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write("<products>"+sb.toString()+"</products>");
				} 
			}
        }

       

	   else if (action.equals("lookup")) {
    		request.setAttribute("action", action);
    		request.setAttribute("searchId", searchId);
    		request.getRequestDispatcher("LookupProduct").forward(request, response);
    		//response.sendRedirect("LookupProduct");
    	}
	
		
	
    }
}
