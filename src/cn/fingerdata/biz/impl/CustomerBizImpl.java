package cn.fingerdata.biz.impl;

import java.util.List;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.bizz.CustomerBiz;
import cn.fingerdata.dao.impl.CustomerDaoImpl;
import cn.fingerdata.dao1.CustomerDao;

public class CustomerBizImpl implements CustomerBiz {
	CustomerDao  customerDao=null;
	public  CustomerBizImpl(){
		this.customerDao=new CustomerDaoImpl();
	}

	@Override
	public boolean add(Customer customer) {
		try{
			Customer  customer1=customerDao.add(customer);
			return  customer1!=null;
			
		}catch(RuntimeException  e){
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	@Override
	public Customer CustomerById(Integer id) {
		
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerDao.getAll();
		return customers;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

}
