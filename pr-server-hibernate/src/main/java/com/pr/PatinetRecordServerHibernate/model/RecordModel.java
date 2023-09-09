package com.pr.PatinetRecordServerHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RecordModel")

public class RecordModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int recordId;
	@Column
	private String patientName;
	@Column
	private String patientAge;
	@Column
	private String patientWeight;
	@Column
	private String patientHrate;
	@Column
	private String patientBgroup;
	@Column
	private String patientSymptoms;



	public RecordModel() {

	}



	public RecordModel(int recordId, String patientName, String patientAge, String patientWeight, String patientHrate,String patientBgroup, String patientSymptoms) {
		super();
		this.recordId = recordId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientWeight = patientWeight;
		this.patientHrate = patientHrate;
		this.patientBgroup = patientBgroup;
		this.patientSymptoms = patientSymptoms;
	}



	public int getRecordId() {
		return recordId;
	}



	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public String getPatientAge() {
		return patientAge;
	}



	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}



	public String getPatientWeight() {
		return patientWeight;
	}



	public void setPatientWeight(String patientWeight) {
		this.patientWeight = patientWeight;
	}



	public String getPatientHrate() {
		return patientHrate;
	}



	public void setPatientHrate(String patientHrate) {
		this.patientHrate = patientHrate;
	}



	public String getPatientBgroup() {
		return patientBgroup;
	}



	public void setPatientBgroup(String patientBgroup) {
		this.patientBgroup = patientBgroup;
	}



	public String getPatientSymptoms() {
		return patientSymptoms;
	}



	public void setPatientSymptoms(String patientSymptoms) {
		this.patientSymptoms = patientSymptoms;
	}







}