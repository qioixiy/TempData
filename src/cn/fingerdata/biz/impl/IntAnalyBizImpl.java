package cn.fingerdata.biz.impl;

import java.util.List;


import cn.fingerdata.bean.TempInter;
import cn.fingerdata.bizz.IntAnalyBiz;
import cn.fingerdata.dao.impl.IntAnalyDaoImpl;
import cn.fingerdata.dao1.IntAnalyDao;
public class IntAnalyBizImpl implements IntAnalyBiz {
	
	IntAnalyDao   intAnalyDao=null;//构造函数，实例化它
	
	public   IntAnalyBizImpl(){
		 this.intAnalyDao=new   IntAnalyDaoImpl();
	}
	   

	/*
	 * 查询所有
	 */
	public List<TempInter> getAllTempInters() {
		 List<TempInter>  tempInters=intAnalyDao.getAll();
		   return tempInters;
	}

	/*
	 *根据主键id查询
	 */
	public TempInter getTempInter(int id) {
		return intAnalyDao.getById(id);
	}

	@Override
	public boolean add(TempInter tempInter) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TempInter TempInterById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(TempInter tempInter) {
		// TODO Auto-generated method stub
		return false;
	}

}
