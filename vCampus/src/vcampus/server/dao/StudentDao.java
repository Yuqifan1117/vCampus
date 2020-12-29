package vcampus.server.dao;

import vcampus.server.exception.*;
import vcampus.vo.Student;

public interface StudentDao {
	/**
	 * ����userName����,����Student����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return student
	 */
	public Student findByID(String id);

	/**
	 * ����studentID,password,�û��Ѿ��������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean insertByUserNameAndPassword(String userName,String password)throws RecordAlreadyExistException;
	
	/**
	 * ����userName,password,��userName���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updatePassword(String userName,String password)throws RecordNotFoundException;
	
	/**
	 * ����Student,��userName���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updateSelfInformation(Student std)throws RecordNotFoundException;
	
	/**
	 * ����userName,��userName���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteStudent(String userName)throws RecordNotFoundException;
}
