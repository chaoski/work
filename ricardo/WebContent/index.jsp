<html>
<head>
	<title>Event reports</title>
	

	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="style.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	
	
</head>
<body>

	<div class="container">
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Hola
		</button>
		<div class="modal fade" id="modal-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 class="modal-title">Hola mundo</h3>
					</div>
					<div class="modal-body">
						xdfjskladjfasñldkfjañsdlfjkañsdflkjañsdflkj
					</div>
					<div class="modal-footer">
						<a href="" class="btn btn-default" data-dismiss="modal">Close</a>
						<a href="" class="btn btn-primary" data-dismiss="modal">Accept</a>				
					</div>
				</div>
			</div>	
		</div>
		
		<nav class="navbar navbar-default">
			<ul class="nav navbar-nav">
				<li><a href="">Event Log</a></li>
				
				<li class="dropdown"><a data-toggle="dropdown" href="">Apps <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#modal-1">View</a></li>
						<li><a href="">Add</a></li>
						<li><a href="">Delete</a></li>
						<li><a href="">Update</a></li>
					</ul>	
				</li>
				
				<li class="dropdown"><a data-toggle="dropdown" href="">Errors <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="">View</a></li>
						<li><a href="">Add</a></li>
						<li><a href="">Delete</a></li>
						<li><a href="">Update</a></li>
					</ul>	
				</li>
			</ul>
		</nav>
	
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>App</th>
					<th>Error</th>
					<th>User Name</th>
				</tr>
			</thead>
		</table>
		
	</div>


<script src="js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</body>
</html>