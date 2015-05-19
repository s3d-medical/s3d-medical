package com.s3d.tech.data.dao.hibernate;

import com.s3d.tech.utils.SQLQueryUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Map;

public class CommonDao<T, ID extends Serializable>  extends HibernateDao<T, ID> {

    protected  void runSQL(Session s , String sql){
		SQLQuery query = s.createSQLQuery(sql);
		query.executeUpdate();
	}

    protected void runSQL(String sql){
        Session s = this.getSession();
        this.runSQL(s, sql);
    }

    protected void runSQL(String sql, Map<String, Object> paramModel){
        Session s = this.getSession();
        SQLQuery sqlQuery = s.createSQLQuery(sql);
        SQLQueryUtils.fillParameters(sqlQuery, paramModel);
        sqlQuery.executeUpdate();
    }

}
