<%@ page pageEncoding="UTF-8"%>
<%
	String sessionId    = (String)session.getAttribute("sessionId");
	String sessionName  = (String)session.getAttribute("sessionName");
	String sessionLevel = (String)session.getAttribute("sessionLevel");
	
	if(sessionLevel == null) sessionLevel = "";
	if(sessionId == null)    sessionId = "";	
	if(sessionName == null)  sessionName = "";
		
	

%>