<%@page import="java.net.URLEncoder"%>
<%@page import="net.minidev.json.JSONObject"%>
<%@page import="net.minidev.json.JSONArray"%>
<%@page import="net.minidev.json.JSONValue"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
String appId = "245702182112324";
String canvasPage = "http://apps.facebook.com/mercadolibretacs/";

String authUrl = "http://www.facebook.com/dialog/oauth?client_id=" + appId + "&redirect_uri=" + canvasPage;
String oauthToken;
String userId;

String feedUrl;
String feedMessage;

//obtengo JSON que envía Facebook
String signedRequest = request.getParameter("signed_request");
String payload = signedRequest.split("\\.")[1].replace('-', '+').replace('_', '/');
String jsonString = new String(Base64.decodeBase64(payload.getBytes()));

JSONObject json = (JSONObject)JSONValue.parse(jsonString);
//JSONObject user = (JSONObject)json.get("user");

try{
    //obtengo información del usuario
    oauthToken = json.get("oauth_token").toString();
    userId = json.get("user_id").toString();

    out.print("<br><br>Usuario logeado y permisos aceptados para la aplicación TACS-TP<br><br>");

    //construyo boton para publicar en muro
    feedMessage = URLEncoder.encode("<img src='http://profile.ak.fbcdn.net/hprofile-ak-snc4/27404_1226188310_8908_n.jpg'> ","UTF-8");
    feedUrl = "http://www.facebook.com/dialog/feed?app_id=" + appId + "&redirect_uri=" + canvasPage;

    out.print("<script type=\"text/javascript\"> var userId='" + userId + "'; feedUrl=' " + feedUrl + "';</script>");
    
}catch(Exception e){
    //el usuario no está logeado o no autorizó que la aplicación acceda a sus datos
    out.print("<script> top.location.href='" + authUrl + "'</script>");
}


%>

<html>
	<head>
	
	<link rel="stylesheet" href="FB_ML.css" />
	<link rel="stylesheet" href="ml.css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript" src="chico-0.6.2.js"></script>
	<script type="text/javascript" src="index.js"></script>
	
		
	</head>

	<body>
	<table width="100%">
			<tr>
				<td align="center">
					<h3>TACS - Mercado Libre</h3> 
				</td>
				<td>
					<div class="demoDropdown">
					    <span>País</span>
					    <ul id="listaPaises"></ul>
				    </div>
				</td>
				<td class="banderita">
					<li id="bandera" class="argentina"/>
				</td>
			</tr>
		</table>
		<br/>
		
		
		<table width="100%">	
			<tr>
				<td colspan="100%">
					Ingrese una palabra para efectuar la búsqueda (ejemplos: "argentina","brasil","boca","ford")
				</td>
			</tr>
			<tr>
				<td colspan="100%">
					<div id=breadcrumb></div>
				</td>
			</tr>
			<tr>
				<td colspan="100%">
					<input type="text" name="key" id="key"/> 
					<input type="button" class="btn secondary" value="buscar" onclick="buscar($('#key').val())"/>
				</td>
			</tr>
			<tr>
				<td valign="top" align="left" width="200px">
					<div class="box"> 
						<ol id="categorias" summary="Listado de Categorias"></ol>
					</div>
					<div class="wishlist">
						<a href="javascript:getWishlist()">Ver Favoritos</a>
					</div>
					<div class="wishlist">
						<a href="javascript:muro()">Publicar Favoritos</a>
					</div>
		 		</td>
		 		<td>
					<!--Hay un table adentro del tag "li", por eso se ven medio raras algunas filas. Deberiamos hacer estilos y sacar ese table.-->
					<br/>
		 			<div class="box"> 
		 				<div id="paginador"></div>
						<ol id="listado" summary="Listado de Resultados"></ol>
					</div> 
		 		</td>
			</tr>
		</table>

	</body>
</html>
