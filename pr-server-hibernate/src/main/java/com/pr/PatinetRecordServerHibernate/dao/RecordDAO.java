package com.pr.PatinetRecordServerHibernate.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pr.PatinetRecordServerHibernate.model.RecordModel;


public class RecordDAO {

	public void addRecord(RecordModel bean){
		Session session = SessionUtil.getSession();    
		Transaction tx = session.beginTransaction();
		addRecord(session,bean);    
		tx.commit();
		session.close();

	}
	//add medical record

	private void  addRecord(Session session, RecordModel bean){
		RecordModel record = new RecordModel();

		record.setPatientName(bean.getPatientName());
		record.setPatientAge(bean.getPatientAge());
		record.setPatientBgroup(bean.getPatientBgroup());
		record.setPatientHrate(bean.getPatientHrate());
		record.setPatientWeight(bean.getPatientWeight());
		record.setPatientSymptoms(bean.getPatientSymptoms());


		session.save(record);
	}

	//get medical records

	public List<RecordModel> getRecord(){
		Session session = SessionUtil.getSession();  
		Query query = session.createQuery("from RecordModel");
		List<RecordModel> records =query.list();
		session.close();
		return records;
	}

	//delete medical records
	public int deleteRecord(int id) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from RecordModel where recordId = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id",id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

	//update medical records
	public int updateRecord(int id, RecordModel record){
		if(id <=0)  
			return 0;  
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update RecordModel set patientName=:patientName,patientAge=:patientAge,patientWeight=:patientWeight,patientHrate=:patientHrate,patientBgroup=:patientBgroup,patientSymptoms=:patientSymptoms where recordId =:recordId";
		Query query = session.createQuery(hql);
		query.setInteger("recordId",record.getRecordId());
		query.setString("patientName",record.getPatientName());
		query.setString("patientAge",record.getPatientWeight());
		query.setString("patientWeight",record.getPatientWeight());
		query.setString("patientHrate",record.getPatientHrate());
		query.setString("patientBgroup",record.getPatientBgroup());
		query.setString("patientSymptoms",record.getPatientSymptoms());



		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}