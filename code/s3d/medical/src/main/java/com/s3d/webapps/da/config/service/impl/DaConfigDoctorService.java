package com.s3d.webapps.da.config.service.impl;

import com.s3d.webapps.da.config.dao.impl.DaConfigDoctorDao;
import com.s3d.webapps.config.persistence.ConfigDoctor;
import com.s3d.webapps.da.config.service.IDaConfigDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
@Service
@Transactional
public class DaConfigDoctorService implements IDaConfigDoctorService {
    @Override
    public List<ConfigDoctor> getDoctors(String hospitalId) {
        return daConfigDocrotDao.getDoctors(hospitalId);
    }

    @Override
    public ConfigDoctor getDoctor(Integer id) {
        return daConfigDocrotDao.getDoctor(id);
    }

    public Integer addDoctor(ConfigDoctor doctor) {
        return daConfigDocrotDao.addDoctor(doctor);
    }

    public void updateDoctor(ConfigDoctor doctor) {
        daConfigDocrotDao.updateDoctor(doctor);
    }

    public void deleteDoctor(Integer id) {
        daConfigDocrotDao.deleteDoctor(id);
    }

    @Autowired
    private DaConfigDoctorDao daConfigDocrotDao;

    public void setDaConfigDocrotDao(DaConfigDoctorDao daConfigDocrotDao) {
        this.daConfigDocrotDao = daConfigDocrotDao;
    }
}
