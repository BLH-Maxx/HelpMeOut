<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	Authentication auth2 = SecurityContextHolder.getContext().getAuthentication();
	String userName = auth2.getName();
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link href="/css/style2.css" rel="stylesheet">
<link href="/src/main/webapp/WEB-INF/static/css/style2.css"
	rel="stylesheet" type="text/css" />
<!-- Bootstrap -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">


<title>bootstrap 4 sidebar</title>
</head>
<body>

	<div class="wrapper">
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>SIDEBAR</h3>
			</div>

			<ul class="list-unstyled components">
				<p hidden="true">Your Balance:</p>

				<li><a href="/borrow">Request a Credit</a></li>
				<li><a href="/show-my-borrows?userName=<%=userName%>">Status of Credits</a></li>
				<li><a href="http://localhost:8765/transaction/makeadeposit">Deposit Money</a></li>
				<li><a href="http://localhost:8765/credit/mycredit">My Credits</a></li>
				<li><a href="/lend-Money">Lend Money</a></li>
				<li><a href="/borrow">Borrow Money</a></li>
				<li><a href="/show-my-borrows?userName=<%=userName%>">My borrows</a></li>
			</ul>
		</nav>

		<div class="container-fluid">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">

				<button type="button" id="sidebarCollapse" class="btn btn-info">
					<i class="fa fa-align-justify"></i><span> Toggle sidebar</span>
				</button>

				<!--<a class="navbar-brand" href="#">Navbar</a> -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="nav navbar-nav navbar-right">
						<li class="nav-item"><a class="nav-link" href="/"> Home</a></li>
						<li class="nav-item"><a class="nav-link" href="/admin/admin-dashboard"> Admin
								Dashboard</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul>
				</div>
			</nav>

			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Welcome to Lernia auto borrowing system</h2>
					<h3>Click on the option you want on the sidebar</h3>
				</div>

				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img
								src="https://www.naturespicsonline.com/system/carousel_image/file/212/61.jpg"
								alt="Los Angeles">
						</div>

						<div class="item">
							<img
								src="https://www.naturespicsonline.com/system/carousel_image/file/209/58.jpg"
								alt="Chicago">
						</div>

						<div class="item">
							<img
								src="https://www.naturespicsonline.com/system/carousel_image/file/214/63.jpg"
								alt="New York">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>

		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

	<script>
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
			});
		});
	</script>
</body>
</html>