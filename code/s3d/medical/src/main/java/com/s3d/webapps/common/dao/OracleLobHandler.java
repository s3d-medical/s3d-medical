package com.s3d.webapps.common.dao;

import java.util.ResourceBundle;

public class OracleLobHandler extends
		org.springframework.jdbc.support.lob.OracleLobHandler {
	private String hibernateDialect;
	
	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public boolean isOracle() {
		return hibernateDialect != null && hibernateDialect.equals("org.hibernate.dialect.Oracle9Dialect");
	}
}
