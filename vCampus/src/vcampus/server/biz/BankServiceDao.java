package vcampus.server.biz;

import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.Account;

public interface BankServiceDao {

	/**
	 * 传入account, 其中rechargeTime在写入数据库时计算(无需传入)
	 * 在未找到当前学生和银行账号余额不足时分别抛出异常,SQL异常返回false
	 * @param account
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
	public boolean rechargeByBankAccount(Account account)throws OutOfLimitException,RecordNotFoundException;
	
}
