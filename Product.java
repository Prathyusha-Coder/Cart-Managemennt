package product_details;

public class Product {
	private String productName;
	private String productColor;
	private int productSize;
	
	public Product(String productName,String productColor,int productSize)
	{
		this.productName=productName;
		this.productColor=productColor;
		this.productSize=productSize;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public int getProductSize() {
		return productSize;
	}
	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}
	public Product()
	{
		//creating a non argument constructor helps to avoid the data entering while creating a object.
	}
	
}
