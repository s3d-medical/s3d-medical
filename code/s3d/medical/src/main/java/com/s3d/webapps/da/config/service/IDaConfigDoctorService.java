package com.s3d.webapps.da.config.service;

import com.s3d.webapps.da.config.persistence.DaConfigDoctor;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
public interface IDaConfigDoctorService {

    Integer addDoctor(DaConfigDoctor doctor);

    void updateDoctor(DaConfigDoctor doctor);

    void deleteDoctor(DaConfigDoctor doctor);

}
