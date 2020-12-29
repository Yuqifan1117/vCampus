package vcampus.vo;

public class ProductInformation implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String productID;
	String productName;
	double productCost;// 成本
	double productPrice;// 售价
	int amount;
	public ProductInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductInformation(String productID, String productName, double productCost, double productPrice, int amount) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productCost = productCost;
		this.productPrice = productPrice;
		this.amount = amount;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
