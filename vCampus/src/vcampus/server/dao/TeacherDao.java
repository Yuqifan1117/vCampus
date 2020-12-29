package vcampus.server.dao;



import vcampus.server.exception.*;
import vcampus.vo.Teacher;

public interface TeacherDao {
	/**
	 * 传入userName参数,返回Teacher对象,未查询成功将返回null
	 * @param String
	 * @return teacher
	 */
	public Teacher findByID(String id);
	
	/**
	 * 传入id,password,若userName已经存在则抛出异常,SQL异常返回false
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
	 * 传入Teacher,若userName不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updateSelfInformation(Teacher tea)throws RecordNotFoundException;
	
	/**
	 * 传入userName,若userName不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteTeacher(String userName)throws RecordNotFoundException;
}
