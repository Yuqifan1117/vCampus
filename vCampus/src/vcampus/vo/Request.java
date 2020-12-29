package vcampus.vo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//import java.util.ArrayList;

public class Request implements java.io.Serializable{

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;

	private int request_ID;
	private int request_type;

    private Account _account;
    private CopyOnWriteArrayList<Account>_accountList;
	private Admin _admin;
	private Book _book;
	private CopyOnWriteArrayList<Book>_bookList;
	private BookBorrow _borrowNreturn;
	private Course _course;
	private CopyOnWriteArrayList<Course>_courseList;
	private CourseSelectNDrop _courseSelectNDrop;
	private DepositsNWithdrawals _depositsNWithdrawals;
	private ProductInformation _product;
	private CopyOnWriteArrayList<ProductInformation>_productList;
	private ProductPurchase _productPurchase;
	private Student _student;
	private CopyOnWriteArrayList<Student>_studentList;
	private CopyOnWriteArrayList<Teacher>_teacherList;
	private Teacher _teacher;
	private User _user;

	private Boolean isHandled=false;
	private Boolean checkResult=false;


	
	public CopyOnWriteArrayList<Account> get_accountList() {
		return _accountList;
	}




	public void set_accountList(CopyOnWriteArrayList<Account> _accountList) {
		this._accountList = _accountList;
	}




	public Request(int request_ID, int request_type, Account _account, Admin _admin, Book _book,
			CopyOnWriteArrayList<Book> _bookList, BookBorrow _borrowNreturn, Course _course,
			CopyOnWriteArrayList<Course> _courseList, CourseSelectNDrop _courseSelectNDrop,
			DepositsNWithdrawals _depositsNWithdrawals, ProductInformation _product,
			CopyOnWriteArrayList<ProductInformation> _productList, ProductPurchase _productPurchase, Student _student,
			Teacher _teacher, User _user, Boolean isHandled, Boolean checkResult) {
		super();
		this.request_ID = request_ID;
		this.request_type = request_type;
		this._account = _account;
		this._admin = _admin;
		this._book = _book;
		this._bookList = _bookList;
		this._borrowNreturn = _borrowNreturn;
		this._course = _course;
		this._courseList = _courseList;
		this._courseSelectNDrop = _courseSelectNDrop;
		this._depositsNWithdrawals = _depositsNWithdrawals;
		this._product = _product;
		this._productList = _productList;
		this._productPurchase = _productPurchase;
		this._student = _student;
		this._teacher = _teacher;
		this._user = _user;
		this.isHandled = isHandled;
		this.checkResult = checkResult;
	}




	public CopyOnWriteArrayList<Teacher> get_teacherList() {
		return _teacherList;
	}




	public void set_teacherList(CopyOnWriteArrayList<Teacher> _teacherList) {
		this._teacherList = _teacherList;
	}




	public CopyOnWriteArrayList<Student> get_studentList() {
		return _studentList;
	}




	public void set_studentList(CopyOnWriteArrayList<Student> _studentList) {
		this._studentList = _studentList;
	}




	public ProductInformation get_product() {
		return _product;
	}




	public void set_product(ProductInformation _product) {
		this._product = _product;
	}




	public ProductPurchase get_productPurchase() {
		return _productPurchase;
	}




