package com.havenliu.document;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xxx.db.jdbc;
import com.xxx.utils.ComputeResult;
import com.xxx.utils.TypeUtil;
import com.xxx.utils.algorithm;
import com.xxx.utils.TypeUtil.SMSModel;

import cn.fingerdata.bean.Customer;
import cn.fingerdata.dao.impl.CustomerDaoImpl;
import net.sf.json.JSONObject;

public class GenTableAllData {
	class DataShujuZongbiao {
		String xingming;
		String xingbie;
		String xingzuo;
		String chushengnianyue_nian;
		String chushengnianyue_yue;

		String FinCode_L1;
		String FinCode_L2;
		String FinCode_L3;
		String FinCode_L4;
		String FinCode_L5;
		String FinCode_R1;
		String FinCode_R2;
		String FinCode_R3;
		String FinCode_R4;
		String FinCode_R5;
		
		String ATD_L;
		String ATD_R;
		
		String lixingganxing_duiren;
		String lixingganxing_duishi;
		String lixingganxing_duizhiti;
		String lixingganxing_shengyin;
		String lixingganxing_shixiang;

		String xuexifengge_shijue;
		String xuexifengge_tingjue;
		String xuexifengge_tijue;
		
		String xuexidongji_mubiao;
		String xuexidongji_gousi;
		
		String paixu_yuyannengli;
		String paixu_kongjiannengli;
		String paixu_shuxueluoji;
		String paixu_yinyuenengli;
		String paixu_yundongnengli;
		String paixu_renjinengli;
		String paixu_zizhinengli;
		String paixu_ziranganzhi;
	}

	class DataChengrenBaobiao {
		//个人档案
		String bianhao;
		String xingming;
		String xingbie;
		String chushengnianyue;
		String xingzuo;
		String lianxidianhua;
		String dianziyouxiang;
		String lianxidizhi;
		// 先天学习潜能
		String xiantianxuexiqianneng_fenxi;
		// 操作敏锐度 Atd
		String caozuominruidu_zuo;
		String caozuominruidu_you;
		String caozuominruidu_fenxi;
		// 思维习惯
		String siweixiguan_fenxi_duiren;
		String siweixiguan_fenxi_duishi;
		String siweixiguan_fenxi_duizhiti;
		String siweixiguan_fenxi_duishengyin;
		String siweixiguan_fenxi_duituxiang;
		// 先天行为动机
		String xiantianxingweidongji_mubiao;
		String xiantianxingweidongji_gousi;
		String xiantianxingweidongji_fenxi;
		// 先天学习风格
		String xiantianxuexifengge_shijue;
		String xiantianxuexifengge_tingjue;
		String xiantianxuexifengge_tijue;
		String xiantianxuexifengge_leixing;
		String xiantianxuexifengge_fenxi;
		//个性特质1
		String gexingtezhi_1_1;
		String gexingtezhi_1_2;
		String gexingtezhi_1_3;
		String gexingtezhi_1_4;
		String gexingtezhi_1_5;
		String gexingtezhi_1_6;
		String gexingtezhi_1_7;
		String gexingtezhi_1_8;
		String gexingtezhi_1_9;
		String gexingtezhi_1_10;
		String gexingtezhi_1_11;
		String gexingtezhi_1_12;
		String gexingtezhi_1_13;
		String gexingtezhi_1_14;
		String gexingtezhi_1_15;
		//个性特质2
		String gexingtezhi_2_1;
		String gexingtezhi_2_2;
		String gexingtezhi_2_3;
		String gexingtezhi_2_4;
		String gexingtezhi_2_5;
		String gexingtezhi_2_6;
		String gexingtezhi_2_7;
		String gexingtezhi_2_8;
		String gexingtezhi_2_9;
		String gexingtezhi_2_10;
	}
	
