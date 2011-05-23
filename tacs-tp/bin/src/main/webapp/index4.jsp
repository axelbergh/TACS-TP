<html>
<head>
<link rel="stylesheet" href="ml.css" />
<link rel="stylesheet" href="FB_ML.css" />
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
            	$("<li class='list-view-item'>" +
	            	  "<h3 class='list-view-item-title'>" +
	            	  	"<a href='" + item.permalink   +"'>" + 
	            	  	 	item.title +
	            	  	"</a>" +
	            	  "</h3>" +
	            	  "<p class='list-view-item-subtitle'>" +
	            	  	item.subtitle +
	          		  "</p>" +
	          		"<a href='" + item.permalink +"' class='list-view-item-figure'>" +
	          			item.thumbnail + 
	          		  "</a>" +  
	          		  "<p class='price-info'>" +
	          		  	"<span class='price-info-cost'>" + 
		          		  	"<strong class='price'>" +  
		          		  		item.price  + " (con decimales: <sup>99</sup>)" +
		          			"</strong>" +
	          			"</span>" +
	          			"<span class='price-info-installments'>" +
		        			"<span class='installmentsQuantity'>" +
		        				"N°Cuotas" +
		        			"</span> cuotas de "+
		        			"<span class='price'>" + 
		        				"PrecioCuotas" + " (Con decimales: <sup>99</sup>)" + 
		        			"</span>" + 
	        			"</span>" + 
	        		  "</p>" +
	          		  "<ul class='extra-info'>" +  
	          			"<li class='extra-info-condition'>" +
	          				item.condition +
	          			"</li>" +
	          			"<li class='extra-info-sold'>" +
	          				"CantidadVendidos" +
	          			"</li>"  +
	          			"<li class='extra-info-location'>" + 
	          				item.address.city_name +
	          			"</li>" + 
	          		  "</ul>" +
          		  "</li>").appendTo("#listado");
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
