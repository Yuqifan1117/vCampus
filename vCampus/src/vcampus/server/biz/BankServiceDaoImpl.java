package vcampus.server.biz;

import vcampus.server.dao.BankDao;
import vcampus.server.dao.BankDaoImpl;
import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.Account;

public class BankServiceDaoImpl implements BankServiceDao{

	private BankDao bd = new BankDaoImpl();
	@Override
	public boolean rechargeByBankAccount(Account account) throws OutOfLimitException, RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(bd.rechargeByBankAccount(account)) {
				return true;
			}
			
		} catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
		catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
}