	class DataErTongBaobiao {
		// 个人信息
		String bianhao;
		String xingming;
		String xingbie;
		String chushengnianyue;
		String xingzuo;
		String lianxidianhua;
		String dianziyouxiang;
		String lianxidizhi;
		// 先天学习潜能
		String xiantianxuexiqianneng_fenxi;
		// 操作敏锐度
		String caozuominruidu_zuo;
		String caozuominruidu_you;
		String caozuominruidu_fenxi;
		// 思维习惯
		String siweixiguan_fenxi_duiren;
		String siweixiguan_fenxi_duishi;
		String siweixiguan_fenxi_duizhiti;
		String siweixiguan_fenxi_duishengyin;
		String siweixiguan_fenxi_duituxiang;
		// 先天行为动机
		String xiantianxingweidongji_mubiao;
		String xiantianxingweidongji_gousi;
		String xiantianxingweidongji_fenxi;
		// 先天学习风格
		String  xiantianxuexifengge_shijue;
		String  xiantianxuexifengge_tingjue;
		String  xiantianxuexifengge_tijue;
		String  xiantianxuexifengge_leixing;
		String  xiantianxuexifengge_fenxi;
		// 个性特质一
		String gexingtezhi_1_1;
		String gexingtezhi_1_2;
		String gexingtezhi_1_3;
		String gexingtezhi_1_4;
		String gexingtezhi_1_5;
		String gexingtezhi_1_6;
		String gexingtezhi_1_7;
		String gexingtezhi_1_8;
		String gexingtezhi_1_9;
		String gexingtezhi_1_10;
		String gexingtezhi_1_11;
		String gexingtezhi_1_12;
		String gexingtezhi_1_13;
		String gexingtezhi_1_14;
		String gexingtezhi_1_15;
		// 个性特质二
		String gexingtezhi_2_1;
		String gexingtezhi_2_2;
		String gexingtezhi_2_3;
		String gexingtezhi_2_4;
		String gexingtezhi_2_5;
		// 多元智能
		//// 言语能力
		String duoyuanzhineng_yuyannengli_paixu;
		String duoyuanzhineng_yuyannengli_dingyi;
		String duoyuanzhineng_yuyannengli_jutibiaoxian;
		String duoyuanzhineng_yuyannengli_jianyi;
		//// 空间能力
		String duoyuanzhineng_kongjiannengli_paixu;
		String duoyuanzhineng_kongjiannengli_dingyi;
		String duoyuanzhineng_kongjiannengli_jutibiaoxian;
		String duoyuanzhineng_kongjiannengli_jianyi;
		//// 数学逻辑能力
		String duoyuanzhineng_shuxueluojinengli_paixu;
		String duoyuanzhineng_shuxueluojinengli_dingyi;
		String duoyuanzhineng_shuxueluojinengli_jutibiaoxian;
		String duoyuanzhineng_shuxueluojinengli_jianyi;
		//// 音乐能力
		String duoyuanzhineng_yinyuenengli_paixu;
		String duoyuanzhineng_yinyuenengli_dingyi;
		String duoyuanzhineng_yinyuenengli_jutibiaoxian;
		String duoyuanzhineng_yinyuenengli_jianyi;
		//// 运动能力
		String duoyuanzhineng_yundongnengli_paixu;
		String duoyuanzhineng_yundongnengli_dingyi;
		String duoyuanzhineng_yundongnengli_jutibiaoxian;
		String duoyuanzhineng_yundongnengli_jianyi;
		//// 人际能力
		String duoyuanzhineng_renjinengli_paixu;
		String duoyuanzhineng_renjinengli_dingyi;
		String duoyuanzhineng_renjinengli_jutibiaoxian;
		String duoyuanzhineng_renjinengli_jianyi;
		//// 自治能力
		String duoyuanzhineng_zizhinengli_paixu;
		String duoyuanzhineng_zizhinengli_dingyi;
		String duoyuanzhineng_zizhinengli_jutibiaoxian;
		String duoyuanzhineng_zizhinengli_jianyi;
		//// 自然感治能力
		String duoyuanzhineng_ziranganzhinengli_paixu;
		String duoyuanzhineng_ziranganzhinengli_dingyi;
		String duoyuanzhineng_ziranganzhinengli_jutibiaoxian;
		String duoyuanzhineng_ziranganzhinengli_jianyi;
	}

	MakeDetail mMakeDetail;
	
	private DataShujuZongbiao makeDataShujuZongbiao(Customer mCustomer, algorithm.algorithmOutput output)
	{
		DataShujuZongbiao mDataShujuZongbiao = new DataShujuZongbiao();
		mDataShujuZongbiao.xingming = mCustomer.getName();
		mDataShujuZongbiao.xingbie = mCustomer.getGender();
		mDataShujuZongbiao.xingzuo = mCustomer.getConstellation();
		String birthday = mCustomer.getBirthday();
		mDataShujuZongbiao.chushengnianyue_nian = birthday.split("-")[0];
		mDataShujuZongbiao.chushengnianyue_yue = birthday.split("-")[1];
		mDataShujuZongbiao.FinCode_L1 = output.L1temp;
		mDataShujuZongbiao.FinCode_L2 = output.L2temp;
		mDataShujuZongbiao.FinCode_L3 = output.L3temp;
		mDataShujuZongbiao.FinCode_L4 = output.L4temp;
		mDataShujuZongbiao.FinCode_L5 = output.L5temp;
		mDataShujuZongbiao.FinCode_R1 = output.R1temp;
		mDataShujuZongbiao.FinCode_R2 = output.R2temp;
		mDataShujuZongbiao.FinCode_R3 = output.R3temp;
		mDataShujuZongbiao.FinCode_R4 = output.R4temp;
		mDataShujuZongbiao.FinCode_R5 = output.R5temp;
		mDataShujuZongbiao.ATD_L = mCustomer.getLeftATD();
		mDataShujuZongbiao.ATD_R = mCustomer.getRightATD();
		mDataShujuZongbiao.lixingganxing_duiren = output.reason1 + "/" + output.Sensibility1;
		mDataShujuZongbiao.lixingganxing_duishi = output.reason2 + "/" + output.Sensibility2;
		mDataShujuZongbiao.lixingganxing_duizhiti = output.reason3 + "/" + output.Sensibility3;
		mDataShujuZongbiao.lixingganxing_shengyin = output.reason4 + "/" + output.Sensibility4;
		mDataShujuZongbiao.lixingganxing_shixiang = output.reason5 + "/" + output.Sensibility5;
		mDataShujuZongbiao.xuexifengge_shijue = String.valueOf(output.Visual);
		mDataShujuZongbiao.xuexifengge_tingjue = String.valueOf(output.AuditorySense);
		mDataShujuZongbiao.xuexifengge_tijue = String.valueOf(output.Somatosensory);
		mDataShujuZongbiao.xuexidongji_mubiao = String.valueOf(output.motivation);
		mDataShujuZongbiao.xuexidongji_gousi = String.valueOf(output.Idea);
		mDataShujuZongbiao.paixu_yuyannengli = String.valueOf(output.I4);
		mDataShujuZongbiao.paixu_kongjiannengli = String.valueOf(output.I7);
		mDataShujuZongbiao.paixu_shuxueluoji = String.valueOf(output.I5);
		mDataShujuZongbiao.paixu_yinyuenengli = String.valueOf(output.I6);
		mDataShujuZongbiao.paixu_yundongnengli = String.valueOf(output.I8);
		mDataShujuZongbiao.paixu_renjinengli = String.valueOf(output.I3);
		mDataShujuZongbiao.paixu_zizhinengli = String.valueOf(output.I1);
		mDataShujuZongbiao.paixu_ziranganzhi = String.valueOf(output.I2);
		return mDataShujuZongbiao;
	}
	
