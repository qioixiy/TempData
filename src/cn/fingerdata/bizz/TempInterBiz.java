package cn.fingerdata.bizz;

import java.util.List;


import cn.fingerdata.bean.TempInter;

public interface TempInterBiz {
     public  TempInter  getTempInter(int  id);//根据id查询，传递id过来；
	
    public  boolean  add(TempInter  tempInter);//添加信息；
	
	public TempInter  TempInterById(Integer  id);//根据主键id查询；
	
	public  List<TempInter>  getAllTempInters();//查询所有信息，返回List   Customer的泛型集合；
	
	
	public  boolean  updateTempInter(TempInter  tempInter);//修改信息；
	

}
