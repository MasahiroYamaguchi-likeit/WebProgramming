<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>更新</title>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/UserUpdate.css">
</head>
<body>
	<header>
		<nav
			class="navbar navbar-expand-md navbar-dark bg-dark fixed-top justify-content-end">
			<form class="form-inline my-2 my-lg-0">
				<div1>${userInfo.name}さん
				<button class="btn btn-outline-success my-2 my-sm-0"
					onClick="location.href='LogoutS'" type="button" value="logout">ログアウト</button>
				</div1>
			</form>
		</nav>
	</header>
	<form action="UserUpdateS" method="post">
		<table>

			<h1>ユーザー 情報更新</h1>
			<tr>
				<th><i>UserID</i></th>
				<td><input type="hidden" name=id value=${user.id}>${user.loginId }</td>
			</tr>
			<tr>
				<th>ユーザ名</th>
				<td><input type="text" name="name" value=${user.name }></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>パスワード（確認）</th>
				<td><input type="password" name="Cpassword"></td>
			</tr>
			<tr>
				<th>生年月日</th>
				<td><input type="date" name="birthdate"
					value=${user.birthDate }></td>
			</tr>
		</table>

		<div class=button1>
			<input type="submit" onClick="location.href='UserUpdateS'" value="更新"
				class=update>
			<div class="wrapper">
				<a href="#" onClick="location.href='UserListS'" class="button">戻る</a>
			</div>
		</div>
	</form>
	<c:if test="${errMsg != null}">
		<div class="alert alert-danger" role="alert">${errMsg}</div>
	</c:if>
</body>
</html>