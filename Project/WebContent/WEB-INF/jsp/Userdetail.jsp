<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>詳細</title>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/Userdetail.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
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
	<table>

		<h1>ユーザー 詳細情報</h1>
		<tr>
			<th><i>UserID</i></th>
			<td>${user.loginId}</td>
		</tr>
		<tr>
			<th>ユーザー名</th>
			<td>${user.name}</td>
		</tr>
		<tr>
			<th>生年月日</th>
			<td>${user.birthDate}</td>
		</tr>
		<tr>
			<th>登録日時</th>
			<td>${user.createDate}</td>
		</tr>
		<tr>
			<th>更新日時</th>
			<td>${user.updateDate}</td>
		</tr>

	</table>
	<div class="wrapper">
		<a href="#"
			onClick="location.href='UserListS'"
			class="button">戻る</a>
	</div>
</body>
</html>