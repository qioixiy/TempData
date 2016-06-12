package cn.fingerdata.bizz;

import cn.fingerdata.bean.Account;

public interface AccountBiz {
	public  Account  login(String  accountname,String  password);
	public  boolean   register(Account  account);
	/**
	 * 用于验证账号是否存在
	 * @param accountname
	 * @return  true:代表传入的账号是可以注册的，反之，则不行
	 */
	public  boolean  validate(String  accountname);
	
	public  Account  getAccountById(Integer  id);

}
