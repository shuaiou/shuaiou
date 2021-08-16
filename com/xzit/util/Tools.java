package com.xzit.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/*
 * ��ȡ��·�� 
 * */
public final class Tools {
	public static String getPathName() {
		String ret = Tools.class.getClassLoader().getResource("").getPath().toString();
		try {
			ret = URLDecoder.decode(ret,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
