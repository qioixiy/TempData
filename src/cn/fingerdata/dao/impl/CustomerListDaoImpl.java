package cn.fingerdata.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.dao1.BaseDataBaseDao;
import cn.fingerdata.dao1.CustomerListDao;

public class CustomerListDaoImpl extends BaseDataBaseDao implements   CustomerListDao {
		
	
	private  Connection  conn=null;
	private  PreparedStatement  stmt=null;
	private  ResultSet   rs=null;
	
	

	@Override
	public Customer getById(int id) {
		System.out.println("enter dao");
		
	Customer customer = null;
	String sql= "select * from customer where id = ?";
    try{
    	conn=getConnection();
		stmt=conn.prepareStatement(sql);
		stmt.setInt(1, id);
		rs=stmt.executeQuery();//鎵ц姝ql璇彞
		if(rs !=null){
			if(rs.next()){
				 customer=new   Customer();
				 customer.setId(rs.getInt("id"));
				 customer.setUserid(rs.getInt("userid"));
				 customer.setName(rs.getString("name"));
				 customer.setGender(rs.getString("gender"));
				 customer.setBirthday(rs.getString("birthday"));
				 customer.setAge(rs.getString("age"));
				 customer.setVersion(rs.getString("version"));
				 customer.setCollectDate(rs.getString("collectDate"));
				 customer.setConstellation(rs.getString("constellation"));
				 customer.setBloodtype(rs.getString("bloodtype"));
				 customer.setFatherName(rs.getString("fatherName"));
				 customer.setFarBirthday(rs.getString("farBirthday"));
				 customer.setFphone(rs.getString("fphone"));
				 customer.setMatherName(rs.getString("matherName"));
				 customer.setMarBirthday(rs.getString("marBirthday"));
				 customer.setMphone(rs.getString("mphone"));
				 customer.setCareer(rs.getString("career"));
				 customer.setAddress(rs.getString("address"));
				 customer.setPhone(rs.getString("phone"));
				 customer.setQQ(rs.getString("QQ"));
				 customer.setMSN(rs.getString("MSN"));
				 customer.setLeftATD(rs.getString("leftATD"));
				 customer.setRightATD(rs.getString("rightATD"));
				 customer.setNote(rs.getString("note"));
				 customer.setCollId(rs.getInt("collId"));
				 customer.setCollName(rs.getString("collName"));
				 customer.setColldate(rs.getString("colldate"));
				 customer.setDisId(rs.getInt("disId"));
				 customer.setDisName(rs.getString("disName"));
				 customer.setDisdate(rs.getString("disdate"));
				 
			
			}
			
		}
    	
    	
    	
    }catch(Exception  e){
    	e.printStackTrace();
    }finally{
    	closeAll(conn,stmt,rs);
    }
    
		return customer;
	}

	
	
	
	@Override
	public Customer get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*
	 * 鏌ヨ鎵�湁鐨勬暟鎹�
	 */
	public List<Customer> getAll() {
		String sql="Select * from  customer";
		System.out.println(sql);
		List<Customer>  customerList1=new  ArrayList<Customer>();
		try{
			conn=getConnection();
			System.out.println(conn);
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery(sql);//鎵ц姝ql璇彞
			while(rs.next()){//閬嶅巻鏁版嵁锛屽瓨鍏ustomerList1涓�
			 Customer  customer=new   Customer();
			 customer.setId(rs.getInt("id"));
			 customer.setUserid(rs.getInt("userid"));
			 customer.setName(rs.getString("name"));
			 customer.setGender(rs.getString("gender"));
			 customer.setBirthday(rs.getString("birthday"));
			 customer.setAge(rs.getString("age"));
			 customer.setVersion(rs.getString("version"));
			 customer.setCollectDate(rs.getString("collectDate"));
			 customer.setConstellation(rs.getString("constellation"));
			 customer.setBloodtype(rs.getString("bloodtype"));
			 customer.setFatherName(rs.getString("fatherName"));
			 customer.setFarBirthday(rs.getString("farBirthday"));
			 customer.setFphone(rs.getString("fphone"));
			 customer.setMatherName(rs.getString("matherName"));
			 customer.setMarBirthday(rs.getString("marBirthday"));
			 customer.setMphone(rs.getString("mphone"));
			 customer.setCareer(rs.getString("career"));
			 customer.setAddress(rs.getString("address"));
			 customer.setPhone(rs.getString("phone"));
			 customer.setQQ(rs.getString("QQ"));
			 customer.setMSN(rs.getString("MSN"));
			 customer.setLeftATD(rs.getString("leftATD"));
			 customer.setRightATD(rs.getString("rightATD"));
			 customer.setNote(rs.getString("note"));
			 customer.setCollId(rs.getInt("collId"));
			 customer.setCollName(rs.getString("collName"));
			 customer.setColldate(rs.getString("colldate"));
			 customer.setDisId(rs.getInt("disId"));
			 customer.setDisName(rs.getString("disName"));
			 customer.setDisdate(rs.getString("disdate"));
			 
			 
			 customerList1.add(customer);
		}
	
	   }catch(SQLException  e){
		   e.printStackTrace();
	   }finally{
		   closeAll(conn,stmt,rs);//鍏抽棴杩炴帴
	   }
		return  customerList1;
	}
	
	
	

