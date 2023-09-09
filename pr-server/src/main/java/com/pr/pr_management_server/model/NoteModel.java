package com.pr.pr_management_server.model;

public class NoteModel {
	private int noteId;
	private String patientName;
	private String noteType;
	private String careProvider;
	private String noteTime;
	private String note;
	private String noteStatus;
	private int recordID;
	
	
	public NoteModel() {
		
		
	}


	public NoteModel(int noteId, String patientName, String noteType, String careProvider, String noteTime, String note,
			String noteStatus, int recordID) {
		super();
		this.noteId = noteId;
		this.patientName = patientName;
		this.noteType = noteType;
		this.careProvider = careProvider;
		this.noteTime = noteTime;
		this.note = note;
		this.noteStatus = noteStatus;
		this.recordID = recordID;
	}


	public int getNoteId() {
		return noteId;
	}


	public void setNoteId(int noteId) {
		this.noteId = noteId;
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
