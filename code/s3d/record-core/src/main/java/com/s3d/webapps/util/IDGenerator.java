package com.s3d.webapps.util;

import java.util.Date;
import java.util.UUID;

public class IDGenerator {
	/**
	 * 生成主键（32位）
	 * 
	 * @return
	 */
	public static String generateID() {
		String rtnVal = Long.toHexString(System.currentTimeMillis());
		rtnVal += UUID.randomUUID();
		rtnVal = rtnVal.replaceAll("-", "");
		return rtnVal.substring(0, 32);
	}

	/**
	 * 根据指定时间生成主键，该方法只能用来对比主键生成时间，切忌不能用来生成主键插入数据库
	 * 
	 * 
	 * @param date
	 *            时间
	 * @return
	 */
	public static String generateID(Date date) {
		String rtnVal = Long.toHexString(date.getTime());
		rtnVal += UUID.randomUUID();
		rtnVal = rtnVal.replaceAll("-", "");
		return rtnVal.substring(0, 32);
	}

	/**
	 * 查看主键生成时间
	 * 
	 * @param id
	 */
	private static void printIDTime(String id) {
		String timeInfo = id.substring(0, 11);
		System.out.println(new Date(Long.parseLong(timeInfo, 16)));
	}

	/**
	 * 根据ID获取该ID创建的时间
	 * 
	 * @author 
	 * @param id
	 * @return
	 */
	public static Date getIDCreateTime(String id) {
		String timeInfo = id.substring(0, 11);
		return new Date(Long.parseLong(timeInfo, 16));
	}

	public static void main(String[] args) {
		// System.out.println(generateID());
		printIDTime("11fca36d08f032abb30c15642aa89af2");
		printIDTime("11fca36cfa57a4d6a3eea204146b9db7");
		System.out.println(getIDCreateTime("11fca36cfa57a4d6a3eea204146b9db7"));
	}
}
