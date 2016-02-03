package com.aftersencha.main;

import javax.ws.rs.Produces;
import java.lang.String;
import java.util.ArrayList;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.json.JSONArray;
import org.json.JSONObject;

@Path("types")
public class Type
{

   @Path("/{type}")
   @GET
   @Produces("text/html")
   public String list( @PathParam("type") String targetType )
   {
	   ArrayList<Long> array = new ArrayList<Long>();
	   JSONArray typeList = null;
	   String tempType;
	   for (Map.Entry<Long, JSONObject> jsonObject : TransactionService.transactionsById.entrySet()){
    	   tempType = jsonObject.getValue().getString("type"); 
    	   if ( targetType.equals( tempType ) ){
    		   //typeList.add( jsonObject.getValue().getLong("transaction_id") );
    		   array.add( jsonObject.getKey() );
    	   }
       }
	   System.out.println(array);
	   typeList = new JSONArray(array);
		
      return typeList.toString();
   }
}