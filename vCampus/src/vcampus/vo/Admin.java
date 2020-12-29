package vcampus.vo;

import java.io.Serializable;

public class Admin implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String adminID;
	private String password;
	
	public Admin() {
		setAdminID(null);
		setPassword(null);
	}
	
	public Admin(String ad,String pa) {
		setAdminID(ad);
		setPassword(pa);
	}
	
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
