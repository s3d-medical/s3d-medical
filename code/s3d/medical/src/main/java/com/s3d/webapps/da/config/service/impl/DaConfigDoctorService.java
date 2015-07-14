package com.s3d.webapps.da.config.service.impl;

import com.s3d.webapps.da.config.dao.impl.DaConfigDoctorDao;
import com.s3d.webapps.da.config.persistence.DaConfigDoctor;
import com.s3d.webapps.da.config.service.IDaConfigDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
@Service
@Transactional
public class DaConfigDoctorService implements IDaConfigDoctorService {
    public Integer addDoctor(DaConfigDoctor doctor) {
        return daConfigDocrotDao.add(doctor);
    }

    public void updateDoctor(DaConfigDoctor doctor) {
        daConfigDocrotDao.updateDoctor(doctor);
    }

    public void deleteDoctor(DaConfigDoctor doctor) {
        daConfigDocrotDao.deleteDoctor(doctor);
    }

    @Autowired
    private DaConfigDoctorDao daConfigDocrotDao;

    public void setDaConfigDocrotDao(DaConfigDoctorDao daConfigDocrotDao) {
        this.daConfigDocrotDao = daConfigDocrotDao;
    }
}
