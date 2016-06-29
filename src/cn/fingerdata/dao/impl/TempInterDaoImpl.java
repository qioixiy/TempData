package cn.fingerdata.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import cn.fingerdata.bean.TempInter;
import cn.fingerdata.dao1.BaseDataBaseDao;
import cn.fingerdata.dao1.TempInterDao;

public class TempInterDaoImpl extends BaseDataBaseDao implements TempInterDao {
	
	private  Connection  conn=null;
	private  Statement  stmt=null;
	private  ResultSet   rs=null;
	
		/**
		 * 添加指纹判读信息
		 */
		public TempInter add(TempInter entity) {
			String  sql=String.format("INSERT  INTO  tempinter(userid,name,L1temp,L1RCL,L1RCR,L2temp,L2RCL,L2RCR,L3temp,"
					+ "L3RCL,L3RCR,L4temp,L4RCL,L4RCR,L5temp,L5RCL,L5RCR,R1temp,R1RCL,R1RCR,R2temp,R2RCL,R2RCR,R3temp,R3RCL,"
					+ "R3RCR,R4Ttemp,R4RCL,R4RCR,R5temp,R5RCL,R5RCR) ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',"
					+ "'%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s',"
					+ "'%s','%s','%s','%s','%s','%s','%s','%s');", 
					entity.getUserid(),entity.getName(),entity.getL1temp(),entity.getL1RCL(),
					entity.getL1RCR(),entity.getL2temp(),entity.getL2RCL(),entity.getL2RCR(),
					entity.getL3temp(),entity.getL3RCL(),entity.getL3RCR(),entity.getL4temp(),
					entity.getL4RCL(),entity.getL4RCR(),entity.getL5temp(),entity.getL5RCL(),entity.getL5RCR(),entity.getR1temp(),entity.getR1RCL(),entity.getR1RCR(),entity.getR2temp(),
					entity.getR2RCL(),entity.getR2RCR(),entity.getR3temp(),entity.getR3RCL(),entity.getR3RCR(),entity.getR4temp(),entity.getR4RCL(),
					entity.getR4RCR(),entity.getR5temp(),entity.getR5RCL(),entity.getR5RCR());
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

	
	
	@Override
	public TempInter getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TempInter get(Serializable id) {
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

	@Override
	public List<TempInter> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public TempInter getByUserid(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
