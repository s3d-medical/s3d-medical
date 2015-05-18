package com.s3d.webapps.medicalrecord.persistence.patient;

import com.s3d.webapps.medicalrecord.persistence.AbstractGeneralProperties;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 * @created  -2015 10:17:02
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="address_type")
@DiscriminatorValue(value = "base")
@MappedSuperclass
public abstract class BaseAddress {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name="province")
	private String province;

    @Column(name="city")
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseAddress)) return false;

        BaseAddress that = (BaseAddress) o;

        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}