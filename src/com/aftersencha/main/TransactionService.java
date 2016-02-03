package com.aftersencha.main;

import java.lang.String;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Path("transaction")
public class TransactionService
{
   // Map from transaction id to the Object
   public static Map< Long, JSONObject > transactionsById = new TreeMap< Long, JSONObject >(); 

   @PUT
   @Path("/{transaction_id}")
   @Produces("text/html")
   public String create( @PathParam("transaction_id") Long transactionId,
		   @FormParam("amount")double amount, 
           @FormParam("type")String type, 
           @FormParam("parent_id")long parent_id )
   {
	  
	  mapping(transactionId, amount, type, parent_id);
	  
      JSONObject response = new JSONObject();
      response.put( "status", "ok" );
      System.out.println(response.toString());
      return response.toString();
   }

   @GET
   @Path("/{transaction_id}")
   @Produces("text/html")
   public String find( @PathParam("transaction_id") Long transactionId )
   {
      if (transactionsById.containsKey(transactionId)){    	  
         return transactionsById.get(transactionId).toString();
      }
      else{
    	  throw new WebApplicationException(Response.Status.NOT_FOUND);
      }
   }

   public synchronized void  mapping(Long transactionId, Double amount, String type, Long parent_id){
	   JSONObject transactionJsonById = new JSONObject();
		  transactionJsonById.put( "amount", amount );
		  transactionJsonById.put( "type", type );
		  transactionJsonById.put( "parent_id", parent_id );
	      transactionsById.put( transactionId, transactionJsonById );
	       
   }
   
   
}