package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name = "mr_operation")
public class Operation {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    private String name;

    @Column(name="code")
    private String code;

    @Column(name="operate_date")
    private Date operatedDate;

    @Column(name ="level")
    private String level;
    private String healedInGrade;
    private String anesthesiaType;
    private String anesthesiaDoctor;
    private String majorOperator;
    private String assistant1;
    private String assistant2;

    public Operation() {

    }

    public void finalize() throws Throwable {

    }
}