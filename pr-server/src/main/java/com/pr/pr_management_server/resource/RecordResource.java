package com.pr.pr_management_server.resource;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pr.pr_management_server.model.RecordModel;
import com.pr.pr_management_server.service.RecordService;

@Path("/record")
public class RecordResource {
	
	RecordService service = new RecordService();
  
	@Path("/add")
	@POST
	 @Produces(MediaType.APPLICATION_JSON)
	public RecordModel addRecord(RecordModel record) {
		return service.addRecord(record);
		
	}
	//get all instance
	@Path("/get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<RecordModel>  getRecord() throws SQLException {
		 return service.getRecord();
		
	}
	
	//get instance by id
	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<RecordModel>getRecord(@PathParam("id") int id) throws SQLException {
		return service.getRecordById(id);
		
	}
	
	@Path("/update")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public RecordModel updateRecord(RecordModel record) {
		 return service.updatetRecord(record);
		
	}
	
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteRecord(@PathParam("id") int id) {
		return service.deletetRecord(id);
		
	}

	
	

}