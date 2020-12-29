package vcampus.vo;

public class User implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String sex;
	private String password;
	private String deptName;// department name
	private String emailAddress;
	private String phoneNumber;
	private double account;//balance in bank account
    private double money;//balance in Ecard

    

	public User(String id, String name, String sex, String password, String deptName, String emailAddress,
			String phoneNumber,double account,double money) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.password = password;
		this.deptName = deptName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.account=account;
		this.money=money;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

}
