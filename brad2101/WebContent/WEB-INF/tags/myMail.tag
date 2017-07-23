<%@ tag dynamic-attributes='data'%>
<%@ tag import="java.util.HashMap"%>
<%@ tag import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ tag import = "javax.mail.internet.*,javax.activation.*"%>
<%@ tag import = "javax.servlet.http.*,javax.servlet.*" %>
<%
HashMap<String, String> data = 
	(HashMap<String, String>)jspContext.getAttribute("data");
String result;

//Recipient's email ID needs to be mentioned.
String to = data.get("to");

//Sender's email ID needs to be mentioned
String from = data.get("from");

String sub = data.get("sub");

String text = data.get("text");

if(sub != null){
	// Assuming you are sending email from localhost
	String host = "ms7.hinet.net";

	// Get system properties object
	Properties properties = System.getProperties();

	// Setup mail server
	properties.setProperty("mail.smtp.host", host);

	// Get the default Session object.
	Session mailSession = Session.getDefaultInstance(properties);

	try {
	   // Create a default MimeMessage object.
	   MimeMessage message = new MimeMessage(mailSession);
	   
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	   
	   // Set To: header field of the header.
	   message.addRecipient(Message.RecipientType.TO,
	                            new InternetAddress(to));
	   // Set Subject: header field
	   message.setSubject(sub);
	   
	   // Now set the actual message
	   message.setText(text);
	   
	   // Send message
	   Transport.send(message);
	   result = "Sent message successfully....";
	} catch (MessagingException mex) {
	   mex.printStackTrace();
	   result = "Error: unable to send message....";
	}
}
%>