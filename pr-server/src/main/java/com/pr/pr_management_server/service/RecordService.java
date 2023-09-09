package com.pr.pr_management_server.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pr.pr_management_server.model.NoteModel;
import com.pr.pr_management_server.model.RecordModel;

public class RecordService {
	
	Connection con;
	
	public RecordService() {
		
		try {
			String url =String.format("jdbc:sqlserver://localhost:1433;DatabaseName=MyDatabase");
			String uname ="sa";
			String pwd = "tharindu";
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}
	
	public RecordModel addRecord(RecordModel record) {
		String insert = "insert into Medical_Record(patientName,patientAge,patientWeight,patientHrate,patientBgroup,patientSymptoms) values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setString(1, record.getPatientName());
			ps.setString(2,record.getPatientAge());
			ps.setString(3,record.getPatientWeight());
			ps.setString(4,record.getPatientHrate());
			ps.setString(5,record.getPatientBgroup());
			ps.setString(6,record.getPatientSymptoms());
			
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return record;
		
	}
	
	public ArrayList<RecordModel> getRecord() throws SQLException{
		
		ArrayList<RecordModel> data = new ArrayList<RecordModel>();
		
		String select = "select * from Medical_Record";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			RecordModel model = new RecordModel();
			model.setRecordId(rs.getInt("recordId"));
			model.setPatientName(rs.getString("patientName")); // column name
			model.setPatientAge(rs.getString("patientAge"));
			model.setPatientWeight(rs.getString("patientWeight"));
			model.setPatientHrate(rs.getString("patientHrate"));
			model.setPatientBgroup(rs.getString("patientBgroup"));
			model.setPatientSymptoms(rs.getString("patientSymptoms"));
			data.add(model);
			
		}
		
		return data;
		
	}
	
