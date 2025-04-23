<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>로긘</title>
</head>
<body>
	<!-- validation check  
		브라우저 내장 유효성 검사 X <= <form novalidate>
		BootStrap 제공 유효성 검사 O
	-->
	<div class="container">
		<div class="mb-3 mt-3 d-flex justify-content-center">
			<h1 class="display-4">폰켓몬 로그인</h1>
		</div>
		
		<div class="mb-3">
			<h2>로그인</h2>
		</div>
		
		<form novalidate>
			<div class="mb-3">
				<label for="userEmail" class="form-label">사용자 메일:</label>
				<input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="Endter Email">
			</div>
			<div class="mb-3">
				<label for="userPassword" class="form-label">비번밀호:</label>
				<input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Enter Password">
			</div>
			
		</form>
		<div>
			<button type="button" id="btnlogin" class="btn btn-success">로긘!!</button>
		</div>
		
	</div>
	
<script>
	window.onload = function() {
		// 버튼이 클릭되면 btnlogin 처리
		document.querySelector("#btnlogin").onclick = function() {
			// validation check
			if (document.querySelectorAll("#userEmail").value == ''  || 
				document.querySelectorAll("#userPassword").value == '') {
				alert("입력이 올바르지 않아")
				return;
			}
			login();
		}
		
	}
	
	// 로그인
	async function login() {
		// 사용자 입력 값
		let userEmail = document.querySelector("#userEmail").value;
		let userPassword = document.querySelector("#userPassword").value;
		
		// x-www-form-urlencoded
		let urlParams = new URLSearchParams({
			userEmail: userEmail,
			userPassword: userPassword,
			
		});
		
		//fetch Option
		let fetchOptions = {
				method: "POST",
				body: urlParams
		}
		
		let response = await fetch("/auth/login", fetchOptions);
		let data = await response.json();
		
		if(data.result == "success") {
			// 게시판 페이지 이동
			window.location.href="/pages/store"
		}else {
			alert("도감메일 또는 도감번호가 올바르지 않습니다")
		}
	}
</script>
</body>
</html>