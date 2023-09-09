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

import com.pr.pr_management_server.model.NoteModel;
import com.pr.pr_management_server.service.NoteService;


@Path("/note")
public class NoteResource {
	
	NoteService service = new NoteService();
	
  
	@Path("/add")
	@POST
	 @Produces(MediaType.APPLICATION_JSON)
	public NoteModel addNote(NoteModel note) {
		return service.addNote(note);
		
	}
	//get all instance
	@Path("/get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<NoteModel>  getNote() throws SQLException {
		 return service.getNote();
		
	}
	
	//get instance by id
	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<NoteModel>getNote(@PathParam("id") int id) throws SQLException {
		return service.getNoteById(id);
		
	}
	
	@Path("/update")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public NoteModel updateNote(NoteModel note) {
		 return service.updateNote(note);
		
	}
	
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteNote(@PathParam("id") int id) {
		return service.deletetNote(id);
		
	}
	
}

	
	