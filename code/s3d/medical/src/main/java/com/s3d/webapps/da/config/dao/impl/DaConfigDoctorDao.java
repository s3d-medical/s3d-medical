package com.s3d.webapps.da.config.dao.impl;

import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.webapps.da.config.dao.IDaConfigDoctorDao;
import com.s3d.webapps.config.persistence.ConfigDoctor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
@Repository
public class DaConfigDoctorDao extends HibernateDao<ConfigDoctor, Integer> implements IDaConfigDoctorDao {
    @Override
    public List<ConfigDoctor> getDoctors(String hospitalId) {
        String hql = "from ConfigDoctor where hospitalId = :hospitalId";
        Map<String, String> params = new HashMap<String, String>();
        params.put("hospitalId", hospitalId);
        return get(hql, params);
    }

    @Override
    public ConfigDoctor getDoctor(Integer id) {
        return get(id);
    }

    public Integer addDoctor(ConfigDoctor doctor) {
        return add(doctor);
    }

    public void updateDoctor(ConfigDoctor doctor) {
        update(doctor);
    }

    public void deleteDoctor(Integer id) {
        delete(id);
    }

    @Override
    public List<ConfigDoctor> getDoctorsByMainPage(Integer mainPageId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM da_config_doctor dcd WHERE dcd.hospital_id = (");
        sql.append("SELECT dch.fd_id FROM da_customer_hospital dch WHERE dch.fd_id = (");
        sql.append("SELECT dch.fd_parent_id FROM da_customer_hospital dch WHERE dch.fd_id = (");
        sql.append("SELECT dch.fd_parent_id FROM da_customer_hospital dch WHERE dch.fd_id = (");
        sql.append("SELECT dcs.fd_label_id FROM da_customer_shouye dcs WHERE dcs.fd_file_no = :mainPageId");
        sql.append("))))");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("mainPageId", mainPageId);
        return sqlList(sql.toString(), params);
    }
}
