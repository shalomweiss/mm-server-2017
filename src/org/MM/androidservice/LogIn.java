package org.MM.androidservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.Data;
import javax.enterprise.context.spi.Context;
import javax.json.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Past;




import org.MM.model.*;

import java.lang.Object;



import org.apache.catalina.Session;


public class LogIn {

	// This method is called if TEXT_PLAIN is request
	 
	  @POST
	  @Path ("/LogIn")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public JsonUser doLogin(@QueryParam("email") String uname, @QueryParam("password") String pwd, @QueryParam("deviceId") String device) {
		   {

		       // HttpSession session= req.getSession(true);
		        User user=DA.login(uname);
		        JsonUser jsonUser;
		       
		       	  if( user==null) {
		    	   		 
		       		 jsonUser=new JsonUser(user,403,"invalid input",null);
		    	  }
		    	   	  else
		    	   	  {
		    	   		  
		    	   		//HttpSession session=Context
		    	   		  if(user.getPassword==pwd )
		    	   		 jsonUser=new JsonUser(user,200,"success",null);
		    	   		  else  jsonUser=new JsonUser(user,403,"wrong password",null);
		    	   		 //missing the session instead of null 
		    	   		  //DA.insert(token,uID,deviceID);
		    	   		  
		    	   			
		    	   	  }
		          
		  return jsonUser;

	  }
	  }}