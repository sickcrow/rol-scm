<![CDATA[<!DOCTYPE html>]]>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>	        	        
    </head>
    	
    <body>      
		<div class="container">
			<h2 class="error">ERROR 404</h2>
			<p class="textError">Lo sentimos, la página solicitada no se encuentra disponible</p>
			<div class="botonHome">
				<a href="${pageContext.servletContext.contextPath}/crearaviso/crear-aviso" title="Volver al inicio">Volver al inicio</a>
			</div>
		</div>
		
		<!-- Colocar aqui los include de js necesarios para la pantalla -->
		<content tag="myJavascript">  
       		<script src="${pageContext.servletContext.contextPath}/js/url.utils.js" type="text/javascript" charset="cp1252"></script>
       		<script src="${pageContext.servletContext.contextPath}/js/error/error.controller.js" type="text/javascript" charset="cp1252"></script>   
		</content>	 
    </body>
</html>