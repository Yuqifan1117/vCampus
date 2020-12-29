package vcampus.vo;

import java.sql.Date;

public class BookBorrow implements java.io.Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userID;
	String bookID;
	Date borrowTime;
	int borrowNumber;
	public BookBorrow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookBorrow(String userID, String bookID, Date borrowTime, int borrowNumber) 
	{
		super();
		this.userID = userID;
		this.bookID = bookID;
		this.borrowTime = borrowTime;
		this.borrowNumber = borrowNumber;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public int getBorrowNumber() {
		return borrowNumber;
	}
	public void setBorrowNumber(int borrowNumber) {
		this.borrowNumber = borrowNumber;
	}
	
}
