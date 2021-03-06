package test;
import static org.junit.Assert.*;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TestCase1 {

   @Test //Case 1 PUT
   @FileParameters("test/test/testdata.csv")
   public void testPut(Long transactionId, Double amount, String type, Long parentId) {
	   
	   ClientConfig config = new DefaultClientConfig();
	   Client client = Client.create(config);
	   WebResource webResource = client.resource(UriBuilder.fromUri( "http://127.0.0.1:8080/RESTfulApiTest/transactionservice/transaction/" + transactionId.toString() ).build());
	   
	   MultivaluedMap formData = new MultivaluedMapImpl();
	   formData.add("amount", amount.toString());
	   formData.add("type", type);
	   formData.add("parent_id", parentId.toString());
	   
	   ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).put(ClientResponse.class, formData);
	   System.out.println("Test case 1 - PUT - Response " + response.getEntity(String.class));
  
   }
}