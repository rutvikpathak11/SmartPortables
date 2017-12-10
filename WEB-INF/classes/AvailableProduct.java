

import java.util.*;

public class AvailableProduct {
	 String productname;
	 int quantity;
	 double price;
	
	
	public AvailableProduct(String productname,int quantity,double price){
		this.productname=productname;
		this.quantity=quantity;
		this.price=price;
	}
	
	public AvailableProduct(){
		
	}
	
	public String getProductname(){
		return productname;
	}
	
	public void setProductname(String productname){
		this.productname=productname;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

