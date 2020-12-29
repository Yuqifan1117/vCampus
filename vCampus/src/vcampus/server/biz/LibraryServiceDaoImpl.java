package vcampus.server.biz;

import java.util.ArrayList;

import vcampus.server.dao.LibraryDao;
import vcampus.server.dao.LibraryDaoImpl;
import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.BookBorrow;
import vcampus.vo.Book;

public class LibraryServiceDaoImpl implements LibraryServiceDao{

	private LibraryDao ld = new LibraryDaoImpl();
	
	@Override
	public Book queryBookInformation(String bookID) {
		// TODO Auto-generated method stub
		if(ld.queryBookInformation(bookID) != null) {
			return ld.queryBookInformation(bookID);
		}
		return null;
	}
	
	
	
	@Override
	public ArrayList<Book> queryBook(String bookName) {
		// TODO Auto-generated method stub
		if(ld.queryBook(bookName) != null) {
			return ld.queryBook(bookName);
		}
		return null;
	}
	
	
	@Override
	public ArrayList<BookBorrow> queryBookBorrow(String userID) {
		// TODO Auto-generated method stub
		if(ld.queryBookBorrow(userID) != null) {
			return ld.queryBookBorrow(userID);
		}
		return null;
	}
	
	
	@Override
	public boolean borrowBook(BookBorrow borrow) throws RecordNotFoundException, OutOfLimitException {
		// TODO Auto-generated method stub
		try {
			if(ld.borrowBook(borrow)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		return false;
	}
	
	
	
	@Override
	public boolean returnBook(BookBorrow borrow) throws RecordNotFoundException, OutOfLimitException {
		// TODO Auto-generated method stub
		try {
			if(ld.returnBook(borrow)) {
				return true;
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			
			throw new RecordNotFoundException();
		}
		
		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.LibraryServiceDao#queryAllBook()
	 */
	@Override
	public ArrayList<Book> queryAllBook() {
		// TODO Auto-generated method stub
		
		ArrayList<Book> allBooks = ld.queryAllBook();
		if(allBooks != null) {
			return allBooks;
		}
		 
		return null;
	}
	
	
	@Override
	public boolean addBookByAdmin(Book book) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(ld.addBookByAdmin(book)) {
				return true;
			}
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return false;
	}
	
	
	
	@Override
	public boolean updateBookByAdmin(Book book) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ld.updateBookByAdmin(book)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
	@Override
	public boolean deleteBookByAdmin(String bookID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ld.deleteBookByAdmin(bookID)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
	
}
