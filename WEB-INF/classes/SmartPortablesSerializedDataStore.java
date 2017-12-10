import java.util.*;
import java.io.*;

public class SmartPortablesSerializedDataStore {
	public static SaxParser4SmartPortableXMLdataStore saxparseobj;
	public static List<Product> products;
	public static List<Accessory> accessories ;
	public static HashMap<String, Product> hm_smartwatches = new HashMap<String, Product>();
	public static HashMap<String, Product> hm_speakers = new HashMap<String, Product>();
	public static HashMap<String, Product> hm_headphones = new HashMap<String, Product>();
	public static HashMap<String, Product> hm_phones = new HashMap<String, Product>();
	public static HashMap<String, Product> hm_laptops = new HashMap<String, Product>();
	public static HashMap<String, Product> hm_externalstorages = new HashMap<String, Product>();
	public static HashMap<String, Accessory> hm_accessories = new HashMap<String, Accessory>();
	
	public static void populateSerializedDataStore(){
		//System.out.println("Dfer");
		saxparseobj= new SaxParser4SmartPortableXMLdataStore("C:/apache-tomcat-7.0.34/webapps/Assignment5/WEB-INF/ProductCatalog.xml");
		products= saxparseobj.products;
		accessories = saxparseobj.accessories;
		populateAccessories();
		populateSmartWatches();
		populateSpeakers();
		populateHeadphones();
		populatePhones();
		populateLaptops();
		populateExternalstorages();
	}
	
	public static void populateAccessories()
	{
		for(Accessory acc : accessories)
		{
			hm_accessories.put(acc.getName(), acc);
		}
		//System.out.println("rgsr"+hm_accessories.size());
	}
	
	public static void populateSmartWatches()
	{
		for(Product prod : products)
		{
			if(prod.getId().equals("SmartWatches"))
				hm_smartwatches.put(prod.getName(), prod);
		}
	}
	
	public static void populateSpeakers()
	{
		for(Product prod : products)
		{
			if(prod.getId().equals("Speakers"))
				hm_speakers.put(prod.getName(), prod);
		}
	}
	
	public static void populateHeadphones()
	{
		for(Product prod : products)
		{
			if(prod.getId().equals("Headphones"))
				hm_headphones.put(prod.getName(), prod);
		}
	}
	
	public static void populatePhones()
	{
		for(Product prod : products)
		{
			if(prod.getId().equals("Phones"))
				hm_phones.put(prod.getName(), prod);
		}
	}
	
	public static void populateLaptops()
	{
		for(Product prod : products)
		{
			if(prod.getId().equalsIgnoreCase("Laptops"))
				hm_laptops.put(prod.getName(), prod);
		}
	}
	
	public static void populateExternalstorages()
	{
		for(Product prod : products)
		{
			if(prod.getId().equals("Harddrive") || prod.getId().equals("Flashdrive") || prod.getId().equals("MemoryCard")){
				
				hm_externalstorages.put(prod.getName(), prod);
			}	
		}
	}
	
	/*public static void main(String[] args) {
		SmartPortablesSerializedDataStore s1=new SmartPortablesSerializedDataStore();
		s1.populateSerializedDataStore();
    }*/
	
}
