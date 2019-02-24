package com.hospital.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateId {
	public static String getId(){
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat("HHmmssSSS");
		String fd=f.format(d);
		return "1"+fd;
	}
}
