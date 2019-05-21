<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help Me Out</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
<!-- bootstrap ccs -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
<script
    src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
<link href="css/simple-sidebar.css" rel="stylesheet">
</head>
<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
        <div class="bg-light border-right" id="sidebar-wrapper">
            <div class="sidebar-heading">Current Balance:? $1,000,000</div>
            <div class="list-group list-group-flush">
                <a href="#" class="list-group-item list-group-item-action bg-light">Request
                    a Credit</a> <a href="#"
                    class="list-group-item list-group-item-action bg-light">Status
                    of Credits</a> <a href="http://localhost:8100/makeadeposit"
                    class="list-group-item list-group-item-action bg-light">Deposite
                    Money</a> <a href="http://localhost:8300/mycredit"
                    class="list-group-item list-group-item-action bg-light">My
                    Credits</a> <a href="#"
                    class="list-group-item list-group-item-action bg-light">Borrow
                    Money</a> <a href="#"
                    class="list-group-item list-group-item-action bg-light">LogOut</a>
            </div>
        </div>
        <!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav
                class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                <button class="btn btn-primary" id="menu-toggle">Toggle
                    Menu</button>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                        <li class="nav-item active"><a class="nav-link"
                            href="http://localhost:8000/">Help Me Out <span
                                class="sr-only">(current)</span></a></li>
                        <li class="nav-item"><a class="nav-link" href="#">And
                                Here</a></li>
                        <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                            role="button" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false"> Dropdown </a>
                            <div class="dropdown-menu dropdown-menu-right"
                                aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a> <a
                                    class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div></li>
                    </ul>
                </div>
            </nav>
            <div class="container text-center">
                <!-- here we start the code of each page -->
                
                
                
                
                
                
                <div class="container text-center">
				<!-- here we start the code of each page -->
				<h3>New Borrow Request</h3>
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
						<input type="submit" class="btn btn-primary" value="Borrow" />
					</div>
				</form>
			</div>
                
                
                
                
                
                
            </div>
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <link href="css/simple-sidebar.css" rel="stylesheet">
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script
        src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            window.setTimeout(function() {
                $(".alert").fadeTo(1000, 0).slideUp(1000, function() {
                    $(this).remove();
                });
            }, 5000);
        });
    </script>
    <script type="text/javascript">
    #foo {
          resize: none;
        }
    </script>
    <!-- Menu Toggle Script -->
    <script>
        $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>
</body>
</html>