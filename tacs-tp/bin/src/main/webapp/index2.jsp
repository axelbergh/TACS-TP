<html>
<head>
<link rel="stylesheet" href="ml.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	
	<script type="text/javascript">    
		
		function getJSONMercadoLibre(key){
			$.getJSON("https://api.mercadolibre.com/sites/MLA/search?q="+key+"&callback=?", mostrarResultados);
		}

		function mostrarResultados(response){
            respuesta = response;
            $("#tablitaBody").html("");
            
            $.each(response[2].results, function(i, item) {
            	$("<tr>"+
            			"<td><img src='" + item.thumbnail + "'></span></li>" +
        				"<td>" + item.title + "</td>" +
        				"<td>" + item.price + "</td>" +             				
        				"<td>" + item.condition + "</td>" + 
        				"<td>" + item.buying_mode + "</span></li>" + 
        				"<td>" + item.address.city_name + "</span></li>" + 
        				"<td><a href='" + item.permalink + "'>Ir</a></span></li>" +                 			 	
           		  "</tr>").appendTo("#tablitaBody");
            });  
		}
		
	</script>

	
</head>

<body>
<table width="100%">
	<tr>
		<td align="center">
			<h3>TACS - Mercado Libre</h3> 
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
			<input type="button" class="btn secondary" value="buscar" onclick="getJSONMercadoLibre($('#key').val())"/>
		</td>
	</tr>
</table>
<br/>
<br/>

<div class="box"> 
	<table id="tablita" summary="Listado de Resultados">
		<caption>Table</caption>
		<thead>
			<tr>
				<th scope="col">Imagen</th>
				<th scope="col">Nombre</th>
				<th scope="col">Precio</th>
				<th scope="col">Condición</th>
				<th scope="col">Forma de Compra</th>
				<th scope="col">Ciudad</th>
				<th scope="col">Ir a Publicación</th>
			</tr>
		</thead>
		<tbody id="tablitaBody">
		
		</tbody>
	</table>
</div> 

<br/>
<br/>

</body>
</html>
