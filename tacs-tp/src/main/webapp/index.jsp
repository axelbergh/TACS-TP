<html>
<head>
<script type="text/javascript" src="jquery.js">
</script>
<script type="text/javascript">
	    $(document).ready( function(){  
	    	alert("FUNCA!");
	    	$("input:submit").click(function () {
	    		var tags = $("input:tags").val();
	    		$.getJSON("http://api.mercadolibre.com", 
	    		  function(data){
		    		  //DO SOMETHING!
	    		});
	    	});	
	    }); 
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
