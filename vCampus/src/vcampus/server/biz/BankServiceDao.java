package vcampus.server.biz;

import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.Account;

public interface BankServiceDao {

	/**
	 * ����account, ����rechargeTime��д�����ݿ�ʱ����(���贫��)
	 * ��δ�ҵ���ǰѧ���������˺�����ʱ�ֱ��׳��쳣,SQL�쳣����false
	 * @param account
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean rechargeByBankAccount(Account account)throws OutOfLimitException,RecordNotFoundException;
	
}
