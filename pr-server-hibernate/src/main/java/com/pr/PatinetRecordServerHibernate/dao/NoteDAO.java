package com.pr.PatinetRecordServerHibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pr.PatinetRecordServerHibernate.model.NoteModel;

public class NoteDAO {

	public void addNote( NoteModel bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();
		addNote(session,bean);    
		tx.commit();
		session.close();

	}
	//add medical note
	private void addNote(Session session, NoteModel bean){
		NoteModel note = new NoteModel();

		note.setPatientName(bean.getPatientName());
		note.setNoteType(bean.getNoteType());
		note.setCareProvider(bean.getCareProvider());
		note.setNoteTime(bean.getNoteTime());
		note.setNoteStatus(bean.getNoteStatus());
		note.setRecordID(bean.getRecordID());
		note.setNote(bean.getNote());

		session.save(note);
	}

	//get all medical notes
	public List<NoteModel> getNote(){
		Session session = SessionUtil.getSession();  
		Query query = session.createQuery("from NoteModel");
		List<NoteModel> notes =query.list();
		session.close();
		return notes;
	}
	//delete note
	public int deleteNote(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from NoteModel where noteID = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id",id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

	//update note
	public int updateNote(int id, NoteModel note){
		if(id <=0)  
			return 0;  
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update NoteModel set patientName=:patientName,noteType=:noteType,careProvider=:careProvider,noteTime=:noteTime,note=:note,noteStatus=:noteStatus,recordID=:recordID where noteID =:noteID";
		Query query = session.createQuery(hql);
		query.setInteger("noteID",note.getNoteId());
		query.setString("patientName",note.getPatientName());
		query.setString("noteType",note.getNoteType());
		query.setString("careProvider",note.getCareProvider());
		query.setString("noteTime",note.getNoteTime());
		query.setString("note",note.getNote());
		query.setString("noteStatus",note.getNoteStatus());
		query.setInteger("recordID",note.getRecordID());


		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}