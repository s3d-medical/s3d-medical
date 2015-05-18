package com.s3d.webapps.medicalrecord.persistence.patient;

import com.s3d.tech.utils.DateUtils;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 10:31:08
 */
@Entity
@Table(name = "p_patient_info")
public class PatientInfo implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "age_year")
    private Integer ageYear;

    @Column(name = "age_month")
    private Integer ageMonth;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "weight_of_birth")
    private Integer weightOfBirth;

    @Column(name = "weight_of_admission")
    private Integer weightOfAdmission;

    @Column(name = "race")
    private String race;

    @Column(name = "id_card_no")
    private String idCardNo;

    @Column(name = "career")
    private String career;

    @Column(name = "marital_status")
    private String maritalStatus;

    @OneToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="birth_place_id", referencedColumnName = "birth_place_id")
    private BirthPlace birthPlace;

    @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="native_place_id", referencedColumnName = "native_place_id")
    private NativePlace nativePlace;

    @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="present_address_id", referencedColumnName = "present_address_id")
    private PresentAddress presentAddress;

    @OneToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="registered_residence_id", referencedColumnName = "registered_residence_id")
    private RegisteredResidence registeredResidence;

    @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="contact_person_id", referencedColumnName = "id")
    private ContactPerson contactPerson;

    public PatientInfo() {
        this.birthPlace = new BirthPlace();
        this.nativePlace = new NativePlace();
        this.presentAddress = new PresentAddress();
        this.registeredResidence = new RegisteredResidence();
        this.company = new Company();
        this.contactPerson = new ContactPerson();
    }

    public void fillPatientBasicInfo(String fullName, String sex, Date birthDate, Integer ageYear, Integer ageMonth,
                                     String nationality, Integer weightOfBirth, Integer weightOfAdmission, String race, String idCardNo, String career, String maritalStatus) {
        this.fullName = fullName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.ageYear = ageYear;
        this.ageMonth = ageMonth;
        this.nationality = nationality;
        this.weightOfBirth = weightOfBirth;
        this.weightOfAdmission = weightOfAdmission;
        this.race = race;
        this.idCardNo = idCardNo;
        this.career = career;
        this.maritalStatus = maritalStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void fillBirthPlace(String province, String city, String county){
        this.birthPlace.fill(province, city, county);
    }

    public void fillNativeAddress(String province, String city){
        this.nativePlace.fill(province, city);
    }

    public void fillPresentAddress(String province, String city, String county, String phoneNo, String zipCode){
        this.presentAddress.fill(province, city, county, phoneNo, zipCode);
    }

    public void fillRegisteredResidence(String province, String city, String county, String zipCode){
        this.registeredResidence.fill(province, city, county, zipCode);
    }

    public void fillCompany(String name, String address, String phoneNo, String zipCode){
        this.company.fill(name, address, phoneNo, zipCode);
    }

    public void fillContactPerson(String fullName, String relationship, String address, String phoneNo){
        this.contactPerson.fill(fullName,relationship,  address, phoneNo);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public Integer getWeightOfBirth() {
        return weightOfBirth;
    }

    public void setWeightOfBirth(Integer weightOfBirth) {
        this.weightOfBirth = weightOfBirth;
    }

    public Integer getWeightOfAdmission() {
        return weightOfAdmission;
    }

    public void setWeightOfAdmission(Integer weightOfAdmission) {
        this.weightOfAdmission = weightOfAdmission;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
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

    public BirthPlace getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(BirthPlace birthPlace) {
        this.birthPlace = birthPlace;
    }
}