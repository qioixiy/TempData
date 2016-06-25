package com.havenliu.document;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenTableAllData {
	
	public void run() throws UnsupportedEncodingException  {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		dataMap.put("xx1", "徐薪洲");
		dataMap.put("xx2", "男");
		dataMap.put("xx3", "1999");
		dataMap.put("xx4", "4");
		dataMap.put("xx5", "xx5");
		dataMap.put("xx6", "xx6");
		dataMap.put("xx7", "xx7");
		dataMap.put("xx8", "xx8");
		dataMap.put("xx9", "xx9");
		dataMap.put("xx10", "xx10");
		dataMap.put("xx11", "xx");
		dataMap.put("xx12", "xx");
		dataMap.put("xx13", "xx");
		dataMap.put("xx14", "xx");
		dataMap.put("xx15", "xx");
		dataMap.put("xx16", "xx");
		dataMap.put("xx17", "xx");
		dataMap.put("xx18", "xx");
		dataMap.put("xx19", "xx");
		dataMap.put("xx20", "xx");
		dataMap.put("xx21", "xx");
		dataMap.put("xx22", "xx");
		dataMap.put("xx23", "xx");
		dataMap.put("xx24", "xx");
		dataMap.put("xx25", "xx");
		dataMap.put("xx26", "xx");
		dataMap.put("xx27", "xx");
		dataMap.put("xx28", "xx");
		dataMap.put("xx29", "xx");
		dataMap.put("xx30", "xx");
		dataMap.put("xx31", "xx");
		dataMap.put("xx32", "xx");
		dataMap.put("xx33", "xx");
		dataMap.put("xx34", "xx");

		MDoc mdoc = new MDoc();
		mdoc.createDoc(dataMap, "C:/Users/Mu/Desktop/shujuzongbiao.doc", "shujuzongbiao.xml");
	}
}
