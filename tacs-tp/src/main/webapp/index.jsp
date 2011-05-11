<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function(){ 
			$("input:submit").click(function () {
				var tags = $("#tags").val();
				$.getJSON("https://api.mercadolibre.com/sites/MLA/search?q="+tags+"&callback=?", hacerAlgoConDatos);
				$("#tagsToSearch").text(tags);
			});
			$("#loading").ajaxStart(function(){ 
				$(this).show(); 
			});
			$("#loading").ajaxComplete( 
				function(event,request, settings) { 
					$(this).hide();
				});      
		});
		
		function hacerAlgoConDatos(data){
			//DO SOMETHING!
			$("#resultados").empty(); 
			$.each(data[2].results, function(i,item){ 
				$("#resultados").append(item.title + "<br/>");
			}); 
		}
	</script>

</head>

	<body>
		<h1>Consumir API de MercadoLibre</h1>
		
		<!--#buscador -->
		<fieldset><legend>Consumer de la API de ML</legend>
			<div id="search"><label for="tags">Tags: </label> <input
		    	type="text" id="tags" value="" /> <input type="submit"
		    	value="Buscar" /> <span> </span>
			</div>
		</fieldset>
	
		<!--#resultado -->
		<fieldset><legend>Resultados para: <span id="tagsToSearch"></span></legend>
			<div id="resultados"></div>
		</fieldset>
	</body>
</html>
