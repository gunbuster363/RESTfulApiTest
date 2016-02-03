package com.aftersencha.main;

import javax.ws.rs.Produces;
import java.lang.String;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.json.JSONObject;

@Path("sum")
public class Sum
{

   @GET
   @Path("/{transaction_id}")
   @Produces("text/html")
   public String list( @PathParam("transaction_id") Long targetTransactionId )
   {
	   
	   long tempParentId;
	   long targetParentId = TransactionService.transactionsById.get(targetTransactionId).getLong("parent_id");
	   double totalAmount= 0.0;
	   for (Map.Entry<Long, JSONObject> iterator : TransactionService.transactionsById.entrySet()){
		   tempParentId = iterator.getValue().getLong("parent_id");
    	   if ( tempParentId == targetParentId ){
    		   totalAmount += iterator.getValue().getDouble("amount");
    	   }
       }
	   
	   JSONObject returnValue = new JSONObject();
	   returnValue.put( "sum", totalAmount );
		
      return returnValue.toString();
   }
}