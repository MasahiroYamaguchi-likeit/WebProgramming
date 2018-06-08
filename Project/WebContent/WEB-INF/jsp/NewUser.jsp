<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新規登録</title>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/NewUser.css">

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
	<h1>ユーザー新規登録　　<a href="#" onClick="location.href='UserListS'" class="button">一覧へ</a></h1>
	<form action="NewUserS" method="post">
		<div class=font>
			<div class=Newdata>
				<b>
					<p>ユーザーID</p>
					<p>パスワード</p>
					<p>パスワード（確認）</p>
					<p>ユーザー名</p>
					<p>生年月日</p>
				</b>
			</div>

			<div class=form-position>

				<p>
					<input type="text" name="loginId" ID=form>
				</p>
				<p>
					<input type="password" name="password" ID=form>
				</p>
				<p>
					<input type="password" name="Cpassword" ID=form>
				</p>
				<p>
					<input type="text" name="name" ID=form>
				</p>
				<p>
					<input type="date" name="birthDate" value="YYYY-MM-DD" ID=date>
				</p>
			</div>
		</div>
		<p class=button1>
			<input onClick="location.href='NewUserS'" type="submit" value="登録"
				class=Registration>
		</p>
	</form>

	<footer>
		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" role="alert">${errMsg}</div>
		</c:if>
	</footer>

</body>
</html>