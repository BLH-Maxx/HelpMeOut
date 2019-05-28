<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<!-- Bootstrap -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/style2.css" rel="stylesheet">
<link href="/src/main/webapp/WEB-INF/static/css/style2.css"
	rel="stylesheet" type="text/css" />

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
			<h3 class="text-center">New Borrow Request</h3>
			<hr>

			<br> <br>
			<div class="col-sm-10">
				<form class="form-horizontal" method="POST" action="borrow-request">
					<input type="hidden" name="id" value="${borrow.borrowId}" />

					<div class="form-group">
						<label class="control-label col-md-3">Requested Amount:</label>
						<div class="col-md-3">
							<input type="number" min="1000" max="100000" step="1000"
								class="form-control" name="requestedAmount"
								value="${borrow.requestedAmount}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Borrowing period:</label>
						<div class="col-md-3">
							<input type="number" min="3" max="36" step="3"
								class="form-control" name="period" value="${borrow.period}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Reason:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="reason"
								value="${borrow.reason}" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-10">
							<input type="submit" class="btn btn-primary" value="Borrow" />
						</div>
					</div>
				</form>
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