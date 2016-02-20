package com.framework.architecture.common.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {

	private JsonHelper(){};
	
	public static String obj2Str(Object obj){
		String result = "";
		ObjectMapper om = null;
		
		try{
			om = new ObjectMapper();
			result = om.writeValueAsString(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object str2Obj(String jsonStr,Class c){
		Object resObj = null;
		ObjectMapper om = null;
		
		try{
			om = new ObjectMapper();
			resObj = om.readValue(jsonStr, c);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resObj;
	}
	
}
