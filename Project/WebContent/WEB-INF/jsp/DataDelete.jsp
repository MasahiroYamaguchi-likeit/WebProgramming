<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>退会</title>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/DataDelete.css">
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

	<h1>確認</h1>
	<p>ユーザーＩＤ：${user.loginId}(${user.name})</p>
	<p>を本当に削除しますか？</p>
	<div class=button>
		<button type="submit" onClick="location.href='DeleteS?Id=${user.id}'"
			class=button1>はい</button>
		<button type="button" onClick="location.href='UserListS'"
			class=button2>いいえ</button>
	</div>
</body>
</html>