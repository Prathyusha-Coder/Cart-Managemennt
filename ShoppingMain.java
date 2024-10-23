package product_details;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShoppingMain{
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println("welcome to shopping application");
		/*String head="welcome to shopping application";
		char ch[]=head.toCharArray();
		for(char c:ch)
		{
			System.out.print("\033[38;5;205m"+c);
			Thread.sleep(156);
		}
		System.out.println();
	*/
		System.out.println("please login the application");
		System.out.println("enter your mobile");
		Scanner scanner=new Scanner(System.in);
		long mobileNumber=scanner.nextLong();
		int mobileNumberChance=5;
		boolean cond=true;
		while(cond){
			if((mobileNumber>999999999l && mobileNumber<9999999999l) && 
					(mobileNumber>6000000000l || 
							mobileNumber>7000000000l || 
							mobileNumber>8000000000l || 
							mobileNumber>9000000000l))
			{
				int otp=ProductFactory.generateOTP();
				System.out.println("Your otp is : "+otp);
				
				System.out.println("Enter the otp");
				int inputOTP=scanner.nextInt();
				
				int OTPChance=5;
				while(cond) {
				if(inputOTP==otp)
				{
					System.out.println("Login successfull👍");
					List<Product> productList=new ArrayList();
	//				boolean cond=true;
					while(cond)
					{
						ProductFactory.displayOptions();
						int choice=scanner.nextInt();
						
						switch(choice)
						{
						case 1 :{
							Product product=ProductFactory.addProduct();
							productList.add(product);
							System.out.println("product is added successfully");
						}
						break;
						
						case 2 :{
							if(productList.isEmpty())
							{
								System.out.println("There are no products to remove from the cart. Cart is empty ");
							}
							else
							{
								System.out.println("Available products in cart....");
								System.out.format("%-15s %-5s %-15s","Name","size","color");
								System.out.println();//this statement is used because the format method returns the output in single line ,inorder to bring the cursor to down 
								System.out.println("----------------------------------------------------------------------------");
								for(Product product:productList)
								{
									ProductFactory.displayProducts(product);
								}
								boolean flag=true;
								if(flag)
								{
									Iterator<Product> itr=productList.iterator();
									ProductFactory.removeProduct(itr, productList);
								}
							}
	//						Iterator<Product> itr=productList.iterator();
	//						ProductFactory.removeProduct(itr, productList);
						}
						break;
						
						case 3 :{
							if(productList.isEmpty())
							{
								System.out.println("There are no products in the cart to be update. Cart is empty ");
							}
							else
							{
								System.out.println("Available products in the cart ");
								for(Product product:productList)
								{
									ProductFactory.displayProducts(product);
								}
								ProductFactory.updateProduct(productList);
							}
						}
						break;
						
						case 4 :{
							
							if(productList.isEmpty())
							{
								System.out.println("There are no products in the cart to be displayed. Cart is empty ");
							}
							else
							{
								System.out.format("%-15s %-5s %-15s","Name","size","color");
								System.out.println();//this statement is used because the format method returns the output in single line ,inorder to bring the cursor to down 
								System.out.println("----------------------------------------------------------------------------");
								for(Product product:productList)
								{
									ProductFactory.displayProducts(product);
												
								}
							}
						}
							
						break;
						
						case 5 :{
							cond=false;
							System.out.println("Logout successful..don't come again waste fellow ...full time waste.");
						}
						break;
						
						default : System.out.println("Invalid Option\n Please try again...");
						}
					}
				}
				else{
						try
						{
							throw new InvalidMobileNumberException("Invalid OTP..please enter a valid otp");
						}
						catch(InvalidMobileNumberException e)
						{
							OTPChance--;
							System.out.println("only "+OTPChance+" chance left..please enter clearfully");
							if(OTPChance==0)
							{
								ColoredOutput.printRed("locked");
							}
							otp=ProductFactory.generateOTP();
							System.out.println("Your otp is : "+otp);
							
							System.out.println("Enter the otp");
							inputOTP=scanner.nextInt();
						}
					}
				}
			}
			else
			{
				try
				{
					throw new InvalidMobileNumberException("Invalid mobile number\nPlease enter a valid number\nShould start with either 9/8/7/6 and contain 10 digits\n");
				}
				catch(InvalidMobileNumberException e)
				{
					mobileNumberChance--;
					System.out.println("only "+mobileNumberChance+" chance are there to enter the mobile number");
					if(mobileNumberChance==0)
					{
						System.out.println("locked");
					}
					System.out.println("re-enter mobile number : ");
					mobileNumber=scanner.nextLong();
				}
			}
		}
	}
}
