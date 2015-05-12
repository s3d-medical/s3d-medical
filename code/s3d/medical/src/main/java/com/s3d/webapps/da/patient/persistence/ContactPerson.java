package com.s3d.webapps.da.patient.persistence;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wind.chen
 * @version 1.0
 * @created 2015 10:24:46
 */
@Entity
@Table(name = "p_contact_person")
public class ContactPerson implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_no")
    private String phoneNo;

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}