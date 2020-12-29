package vcampus.server.dao;

import vcampus.vo.BookBorrow;
import vcampus.vo.Book;
import vcampus.server.exception.*;
import java.util.ArrayList;

public interface LibraryDao {

	/**
	 * 传入bookID参数,返回Book对象,未查询成功将返回null
	 * @param String
	 * @return book
	 */
	public Book queryBookInformation(String bookID);
	
	/**
	 * 传入bookName参数,返回ArrayList<Book>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<Book>
	 */
	public ArrayList<Book> queryBook(String bookName);
	
	/**
	 * 获取所有书目,返回ArrayList<Book>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<Book>
	 */
	public ArrayList<Book> queryAllBook();
	
	/**
	 * 传入userID参数,返回ArrayList<BookBorrow>对象,未查询成功将返回null
	 * @param String
	 * @return ArrayList<BookBorrow>
	 */
	public ArrayList<BookBorrow> queryBookBorrow(String userID);
	
    /**
	 * 传入BookBorrow,时间设为写入数据库的时间(时间属性无需传入),
	 * 若书不存在/书的剩余数量不足则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean borrowBook(BookBorrow borrow)throws RecordNotFoundException,OutOfLimitException;
	
	/**
	 * 传入BookBorrow,时间设为写入数据库的时间(时间属性无需传入),若之前有借相同ID的书则刷新借阅时间和数量
	 * 若书目不存在或者该学生并未借书/已经借出的数量比还书的数量少则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean returnBook(BookBorrow borrow)throws RecordNotFoundException,OutOfLimitException;
	
	/**
	 * 传入BookInformation,若bookID已经存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean addBookByAdmin(Book book)throws RecordAlreadyExistException;
	/**
	 * 传入BookInformation,若bookID不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean updateBookByAdmin(Book book)throws RecordNotFoundException;
	/**
	 * 传入bookID,若bookID不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean deleteBookByAdmin(String bookID)throws RecordNotFoundException;
}