        public ArrayList<RecordModel> getRecordById(int id) throws SQLException{
		
		ArrayList<RecordModel> data = new ArrayList<RecordModel>();
		String select = "select * from Medical_Record where recordId =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			RecordModel model = new RecordModel();
			model.setRecordId(rs.getInt("recordId"));
			model.setPatientName(rs.getString("patientName")); // column name
			model.setPatientAge(rs.getString("patientAge"));
			model.setPatientWeight(rs.getString("patientWeight"));
			model.setPatientHrate(rs.getString("patientHrate"));
			model.setPatientBgroup(rs.getString("patientBgroup"));
			model.setPatientSymptoms(rs.getString("patientSymptoms"));
			data.add(model);		
		}		
		return data;	
	}
        
    	
    	public RecordModel updatetRecord(RecordModel record) {
    		String insert = "update Medical_Record set patientName=?,patientAge=?,patientWeight=?,patientHrate=?,patientBgroup=?,patientSymptoms=? where recordId =?";
    		
    		try {
    			PreparedStatement ps = con.prepareStatement(insert);
    			ps.setString(1, record.getPatientName());
    			ps.setString(2,record.getPatientAge());
    			ps.setString(3,record.getPatientWeight());
    			ps.setString(4,record.getPatientHrate());
    			ps.setString(5,record.getPatientBgroup());
    			ps.setString(6,record.getPatientSymptoms());
    			ps.setInt(7,record.getRecordId());
    			
    			ps.executeUpdate();
    		}catch(Exception e) {
    			System.out.println(e +"data insert unsuccess.");
    		}
    		
    		return record;
    		
    	}
    	

    	public int deletetRecord(int id) {
    		
    		String insert = "delete from Medical_Record where recordId =?";
    		
    		try {
    			PreparedStatement ps = con.prepareStatement(insert);
    			ps.setInt(1,id);
    			
    			ps.executeUpdate();
    		}catch(Exception e) {
    			System.out.println(e +"data insert unsuccess.");
    		}
    		
    		return id;
    		
    	}
    	
    	
    	
    	
    	//note services
    	public NoteModel addNote(NoteModel note) {
    		String insert = "insert into Medical_Note(patientName,noteType,careProvider,noteTime,note,noteStatus,recordID) values(?,?,?,?,?,?,?) ";
    		
    		try {
    			PreparedStatement ps = con.prepareStatement(insert);
    			
    			ps.setString(1, note.getPatientName());
    			ps.setString(2,note.getNoteType());
    			ps.setString(3,note.getCareProvider());
    			ps.setString(4,note.getNoteTime());
    			ps.setString(5,note.getNote());
    			ps.setString(6,note.getNoteStatus());
    			ps.setInt(7,note.getRecordID());
    			
    			
    			ps.execute();
    		}catch(Exception e) {
    			System.out.println(e +"data insert unsuccess.");
    		}
    		
    		return note;
    		
    	}
    	
    	public ArrayList<NoteModel> getNote() throws SQLException{
    		
    		ArrayList<NoteModel> data = new ArrayList<NoteModel>();
    		
    		String select = "select * from Medical_Note";
    		PreparedStatement ps = con.prepareStatement(select);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			NoteModel model = new NoteModel();
    			model.setNoteId(rs.getInt("noteID"));
    			model.setPatientName(rs.getString("patientName")); // column name
    			model.setNoteType(rs.getString("noteType"));
    			model.setCareProvider(rs.getString("careProvider"));
    			model.setNoteTime(rs.getString("noteTime"));
    			model.setNote(rs.getString("note"));
    			model.setNoteStatus(rs.getString("noteStatus"));
    			model.setRecordID(rs.getInt("recordID"));
    			data.add(model);
    			
    		}
    		
    		return data;
    		
    	}
    	
    	public ArrayList<NoteModel> getNoteById(int id) throws SQLException{
    		
    		ArrayList<NoteModel> data = new ArrayList<NoteModel>();
    		String select = "select * from Medical_Note where recordID =?";
    		PreparedStatement ps = con.prepareStatement(select);
    		ps.setInt(1,id);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			NoteModel model = new NoteModel();
    			model.setNoteId(rs.getInt("noteID"));
    			model.setPatientName(rs.getString("patientName")); // column name
    			model.setNoteType(rs.getString("noteType"));
    			model.setCareProvider(rs.getString("careProvider"));
    			model.setNoteTime(rs.getString("noteTime"));
    			model.setNote(rs.getString("note"));
    			model.setNoteStatus(rs.getString("noteStatus"));;
    			model.setRecordID(rs.getInt("recordID"));
    			data.add(model);		
    		}		
    		return data;	
    	}
    	
    	
    	public NoteModel updateNote(NoteModel record) {
    		String insert = "update Medical_Note set patientName=?,noteType=?,careProvider=?,noteTime=?,note=?,noteStatus=?,recordID=? where noteID =?";
    		
    		try {
    			PreparedStatement ps = con.prepareStatement(insert);
    			ps.setString(1, record.getPatientName());
    			ps.setString(2,record.getNoteType());
    			ps.setString(3,record.getCareProvider());
    			ps.setString(4,record.getNoteTime());
    			ps.setString(5,record.getNote());
    			ps.setString(6,record.getNoteStatus());
    			ps.setInt(7,record.getRecordID());
    			ps.setInt(8,record.getNoteId());
    			
    			ps.executeUpdate();
    		}catch(Exception e) {
    			System.out.println(e +"data insert unsuccess.");
    		}
    		
    		return record;
    		
    	}
    	
    public int deletetNote(int id) {
    		
    		String insert = "delete from Medical_Note where noteID =?";
    		
    		try {
    			PreparedStatement ps = con.prepareStatement(insert);
    			ps.setInt(1,id);
    			
    			ps.executeUpdate();
    		}catch(Exception e) {
    			System.out.println(e +"data insert unsuccess.");
    		}
    		
    		return id;
    		
    	}
    	
    	
    	
    	
    	
    	

	}
	