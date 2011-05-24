<html>
	<head>
	<link rel="stylesheet" href="ml.css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript" src="chico-0.6.2.js"></script>
		
		<script type="text/javascript">    
			var paginaActual = 1;
			var cantidadPorPagina = 10;
			var offset = (paginaActual-1) * cantidadPorPagina;
			var resultadosTotales = 0;
			var busqueda = "";
			var categoria = "";
			var paisId = "MLA";  //TODO: Parametrizar luego
			var breadcrumb = new Array();
			
			
			function completarComboPaises(){
				$.getJSON("https://api.mercadolibre.com/sites?callback=?", function(response){
					$("#listaPaises").html("");
					$.each(response[2], function(i, country) {
			        	$("<li><a href='javascript:cambiarPaisA(\"" + country.id + "\")'>" + country.name + "</li>").appendTo("#listaPaises");
			        });  
					
				});
				
			}
	    	
			function cambiarPaisA(countryId){
				paisId = countryId;
				actualizarCategoriasPrincipales();
				resetearBusquedas();
			}
			

			function resetearBusquedas(){
				$('#key').val("");
				$("#listado").html("");
				$("#paginador").html("");
				categoria = "";
				paginaActual = 1;
				resultadosTotales = 0;
			}
			
			function buscar(key){
				busqueda = key;
				if (busqueda == null) busqueda = "";
				actualizarBusqueda();
			}
			
			function filtrarPorCategoria(categoriaId){
				categoria = categoriaId;
				actualizarCategoriasSecundarias();
				actualizarBusqueda();
			}
			
			function actualizarBreadcrumb(root_categories){
				$("#breadcrumb").html("");
				
				if($('#breadcrumb').html() == ""){
					$("<li><a href='javascript:actualizarCategoriasPrincipales()'> Categorias Principales </li>").appendTo("#breadcrumb");
				}
				
	            $.each(root_categories, function(i, category) {
	            	$("<li><a href='javascript:filtrarPorCategoria(\"" + category.id + "\")'>" + category.name + "</li>").appendTo("#breadcrumb");
	            });
			}
			
			function actualizarCategoriasSecundarias(){
				$.getJSON("https://api.mercadolibre.com/categories/" + categoria + "?callback=?", function(response){
					mostrarCategorias(response[2].children_categories);
					actualizarBreadcrumb(response[2].path_from_root);
				});
			}
			
			function actualizarCategoriasPrincipales(){
				$('#breadcrumb').html("");
				$.getJSON("https://api.mercadolibre.com/sites/" + paisId + "?callback=?", function(response){
					mostrarCategorias(response[2].categories);
				});
			}
			
			function mostrarCategorias(listadoCategorias){	 
	            $("#categorias").html("");
	            $.each(listadoCategorias, function(i, category) {
	            	$("<li><a href='javascript:filtrarPorCategoria(\"" + category.id + "\")'>" + category.name + "</li>").appendTo("#categorias");
	            });  
			}
			
			function actualizarBusqueda(){
				var parameters = "?q=" + busqueda +
								 "&category=" + categoria + 
						         "&limit=" + cantidadPorPagina + 
						         "&offset="+ offset;
				
				$.getJSON("https://api.mercadolibre.com/sites/" + paisId + "/search" + parameters + "&callback=?", mostrarResultados);
			}
	
			function mostrarResultados(response){
	            
	            resultadosTotales = response[2].paging.total;
	            
	            $("#listado").html("");
	            $.each(response[2].results, function(i, item) {
	            	$("<li><table><tr height='100px'>"+
	            			"<td>" +
	            				"<a href='" + item.permalink + "' target='_blank'>" +
	            					"<img src='" + item.thumbnail + "'>" +
	            				"</a>" +
	            			"</td>" +	
	        				"<td>" + 
	        					"<a href='" + item.permalink + "' target='_blank'>" +
	        						item.title +
	    						"</a>"+
	        				"</td>" +
	        				"<td>" + item.price + "</td>" +             				
	        				"<td>" + item.condition + "</td>" + 
	        				"<td>" + item.buying_mode + "</td>" + 
	        				"<td>" + item.address.city_name + "</td>" +                 			 	
	           		  "</tr></table></li>").appendTo("#listado");
	            });  
	            armarPaginador();
			}
			
			function irAPagina(pagina){
				paginaActual = pagina;
				ActualizarBusqueda();
			}
			
			function armarPaginador(pagAnt, pagDesp){
				$("#paginador").html("");
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
			
			$(document).ready(function(){
				actualizarCategoriasPrincipales();
				completarComboPaises();
				$(".demoDropdown").dropdown();
			});
			
		</script>
	
		
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
					<input type="text" name="key" id="key"/> 
					<input type="button" class="btn secondary" value="buscar" onclick="buscar($('#key').val())"/>
				</td>
			</tr>
			<tr>
				<td valign="top" align="left">
					<div class="box"> 
						<div id=breadcrumb></div>
						<ol id="categorias" summary="Listado de Categorias"></ol>
					</div>
		 		</td>
		 		<td>
					<!--Hay un table adentro del tag "li", por eso se ven medio raras algunas filas. Deberiamos hacer estilos y sacar ese table.-->
					<br/>
		 			<div class="box"> 
						<ol id="listado" summary="Listado de Resultados"></ol>
						<div id="paginador"></div>
					</div> 
		 		</td>
			</tr>
		</table>

	</body>
</html>
