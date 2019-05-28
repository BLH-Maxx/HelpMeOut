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

				<li><a href="#">Request a Credit</a></li>
				<li><a href="#">Status of Credits</a></li>
				<li><a href="http://localhost:8765/transaction/makeadeposit">Deposit Money</a></li>
				<li><a href="http://localhost:8765/credit/mycredit">My Credits</a></li>
				<li><a href="/lend-Money">Lend Money</a></li>
				<li><a href="/borrow">Borrow Money</a></li>
				<li><a href="/show-my-borrows?userName=<%=userName%>">My
						borrows</a></li>
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
						<li class="nav-item"><a class="nav-link"
							href="/admin/admin-dashboard"> Admin Dashboard</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</ul>
				</div>
			</nav>

			<div class="container-fluid text-center" id="tasksDiv">
				<h3>All Borrows Requests</h3>
				<hr>
				<a href="/admin/show-all-borrows" class="btn btn-primary"
					role="button">All</a> <a href="/admin/show-all-approved"
					class="btn btn-success" role="button">Approved</a> <a
					href="/admin/show-all-rejected" class="btn btn-danger"
					role="button">Rejected</a> <a href="/admin/show-all-pendings"
					class="btn btn-warning" role="button">Pendings</a> <br> <br>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Borrow Id</th>
								<th>User Id</th>
								<th>UserName</th>
								<th>Requested Amount</th>
								<th>Remaining Amount</th>
								<th>Period</th>
								<th>Requested Date</th>
								<th>Requested Time</th>
								<th>Eligible</th>
								<th>Reason</th>
								<th>Status</th>

								<th>Lender 1</th>
								<th>Lender 2</th>
								<th>Lender 3</th>
								<th>Lender 4</th>
								<th>Lender 5</th>
								<th>Approve</th>
								<th>Reject</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="borrow" items="${borrows}">
								<tr>
									<td>${borrow.borrowId}</td>
									<td>${borrow.userId}</td>
									<td>${borrow.userName}</td>
									<td>${borrow.requestedAmount}</td>
									<td>${borrow.remainingAmount}</td>
									<td>${borrow.period}</td>
									<td>${borrow.requestedDate}</td>
									<td>${borrow.requestedTime}</td>
									<td>${borrow.eligible}</td>
									<td>${borrow.reason}</td>
									<td>${borrow.status}</td>
									<td>${borrow.lenderOneId}</td>
									<td>${borrow.lenderTwoId}</td>
									<td>${borrow.lenderThreeId}</td>
									<td>${borrow.lenderFourId}</td>
									<td>${borrow.lenderFiveId}</td>
									<td><a href="/admin/approve-borrow?id=${borrow.borrowId}"><span
											class="glyphicon glyphicon-ok"></span></a></td>
									<td><a href="/admin/reject-borrow?id=${borrow.borrowId}"><span
											class="glyphicon glyphicon-remove"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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