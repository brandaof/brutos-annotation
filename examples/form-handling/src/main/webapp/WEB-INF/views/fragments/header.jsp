	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Brutos MVC form handling example</title>
	
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
	
	<script type="text/javascript">
		
		contextPath = "${pageContext.request.contextPath}";

		function get(resource){
			location.href = contextPath + resource;
		}

		function post(resource, reload){
			$.ajax({
			    type: 'POST',
			    url: contextPath + resource,
			    success: function(data) {
			    	document.write(data);
			    	document.close();
	            }			    
			});
		}
		
	</script>
	<style>
		body {
			padding-top: 56px;
		}

		section {
			width: 100%;
		}
		
		@media ( min-width : 992px) {
			body {
				padding-top: 58px;
			}
		}
	</style>
