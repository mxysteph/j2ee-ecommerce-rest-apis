package services;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.json.*;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.text.SimpleDateFormat;
import java.util.Calendar;


@Path("send_email")
public class Mailer {
	@POST
	@Produces("application/json") //gets json object
	
	 public Response sendEmail(@QueryParam("to") String to, @QueryParam("order_id") int order_id, @QueryParam("username") String username) throws AddressException, MessagingException {
		
		
        	Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 3);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = formatter.format(calendar.getTime());

		
			//sets SMTP server variables
			String host = "smtp.gmail.com";
	        String from = "snapsell.j2ee@gmail.com";
	        String txt = "Thank you for your order from Blitz, " + username + "! \nOrder ID: " + order_id + "\nDelivery Date: " + formattedDate;
	        System.out.println(calendar.getTime());


			
	        // sets SMTP server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        properties.put("mail.smtp.starttls.enable", "true");
	 
	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("snapsell.j2ee@gmail.com", "J2EE$snapsell");
	            }
	        };
	 
	        Session session = Session.getInstance(properties, auth);
	 
	        // creates a new e-mail message
	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        msg.setSubject("Blitz: Your Drink Order");
	        msg.setText(txt);
	 
	        // sends the e-mail
	        Transport.send(msg);
	 
	        //returns json
	        JSONObject obj = new JSONObject();
			obj.put("status", "success");
			return Response.ok().entity(obj.toString()).build(); //returns ok code, sends entity and builds
			
			}
}
