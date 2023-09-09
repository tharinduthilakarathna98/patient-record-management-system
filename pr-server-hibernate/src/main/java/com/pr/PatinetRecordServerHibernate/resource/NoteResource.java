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

import com.pr.PatinetRecordServerHibernate.dao.NoteDAO;
import com.pr.PatinetRecordServerHibernate.model.NoteModel;


@Path("/note")
public class NoteResource {

	@GET
	@Produces("application/json")
	public List<NoteModel> getNote() {
		NoteDAO dao = new  NoteDAO();
		List notes = dao.getNote();
		return notes;
	}


	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addNote(NoteModel note){
		note.setPatientName(note.getPatientName());
		note.setNoteType(note.getNoteType());
		note.setCareProvider(note.getCareProvider());
		note.setNoteTime(note.getNoteTime());
		note.setNoteStatus(note.getNoteStatus());
		note.setRecordID(note.getRecordID());
		note.setNote(note.getNote());

		NoteDAO dao = new  NoteDAO();
		dao.addNote(note);

		return Response.ok().build();
	}

	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	public Response updateNote(@PathParam("id") int id, NoteModel note){
		NoteDAO dao = new  NoteDAO();
		int count = dao.updateNote(id,note);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes("application/json")
	public Response deleteNote(@PathParam("id") int id){
		NoteDAO dao = new  NoteDAO();
		int count = dao.deleteNote(id);
		if(count==0){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().build();
	}




}
