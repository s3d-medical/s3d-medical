package com.s3d.webapps.da.config.dao.impl;

import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.webapps.da.config.dao.IDaConfigDoctorDao;
import com.s3d.webapps.da.config.persistence.DaConfigDoctor;
import org.springframework.stereotype.Repository;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
@Repository
public class DaConfigDoctorDao extends HibernateDao<DaConfigDoctor, Integer> implements IDaConfigDoctorDao {
    public Integer addDoctor(DaConfigDoctor doctor) {
        return add(doctor);
    }

    public void updateDoctor(DaConfigDoctor doctor) {
        update(doctor);
    }

    public void deleteDoctor(DaConfigDoctor doctor) {
        delete(doctor);
    }
}
