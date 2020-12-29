package vcampus.server.dao;

import java.util.ArrayList;

import vcampus.server.exception.*;
import vcampus.vo.*;

/**
 * StudentDao���Ѿ��ṩ��ѧ���˻���Ϣ�Ĳ�ѯ����
 * ѧ��ʵ����������˻����account��һ��ͨ���money����Ϣ
 * ��BankDao�н��ṩ�����˻���һ��ͨ��ֵ�Ĺ���
 */
public interface BankDao {
	/**
	 * ����account, ����rechargeTime��д�����ݿ�ʱ����(���贫��)
	 * ��δ�ҵ���ǰѧ���������˺�����ʱ�ֱ��׳��쳣,SQL�쳣����false
	 * @param account
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public double queryAccountByUserID(String userID);
	public double queryMoneyByUserID(String userID);
	public ArrayList<Account> queryRechargeInformation(String userID);
	public boolean rechargeByBankAccount(Account account)throws OutOfLimitException,RecordNotFoundException;
	
}
