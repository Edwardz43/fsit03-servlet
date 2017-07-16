<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>
<%@ page import='java.io.*' %>
<%@ page import='java.util.*' %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uploadPath = 
		pageContext.getServletContext().getInitParameter("upload-path");
	//Create a new file upload handler
	int maxFileSize = 5000 * 1024;
   	int maxMemSize = 5000 * 1024;
   	DiskFileItemFactory factory = new DiskFileItemFactory();
    // maximum size that will be stored in memory
    factory.setSizeThreshold(maxMemSize);
    
    // Location to save data that is larger than maxMemSize.
    factory.setRepository(new File("c:\\Ed\\temp"));
    
	ServletFileUpload upload = new ServletFileUpload(factory);
	
	List<FileItem> items = upload.parseRequest(request);
	
	int i = 0;
	for(FileItem item : items){
		String tname = item.getName();
		String name = new String(tname.getBytes(), "UTF-8");
		long size = item.getSize();
		String fname = item.getFieldName();
		boolean isInMemory = item.isInMemory();
		out.print(name + ":"+size+":"+fname+":"+isInMemory+"<br>");
		
		item.write(new File(uploadPath, "ed"+ i++ +".jpg"));
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


</body>
</html>