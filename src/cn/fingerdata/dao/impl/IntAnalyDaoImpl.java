package cn.fingerdata.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.bean.TempInter;
import cn.fingerdata.dao1.BaseDataBaseDao;
import cn.fingerdata.dao1.IntAnalyDao;

public class IntAnalyDaoImpl extends BaseDataBaseDao implements IntAnalyDao {
	
	private  Connection  conn=null;
	private  PreparedStatement  stmt=null;
	private  ResultSet   rs=null;


	/**
	 * 根据主键Id查询
	 */
	public TempInter getById(int id) {
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String sql = "select * from  tempinter where Inter_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					
					
					TempInter   tempInter=new  TempInter();
					 tempInter.setInter_id(rs.getInt("Inter_id"));
					 tempInter.setUserid(rs.getInt("userid"));
				      tempInter.setL1temp(rs.getString("L1temp"));
				      tempInter.setL1RCL(rs.getInt("L1RCL"));
				      tempInter.setL1RCR(rs.getInt("L1RCR"));
				      tempInter.setL2temp(rs.getString("L2temp"));
				      tempInter.setL2RCL(rs.getInt("L2RCL"));
				      tempInter.setL2RCR(rs.getInt("L2RCR"));
				      tempInter.setL3temp(rs.getString("L3temp"));
				      tempInter.setL3RCL(rs.getInt("L3RCL"));
				      tempInter.setL3RCR(rs.getInt("L3RCR"));
				      tempInter.setL4temp(rs.getString("L4temp"));
				      tempInter.setL4RCL(rs.getInt("L4RCL"));
				      tempInter.setL4RCR(rs.getInt("L4RCR"));
				      tempInter.setL5temp(rs.getString("L5temp"));
				      tempInter.setL3RCL(rs.getInt("L5RCL"));
				      tempInter.setL3RCR(rs.getInt("L5RCR"));
				      tempInter.setL5temp(rs.getString("R1temp"));
				      tempInter.setR1RCL(rs.getInt("R1RCL"));
				      tempInter.setR1RCR(rs.getInt("R1RCR"));
				      tempInter.setR2temp(rs.getString("R2temp"));
				      tempInter.setR2RCL(rs.getInt("R2RCL"));
				      tempInter.setR2RCR(rs.getInt("R2RCR"));
				      tempInter.setR3temp(rs.getString("R3temp"));
				      tempInter.setR3RCL(rs.getInt("R3RCL"));
				      tempInter.setR3RCR(rs.getInt("R3RCR"));
				      tempInter.setR4temp(rs.getString("R4temp"));
				      tempInter.setR4RCL(rs.getInt("R4RCL"));
				      tempInter.setR4RCR(rs.getInt("R4RCR"));
				      tempInter.setR5temp(rs.getString("R5temp"));
				      tempInter.setR5RCL(rs.getInt("R5RCL"));
				      tempInter.setR5RCR(rs.getInt("R5RCR"));
					
					 
					 
					return tempInter;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, stmt, rs);
		}
		return null;
	}

	
	
	
    /*
     * 查询所有的数据
     */
	public List<TempInter> getAll() {
		String sql="Select * from  tempinter";
		System.out.println(sql);
		List<TempInter>  tempInterList1=new  ArrayList<TempInter>();
		try{
			conn=getConnection();
			System.out.println(conn);
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery(sql);//执行此sql语句
			while(rs.next()){//遍历数据，存入tempInterList1中
				
		      TempInter   tempInter=new  TempInter();
		      
		      
		      tempInter.setUserid(rs.getInt("userid"));
		      tempInter.setL1temp(rs.getString("L1temp"));
		      tempInter.setL1RCL(rs.getInt("L1RCL"));
		      tempInter.setL1RCR(rs.getInt("L1RCR"));
		      tempInter.setL2temp(rs.getString("L2temp"));
		      tempInter.setL2RCL(rs.getInt("L2RCL"));
		      tempInter.setL2RCR(rs.getInt("L2RCR"));
		      tempInter.setL3temp(rs.getString("L3temp"));
		      tempInter.setL3RCL(rs.getInt("L3RCL"));
		      tempInter.setL3RCR(rs.getInt("L3RCR"));
		      tempInter.setL4temp(rs.getString("L4temp"));
		      tempInter.setL4RCL(rs.getInt("L4RCL"));
		      tempInter.setL4RCR(rs.getInt("L4RCR"));
		      tempInter.setL5temp(rs.getString("L5temp"));
		      tempInter.setL3RCL(rs.getInt("L5RCL"));
		      tempInter.setL3RCR(rs.getInt("L5RCR"));
		      tempInter.setL5temp(rs.getString("R1temp"));
		      tempInter.setR1RCL(rs.getInt("R1RCL"));
		      tempInter.setR1RCR(rs.getInt("R1RCR"));
		      tempInter.setR2temp(rs.getString("R2temp"));
		      tempInter.setR2RCL(rs.getInt("R2RCL"));
		      tempInter.setR2RCR(rs.getInt("R2RCR"));
		      tempInter.setR3temp(rs.getString("R3temp"));
		      tempInter.setR3RCL(rs.getInt("R3RCL"));
		      tempInter.setR3RCR(rs.getInt("R3RCR"));
		      tempInter.setR4temp(rs.getString("R4temp"));
		      tempInter.setR4RCL(rs.getInt("R4RCL"));
		      tempInter.setR4RCR(rs.getInt("R4RCR"));
		      tempInter.setR5temp(rs.getString("R5temp"));
		      tempInter.setR5RCL(rs.getInt("R5RCL"));
		      tempInter.setR5RCR(rs.getInt("R5RCR"));
			
			 
			 
			 tempInterList1.add( tempInter);
		}
	
	   }catch(SQLException  e){
		   e.printStackTrace();
	   }finally{
		   closeAll(conn,stmt,rs);//关闭连接
	   }
		return  tempInterList1;
	}
	
	
	
	
	@Override
	public TempInter get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TempInter add(TempInter entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletById(Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(TempInter entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TempInter> find(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TempInter> find(TempInter condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TempInter> findByProperty(String propertyName, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
