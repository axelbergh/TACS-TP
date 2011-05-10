<html>
	<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready( function(){ 
			$("input:submit").click(function () {
				alert("funca");
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
			$.each(data.items, function(i,item){ 
				//HACER ALGO CON CADA RESULT 
				if ( i == 20 ) return false; 
			}); 
		}
	</script>

   
</head>

	<body>
		<h1>Ajax getJSON Flickr Web Service</h1>
	
		<!--#buscador -->
		<fieldset><legend>Consumer de la API de ML</legend>
		<div id="search"><label for="tags">Tags: </label> <input
			type="text" name="tags" value="" /> <input type="submit"
			value="Buscar" /> <span> </span><img src="./images/ajax-loader.gif"
			id="loading" style="display: none;" /></div>
		</fieldset>
	
		<!--#resultado -->
		<fieldset><legend>Resultados para: <span
			id="tagsToSearch"></span></legend>
			<div id="images"></div>
		</fieldset>
	</body>
</html>
