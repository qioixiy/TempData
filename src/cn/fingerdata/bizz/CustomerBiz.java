package cn.fingerdata.bizz;

import java.util.List;

import cn.fingerdata.bean.Customer;

public interface CustomerBiz {
	public  boolean  add(Customer  customer);//添加信息；
	
	public  Customer  getCustomer(int  id);//根据主键id查询，传递id过来；
	
	public  List<Customer>  getAllCustomers();//查询所有信息，返回List   Customer的泛型集合；
	
	public Customer  CustomerById(Integer  id);
	
	public  boolean  updateCustomer(Customer  customer);//修改信息；
	
	public List<Customer> getCustomer8Conditions(String conditions,Object obj);
}
