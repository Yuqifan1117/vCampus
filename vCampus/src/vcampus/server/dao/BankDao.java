package vcampus.server.dao;

import java.util.ArrayList;

import vcampus.server.exception.*;
import vcampus.vo.*;

/**
 * StudentDao中已经提供了学生账户信息的查询方法
 * 学生实体包含银行账户余额account、一卡通余额money的信息
 * 在BankDao中仅提供银行账户向一卡通充值的功能
 */
public interface BankDao {
	/**
	 * 传入account, 其中rechargeTime在写入数据库时计算(无需传入)
	 * 在未找到当前学生和银行账号余额不足时分别抛出异常,SQL异常返回false
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
