

import java.util.*;

public class Product implements java.io.Serializable{
	 String id;
	 String name;
	 String type;
	 int price;
	 String image;
	 String retailer;
	 String condition;
	 int discount;
	 double manrebate;
	 ArrayList<Accessory> accessories = new ArrayList<Accessory>();
	
	public Product(String id, String name, int price, String image, String retailer,String condition,int discount,double manrebate,ArrayList<Accessory> accessories) 
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
		this.condition=condition;
		this.discount = discount;
		this.manrebate=manrebate;
		this.setAccessories(accessories);
	}
	
	public Product(String name, String type)
	{
		this.name=name;
		this.type=type;
	}	
	
	public Product(){
		
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String itype){
		this.type=type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public void setAccessories(ArrayList<Accessory> accessories) {
		this.accessories = accessories;
	}

	public ArrayList<Accessory> getAccessories() {
		return accessories;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public double getManrebate() {
		return manrebate;
	}

	public void setManrebate(double manrebate) {
		this.manrebate = manrebate;
	}
	
}

