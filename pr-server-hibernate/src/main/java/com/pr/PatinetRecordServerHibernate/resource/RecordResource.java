package com.pr.PatinetRecordServerHibernate.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.pr.PatinetRecordServerHibernate.dao.RecordDAO;
import com.pr.PatinetRecordServerHibernate.model.RecordModel;



@Path("/record")
public class RecordResource {

	@GET
	@Produces("application/json")
	public List<RecordModel> getRecord() {
		RecordDAO dao = new  RecordDAO();
		List records = dao.getRecord();
		return records;
	}


	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addRecord(RecordModel record){
		record.setPatientName(record.getPatientName());
		record.setPatientAge(record.getPatientAge());
		record.setPatientBgroup(record.getPatientBgroup());
		record.setPatientHrate(record.getPatientHrate());
		record.setPatientWeight(record.getPatientWeight());
		record.setPatientSymptoms(record.getPatientSymptoms());

		RecordDAO dao=new RecordDAO();
		dao.addRecord(record);
		return Response.ok().build();
	}

	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	public Response updateNote(@PathParam("id") int id, RecordModel record){
		RecordDAO dao = new  RecordDAO();
		int count = dao.updateRecord(id,record);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteRecord(@PathParam("id") int id){
		RecordDAO dao = new   RecordDAO();
		int count = dao.deleteRecord(id);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}




}
