<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>


<%
String result;

// Recipient's email ID needs to be mentioned.
String to = "n0919046739@gmail.com";

// Sender's email ID needs to be mentioned
String from = "b93303015@gmail.com";

// Assuming you are sending email from localhost
String host = "ms7.hinet.net";

// Get system properties object
Properties properties = System.getProperties();

// Setup mail server
properties.setProperty("mail.smtp.host", host);

// Get the default Session object.
Session mailSession = Session.getDefaultInstance(properties);
for(int i = 0; i < 10; i++){
	
}
try {
   // Create a default MimeMessage object.
   MimeMessage message = new MimeMessage(mailSession);
   
   // Set From: header field of the header.
   message.setFrom(new InternetAddress(from));
   
   // Set To: header field of the header.
   message.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(to));
   // Set Subject: header field
   message.setSubject("老婆妳好!");
   
   // Now set the actual message
   message.setText("我用java程式寄email給妳~~");
   
   // Send message
   Transport.send(message);
   result = "Sent message successfully....";
} catch (MessagingException mex) {
   mex.printStackTrace();
   result = "Error: unable to send message....";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
         <h1>Send Email using JSP</h1>
      </center>
      
      <p align = "center">
         <% 
            out.println("Result: " + result + "\n");
         %>
      </p>
</body>
</html>