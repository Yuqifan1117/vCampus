package vcampus.vo;

public class Book implements java.io.Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String bookID;
	String bookName;
	String author;
	String bookPress;
	String bookLocation;
	int totalAmount;
	int borrowedAmount;
	public Book(){
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookID, String bookName, String author, String bookPress, String bookLocation, int totalAmount,
			int borrowedAmount) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.bookPress = bookPress;
		this.bookLocation = bookLocation;
		this.totalAmount = totalAmount;
		this.borrowedAmount = borrowedAmount;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	public String getBookLocation() {
		return bookLocation;
	}
	public void setBookLocation(String bookLocation) {
		this.bookLocation = bookLocation;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getBorrowedAmount() {
		return borrowedAmount;
	}
	public void setBorrowedAmount(int borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}
	
	
}
