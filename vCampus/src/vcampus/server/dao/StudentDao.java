package vcampus.server.dao;

import vcampus.server.exception.*;
import vcampus.vo.Student;

public interface StudentDao {
	/**
	 * 传入userName参数,返回Student对象,未查询成功将返回null
	 * @param String
	 * @return student
	 */
	public Student findByID(String id);

	/**
	 * 传入studentID,password,用户已经存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean insertByUserNameAndPassword(String userName,String password)throws RecordAlreadyExistException;
	
	/**
	 * 传入userName,password,若userName不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updatePassword(String userName,String password)throws RecordNotFoundException;
	
	/**
	 * 传入Student,若userName不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updateSelfInformation(Student std)throws RecordNotFoundException;
	
	/**
	 * 传入userName,若userName不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteStudent(String userName)throws RecordNotFoundException;
}
