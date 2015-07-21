package com.s3d.webapps.da.config.service.impl;

import com.s3d.webapps.da.config.dao.impl.DaConfigDoctorDaoImp;
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
public class DaConfigDoctorServiceImp implements IDaConfigDoctorService {
    @Override
    public List<ConfigDoctor> getDoctors(String hospitalId) {
        return daConfigDoctorDao.getDoctors(hospitalId);
    }

    @Override
    public ConfigDoctor getDoctor(Integer id) {
        return daConfigDoctorDao.getDoctor(id);
    }

    public Integer addDoctor(ConfigDoctor doctor) {
        return daConfigDoctorDao.addDoctor(doctor);
    }

    public void updateDoctor(ConfigDoctor doctor) {
        daConfigDoctorDao.updateDoctor(doctor);
    }

    public void deleteDoctor(Integer id) {
        daConfigDoctorDao.deleteDoctor(id);
    }

    @Override
    public List<ConfigDoctor> getDoctorsByMainPage(Integer mainPageId) {
        return daConfigDoctorDao.getDoctorsByMainPage(mainPageId);
    }

    @Autowired
    private DaConfigDoctorDaoImp daConfigDoctorDao;

    public void setDaConfigDocrotDao(DaConfigDoctorDaoImp daConfigDoctorDao) {
        this.daConfigDoctorDao = daConfigDoctorDao;
    }
}
