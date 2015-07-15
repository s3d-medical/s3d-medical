package com.s3d.webapps.da.config.service;

import com.s3d.webapps.config.persistence.ConfigDoctor;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
public interface IDaConfigDoctorService {

    List<ConfigDoctor> getDoctors(String hospitalId);

    ConfigDoctor getDoctor(Integer id);

    Integer addDoctor(ConfigDoctor doctor);

    void updateDoctor(ConfigDoctor doctor);

    void deleteDoctor(Integer id);

}
