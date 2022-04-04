package services;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.json.*;

@Path("convert_currency")
public class convertCurrencyAPI {
	@GET
	@Produces("application/json") //gets json object
	public Response convertCurrency(@QueryParam("currency") String currency) {
		double conversionRate = 0;
		
		switch(currency) {
		
			case "SGD":
				conversionRate = 1;
				break;
				
			case "USD":
				conversionRate = 0.7;
				break;
				
			case "MYR":
				conversionRate = 3.0;
				break;
				
			case "GBP":
				conversionRate = 0.5;
				break;
				
			case "EUR":
				conversionRate = 0.6;
				break;
				
			default:
				conversionRate = 1;
		}
		
		JSONObject obj = new JSONObject();
		obj.put("conversionRate", conversionRate);
		return Response.ok().entity(obj.toString()).build(); //returns ok code, sends entity and builds
		}
	}
