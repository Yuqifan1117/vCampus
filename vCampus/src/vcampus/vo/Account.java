package vcampus.vo;

import java.sql.Date;

public class Account implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//String account;// bank account
	//String password;
	/*
	 * 只需要userID、amount即提供转账服务
	 */
	private String userID;
	private Date rechargeTime;
	private double amount;
	

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String userID, Date rechargeTime, double amount) {
		super();
		this.userID = userID;
		this.rechargeTime=rechargeTime;
		this.amount=amount;
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
