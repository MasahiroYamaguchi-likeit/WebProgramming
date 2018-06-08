<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログイン</title>
<link rel="stylesheet" type="text/css" href="css/Login.css">
</head>
<body>
	<c:if test="${errMsg != null}">
		<div class="alert alert-danger" role="alert">${errMsg}</div>
	</c:if>
	<div class="login">
		<div class="heading">

			<h1 class="login_title">Sign in</h1>

			<form action="LoginS" method="post">

				<div class="input-group input-group-lg">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" name="loginId" class="form-control"
						placeholder="UserID">
				</div>

				<div class="input-group input-group-lg">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="password" name="password" class="form-control"
						placeholder="Password">
				</div>

				<div class="button-area">
					<input type="submit" value="Login" class="float">
				</div>
			</form>
		</div>
	</div>
</body>
</html>