	private DataChengrenBaobiao makeDataChengrenBaobiao(Customer mCustomer, algorithm.algorithmOutput output)
	{
		DataChengrenBaobiao mDataChengrenBaobiao = new DataChengrenBaobiao();
		
		// 个人档案
		mDataChengrenBaobiao.bianhao = String.valueOf(mCustomer.getUserid());
		mDataChengrenBaobiao.xingming = mCustomer.getName();
		mDataChengrenBaobiao.xingbie = mCustomer.getGender();
		String birthday = mCustomer.getBirthday();
		mDataChengrenBaobiao.chushengnianyue = birthday.split("-")[0] + "年" + birthday.split("-")[1] + "月";
		mDataChengrenBaobiao.xingzuo = mCustomer.getConstellation();
		mDataChengrenBaobiao.lianxidianhua = mCustomer.getPhone();
		mDataChengrenBaobiao.dianziyouxiang = mCustomer.getMSN();
		mDataChengrenBaobiao.lianxidizhi = mCustomer.getAddress();
		// 先天学习潜能
		mDataChengrenBaobiao.xiantianxuexiqianneng_fenxi = mMakeDetail.Get_xiantianxuexiqianneng_fenxi();
		// 操作敏锐度 Atd
		mDataChengrenBaobiao.caozuominruidu_zuo = mCustomer.getLeftATD();
		mDataChengrenBaobiao.caozuominruidu_you = mCustomer.getRightATD();
		mDataChengrenBaobiao.caozuominruidu_fenxi = mMakeDetail.Get_caozuominruidu_fenxi("成人");
		// 思维习惯
		mDataChengrenBaobiao.siweixiguan_fenxi_duiren = mMakeDetail.Get_siweixiguan_fenxi_duiren("成人");
		mDataChengrenBaobiao.siweixiguan_fenxi_duishi = mMakeDetail.Get_siweixiguan_fenxi_duishi("成人");
		mDataChengrenBaobiao.siweixiguan_fenxi_duizhiti = mMakeDetail.Get_siweixiguan_fenxi_duizhiti("成人");
		mDataChengrenBaobiao.siweixiguan_fenxi_duishengyin = mMakeDetail.Get_siweixiguan_fenxi_duishengyin("成人");
		mDataChengrenBaobiao.siweixiguan_fenxi_duituxiang = mMakeDetail.Get_siweixiguan_fenxi_duituxiang("成人");
		// 先天行为动机
		mDataChengrenBaobiao.xiantianxingweidongji_mubiao = String.valueOf(output.motivation);
		mDataChengrenBaobiao.xiantianxingweidongji_gousi = String.valueOf(output.Idea);
		mDataChengrenBaobiao.xiantianxingweidongji_fenxi = mMakeDetail.Get_xiantianxingweidongji_fenxi("成人");
		// 先天学习风格
		mDataChengrenBaobiao.xiantianxuexifengge_shijue = String.valueOf(output.Visual);
		mDataChengrenBaobiao.xiantianxuexifengge_tingjue = String.valueOf(output.AuditorySense);
		mDataChengrenBaobiao.xiantianxuexifengge_tijue = String.valueOf(output.Somatosensory);
		String [] s = mMakeDetail.Get_xiantianxuexifengge("成人");
		mDataChengrenBaobiao.xiantianxuexifengge_leixing = s[0];
		mDataChengrenBaobiao.xiantianxuexifengge_fenxi = s[1];
		// 个性特质1
		String ret = mMakeDetail.Get_gexingtezhi1();
		System.out.println(ret);
		int index = 0;
		mDataChengrenBaobiao.gexingtezhi_1_1 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_2 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_3 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_4 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_5 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_6 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_7 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_8 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_9 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_10 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_11 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_12 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_13 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_14 = ret.split("\n")[index++];
		mDataChengrenBaobiao.gexingtezhi_1_15 = ret.split("\n")[index++];
		// 个性特质2
		mDataChengrenBaobiao.gexingtezhi_2_1 = "";
		mDataChengrenBaobiao.gexingtezhi_2_2 = "";
		mDataChengrenBaobiao.gexingtezhi_2_3 = "";
		mDataChengrenBaobiao.gexingtezhi_2_4 = "";
		mDataChengrenBaobiao.gexingtezhi_2_5 = "";
		mDataChengrenBaobiao.gexingtezhi_2_6 = "";
		mDataChengrenBaobiao.gexingtezhi_2_7 = "";
		mDataChengrenBaobiao.gexingtezhi_2_8 = "";
		mDataChengrenBaobiao.gexingtezhi_2_9 = "";
		mDataChengrenBaobiao.gexingtezhi_2_10 = "";
		
		//System.out.println(JSONObject.fromObject(mDataChengrenBaobiao).toString());
		 System.out.println(TypeUtil.typeToString("mDataChengrenBaobiao", mDataChengrenBaobiao));

		return mDataChengrenBaobiao;
	}
	
