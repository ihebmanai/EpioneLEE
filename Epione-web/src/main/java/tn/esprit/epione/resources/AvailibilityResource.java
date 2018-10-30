package tn.esprit.epione.resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.epione.interfaces.AvailibilityInterface;

@Path("availibility")
public class AvailibilityResource {
	@EJB
	AvailibilityInterface availibilityService;
	
	@POST
	@Path("/avai")
	@Consumes("application/json")
	@Produces("application/octet-stream")

	public Response addAvailly(@QueryParam("idDoc")int idDoc ,@QueryParam("startDate")String startDate ,@QueryParam("endDate")String endDate) {
try {
			availibilityService.addAvaillibility((Date)(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	                .parse(startDate)),(Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	                .parse(endDate), idDoc);

			return 	 Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			
			return 	 Response.status(Status.NOT_MODIFIED).entity(e.getMessage()).build();

		}
		
	}
	@DELETE
	@Path("{idAv}")
	@Consumes
	public Response DeleteAva(@PathParam(value="idAv")int idAv) {
		try {

			availibilityService.DeleteAva(idAv);

			return 	 Response.status(Status.OK).build();

			
		} catch (Exception e) {
			return 	 Response.status(Status.NOT_MODIFIED).build();

		}
		
	}
	
	@DELETE
	@Path("{idDoc}/{date}")
	@Consumes
	public Response DeleteAvabyDoc(@PathParam(value="idDoc")int idDoc,@PathParam(value="date")String date) {
		try {

			availibilityService.DeleteAvaDoc(idDoc, date);

			return 	 Response.status(Status.OK).build();

			
		} catch (Exception e) {
			return 	 Response.status(Status.NOT_MODIFIED).build();

		}
		
	}

	
	
	
	
	
	
	public static Date getDateNowUTC(String date) {
		Date nowUTC = new Date();
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
			nowUTC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return nowUTC;
	}


}
