package com.s3d.webapps.medicalrecord.dao.hibernate;

import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.webapps.medicalrecord.dao.MedicalRecordHomePageDao;
import com.s3d.webapps.medicalrecord.persistence.MedicalRecordHomePage;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.MappedSuperclass;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wind.chen
 * @dte 2015/5/15.
 */
@Repository
public class MedicalRecordHomePageDaoImpl extends HibernateDao<MedicalRecordHomePage,Integer> implements MedicalRecordHomePageDao{

    @Override
    public MedicalRecordHomePage getByBusinessKey(String businessKey) {
        if(!StringUtils.hasText(businessKey)){
            return null;
        }
        StringBuilder hql = new StringBuilder();
        Map paramMap = new HashMap();
        paramMap.put("businessKey", businessKey);
        hql.append("from MedicalRecordHomePage t where t.homePageBasicInfo.businessKey = :businessKey");
        Query query = this.getSession().createQuery(hql.toString());
        query.setString("businessKey" , businessKey);
        List<MedicalRecordHomePage> list = query.list();
        if(list == null || list.size() ==0){
            return null;
        }
        return list.get(0);
    }
}
