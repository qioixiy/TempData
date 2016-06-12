package cn.fingerdata.biz.impl;

import java.util.Iterator;
import java.util.List;

import cn.fingerdata.bean.Account;
import cn.fingerdata.bizz.AccountBiz;
import cn.fingerdata.dao.impl.AccountDaoImpl;
import cn.fingerdata.dao1.AccountDao;

public class AccountBizImpl implements AccountBiz {
	 private  AccountDao dao=new  AccountDaoImpl();

	@Override
	public Account login(String accountname, String password) {
		List<Account>  accounts=dao.findByProperty("accountname", accountname);
		Iterator<Account>  it=accounts.iterator();
		while(it.hasNext()){
			Account  account=it.next();
			if(account.getPassword().equals(password)){
				return   account;
			}
		}
		


		return null;
	}

	@Override
	public boolean register(Account account) {
		try{
			Account  _account =dao.add(account);
			return   _account!=null;
		}catch(RuntimeException  e){
			e.printStackTrace();
			return  false;
		}

	}

	/**
	 * 用于验证账号是否存在
	 * 
	 */
	public boolean validate(String accountname) {
		try{
			List<Account>  accounts=dao.findByProperty("accountname",accountname);
			if(accounts.size()>0)  return false;
			return  true;
		
		}catch(RuntimeException  e){
			e.printStackTrace();
			return false;
		}
}
	

	@Override
	public Account getAccountById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
