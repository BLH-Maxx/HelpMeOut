<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
				<input type="number" min="3" max="36" step="3" class="form-control"
					name="period" value="${borrow.period}" />
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
</body>
</html>