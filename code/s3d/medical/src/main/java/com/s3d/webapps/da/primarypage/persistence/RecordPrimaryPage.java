package com.s3d.webapps.da.primarypage.persistence;

import com.s3d.webapps.da.patient.persistence.PatientInfo;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 14:12:55
 */
public class RecordPrimaryPage {
	private String paymentType;
	private String healthCardNo;
	private int seqInHospital;
	private String drugAllergy;
	private boolean ifAutopsy;
	private String bloodType;
	private boolean isRH;

    private PatientInfo patientInfo;

    private ClinicDiagnosis clinicDiagnosis;
    private List<DischargeDiagnosis> dischargeDiagnosises;
    private ExternalReasonDiagnosis externalReasonDiagnosis;
    private PathologyDiagnosis pathologyDiagnosis;

    private AdmissionRegistration admissionRegistration;
    private DischargeRegistration dischargeRegistration;
    private ComaRegistration comaRegistration;

	private List<PersonInCharge> personsInCharge;
    private QualityControl qualityControl;
    private ExpenseInvoice expenseInvoice;
    private DepartChangeRegistration departChangeRegistration;


    private List<Operation> opertions;


}
