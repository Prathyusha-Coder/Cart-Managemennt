package product_details;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductFactory {
	public static int generateOTP()
	{
		Random random=new Random();
		int otp=random.nextInt(1000,9999);
		
		return otp;
	}
	public static void displayOptions()
	{
		System.out.println("Select below option.....");
		System.out.println("1. Add a product to cart");
		System.out.println("2. Remove a produtc from cart");
		System.out.println("3. update cart");
		System.out.println("4. Display all products");
		System.out.println("5. logout from application");
	}
	
	public static Product addProduct()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Products available are : ");
		Category.getCategoryNames();
		
		System.out.println("select your product to add to cart");
		String productName=scanner.next();
		System.out.println("select the product size");
		int productSize=scanner.nextInt();
		System.out.println("enter your product Color");
		String productColor=scanner.next();
		
		return new Product(productName,productColor,productSize);
	}
	public static void removeProduct(Iterator<Product> itr,List<Product> productList)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the product you want to remove from the cart...");
		String deleteProductName=scanner.next();
		boolean found=false;
		while(itr.hasNext())
		{
			Product product=itr.next();
			if(product.getProductName().equalsIgnoreCase(deleteProductName));
			{
				itr.remove();
				System.out.println(deleteProductName+" is removed from the cart..");
				found=true;
				break;
			}
		}
		if(!found)
		{
			System.out.println("The entered product "+deleteProductName+"is not available in the cart..\n Please try again..");
		}
		
	}
	public static void updateProduct(List<Product> productList) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the product you want to update...");
	    String updateProductName = scanner.next();
	    boolean found = false;
	    
	    for (Product product : productList) {
	        if (product.getProductName().equalsIgnoreCase(updateProductName)) {
	        	System.out.println("Product found! Enter new details to update.");

	        	System.out.println("Enter new product name (or press Enter to keep the same):");
	            scanner.nextLine(); // Clear buffer
	            String newName = scanner.nextLine();
	            if (!newName.isEmpty()) {
	            	if(newName==product.getProductName())
	            	{
	            		System.out.println("Entered product name "+newName+" is already available in cart");
	            		
	            	}
	            	else
	            	{
	            		product.setProductName(newName);
	            	}
	            }
	            System.out.println("Enter new product size (or press -1 to keep the same):");
	            int newSize = scanner.nextInt();
	            scanner.nextLine();
	            if (newSize != -1) {
	            	if(newSize==product.getProductSize())
	            	{
	            		System.out.println("Product of same size "+newSize+" is available in cart");
	            	}
	            	else
	            	{
	            		product.setProductSize(newSize);
	            	}
	                
	            }
	            
	            System.out.println("Enter new product color (or press Enter to keep the same):");
	            
	            String newColor = scanner.nextLine();
	            if (!newColor.isEmpty()) {
	            	if(newColor==product.getProductColor())
	            	{
	            		System.out.println("Product with same color "+newColor+" is available a in cart");
	            		
	            	}
	            	else
	            	{
	            		product.setProductColor(newColor);	
	            	}
	                
	            }

	            System.out.println("Product updated successfully!");
	            found = true;
	            break;
	        }
	    }
	    
	    if (!found) {
	    	System.out.println("The entered product " + updateProductName + " is not available in the cart.\nPlease try again.");
	    }
	}

	public static void displayProducts(Product product)
	{
	//	=new Product();
		System.out.format("%-15s %-5s %-15s",product.getProductName(),product.getProductSize(),product.getProductColor());
		System.out.println();//this statement is used because the format method returns the output in single line ,inorder to bring the cursor to down 
		System.out.println("----------------------------------------------------------------------------");
	}
	public static void exit()
	{
//		while(true)
//		{
//			break;
//		}
	}
	/*
	 * public static void update(List<Product> productList,string productName,string newName)
	 * {
	 * boolean cond=true;
	 * for(Product product: productList)
	 * {
	 * if(product.getProName.eIC(productName)
	 * {
	 * product.setName(newName);
	 * cond=false;
	 * }
	 * }
	 * if(cond)
	 * {
	 * sop("product not found");
	 * }
	 */
}
