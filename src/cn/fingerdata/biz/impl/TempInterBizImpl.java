package cn.fingerdata.biz.impl;

import java.util.List;

import cn.fingerdata.bean.TempInter;
import cn.fingerdata.bizz.TempInterBiz;
import cn.fingerdata.dao.impl.TempInterDaoImpl;
import cn.fingerdata.dao1.TempInterDao;

public class TempInterBizImpl implements TempInterBiz {
	TempInterDao   tempInterDao=null;
	public  TempInterBizImpl(){
		this.tempInterDao=new   TempInterDaoImpl();
	}
	

	@Override
	public boolean add(TempInter tempInter) {
		try{
		TempInter  tempInter1=tempInterDao.add(tempInter);
		return  tempInter1!=null;
		
		}catch(RuntimeException   e){
			e.printStackTrace();

			return false;
		}
		
	}

	@Override
	public TempInter getTempInter(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TempInter TempInterById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TempInter> getAllTempInters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTempInter(TempInter tempInter) {
		// TODO Auto-generated method stub
		return false;
	}

}
