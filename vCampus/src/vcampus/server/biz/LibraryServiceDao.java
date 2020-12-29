package vcampus.server.biz;

import java.util.ArrayList;

import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.BookBorrow;
import vcampus.vo.Book;

public interface LibraryServiceDao {
	/**
	 * ����bookID����,����Book����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return book
	 */
	public Book queryBookInformation(String bookID);
	
	/**
	 * ����bookName����,����ArrayList<BookInformation>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<BookInformation>
	 */
	public ArrayList<Book> queryBook(String bookName);
	
	/**
	 * ����userID����,����ArrayList<BookBorrow>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<BookBorrow>
	 */
	public ArrayList<BookBorrow> queryBookBorrow(String userID);
	
    /**
	 * ����BookBorrow,ʱ����Ϊд�����ݿ��ʱ��(ʱ���������贫��),
	 * ���鲻����/���ʣ�������������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean borrowBook(BookBorrow borrow)throws RecordNotFoundException,OutOfLimitException;
	
	/**
	 * ����BookBorrow,ʱ����Ϊд�����ݿ��ʱ��(ʱ���������贫��),��֮ǰ�н���ͬID������ˢ�½���ʱ�������
	 * ����Ŀ�����ڻ��߸�ѧ����δ����/�Ѿ�����������Ȼ�������������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean returnBook(BookBorrow borrow)throws RecordNotFoundException,OutOfLimitException;
	
	
	
	/**
	 * ��ȡ������Ŀ,����ArrayList<BookInformation>����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<BookInformation>
	 */
	public ArrayList<Book> queryAllBook();
	
	/**
	 * ����Book,��bookID�Ѿ��������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean addBookByAdmin(Book book)throws RecordAlreadyExistException;
	/**
	 * ����Book,��bookID���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean updateBookByAdmin(Book book)throws RecordNotFoundException;
	/**
	 * ����bookID,��bookID���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean deleteBookByAdmin(String bookID)throws RecordNotFoundException;
	
}
