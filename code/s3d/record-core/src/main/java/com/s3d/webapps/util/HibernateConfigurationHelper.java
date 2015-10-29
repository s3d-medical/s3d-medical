package com.s3d.webapps.util;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.property.Getter;
import org.hibernate.type.Type;

public class HibernateConfigurationHelper {
	private static Configuration hibernateConf = new Configuration();

	/**
	 * 获得Hibernate持久化类
	 * 
	 */
	private static PersistentClass getPersistentClass(Class clazz) {
		synchronized (HibernateConfigurationHelper.class) {
			PersistentClass pc = hibernateConf.getClassMapping(clazz.getName());
			if (pc == null) {
				hibernateConf = hibernateConf.addClass(clazz);
				pc = hibernateConf.getClassMapping(clazz.getName());
			}
			return pc;
		}
	}

	/**
	 * 获得表名
	 */
	public static String getTableName(Class clazz) {
		return getPersistentClass(clazz).getTable().getName();
	}

	/**
	 * 获得列名
	 * 
	 * @param clazz
	 *            映射到数据库的po类
	 * @param icol
	 *            第几列
	 * @return String
	 */
	public static String getColumnName(Class clazz, int icol) {
		// return getPersistentClass( clazz
		// ).getTable().getPrimaryKey().getColumn( 0 ).getName(); //獲取主鍵名
		return getPersistentClass(clazz).getTable().getColumn(icol).getName();
	}

	/**
	 * 获得所有列名
	 * 
	 * @author 
	 * @param clazz
	 *            映射到数据库的po类
	 * @return List<String> 列名
	 */
	public static List<String> getColumnNames(Class clazz) {
		Iterator<Column> itr = getPersistentClass(clazz).getTable()
				.getColumnIterator();
		List<String> columns = new ArrayList<String>();
		while (itr.hasNext()) {
			Column tmp = itr.next();
			columns.add(tmp.getName());
		}
		return columns;
	}

	public static String getColumnName(Class clazz, String propertyName) {
		String name = "";
		for (Iterator it = getPersistentClass(clazz).getProperty(propertyName)
				.getColumnIterator(); it.hasNext();) {
			name = ((Column) it.next()).getName();
			break;
			// 取第一个就够了
		}
		return name;
	}
	
	public static Property getProperty(Class clazz, String propertyName) {
		return getPersistentClass(clazz).getProperty(propertyName);
	}
	
	public static String getAssociationTypeOProperty(Class clazz, String propertyName) {
		Property property = HibernateConfigurationHelper.getProperty(clazz, propertyName);
		if(property.getType().isAssociationType()){
			Getter getter = property.getGetter(clazz);
			return getter.getReturnType().getClass().getName();
		}
		return null;
	}
	
	public static String getTypeInListProperty(Class clazz, String propertyName) {
		Property property = HibernateConfigurationHelper.getProperty(clazz, propertyName);
		if(property.getType().isCollectionType()){
			Getter getter = property.getGetter(clazz);
			java.lang.reflect.Type type=getter.getMethod().getGenericReturnType();
			if(type instanceof ParameterizedType){
				java.lang.reflect.Type typeInList = ((ParameterizedType)type).getActualTypeArguments()[0];
				if (typeInList instanceof Class) {
					return ((Class) typeInList).getName();
				}
			}
		}
		return null;
	}	
	
	public static String getPkColumnName(Class clazz) {
		return getPersistentClass(clazz).getTable().getPrimaryKey()
				.getColumn(0).getName();
	}
}