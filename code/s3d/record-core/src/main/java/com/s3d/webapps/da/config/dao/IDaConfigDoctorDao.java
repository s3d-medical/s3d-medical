package com.s3d.webapps.da.config.dao;

import com.s3d.tech.data.dao.GenericDao;
import com.s3d.webapps.config.persistence.ConfigDoctor;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
public interface IDaConfigDoctorDao extends GenericDao<ConfigDoctor, Integer> {

    List<ConfigDoctor> getDoctors(String hospitalId);

    ConfigDoctor getDoctor(Integer id);

    Integer addDoctor(ConfigDoctor doctor);

    void updateDoctor(ConfigDoctor doctor);

    void deleteDoctor(Integer id);

    List<ConfigDoctor> getDoctorsByMainPage(String businessKey, Integer status);

}
