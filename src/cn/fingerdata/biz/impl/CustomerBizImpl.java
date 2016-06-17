package cn.fingerdata.biz.impl;

import java.util.ArrayList;
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


	
	public boolean add(Customer customer) {
		try{
			Customer  customer1=customerDao.add(customer);
			return  customer1!=null;
			
		}catch(RuntimeException  e){
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	

	public Customer getCustomer(int id) {
		return customerDao.getById(id);
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
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public List<Customer> getCustomer8Conditions(String conditions,Object obj) {
		List<Customer> customers= new ArrayList<Customer>();
		
		if(conditions.equals("全部")){
			return customers;
		}
		if(conditions.equals("姓名")){
			customers = customerDao.find8Object("name", obj);
		}else if(conditions.equals("年龄")){
			customers = customerDao.find8Object("age", obj);
		}
		else if(conditions.equals("编号")){
			customers = customerDao.find8Object("userid", obj);
		}
		else if(conditions.equals("性别")){
			customers = customerDao.find8Object("gender", obj);
		}
		else if(conditions.equals("版本")){
			customers = customerDao.find8Object("version", obj);
		}
		else if(conditions.equals("采集师编号")){
			customers = customerDao.find8Object("collId", obj);
		}
		else if(conditions.equals("采集师")){
			customers = customerDao.find8Object("collName", obj);
		}
		else if(conditions.equals("采集日期")){
			customers = customerDao.find8Object("colldate", obj);
		}
		else if(conditions.equals("生日")){
			customers = customerDao.find8Object("birthday", obj);
		}
		return customers;
	}

}
