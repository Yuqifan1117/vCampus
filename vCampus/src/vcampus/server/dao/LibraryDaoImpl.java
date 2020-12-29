package vcampus.server.dao;

import java.sql.SQLException;
import java.sql.Date;
import vcampus.vo.BookBorrow;
import vcampus.vo.Book;
import vcampus.server.exception.*;
import vcampus.server.dao.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Yu
 *
 */
public class LibraryDaoImpl implements LibraryDao{
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private Book ResultSetToBookInformation() {
		try {
			Book book=new Book();
			book.setBookLocation(rs.getString("bookLocation"));
			book.setBookID(rs.getString("bookID"));
			book.setBookName(rs.getString("bookName"));
			book.setBookPress(rs.getString("bookPress"));
			book.setAuthor(rs.getString("author"));
			book.setBorrowedAmount(rs.getInt("borrowedAmount"));
			book.setTotalAmount(rs.getInt("totalAmount"));
    		return book;
    	}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	
	private ArrayList<BookBorrow> ResultSetToBookBorrowArrayList(){
		try {
			ArrayList<BookBorrow> list=new ArrayList<BookBorrow>();
			do {
				BookBorrow bookborrow;
				bookborrow=new BookBorrow();
				bookborrow.setBookID(rs.getString("bookID"));
				bookborrow.setBorrowNumber(rs.getInt("borrowNumber"));
				bookborrow.setBorrowTime(rs.getDate("borrowTime"));
				bookborrow.setUserID(rs.getString("userID"));
				list.add(bookborrow);
			}while(rs.next());
			return list;
		}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	
	private ArrayList<Book> ResultSetToBookInformationArrayList(){
		try {
			ArrayList<Book> list=new ArrayList<Book>();
			do {
				Book book;
				book=new Book();
				book.setBookID(rs.getString("bookID"));
				book.setBookLocation(rs.getString("bookLocation"));
				book.setBookName(rs.getString("bookName"));
				book.setBookPress(rs.getString("bookPress"));
				book.setAuthor(rs.getString("author"));
				book.setBorrowedAmount(rs.getInt("borrowedAmount"));
				book.setTotalAmount(rs.getInt("totalAmount"));
				
				list.add(book);
			}while(rs.next());
			return list;
		}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	
	
	
	@Override
	public Book queryBookInformation(String bookID) {
		try {
			String sql="SELECT * FROM book WHERE bookID='"+bookID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToBookInformation();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<BookBorrow> queryBookBorrow(String userID) {
		try {
			String sql="SELECT * FROM bookborrow WHERE userID='"+userID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return ResultSetToBookBorrowArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public ArrayList<Book> queryBook(String bookName) {
		try {
			String sql="SELECT * FROM book WHERE bookName ='"+bookName+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToBookInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<Book> queryAllBook() {
		try {
			String sql="SELECT * FROM book";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToBookInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean borrowBook(BookBorrow borrow) 
			throws RecordNotFoundException,OutOfLimitException {
		try {
			String sql1="SELECT * FROM book WHERE bookID='"+borrow.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
			    int currentNumber=rs.getInt("borrowedAmount");
			    int maxNumber=rs.getInt("totalAmount");
				if(currentNumber+borrow.getBorrowNumber()>maxNumber)throw new OutOfLimitException();
			    currentNumber+=borrow.getBorrowNumber();
				
				String sql2="SELECT * FROM bookborrow WHERE bookID='"+borrow.getBookID()
						+"' AND userID='"+borrow.getUserID()+"'";
				stmt=DBC.con.prepareStatement(sql2);
				rs = stmt.executeQuery();
				int borrowNumber=borrow.getBorrowNumber();
				//UPDATE borrow time
			    Date ts = new Date(System.currentTimeMillis());
				if(rs.next()) {
					borrowNumber+=rs.getInt("borrowNumber");
				    
				    //UPDATE tbl_bookborrow  //not to update the borrowTime
				    String sql="UPDATE bookborrow SET borrowNumber=? WHERE bookID='"
				    		+borrow.getBookID()+"' AND userID='"+borrow.getUserID()+"'";
				    stmt=DBC.con.prepareStatement(sql);
				    stmt.setInt(1,borrowNumber);
				    
					stmt.executeUpdate();
				}else {
					//INSERT NEW borrow record
					String sql="INSERT INTO bookborrow (userID,bookID,borrowTime,borrowNumber)"
							+" VALUES (?,?,?,?)";
				    stmt=DBC.con.prepareStatement(sql);
					stmt.setString(1,borrow.getUserID());
					stmt.setString(2,borrow.getBookID());
					stmt.setDate(3,ts);//record the time of modification
					stmt.setInt(4,borrow.getBorrowNumber());
					stmt.executeUpdate();
				}
				//UPDATE tbl_bookinformation
			    String sqll="UPDATE book SET borrowedAmount=? WHERE bookID='"
			    		+borrow.getBookID()+"'";
			    stmt=DBC.con.prepareStatement(sqll);
			    stmt.setInt(1,currentNumber);
			    
				stmt.executeUpdate();
					
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean returnBook(BookBorrow borrow) throws RecordNotFoundException, OutOfLimitException {
		try {
			String sql1="SELECT * FROM book WHERE bookID='"+borrow.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int borrowedAmount=rs.getInt("borrowedAmount");
				if(borrowedAmount<borrow.getBorrowNumber())throw new OutOfLimitException();
				borrowedAmount-=borrow.getBorrowNumber();
				
				String sql2="SELECT * FROM bookborrow WHERE bookID='"+borrow.getBookID()
						+"' AND userID='"+borrow.getUserID()+"'";
				stmt=DBC.con.prepareStatement(sql2);
				rs = stmt.executeQuery();
				if(rs.next()) {
					int borrowNumber=rs.getInt("borrowNumber");
					if(borrowNumber<borrow.getBorrowNumber())throw new OutOfLimitException();
					borrowNumber-=borrow.getBorrowNumber();
					
					if(borrowNumber==0) {
						String sql="DELETE FROM bookborrow WHERE bookID='"
							+borrow.getBookID()+"' AND userID='"+borrow.getUserID()+"'";
						stmt=DBC.con.prepareStatement(sql);
					
						stmt.executeUpdate();
					}else {
						String sql="UPDATE bookborrow SET borrowNumber=? WHERE bookID='"
							+borrow.getBookID()+"' AND userID='"+borrow.getUserID()+"'";
						stmt=DBC.con.prepareStatement(sql);
						stmt.setInt(1, borrowNumber);
						
						stmt.executeUpdate();
					}
					
					String sqll="UPDATE book SET borrowedAmount=? "
							+"WHERE bookID='"+borrow.getBookID()+"'";
					stmt=DBC.con.prepareStatement(sqll);
					stmt.setInt(1,borrowedAmount);
					
					stmt.executeUpdate();
				}else throw new RecordNotFoundException();
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean addBookByAdmin(Book book) 
			throws RecordAlreadyExistException {
		try {
			String sql1="SELECT * FROM book WHERE bookID='"+book.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) throw new RecordAlreadyExistException();
				
			String sql2="INSERT INTO book (bookID,bookName,bookPress,"
					+"bookLocation,author,totalAmount,borrowedAmount) "
					+"VALUES (?,?,?,?,?,?,?)";
			stmt=DBC.con.prepareStatement(sql2);
			stmt.setString(1,book.getBookID());
			stmt.setString(2,book.getBookName());
			stmt.setString(3,book.getBookPress());
			stmt.setString(4,book.getBookLocation());
			stmt.setString(5,book.getAuthor());
			stmt.setInt(6,book.getTotalAmount());
			stmt.setInt(7, book.getBorrowedAmount());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateBookByAdmin(Book book) 
			throws RecordNotFoundException {
		try {
			String sql1="SELECT * FROM book WHERE bookID='"+book.getBookID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String sql="UPDATE book SET bookName=?,bookPress=?,bookLocation=?,author=?,"
						+"totalAmount=?,borrowedAmount=? WHERE bookID='"+book.getBookID()+"'";
				stmt=DBC.con.prepareStatement(sql);
				stmt.setString(1,book.getBookName());
				stmt.setString(2,book.getBookPress());
				stmt.setString(3,book.getBookLocation());
				stmt.setString(4,book.getAuthor());
				stmt.setInt(5,book.getTotalAmount());
				stmt.setInt(6, book.getBorrowedAmount());
				
				stmt.executeUpdate();
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteBookByAdmin(String bookID) 
			throws RecordNotFoundException {
		try {
			String sql1="SELECT * FROM book WHERE bookID='"+bookID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String sql="DELETE FROM book WHERE bookID='"+bookID+"'";
				stmt=DBC.con.prepareStatement(sql);
				stmt.executeUpdate();
			}else throw new RecordNotFoundException();
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