	private DataErTongBaobiao makeDataErTongBaobiao(Customer mCustomer, algorithm.algorithmOutput output)
	{
		DataErTongBaobiao mDataErTongBaobiao = new DataErTongBaobiao();
		
		// 个人信息
		mDataErTongBaobiao.bianhao = String.valueOf(mCustomer.getUserid());;
		mDataErTongBaobiao.xingming = mCustomer.getName();;
		mDataErTongBaobiao.xingbie = mCustomer.getGender();
		String birthday = mCustomer.getBirthday();
		mDataErTongBaobiao.chushengnianyue = birthday.split("-")[0] + "年" + birthday.split("-")[1] + "月";
		mDataErTongBaobiao.xingzuo = mCustomer.getConstellation();
		mDataErTongBaobiao.lianxidianhua = mCustomer.getPhone();
		mDataErTongBaobiao.dianziyouxiang = mCustomer.getMSN();
		mDataErTongBaobiao.lianxidizhi = mCustomer.getAddress();
		// 先天学习潜能
		mDataErTongBaobiao.xiantianxuexiqianneng_fenxi = mMakeDetail.Get_xiantianxuexiqianneng_fenxi();
		// 操作敏锐度
		mDataErTongBaobiao.caozuominruidu_zuo = mCustomer.getLeftATD();
		mDataErTongBaobiao.caozuominruidu_you = mCustomer.getRightATD();
		mDataErTongBaobiao.caozuominruidu_fenxi = mMakeDetail.Get_caozuominruidu_fenxi("儿童");
		// 思维习惯
		mDataErTongBaobiao.siweixiguan_fenxi_duiren = mMakeDetail.Get_siweixiguan_fenxi_duiren("儿童");
		mDataErTongBaobiao.siweixiguan_fenxi_duishi = mMakeDetail.Get_siweixiguan_fenxi_duishi("儿童");
		mDataErTongBaobiao.siweixiguan_fenxi_duizhiti = mMakeDetail.Get_siweixiguan_fenxi_duizhiti("儿童");
		mDataErTongBaobiao.siweixiguan_fenxi_duishengyin = mMakeDetail.Get_siweixiguan_fenxi_duishengyin("儿童");
		mDataErTongBaobiao.siweixiguan_fenxi_duituxiang = mMakeDetail.Get_siweixiguan_fenxi_duituxiang("儿童");
		// 先天行为动机
		mDataErTongBaobiao.xiantianxingweidongji_mubiao = String.valueOf(output.motivation);
		mDataErTongBaobiao.xiantianxingweidongji_gousi = String.valueOf(output.Idea);
		mDataErTongBaobiao.xiantianxingweidongji_fenxi = mMakeDetail.Get_xiantianxingweidongji_fenxi("儿童");
		// 先天学习风格
		mDataErTongBaobiao.xiantianxuexifengge_shijue = String.valueOf(output.Visual);
		mDataErTongBaobiao.xiantianxuexifengge_tingjue = String.valueOf(output.AuditorySense);
		mDataErTongBaobiao.xiantianxuexifengge_tijue = String.valueOf(output.Somatosensory);
		String [] s = mMakeDetail.Get_xiantianxuexifengge("儿童");
		mDataErTongBaobiao.xiantianxuexifengge_leixing = s[0];
		mDataErTongBaobiao.xiantianxuexifengge_fenxi = s[1];
		// 个性特质一
		String ret = mMakeDetail.Get_gexingtezhi1();
		System.out.println(ret);
		int index = 0;
		mDataErTongBaobiao.gexingtezhi_1_1 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_2 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_3 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_4 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_5 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_6 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_7 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_8 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_9 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_10 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_11 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_12 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_13 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_14 = ret.split("\n")[index++];
		mDataErTongBaobiao.gexingtezhi_1_15 = ret.split("\n")[index++];
		// 个性特质二
		mDataErTongBaobiao.gexingtezhi_2_1 = "";
		mDataErTongBaobiao.gexingtezhi_2_2 = "";
		mDataErTongBaobiao.gexingtezhi_2_3 = "";
		mDataErTongBaobiao.gexingtezhi_2_4 = "";
		mDataErTongBaobiao.gexingtezhi_2_5 = "";
		// 多元智能
		//// 言语能力
		mDataErTongBaobiao.duoyuanzhineng_yuyannengli_paixu = "";
		mDataErTongBaobiao.duoyuanzhineng_yuyannengli_dingyi = "";
		mDataErTongBaobiao.duoyuanzhineng_yuyannengli_jutibiaoxian = "";
		mDataErTongBaobiao.duoyuanzhineng_yuyannengli_jianyi = "";
		//// 空间能力
		mDataErTongBaobiao.duoyuanzhineng_kongjiannengli_paixu = "";
		mDataErTongBaobiao.duoyuanzhineng_kongjiannengli_dingyi = "";
		mDataErTongBaobiao.duoyuanzhineng_kongjiannengli_jutibiaoxian = "";
		mDataErTongBaobiao.duoyuanzhineng_kongjiannengli_jianyi = "";
		//// 数学逻辑能力
		mDataErTongBaobiao.duoyuanzhineng_shuxueluojinengli_paixu = "";
		mDataErTongBaobiao.duoyuanzhineng_shuxueluojinengli_dingyi = "";
		mDataErTongBaobiao.duoyuanzhineng_shuxueluojinengli_jutibiaoxian = "";
		mDataErTongBaobiao.duoyuanzhineng_shuxueluojinengli_jianyi = "";
		//// 音乐能力
		mDataErTongBaobiao.duoyuanzhineng_yinyuenengli_paixu = "";
		mDataErTongBaobiao.duoyuanzhineng_yinyuenengli_dingyi = "";
		mDataErTongBaobiao.duoyuanzhineng_yinyuenengli_jutibiaoxian = "";
		mDataErTongBaobiao.duoyuanzhineng_yinyuenengli_jianyi = "";
		//// 运动能力
		mDataErTongBaobiao.duoyuanzhineng_yundongnengli_paixu = "";
		mDataErTongBaobiao.duoyuanzhineng_yundongnengli_dingyi = "";
		mDataErTongBaobiao.duoyuanzhineng_yundongnengli_jutibiaoxian = "";
		mDataErTongBaobiao.duoyuanzhineng_yundongnengli_jianyi = "";
		//// 人际能力
		mDataErTongBaobiao.duoyuanzhineng_renjinengli_paixu = "";
		mDataErTongBaobiao.duoyuanzhineng_renjinengli_dingyi = "";
		mDataErTongBaobiao.duoyuanzhineng_renjinengli_jutibiaoxian = "";
		mDataErTongBaobiao.duoyuanzhineng_renjinengli_jianyi = "";
		//// 自治能力
		mDataErTongBaobiao.duoyuanzhineng_zizhinengli_paixu = "";
		mDataErTongBaobiao.duoyuanzhineng_zizhinengli_dingyi = "";
		mDataErTongBaobiao.duoyuanzhineng_zizhinengli_jutibiaoxian = "";
		mDataErTongBaobiao.duoyuanzhineng_zizhinengli_jianyi = "";
		//// 自然感治能力
		mDataErTongBaobiao.duoyuanzhineng_ziranganzhinengli_paixu = "";
		mDataErTongBaobiao.duoyuanzhineng_ziranganzhinengli_dingyi = "";
		mDataErTongBaobiao.duoyuanzhineng_ziranganzhinengli_jutibiaoxian = "";
		mDataErTongBaobiao.duoyuanzhineng_ziranganzhinengli_jianyi = "";

		return mDataErTongBaobiao;
	}
		
