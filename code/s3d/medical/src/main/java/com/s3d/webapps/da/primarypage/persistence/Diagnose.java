package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 * parent holds public properties, other properties in subclass.
 */
@Entity
@Table(name = "mr_diagnosis")
@Inheritance(strategy = InheritanceType.JOINED)
public class Diagnose {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    public Diagnose(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Diagnose() {
    }
}