	public void set_productPurchase(ProductPurchase _productPurchase) {
		this._productPurchase = _productPurchase;
	}


	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}




	public static void setSerialVersionUID(long serialVersionUID) {
		Request.serialVersionUID = serialVersionUID;
	}




	public int getRequest_type() {
		return request_type;
	}




	public void setRequest_type(int request_type) {
		this.request_type = request_type;
	}




	public CopyOnWriteArrayList<Course> get_courseList() {
		return _courseList;
	}




	public void set_courseList(CopyOnWriteArrayList<Course> _courseList) {
		this._courseList = _courseList;
	}

	public void set_courseList(ArrayList<Course> arrayList) {
		Object[] aa = arrayList.toArray();
		CopyOnWriteArrayList bb = new CopyOnWriteArrayList(aa);		
		this._courseList = bb;
	}
	
	public void set_accountList(ArrayList<Account> arrayList) {
		Object[] aa = arrayList.toArray();
		CopyOnWriteArrayList bb = new CopyOnWriteArrayList(aa);		
		this._accountList = bb;
	}


	public CopyOnWriteArrayList<ProductInformation> get_productList() {
		return _productList;
	}




	public void set_productList(CopyOnWriteArrayList<ProductInformation> _productList) {
		this._productList = _productList;
	}


	public void set_productList(ArrayList<ProductInformation> arrayList) {

		Object[] aa = arrayList.toArray();
		CopyOnWriteArrayList bb = new CopyOnWriteArrayList(aa);		
		this._productList = bb;
	}



	public void set_bookList(CopyOnWriteArrayList<Book> _bookList) {
		this._bookList = _bookList;
	}




	public CopyOnWriteArrayList<Book> get_bookList() {
		return _bookList;
	}




	public void set_bookList(ArrayList<Book> arrayList) {
		Object[] aa = arrayList.toArray();
		CopyOnWriteArrayList bb = new CopyOnWriteArrayList(aa);		
		this._bookList = bb;
	}

	public void set_studentList(ArrayList<Student> arrayList) {

		Object[] aa = arrayList.toArray();
		CopyOnWriteArrayList bb = new CopyOnWriteArrayList(aa);		
		this._studentList = bb;
	}

	public void set_teacherList(ArrayList<Teacher> arrayList) {

		Object[] aa = arrayList.toArray();
		CopyOnWriteArrayList bb = new CopyOnWriteArrayList(aa);		
		this._teacherList = bb;
	}

	public Boolean getIsHandled() {
		return isHandled;
	}




	public void setIsHandled(Boolean isHandled) {
		this.isHandled = isHandled;
	}




	public Boolean getCheckResult() {
		return checkResult;
	}




	public void setCheckResult(Boolean checkResult) {
		this.checkResult = checkResult;
	}




	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}





	public int getRequest_ID() {
		return request_ID;
	}




	public void setRequest_ID(int request_ID) {
		this.request_ID = request_ID;
	}




	public Account get_account() {
		return _account;
	}


	public void set_account(Account _account) {
		this._account = _account;
	}


	public Admin get_admin() {
		return _admin;
	}


	public void set_admin(Admin _admin) {
		this._admin = _admin;
	}


	public Book get_book() {
		return _book;
	}


	public void set_book(Book _book) {
		this._book = _book;
	}


	public BookBorrow get_borrowNreturn() {
		return _borrowNreturn;
	}


	public void set_borrowNreturn(BookBorrow _borrowNreturn) {
		this._borrowNreturn = _borrowNreturn;
	}


	public Course get_course() {
		return _course;
	}


	public void set_course(Course _course) {
		this._course = _course;
	}


	public CourseSelectNDrop get_courseSelectNDrop() {
		return _courseSelectNDrop;
	}


	public void set_courseSelectNDrop(CourseSelectNDrop _courseSelectNDrop) {
		this._courseSelectNDrop = _courseSelectNDrop;
	}


	public DepositsNWithdrawals get_depositsNWithdrawals() {
		return _depositsNWithdrawals;
	}


	public void set_depositsNWithdrawals(DepositsNWithdrawals _depositsNWithdrawals) {
		this._depositsNWithdrawals = _depositsNWithdrawals;
	}



	public Student get_student() {
		return _student;
	}


	public void set_student(Student _student) {
		this._student = _student;
	}


	public Teacher get_teacher() {
		return _teacher;
	}


	public void set_teacher(Teacher _teacher) {
		this._teacher = _teacher;
	}


	public User get_user() {
		return _user;
	}


	public void set_user(User _user) {
		this._user = _user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
