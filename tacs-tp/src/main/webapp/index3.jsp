<html>
<head>
<link rel="stylesheet" href="ml.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	
	<script type="text/javascript">    
		var paginaActual = 1;
		var cantidadPorPagina = 10;
		var offset = (paginaActual-1) * cantidadPorPagina;
		var resultadosTotales = 0;
		var busqueda = "";
		
		function buscar(key){
			busqueda = key;
			ActualizarBusqueda();
		}
		
		function ActualizarBusqueda(){
			var parameters = "?q=" + busqueda +
					         "&limit=" + cantidadPorPagina + 
					         "&offset="+ offset;
			
			$.getJSON("https://api.mercadolibre.com/sites/MLA/search" + parameters + "&callback=?", mostrarResultados);
		}

		function mostrarResultados(response){
            respuesta = response;
            
            resultadosTotales = response[2].paging.total;
            
            $("#listado").html("");
            $.each(response[2].results, function(i, item) {
            	$("<li><table><tr><td>"+
            			"<td><img src='" + item.thumbnail + "'></span></li>" +
        				"<td>" + item.title + "</td>" +
        				"<td>" + item.price + "</td>" +             				
        				"<td>" + item.condition + "</td>" + 
        				"<td>" + item.buying_mode + "</span></li>" + 
        				"<td>" + item.address.city_name + "</span></li>" + 
        				"<td><a href='" + item.permalink + "' target='_blank'>Ir</a></span></li>" +                 			 	
           		  "</td></tr></table></li>").appendTo("#listado");
            });  
            armarPaginador();
		}
		
		function irAPagina(pagina){
			paginaActual = pagina;
			ActualizarBusqueda();
		}
		
		function armarPaginador(pagAnt, pagDesp){
			if (resultadosTotales == 0) return;
			
			var cantPaginas = Math.ceil(resultadosTotales / cantidadPorPagina);
			if (cantPaginas == 1) return; 
			
			if (pagAnt == null) pagAnt=6;
			if (pagDesp == null) pagDesp=6;
			
			var paginaLimiteInf = Math.max(1,(paginaActual - pagAnt));
			var paginaLimiteSup = Math.min(cantPaginas,(paginaActual + pagDesp));

			
			var paginadorHTML = "<h2>Paginación</h2><ul class='pagination'>";
			if (paginaActual > 1) paginadorHTML += "<li><a type='prev' href='javascript:irAPagina(" + (paginaActual-1) + ")'>&lt; Anterior</a></li>";
			for(pagina = paginaLimiteInf ; pagina <= paginaLimiteSup ; pagina++){
				var selected = "";
				if (pagina == paginaActual) selected = "class='current'";
				paginadorHTML += "<li " + selected + "><a href='javascript:irAPagina(" + pagina + ")'>" + pagina + "</a></li>";
			}
			if (paginaActual < cantPaginas) paginadorHTML += "<li><a type='next' href='javascript:irAPagina(" + (paginaActual+1) + ")'>Siguiente &gt;</a></li>";
			paginadorHTML += "</ul>";
			
			$("#paginador").html(paginadorHTML);	
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
			<input type="button" class="btn secondary" value="buscar" onclick="buscar($('#key').val())"/>
		</td>
	</tr>
</table>
<br/>
Hay un table adentro del tag "li", por eso se ven medio raras algunas filas. Deberiamos hacer estilos y sacar ese table.
<br/>

<div class="box"> 
	<ol id="listado" summary="Listado de Resultados">
	</ol>
	<div id="paginador"></div>
</div> 


<br/>
<br/>

</body>
</html>
