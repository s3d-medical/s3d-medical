package com.s3d.webapps.da.config.dao;

import com.s3d.tech.data.dao.GenericDao;
import com.s3d.webapps.da.config.persistence.DaConfigDoctor;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
public interface IDaConfigDoctorDao extends GenericDao<DaConfigDoctor, Integer> {

    Integer addDoctor(DaConfigDoctor doctor);

    void updateDoctor(DaConfigDoctor doctor);

    void deleteDoctor(DaConfigDoctor doctor);

}
