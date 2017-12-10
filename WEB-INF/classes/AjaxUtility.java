import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class AjaxUtility
{
	public static HashMap<String,Product> getData()
	{ 
	HashMap<String,Product> hm=new HashMap<String,Product>();
	try
	{ 
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
					
	String query = "select * from product";
						
	PreparedStatement pst = con.prepareStatement(query);
	ResultSet rs =pst.executeQuery();		
	
	while(rs.next())
		{
			Product p = new Product(rs.getString("productname"),rs.getString("productname"),rs.getInt("price"),rs.getString("image"),rs.getString("retailer"),rs.getString("cond"),rs.getInt("discount"),rs.getDouble("manrebate"),new ArrayList<Accessory>());
			hm.put(rs.getString("productname"), p);
			
		}
	}
	
	catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	return hm;
	}
	
	public StringBuffer readdata(String searchId)
	{
		
		StringBuffer sb = new StringBuffer();
		HashMap<String,Product> data = new HashMap<String,Product>();;
		data=getData();
		
		Iterator it = data.entrySet().iterator();
				
		while (it.hasNext()) 
		{
			Map.Entry pi = (Map.Entry)it.next();
            Product p = (Product)pi.getValue();

                    if (p.getName().toLowerCase().startsWith(searchId)) 
					{
                        sb.append("<product>");
                        sb.append("<id>"+p.getId()+"</id>");
                        sb.append("<productName>"+p.getName()+"</productName>");                       
                        sb.append("</product>");
                        
                    }
         }
		return sb;
	}
	

}