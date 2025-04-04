<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>회가 원입</title>
</head>
<body>
	<!-- validation check  
		브라우저 내장 유효성 검사 X <= <form novalidate>
		BootStrap 제공 유효성 검사 O
	-->
	<div class="container">
		<div class="mb-3 mt-3 d-flex justify-content-center">
			<h1 class="display-4">바닥트리오</h1>
		</div>
		
		<div class="mb-3">
			<h2>회입 가원</h2>
		</div>
		
		<form novalidate>
			<div class="mb-3">
				<label for="userName" class="form-label">유우저의 이름:</label>
				<input type="text" class="form-control" id="userName" name="userName" placeholder="Enter User Name">
			</div>
			
			<div class="mb-3">
				<label for="userPassword" class="form-label">쉿! 비밀스러운 번호:</label>
				<input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Enter Password">
			</div>
			
			<div class="mb-3">
				<label for="userPassword2" class="form-label">진짜 이 비밀번호가 맞아?:</label>
				<input type="password" class="form-control" id="userPassword2" name="userPassword2" placeholder="Confirm Password">
			</div>
			
			<div class="mb-3">
				<label for="userEmail" class="form-label">너의 전자메일:</label>
				<input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="Endter Email">
			</div>
		</form>
		<div>
			<button type="button" id="btnRegister" class="btn btn-success">가하 입기</button>
		</div>
		
	</div>
	
	
	<script>
	
	</script>
</body>
</html>