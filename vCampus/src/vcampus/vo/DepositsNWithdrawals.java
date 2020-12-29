package vcampus.vo;

import java.sql.Date;

public class DepositsNWithdrawals implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userID;
	Date rechargeTime;
	double amount;
	public DepositsNWithdrawals() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepositsNWithdrawals(String userID, Date rechargeTime, double amount) {
		super();
		this.userID = userID;
		this.rechargeTime = rechargeTime;
		this.amount = amount;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
