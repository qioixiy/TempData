package cn.fingerdata.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import cn.fingerdata.bean.Account;
import cn.fingerdata.dao1.AccountDao;
import cn.fingerdata.dao1.BaseDataBaseDao;

public class AccountDaoImpl extends BaseDataBaseDao implements AccountDao {
	private  java.sql.Connection  conn=null;
	private  java.sql.Statement  stmt=null;
	private  ResultSet  rs=null;
	

	@Override
	public Account get(Serializable id) {
		String  sql="select *  from  account  where id="+id;
		Account  account=new  Account();
		try{
			rs=stmt.executeQuery(sql);
			if(rs!=null&&rs.next()){
				Account  account1=new  Account();
				account1.setId(rs.getInt("id"));
				account1.setAccountId(rs.getString("accountId"));
				account1.setAccountname(rs.getString("accountname"));
				account1.setPassword(rs.getString("password"));
				account1.setName(rs.getString("name"));
				account1.setPrivilege(rs.getString("privilege"));
				
			   return   account1;
			}
			
			
		}catch(Exception  e){
			
		}finally{
			closeAll(conn,stmt,rs);
		}
		return  null;
	}

	@Override
	public Account add(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletById(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Account entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> find(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> find(Account condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByProperty(String propertyName, String value) {
		String  sql=String.format("select  * from account  a where a.%s='%s'", 
				propertyName,  value);
		List<Account> accounts=new   ArrayList<Account>();
		try{
			conn=  getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					Account  account=new  Account();
					account.setId(rs.getInt("id"));
					account.setAccountId(rs.getString("accountId"));
					account.setAccountname(rs.getString("accountname"));
					account.setPassword(rs.getString("password"));
					account.setName(rs.getString("name"));
					account.setPrivilege(rs.getString("privilege"));
					accounts.add(account);
				}
			}
			
			
			
			
		}catch(Exception  e){
			
		}finally{
			closeAll(conn,stmt,rs);
		}
		
    return  accounts;
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
