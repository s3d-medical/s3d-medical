package com.s3d.webapps.medicalrecord.persistence.patient;

import com.s3d.webapps.medicalrecord.persistence.AbstractGeneralProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 10:31:08
 */
@Entity
@Table(name = "p_patient_info")
public class PatientInfo  extends AbstractGeneralProperties {

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "sex")
    private Integer sex;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "ageYear")
    private Integer ageYear;

    @Column(name = "age_month")
    private Integer ageMonth;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "weight_of_birth")
    private Float weightOfBirth;

    @Column(name = "weight_of_admission")
    private Float weightOfAdmission;

    @Column(name = "race")
    private Integer race;

    @Column(name = "id_card_no")
    private String idCardNo;

    @Column(name = "career")
    private Integer career;

    @Column(name = "marital_status")
    private Integer maritalStatus;

    @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="contact_person_id", referencedColumnName = "id")
    private ContactPerson contactPerson;

    @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="native_place_id", referencedColumnName = "id")
    private NativePlace nativePlace;

    @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="present_address_id", referencedColumnName = "id")
    private PresentAddress presentAddress;

    @OneToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="registered_residence_id", referencedColumnName = "id")
    private RegisteredResidence registeredResidence;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAgeYear() {
        return ageYear;
    }

    public void setAgeYear(Integer ageYear) {
        this.ageYear = ageYear;
    }

    public Integer getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(Integer ageMonth) {
        this.ageMonth = ageMonth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public float getWeightOfBirth() {
        return weightOfBirth;
    }

    public void setWeightOfBirth(float weightOfBirth) {
        this.weightOfBirth = weightOfBirth;
    }

    public float getWeightOfAdmission() {
        return weightOfAdmission;
    }

    public void setWeightOfAdmission(float weightOfAdmission) {
        this.weightOfAdmission = weightOfAdmission;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Integer getCareer() {
        return career;
    }

    public void setCareer(Integer career) {
        this.career = career;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public NativePlace getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(NativePlace nativePlace) {
        this.nativePlace = nativePlace;
    }

    public PresentAddress getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(PresentAddress presentAddress) {
        this.presentAddress = presentAddress;
    }

    public RegisteredResidence getRegisteredResidence() {
        return registeredResidence;
    }

    public void setRegisteredResidence(RegisteredResidence registeredResidence) {
        this.registeredResidence = registeredResidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientInfo)) return false;
        if (!super.equals(o)) return false;

        PatientInfo that = (PatientInfo) o;

        if (ageMonth != null ? !ageMonth.equals(that.ageMonth) : that.ageMonth != null) return false;
        if (ageYear != null ? !ageYear.equals(that.ageYear) : that.ageYear != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (career != null ? !career.equals(that.career) : that.career != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (contactPerson != null ? !contactPerson.equals(that.contactPerson) : that.contactPerson != null)
            return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (idCardNo != null ? !idCardNo.equals(that.idCardNo) : that.idCardNo != null) return false;
        if (maritalStatus != null ? !maritalStatus.equals(that.maritalStatus) : that.maritalStatus != null)
            return false;
        if (nationality != null ? !nationality.equals(that.nationality) : that.nationality != null) return false;
        if (nativePlace != null ? !nativePlace.equals(that.nativePlace) : that.nativePlace != null) return false;
        if (presentAddress != null ? !presentAddress.equals(that.presentAddress) : that.presentAddress != null)
            return false;
        if (race != null ? !race.equals(that.race) : that.race != null) return false;
        if (registeredResidence != null ? !registeredResidence.equals(that.registeredResidence) : that.registeredResidence != null)
            return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (weightOfAdmission != null ? !weightOfAdmission.equals(that.weightOfAdmission) : that.weightOfAdmission != null)
            return false;
        if (weightOfBirth != null ? !weightOfBirth.equals(that.weightOfBirth) : that.weightOfBirth != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (ageYear != null ? ageYear.hashCode() : 0);
        result = 31 * result + (ageMonth != null ? ageMonth.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (weightOfBirth != null ? weightOfBirth.hashCode() : 0);
        result = 31 * result + (weightOfAdmission != null ? weightOfAdmission.hashCode() : 0);
        result = 31 * result + (race != null ? race.hashCode() : 0);
        result = 31 * result + (idCardNo != null ? idCardNo.hashCode() : 0);
        result = 31 * result + (career != null ? career.hashCode() : 0);
        result = 31 * result + (maritalStatus != null ? maritalStatus.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (contactPerson != null ? contactPerson.hashCode() : 0);
        result = 31 * result + (nativePlace != null ? nativePlace.hashCode() : 0);
        result = 31 * result + (presentAddress != null ? presentAddress.hashCode() : 0);
        result = 31 * result + (registeredResidence != null ? registeredResidence.hashCode() : 0);
        return result;
    }
}