	private void genShujuZongbiao(Customer mCustomer, algorithm.algorithmOutput output, String path, DataShujuZongbiao mDataShujuZongbiao)
	{
		System.out.println("genShujuZongbiao start");
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("xx0", mDataShujuZongbiao.xingming);
		dataMap.put("xx1", mDataShujuZongbiao.xingbie);
		dataMap.put("xx2", mDataShujuZongbiao.xingzuo);
		dataMap.put("xx3", mDataShujuZongbiao.chushengnianyue_nian);
		dataMap.put("xx4", mDataShujuZongbiao.chushengnianyue_yue);
		
		dataMap.put("xx5", mDataShujuZongbiao.FinCode_L1);
		dataMap.put("xx6", mDataShujuZongbiao.FinCode_L2);
		dataMap.put("xx7", mDataShujuZongbiao.FinCode_L3);
		dataMap.put("xx8", mDataShujuZongbiao.FinCode_L4);
		dataMap.put("xx9", mDataShujuZongbiao.FinCode_L5);
		dataMap.put("xx10", mDataShujuZongbiao.FinCode_R1);
		dataMap.put("xx11", mDataShujuZongbiao.FinCode_R2);
		dataMap.put("xx12", mDataShujuZongbiao.FinCode_R3);
		dataMap.put("xx13", mDataShujuZongbiao.FinCode_R4);
		dataMap.put("xx14", mDataShujuZongbiao.FinCode_R5);
		dataMap.put("xx15", mDataShujuZongbiao.ATD_L);
		dataMap.put("xx16", mDataShujuZongbiao.ATD_R);
		dataMap.put("xx17", mDataShujuZongbiao.lixingganxing_duiren);
		dataMap.put("xx18", mDataShujuZongbiao.lixingganxing_duishi);
		dataMap.put("xx19", mDataShujuZongbiao.lixingganxing_duizhiti);
		dataMap.put("xx20", mDataShujuZongbiao.lixingganxing_shengyin);
		dataMap.put("xx21", mDataShujuZongbiao.lixingganxing_shixiang);
		dataMap.put("xx22", mDataShujuZongbiao.xuexifengge_shijue);
		dataMap.put("xx23", mDataShujuZongbiao.xuexifengge_tingjue);
		dataMap.put("xx24", mDataShujuZongbiao.xuexifengge_tijue);
		dataMap.put("xx25", mDataShujuZongbiao.xuexidongji_mubiao);
		dataMap.put("xx26", mDataShujuZongbiao.xuexidongji_gousi);
		dataMap.put("xx27", mDataShujuZongbiao.paixu_yuyannengli);
		dataMap.put("xx28", mDataShujuZongbiao.paixu_kongjiannengli);
		dataMap.put("xx29", mDataShujuZongbiao.paixu_shuxueluoji);
		dataMap.put("xx30", mDataShujuZongbiao.paixu_yinyuenengli);
		dataMap.put("xx31", mDataShujuZongbiao.paixu_yundongnengli);
		dataMap.put("xx32", mDataShujuZongbiao.paixu_renjinengli);
		dataMap.put("xx33", mDataShujuZongbiao.paixu_zizhinengli);
		dataMap.put("xx34", mDataShujuZongbiao.paixu_ziranganzhi);

		MDoc mdoc = new MDoc();
		try {
			System.out.println("gen file path:" + path + "/数据总表.doc");
			mdoc.createDoc(dataMap, path + "/数据总表.doc", "shujuzongbiao.xml");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("genShujuZongbiao end");
	}
	
	private void genChengrenBaobiao(Customer mCustomer, algorithm.algorithmOutput output, String path, DataChengrenBaobiao mDataChengrenBaobiao)
	{
		System.out.println("genChengrenBaobiao start");
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("xx0", mDataChengrenBaobiao.bianhao);
		dataMap.put("xx1", mDataChengrenBaobiao.xingming);
		dataMap.put("xx2", mDataChengrenBaobiao.xingbie);
		dataMap.put("xx3", mDataChengrenBaobiao.chushengnianyue);
		dataMap.put("xx4", mDataChengrenBaobiao.xingzuo);
		dataMap.put("xx5", mDataChengrenBaobiao.lianxidianhua);
		dataMap.put("xx6", mDataChengrenBaobiao.dianziyouxiang);
		dataMap.put("xx7", mDataChengrenBaobiao.lianxidizhi);
		// 先天学习潜能
		dataMap.put("xx8", mDataChengrenBaobiao.xiantianxuexiqianneng_fenxi);
		// 操作敏锐度 Atd
		dataMap.put("xx9", mDataChengrenBaobiao.caozuominruidu_zuo);
		dataMap.put("xx10", mDataChengrenBaobiao.caozuominruidu_you);
		dataMap.put("xx11", mDataChengrenBaobiao.caozuominruidu_fenxi);
		// 思维习惯
		dataMap.put("xx22", mDataChengrenBaobiao.siweixiguan_fenxi_duiren);
		dataMap.put("xx23", mDataChengrenBaobiao.siweixiguan_fenxi_duishi);
		dataMap.put("xx24", mDataChengrenBaobiao.siweixiguan_fenxi_duizhiti);
		dataMap.put("xx25", mDataChengrenBaobiao.siweixiguan_fenxi_duishengyin);
		dataMap.put("xx26", mDataChengrenBaobiao.siweixiguan_fenxi_duituxiang);
		// 先天行为动机
		dataMap.put("xx27", mDataChengrenBaobiao.xiantianxingweidongji_mubiao);
		dataMap.put("xx28", mDataChengrenBaobiao.xiantianxingweidongji_gousi);
		dataMap.put("xx29", mDataChengrenBaobiao.xiantianxingweidongji_fenxi);
		// 先天学习风格
		dataMap.put("xx30", mDataChengrenBaobiao.xiantianxuexifengge_shijue);
		dataMap.put("xx31", mDataChengrenBaobiao.xiantianxuexifengge_tingjue);
		dataMap.put("xx32", mDataChengrenBaobiao.xiantianxuexifengge_tijue);
		dataMap.put("xx33", mDataChengrenBaobiao.xiantianxuexifengge_leixing);
		dataMap.put("xx34", mDataChengrenBaobiao.xiantianxuexifengge_fenxi);
		//个性特质1
		dataMap.put("xx35", mDataChengrenBaobiao.gexingtezhi_1_1);
		dataMap.put("xx36", mDataChengrenBaobiao.gexingtezhi_1_2);
		dataMap.put("xx37", mDataChengrenBaobiao.gexingtezhi_1_3);
		dataMap.put("xx38", mDataChengrenBaobiao.gexingtezhi_1_4);
		dataMap.put("xx39", mDataChengrenBaobiao.gexingtezhi_1_5);
		dataMap.put("xx40", mDataChengrenBaobiao.gexingtezhi_1_6);
		dataMap.put("xx41", mDataChengrenBaobiao.gexingtezhi_1_7);
		dataMap.put("xx42", mDataChengrenBaobiao.gexingtezhi_1_8);
		dataMap.put("xx43", mDataChengrenBaobiao.gexingtezhi_1_9);
		dataMap.put("xx44", mDataChengrenBaobiao.gexingtezhi_1_10);
		dataMap.put("xx45", mDataChengrenBaobiao.gexingtezhi_1_11);
		dataMap.put("xx46", mDataChengrenBaobiao.gexingtezhi_1_12);
		dataMap.put("xx47", mDataChengrenBaobiao.gexingtezhi_1_13);
		dataMap.put("xx48", mDataChengrenBaobiao.gexingtezhi_1_14);
		dataMap.put("xx49", mDataChengrenBaobiao.gexingtezhi_1_15);
		//个性特质2
		dataMap.put("xx50", mDataChengrenBaobiao.gexingtezhi_2_1);
		dataMap.put("xx51", mDataChengrenBaobiao.gexingtezhi_2_2);
		dataMap.put("xx52", mDataChengrenBaobiao.gexingtezhi_2_3);
		dataMap.put("xx53", mDataChengrenBaobiao.gexingtezhi_2_4);
		dataMap.put("xx54", mDataChengrenBaobiao.gexingtezhi_2_5);
		dataMap.put("xx55", mDataChengrenBaobiao.gexingtezhi_2_6);
		dataMap.put("xx56", mDataChengrenBaobiao.gexingtezhi_2_7);
		dataMap.put("xx57", mDataChengrenBaobiao.gexingtezhi_2_8);
		dataMap.put("xx58", mDataChengrenBaobiao.gexingtezhi_2_9);
		dataMap.put("xx59", mDataChengrenBaobiao.gexingtezhi_2_10);
		
		MDoc mdoc = new MDoc();
		try {
			String name = path + "/成人报表.doc";
			System.out.println("gen file path:" + name);
			mdoc.createDoc(dataMap, name, "baobiao_chengrenban.xml");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("genChengrenBaobiao end");;
	}
	
	private void genErtongBaobiao(Customer mCustomer, algorithm.algorithmOutput output, String path, DataErTongBaobiao mDataErTongBaobiao)
	{
		System.out.println("genErtongBaobiao start");
		
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("xx0", mDataErTongBaobiao.bianhao);
		dataMap.put("xx1", mDataErTongBaobiao.xingming);
		dataMap.put("xx2", mDataErTongBaobiao.xingbie);
		dataMap.put("xx3", mDataErTongBaobiao.chushengnianyue);
		dataMap.put("xx4", mDataErTongBaobiao.xingzuo);
		dataMap.put("xx5", mDataErTongBaobiao.lianxidianhua);
		dataMap.put("xx6", mDataErTongBaobiao.dianziyouxiang);
		dataMap.put("xx7", mDataErTongBaobiao.lianxidizhi);
		
		dataMap.put("xx8", mDataErTongBaobiao.xiantianxuexiqianneng_fenxi);
		dataMap.put("xx9", mDataErTongBaobiao.caozuominruidu_zuo);
		dataMap.put("xx10", mDataErTongBaobiao.caozuominruidu_you);
		dataMap.put("xx11", mDataErTongBaobiao.caozuominruidu_fenxi);
		dataMap.put("xx22", mDataErTongBaobiao.siweixiguan_fenxi_duiren);
		dataMap.put("xx23", mDataErTongBaobiao.siweixiguan_fenxi_duishi);
		dataMap.put("xx24", mDataErTongBaobiao.siweixiguan_fenxi_duizhiti);
		dataMap.put("xx25", mDataErTongBaobiao.siweixiguan_fenxi_duishengyin);
		dataMap.put("xx26", mDataErTongBaobiao.siweixiguan_fenxi_duituxiang);
		dataMap.put("xx27", mDataErTongBaobiao.xiantianxingweidongji_mubiao);
		dataMap.put("xx28", mDataErTongBaobiao.xiantianxingweidongji_gousi);
		dataMap.put("xx29", mDataErTongBaobiao.xiantianxingweidongji_fenxi);
		dataMap.put("xx30", mDataErTongBaobiao.xiantianxuexifengge_shijue);
		dataMap.put("xx31", mDataErTongBaobiao.xiantianxuexifengge_tingjue);
		dataMap.put("xx32", mDataErTongBaobiao.xiantianxuexifengge_tijue);
		dataMap.put("xx33", mDataErTongBaobiao.xiantianxuexifengge_leixing);
		dataMap.put("xx34", mDataErTongBaobiao.xiantianxuexifengge_fenxi);
		dataMap.put("xx35", mDataErTongBaobiao.gexingtezhi_1_1);
		dataMap.put("xx36", mDataErTongBaobiao.gexingtezhi_1_2);
		dataMap.put("xx37", mDataErTongBaobiao.gexingtezhi_1_3);
		dataMap.put("xx38", mDataErTongBaobiao.gexingtezhi_1_4);
		dataMap.put("xx39", mDataErTongBaobiao.gexingtezhi_1_5);
		dataMap.put("xx40", mDataErTongBaobiao.gexingtezhi_1_6);
		dataMap.put("xx41", mDataErTongBaobiao.gexingtezhi_1_7);
		dataMap.put("xx42", mDataErTongBaobiao.gexingtezhi_1_8);
		dataMap.put("xx43", mDataErTongBaobiao.gexingtezhi_1_9);
		dataMap.put("xx44", mDataErTongBaobiao.gexingtezhi_1_10);
		dataMap.put("xx45", mDataErTongBaobiao.gexingtezhi_1_11);
		dataMap.put("xx46", mDataErTongBaobiao.gexingtezhi_1_12);
		dataMap.put("xx47", mDataErTongBaobiao.gexingtezhi_1_13);
		dataMap.put("xx48", mDataErTongBaobiao.gexingtezhi_1_14);
		dataMap.put("xx49", mDataErTongBaobiao.gexingtezhi_1_15);
		dataMap.put("xx50", mDataErTongBaobiao.gexingtezhi_2_1);
		dataMap.put("xx51", mDataErTongBaobiao.gexingtezhi_2_2);
		dataMap.put("xx52", mDataErTongBaobiao.gexingtezhi_2_3);
		dataMap.put("xx53", mDataErTongBaobiao.gexingtezhi_2_4);
		dataMap.put("xx54", mDataErTongBaobiao.gexingtezhi_2_5);
		dataMap.put("xx55", mDataErTongBaobiao.duoyuanzhineng_yuyannengli_paixu);
		dataMap.put("xx56", mDataErTongBaobiao.duoyuanzhineng_kongjiannengli_paixu);
		dataMap.put("xx57", mDataErTongBaobiao.duoyuanzhineng_shuxueluojinengli_paixu);
		dataMap.put("xx58", mDataErTongBaobiao.duoyuanzhineng_yinyuenengli_paixu);
		dataMap.put("xx59", mDataErTongBaobiao.duoyuanzhineng_yundongnengli_paixu);
		dataMap.put("xx60", mDataErTongBaobiao.duoyuanzhineng_renjinengli_paixu);
		dataMap.put("xx61", mDataErTongBaobiao.duoyuanzhineng_zizhinengli_paixu);
		dataMap.put("xx62", mDataErTongBaobiao.duoyuanzhineng_ziranganzhinengli_paixu);

		MDoc mdoc = new MDoc();
		try {
			String name = path + "/儿童报表.doc";
			System.out.println("gen file path:" + name);
			mdoc.createDoc(dataMap, name, "baobiao_ertongban.xml");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("genErtongBaobiao end");;
	}

	public void run(String userid, String path) {
		int userid_i = Integer.parseInt(userid);
		
		CustomerDaoImpl mCustomerDaoImpl = new CustomerDaoImpl();
		Customer mCustomer = mCustomerDaoImpl.getByuserid(userid_i);
			
		ComputeResult mComputeResult = new ComputeResult();
		algorithm.algorithmOutput output = mComputeResult.UseAlgorithm(userid);

		mMakeDetail = new MakeDetail(mCustomer, output);
		
		// Data
		DataShujuZongbiao mDataShujuZongbiao = makeDataShujuZongbiao(mCustomer, output);
		DataChengrenBaobiao mDataChengrenBaobiao = makeDataChengrenBaobiao(mCustomer, output);
		DataErTongBaobiao mDataErTongBaobiao = makeDataErTongBaobiao(mCustomer, output);

		// gen action
		genShujuZongbiao(mCustomer, output, path, mDataShujuZongbiao);
		genChengrenBaobiao(mCustomer, output, path, mDataChengrenBaobiao);
		genErtongBaobiao(mCustomer, output, path, mDataErTongBaobiao);
	}
}
