<?xml version="1.0" encoding="UTF-8"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns:c="http://java.sun.com/jsp/jstl/core"
xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
xmlns="http://www.w3.org/1999/xhtml"
version="2.0">

	<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
	
	<![CDATA[<!DOCTYPE html>]]>
	<html>
	    <head>
	        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>	        	        
	    	<script>
				<!-- Script Here -->	
			</script>
	    </head>
	    	
	    <body> 
	    
	    	<div class="container">
				<h1>VERSION INFO:</h1>
				<br/>
		    	<dl class="dl-horizontal">
   					<dt>WAR VERSION:</dt>
   					<dd id="displayWarVersion">${display_war_version}</dd>
   					<dt>BUILD TIMESTAMP:</dt>
   					<dd id="displayBuildTimestamp">${display_build_timestamp}</dd>
   				</dl>
   			</div>
   				
			<!-- Colocar aqui los include de js necesarios para la pantalla -->
			<content tag="myJavascript">  
         		<!-- <script src="../js/XXX.js" type="text/javascript"></script>  -->  
			</content>	
	    </body>
	</html>

</jsp:root>