package vcampus.vo;

import java.sql.Date;

public class ProductPurchase implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userID;
	String productID;
	String productName;
	int purchaseAmount;
	Date purchaseTime;
	public ProductPurchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductPurchase(String userID, String productID, String productName, int purchaseAmount, Date purchaseTime) {
		super();
		this.userID = userID;
		this.productID = productID;
		this.productName = productName;
		this.purchaseAmount = purchaseAmount;
		this.purchaseTime = purchaseTime;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public int getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	
	
}
