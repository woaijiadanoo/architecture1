package com.framework.architecture.common.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatHelper {

	private FormatHelper(){};
	
	private static final String DEFULT_DATE_STR = "yyyy-MM-dd hh:mm:ss";
	
	public static String long2Str(long time){
		
		Date d = new Date(time);
		
		DateFormat df = new SimpleDateFormat(DEFULT_DATE_STR);
		
		return df.format(d);
	}
	
}