	@Override
	public Customer add(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void deletById(Serializable id) {
		// TODO Auto-generated method stub

	}
	

	@Override
	public void update(Customer entity) {
		// TODO Auto-generated method stub

	}
	

	@Override
	public List<Customer> find(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Customer> find(Customer condition) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Customer> findByProperty(String propertyName, String value) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Customer getByUserid(int userid) {
		System.out.println("enter dao");
		
	Customer customer = null;
	String sql= "select * from customer where userid = ?";
    try{
    	conn=getConnection();
		stmt=conn.prepareStatement(sql);
		stmt.setInt(1, userid);
		rs=stmt.executeQuery();//鎵ц姝ql璇彞
		if(rs !=null){
			if(rs.next()){
				 customer=new   Customer();
				 customer.setId(rs.getInt("id"));
				 customer.setUserid(rs.getInt("userid"));
				 customer.setName(rs.getString("name"));
				 customer.setGender(rs.getString("gender"));
				 customer.setBirthday(rs.getString("birthday"));
				 customer.setAge(rs.getString("age"));
				 customer.setVersion(rs.getString("version"));
				 customer.setCollectDate(rs.getString("collectDate"));
				 customer.setConstellation(rs.getString("constellation"));
				 customer.setBloodtype(rs.getString("bloodtype"));
				 customer.setFatherName(rs.getString("fatherName"));
				 customer.setFarBirthday(rs.getString("farBirthday"));
				 customer.setFphone(rs.getString("fphone"));
				 customer.setMatherName(rs.getString("matherName"));
				 customer.setMarBirthday(rs.getString("marBirthday"));
				 customer.setMphone(rs.getString("mphone"));
				 customer.setCareer(rs.getString("career"));
				 customer.setAddress(rs.getString("address"));
				 customer.setPhone(rs.getString("phone"));
				 customer.setQQ(rs.getString("QQ"));
				 customer.setMSN(rs.getString("MSN"));
				 customer.setLeftATD(rs.getString("leftATD"));
				 customer.setRightATD(rs.getString("rightATD"));
				 customer.setNote(rs.getString("note"));
				 customer.setCollId(rs.getInt("collId"));
				 customer.setCollName(rs.getString("collName"));
				 customer.setColldate(rs.getString("colldate"));
				 customer.setDisId(rs.getInt("disId"));
				 customer.setDisName(rs.getString("disName"));
				 customer.setDisdate(rs.getString("disdate"));
			}
			
		}
    	
    }catch(Exception  e){
    	e.printStackTrace();
    }finally{
    	closeAll(conn,stmt,rs);
    }
    
		return customer;
	}

}
