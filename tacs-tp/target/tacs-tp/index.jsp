<html>
	<head>
	
	<link rel="stylesheet" href="FB_ML.css" />
	<link rel="stylesheet" href="ml.css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript" src="chico-0.6.2.js"></script>
		
	<script type="text/javascript" src="index.js">    
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
