<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ユーザー一覧</title>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/Isometric.css">
<link rel="stylesheet" type="text/css" href="css/UserList.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
</head>
<body>
	<header>
		<nav
			class="navbar navbar-expand-md navbar-dark bg-dark fixed-top justify-content-end">
			<form class="form-inline my-2 my-lg-0">
				<div1>${userInfo.name}さん
				<button class="btn btn-outline-success my-2 my-sm-0" type="button"
					onclick="location.href='LogoutS'" value="logout">ログアウト</button>
				</div1>
			</form>
		</nav>
	</header>

	<main role="main" class="container">

	<div class="starter-template">
		<h1>ユーザー一覧</h1>
	</div>
	<div class="wrapper">
		<a href="NewUserS" class="button"
			onClick="location.href=userCreate.html">新規登録</a>
	</div>
	<form action="UserListS" method="post">
	<div class="form-group row">
		<label for="inputUserID" class="col-sm-2 col-form-label">ユーザーID</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="loginID"
				placeholder="UserID">
		</div>
	</div>

	<div class="form-group row">
		<label for="inputPassword" class="col-sm-2 col-form-label">ユーザー名</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="Name"
				placeholder="UserName">
		</div>
	</div>

	<div class="form-group row">
		<label for="inputDate" class="col-sm-2 col-form-label">生年月日</label>
		<div class="col-sm-10">
			<input type="date" name="Date" > ～ <input
				type="date" name="Date2" >
		</div>
	</div>
	<div class="sub">
		<input type="submit" value=" 検 索 " name="">
	</div>
	</form>
	</main>

	<p class="s3"></p>

	<div>
		<table class="tbl">
			<tr class="t1">
				<th>UserID</th>
				<th>ユーザー</th>
				<th>生年月日</th>
				<th>設定</th>
			</tr>
			<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.loginId}</td>
						<td>${user.name}</td>
						<td>${user.birthDate}</td>
						<td><a href="UserDetailS?id=${user.id}"
							onClick="location.href='UserDetailS'" class="isometric"> <span
								class="iconback isfb"><i class="de de-details"></i></span><span
								class="btnttl">詳細</span>
						</a> <c:if test="${userInfo.name==user.name || userInfo.name=='管理者'}">
								<a href="UserUpdateS?id=${user.id}"
									onClick="location.href='UserUpdateS'" class="isometric"> <span
									class="iconback isfdly"><i class="up up-update"></i></span><span
									class="btnttl">更新</span>
								</a>
							</c:if> <c:if test="${userInfo.name=='管理者'}">
								<a href="DataDeleteS?id=${user.id}"
									onClick="location.href='DataDeleteS'" class="isometric"> <span
									class="iconback ispkt"><i class="de de-get-delete"></i></span><span
									class="btnttl">削除</span>
								</a>
							</c:if></td>
					</tr>
			</c:forEach>

		</table>


	</div>
</body>

</html>