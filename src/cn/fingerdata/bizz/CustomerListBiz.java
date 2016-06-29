package cn.fingerdata.bizz;

import java.util.List;

import cn.fingerdata.bean.Customer;

public interface CustomerListBiz {
	
	public  Customer  getCustomer(int  id);//鏍规嵁id鏌ヨ锛屼紶閫抜d杩囨潵锛�
	
    public  boolean  add(Customer  customer);//娣诲姞淇℃伅锛�
	
	public Customer  CustomerById(Integer  id);//鏍规嵁涓婚敭id鏌ヨ锛�
	
	public  List<Customer>  getAllCustomers();//鏌ヨ鎵�湁淇℃伅锛岃繑鍥濴ist   Customer鐨勬硾鍨嬮泦鍚堬紱
	
	
	public  boolean  updateCustomer(Customer  customer);//淇敼淇℃伅锛�
	public  Customer  getByUserid(int  userid);//根据id查询，传递id过来；
}
	


