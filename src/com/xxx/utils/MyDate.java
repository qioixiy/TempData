package com.xxx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
	public static String getFormatDate(){
	    Date date = new Date();
	    long times = date.getTime();//Ê±¼ä´Á
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
	    String dateString = formatter.format(date);
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    return dateString;
	  }
}
