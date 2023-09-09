package com.pr.PatinetRecordServerHibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NoteModel")
public class NoteModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int noteID;
	@Column
	private String patientName;
	@Column
	private String noteType;
	@Column
	private String careProvider;
	@Column
	private String noteTime;
	@Column
	private String note;
	@Column
	private String noteStatus;
	@Column
	private int recordID;


	public NoteModel() {


	}


	public NoteModel(int noteID, String patientName, String noteType, String careProvider, String noteTime, String note,
			String noteStatus, int recordID) {
		super();
		this.noteID = noteID;
		this.patientName = patientName;
		this.noteType = noteType;
		this.careProvider = careProvider;
		this.noteTime = noteTime;
		this.note = note;
		this.noteStatus = noteStatus;
		this.recordID = recordID;
	}


	public int getNoteId() {
		return noteID;
	}


	public void setNoteId(int noteID) {
		this.noteID = noteID;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getNoteType() {
		return noteType;
	}


	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}


	public String getCareProvider() {
		return careProvider;
	}


	public void setCareProvider(String careProvider) {
		this.careProvider = careProvider;
	}


	public String getNoteTime() {
		return noteTime;
	}


	public void setNoteTime(String noteTime) {
		this.noteTime = noteTime;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getNoteStatus() {
		return noteStatus;
	}


	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}


	public int getRecordID() {
		return recordID;
	}


	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}




}


