package cn.fingerdata.biz.impl;

import java.util.List;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.bizz.CustomerBiz;
import cn.fingerdata.bizz.CustomerListBiz;
import cn.fingerdata.dao.impl.CustomerListDaoImpl;
import cn.fingerdata.dao1.CustomerListDao;

public class CustomerListBizImpl   implements    CustomerListBiz   {
	
	   CustomerListDao  customerListDao = new  CustomerListDaoImpl();//构造函数，实例化它
	 
	   

		@Override
		public Customer getCustomer(int id) {
			System.out.println("enter "+id);
			return   customerListDao.getById(id);
		}

	   
	   
	   @Override
		public List<Customer> getAllCustomers() {
		   List<Customer> customers= customerListDao.getAll();
		   System.out.println(customers.get(0).getId() + "------------------");
		   return customers;
		}
   

	@Override
	public boolean add(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer CustomerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
  
	
}
