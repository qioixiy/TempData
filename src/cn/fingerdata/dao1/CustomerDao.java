package cn.fingerdata.dao1;

import java.util.List;

import cn.fingerdata.bean.Customer;

public interface CustomerDao extends  BaseDao<Customer> {
	
	public List<Customer> find8Object(String conditions,Object obj);

	
 
			

}
