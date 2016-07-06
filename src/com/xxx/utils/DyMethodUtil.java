package com.xxx.utils;

import java.util.HashMap;
import java.util.Map;  
import org.apache.commons.jexl2.Expression;  
import org.apache.commons.jexl2.JexlContext;  
import org.apache.commons.jexl2.JexlEngine;  
import org.apache.commons.jexl2.MapContext;

public class DyMethodUtil {  
      
    public static Object invokeMethod(String jexlExp,Map<String,Object> map){  
        JexlEngine jexl=new JexlEngine();  
        Expression e = jexl.createExpression(jexlExp);  
        JexlContext jc = new MapContext();  
        if (map != null) {
        	for(String key:map.keySet()){  
        		jc.set(key, map.get(key));  
        	}
        }
        return e.evaluate(jc);
    }
    
    public class TService {
		public TService() {
			
		}
		public String save(String in) {
			System.out.println(in);
			return in;
		}
	}
	public static void main(String[] args){
		Map<String, Object> map = new HashMap<String, Object>();
		DyMethodUtil mDyMethodUtil = new DyMethodUtil();
		TService testService = mDyMethodUtil.new TService();
		String person = "me";
		map.put("testService", testService);
		map.put("person", person);
		String expr = "testService.save(person)";
		DyMethodUtil.invokeMethod(expr, map);
	}
}