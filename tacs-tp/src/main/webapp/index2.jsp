<html>
<head>
<link rel="stylesheet" href="http://jquery.bassistance.de/treeview/jquery.treeview.css" />
<link rel="stylesheet" href="http://jquery.bassistance.de/treeview/demo/screen.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<script src="http://jquery.bassistance.de/treeview/lib/jquery.js"            type="text/javascript"></script> 
<script src="http://jquery.bassistance.de/treeview/lib/jquery.cookie.js"     type="text/javascript"></script> 
<script src="http://jquery.bassistance.de/treeview/jquery.treeview.js"       type="text/javascript"></script>
<script src="http://jquery.bassistance.de/treeview/jquery.treeview.edit.js"  type="text/javascript"></script>
<script src="http://jquery.bassistance.de/treeview/jquery.treeview.async.js" type="text/javascript"></script> 
	
	<script type="text/javascript">    

		function getJSONMercadoLibre(key){
			$.getJSON("https://api.mercadolibre.com/sites/MLA/search?q="+key+"&callback=?", construirArbol);
		}

		function construirArbol(response){
            respuesta = response;
            $("#browser").html("");
            $("#browser").treeview({control:"#sidetreecontrol"});
            
            $.each(response[2].results, function(i, item) {
            	var branches = $("<li>"+
                    				"<span class='folder'> "+ item.title + "</span>"+
                    				"<ul>"+
                    				"<li><span class='file'>precio = "          +item.price             +"</span></li>"+             				
                    				"<li><span class='file'>condición = "       +item.condition         +"</span></li>"+ 
                    				"<li><span class='file'>forma de compra = " +item.buying_mode       +"</span></li>"+ 
                    				"<li><span class='file'>cuidad = "          +item.address.city_name +"</span></li>"+    
                    				"<li><span class='file'>url imagen = "      +item.thumbnail         +"</span></li>"+ 
                    				"<li><span class='file'>url publicación = " +item.permalink         +"</span></li>"+
                    				"</ul>"+                 			 	
                       			 "</li>").appendTo("#browser");
   				$("#browser").treeview({
   					add: branches
   				});
            });  
		}
		
	</script>

	
</head>

<body>
<table width="100%">
	<tr>
		<td align="center">
			<h3>TACS - Ejemplo de utilización de servicio REST Mercado Libre</h3> 
		</td>
	</tr>
</table>
<br>
<table width="100%">	
	<tr>
		<td>
			Ingrese una palabra para efectuar la búsqueda (ejemplos: "argentina","brasil","boca","ford")
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="key" id="key"/> 
			<input type="button" value="buscar" onclick="getJSONMercadoLibre($('#key').val())"/>
		</td>
	</tr>
</table>
<br>
<br>
<div id="sidetreecontrol"> 
	<a href="?#">Collapse All</a> | <a href="?#">Expand All</a> 
</div> 
<ul id="browser" class="filetree treeview"></ul>
</body>
</html>
