package cn.fingerdata.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.dao1.BaseDataBaseDao;
import cn.fingerdata.dao1.CustomerDao;


public class CustomerDaoImpl extends BaseDataBaseDao implements CustomerDao {
	private  Connection  conn=null;
	private  Statement  stmt=null;
	private  ResultSet   rs=null;

	@Override
	public Customer get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 添加客户信息
	 */

	public Customer add(Customer entity) {
		String  sql=String.format("INSERT  INTO  Customer(userid,name,gender,birthday,age,version,collectDate,constellation,bloodtype,"
				+ "fatherName,farBirthday,fphone,matherName,marBirthday,mphone,career,address,phone,QQ,MSN,leftATD,rightATD,note,collId,"
				+ "collName,colldate,disId,disName,disdate) ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',"
				+ "'%s','%s','%s','%s','%s','%s');", 
				entity.getUserid(),entity.getName(),entity.getGender(),entity.getBirthday(),entity.getAge(),entity.getVersion(),entity.getCollectDate(),entity.getConstellation(),
				entity.getBloodtype(),entity.getFatherName(),entity.getFarBirthday(),entity.getFphone(),entity.getMatherName(),entity.getMarBirthday(),entity.getMphone(),
				entity.getCareer(),entity.getAddress(),entity.getPhone(),entity.getQQ(),entity.getMSN(),entity.getLeftATD(),entity.getRightATD(),entity.getNote(),entity.getCollId(),
				entity.getCollName(),entity.getColldate(),entity.getDisId(),entity.getDisName(),entity.getDisdate());
				
		System.out.println(sql);
		try{
			conn=getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			int  result=stmt.executeUpdate(sql);
			if(result>0)
				return  entity;
		
		}catch(Exception  e){
			e.printStackTrace();
		}finally{
			closeAll(conn,stmt,rs);
		}
		return null;
		
	}
	
	
	/*
	 * 查询所有的数据
	 */
	public List<Customer> getAll() {
		String sql="Select * from  customer";
		System.out.println(sql);
		List<Customer>  customerList=new  ArrayList<Customer>();
		try{
			conn=getConnection();
			System.out.println(conn);
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery(sql);//执行此sql语句
			while(rs.next()){//遍历数据，存入customerList中
			 Customer  customer=new   Customer();
			 
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
			 
			 
			 customerList.add(customer);
		}
	
	   }catch(SQLException  e){
		   e.printStackTrace();
	   }finally{
		   closeAll(conn,stmt,rs);//关闭连接
	   }
		return  customerList;
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
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
