<%@page import="ch.qos.logback.core.net.SyslogOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.com.mycom.myapp.UserDto"%>
<%
    UserDto userDto = (UserDto) session.getAttribute("userDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/alertify.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/alertify.min.css"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.14.0/build/css/themes/bootstrap.min.css"/>

<title>게시판</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container">
    <a class="navbar-brand" href="#">
        <img src="/assets/img/user/<%= userDto.getUserProfileImage() %>" style="width:24px; height:24px; border-radius:50%;"></img>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
<!--           <a class="nav-link" href="/pages/logout">Logout</a> -->
            <a class="nav-link" href="/auth/logout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container mt-3">
    <h4 class="text-center">게시판</h4>
    <div class="input-group mb-3">
      <input id="inputSearchWord" type="text" class="form-control" placeholder="검색어를 입력하세요.">
      <button id="btnSearchWord" class="btn btn-success" type="button">검색</button>
    </div>    
    
    <table class="table table-hover">
      <thead>
        <tr>
          <th>#</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일시</th>
          <th>조회수</th>
        </tr>
      </thead>
      <tbody id="boardTbody">
      </tbody>
    </table>  
    
    <div id="paginationWrapper"></div>
    
    <button type="button" id="btnInsertPage" class="btn btn-sm btn-primary">글쓰기</button>
</div>    
<div class="modal" tabindex="-1" id="detailBoardModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">글 상세</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       
        <div class="example table-responsive">
            <table class="table">
              <tbody>
                <tr><td>글번호</td><td id="boardIdDetail">#</td></tr>
                <tr><td>제목</td><td id="titleDetail">#</td></tr>
                <tr><td>내용</td><td id="contentDetail">#</td></tr>
                <tr><td>작성자</td><td id="userNameDetail">#</td></tr>
                <tr><td>작성일시</td><td id="regDtDetail">#</td></tr>
                <tr><td>조회수</td><td id="readCountDetail">#</td></tr>
              </tbody>
            </table>
        </div>             
       
        <button type="button" id="btnBoardUpdateForm" class="btn btn-sm btn-primary" data-bs-dismiss="modal">글 수정하기</button>
        <button type="button" id="btnBoardDeleteConfirm" class="btn btn-sm btn-warning" data-bs-dismiss="modal">글 삭제하기</button>
       
      </div>
    </div>
  </div>
</div>
<div class="modal" tabindex="-1" id="insertBoardModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">글 쓰기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        
        <div class="mb-3">
          <label for="titleInsert" class="form-label">제목</label>
          <input type="text" class="form-control" id="titleInsert">
        </div>
        <div class="mb-3">
          <label for="contentInsert" class="form-label">내용</label>
          <textarea class="form-control" id="contentInsert" rows="10"></textarea>
        </div>
        <button id="btnBoardInsert" class="btn btn-sm btn-primary" data-bs-dismiss="modal" type="button">등록</button>
        
      </div>
    </div>
  </div>
</div>

<div class="modal" tabindex="-1" id="updateBoardModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">글 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        
        <div class="mb-3">
          <label for="titleUpdate" class="form-label">제목</label>
          <input type="text" class="form-control" id="titleUpdate">
        </div>
        <div class="mb-3">
          <label for="contentUpdate" class="form-label">내용</label>
          <textarea class="form-control" id="contentUpdate" rows="10"></textarea>
        </div>
        <button id="btnBoardUpdate" class="btn btn-sm btn-primary" data-bs-dismiss="modal" type="button">수정</button>
        
      </div>
    </div>
  </div>
</div>

	<script src="/assets/js/util.js"></script>
	<script>
	
	    let LIST_ROW_COUNT = 10; // limit 해당 변수
	    let OFFSET = 0; // offset
	    let SEARCH_WORD = ''; // searchWord
	    let TOTAL_LIST_COUNT = 0; // 조회된 건수
	    
	    let PAGE_LINK_COUNT = 10; // 페이지에 보여줄 Pagination Button 수
	    let CURRENT_PAGE_INDEX = 1; // Pagination Button 들 중 현재 Page Button 번호
	
	    window.onload = function () {
	        // 글 목록
	        listBoard();
	
	        // 검색어 처리
	        document.querySelector("#btnSearchWord").onclick = function () {
	            SEARCH_WORD = document.querySelector("#inputSearchWord").value;
	            listBoard();
	        }
	
	        // 글 등록 모달
	        document.querySelector("#btnInsertPage").onclick = function () {
	            document.querySelector("#titleInsert").value = '';
	            document.querySelector("#contentInsert").value = '';
	
	            // show modal
	            let modal = new bootstrap.Modal(document.querySelector("#insertBoardModal"));
	            modal.show();
	        }
	
	        // 글 등록
	        document.querySelector("#btnBoardInsert").onclick = function () {
	            if (document.querySelector("#titleInsert").value == ''
	                || document.querySelector("#contentInsert").value == '') {
	                alert("제목 또는 내용을 모두 입력하세요.");
	                return;
	            }
	            insertBoard();
	        }
	
	        document.querySelector("#btnBoardUpdateForm").onclick = function () {
	            let boardId = document.querySelector("#detailBoardModal").getAttribute("data-boardId");
	            document.querySelector("#updateBoardModal").setAttribute("data-boardId", boardId);
	            document.querySelector("#titleUpdate").value = document.querySelector("#titleDetail").innerHTML;
	            document.querySelector("#contentUpdate").value = document.querySelector("#contentDetail").innerHTML;
	
	            let modal = new bootstrap.Modal(document.querySelector("#updateBoardModal"));
	            modal.show();
	        };
	
	        // 글 등록
	        document.querySelector("#btnBoardUpdate").onclick = function () {
	            if (document.querySelector("#titleUpdate").value == ''
	                || document.querySelector("#contentUpdate").value == '') {
	
	                return;
	            }
	            updateBoard();
	        }
	        
	        // 글 삭제
	        document.querySelector("#btnBoardDeleteConfirm").onclick = function () {
	        	// confirm
	            if (confirm("이 글을 삭제할까요?")){
	            	deleteBoard();
	            }
	        }
	    }
	
	    async function listBoard() {
	
	        let fetchOptions = {
	            headers: {
	                "ajax": "true"
	            }
	        }
	
	        let url = "/boards/list";
	        let urlParams = "?limit=" + LIST_ROW_COUNT + "&offset=" + OFFSET + "&searchWord=" + SEARCH_WORD;
	        let response = await fetch(url + urlParams, fetchOptions);
	        let data = await response.json();
	
	        console.log(data);
	
	        if (data.result == "success") {
	            makeListHtml(data.list)
	            TOTAL_LIST_COUNT = data.count;
	            addPagination();
	        } else if (data.result == "fail") { // newwork 장래, 일시, filter 거부 ....
	            alert("글 조회과정에서 오류 발생")
	        } else if (data.result == "login") {
	            window.location.href = "/pages/login";
	        } else if (data.result == "exception") { // business logic 처리 상황 ....
	            alert("글 조회 과정에서 예외 발생");
	        }
	        
// 	        else if(data.result == "fail" || data.result == "exception") {}
	    }
	
	    function makeListHtml(list) {
	        let listHTML = ``;
	
	        list.forEach(el => {
	            let boardId = el.boardId;
	            let userName = el.userName;
	            let title = el.title;
	            let content = el.content;
	            let regDt = el.regDt;
	            // LocalDateTime 객체 --> json 처리 결과물이 gson, jackson 2가지가 다르다.
	//              console.log(regDt);
	            let regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '/'); // 2024.07.11
	            let readCount = el.readCount;
	
	            listHTML += `<tr style="cursor:pointer" data-boardId=\${boardId}>
	                                <td>\${boardId}</td>
	                                <td>\${title}</td>
	                                <td>\${userName}</td>
	                                <td>\${regDtStr}</td>
	                                <td>\${readCount}</td>
	                            </tr>`;
	        });
	
	        document.querySelector("#boardTbody").innerHTML = listHTML;
	
	        document.querySelectorAll("#boardTbody tr").forEach(el => {
	            el.onclick = function () {
	                let boardId = this.getAttribute("data-boardId");
	                detailBoard(boardId);
	            }
	        });
	    }
	    
	    function addPagination(){
	    	// Pagination은 여러 화면에서 함께 사용될 수 있는 공통 컴포넌트
	    	// 한 곳에 만들어 두고 여러 화면에서 사용 => util.js에 구현하고 여기는 가져다 쓴다
	    	makePaginationHtml(LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_COUNT, "paginationWrapper");
	    }
	    
	    function movePage(pageIndex){
	    	OFFSET = (pageIndex - 1) * LIST_ROW_COUNT;
	    	CURRENT_PAGE_INDEX = pageIndex;
	    	listBoard();
	    }

	    async function updateBoard() {
	        let boardId = document.querySelector("#updateBoardModal").getAttribute("data-boardId");
	
	        let urlParams = new URLSearchParams({
	            boardId: boardId,
	            title: document.querySelector("#titleUpdate").value,
	            content: document.querySelector("#contentUpdate").value
	        })
	
	        let fetchOptions = {
	            headers: {
	                "ajax": "true"
	            },
	            method: "POST",
	            body: urlParams
	        }
	
	
	        let url = "/boards/update"
	        let response = await fetch(url, fetchOptions);
	        let data = await response.json();
	
	        console.log(data);
	
	        if (data.result == "success") {
	            alert("글이 수정되었습니다.")
	            listBoard();
	        } else if (data.result == "fail") {
	            alert("글 수정 과정에서 오류 발생")
	        } else if (data.result == "login") {
	            window.location.href = "/pages/login";
	        }
	    }
	
	    async function insertBoard() {
	        let urlParams = new URLSearchParams({
	            title: document.querySelector("#titleInsert").value,
	            content: document.querySelector("#contentInsert").value
	        })
	
	        let fetchOptions = {
	            headers: {
	                "ajax": "true"
	            },
	            method: "POST",
	            body: urlParams
	        }
	
	
	        let url = "/boards/insert"
	        let response = await fetch(url, fetchOptions);
	        let data = await response.json();
	
	        console.log(data);
	
	        if (data.result == "success") {
	       	  	alertify.success("글이 등록되었습니다");
	            listBoard();
	        } else if (data.result == "fail") {
	            /* alert("글 등록 과정에서 오류 발생") */
	       	  alertify.error("글 등록 과정에서 오류 발생");
	        } else if (data.result == "login") {
	            window.location.href = "/pages/login";
	        }
	    }
	
	    async function detailBoard(boardId) {
	        let fetchOptions = {
	            headers: {
	                "ajax": "true"
	            }
	        }
	
	        let url = "/boards/detail/" + boardId
	        let response = await fetch(url, fetchOptions);
	        let data = await response.json();
	
	        console.log(data);
	
	        if (data.result == "success") {
	            makeDetailHtml(data.dto)
	        } else if (data.result == "fail") {
	            alert("글 상세과정에서 오류 발생")
	        } else if (data.result == "login") {
	            window.location.href = "/pages/login";
	        }
	    }
	
	    function makeDetailHtml(dto) {
	        let regDt = dto.regDt;
	        let regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.') + ' ' +
	            makeTimeStr(regDt.time.hour, regDt.time.minute, regDt.time.second, ':');
	
	        document.querySelector("#detailBoardModal").setAttribute("data-boardId", dto.boardId);
	        document.querySelector("#boardIdDetail").innerHTML = "#" + dto.boardId;
	        document.querySelector("#titleDetail").innerHTML = dto.title;
	        document.querySelector("#contentDetail").innerHTML = dto.content;
	        document.querySelector("#userNameDetail").innerHTML = dto.userName;
	        document.querySelector("#regDtDetail").innerHTML = regDtStr; // dto 없이
	        document.querySelector("#readCountDetail").innerHTML = dto.readCount;
	
	        if (dto.sameUser) {
	            document.querySelector("#btnBoardUpdateForm").style.display = "inline-block";
	            document.querySelector("#btnBoardDeleteConfirm").style.display = "inline-block";
	        } else {
	            document.querySelector("#btnBoardUpdateForm").style.display = "none";
	            document.querySelector("#btnBoardDeleteConfirm").style.display = "none";
	        }
	
	        // show modal
	        let modal = new bootstrap.Modal(document.querySelector("#detailBoardModal"));
	        modal.show();
	    }
	    
	    async function deleteBoard() { // boardId 전송 필요, 나머지 데이터 필요 없음
	        let boardId = document.querySelector("#detailBoardModal").getAttribute("data-boardId");
	    
	        let fetchOptions = {
	            headers: {
	                "ajax": "true"
	            },
	        }
	        
	        let url = "/boards/delete/" + boardId;
	        let response = await fetch(url, fetchOptions);
	        let data = await response.json();
	
	        console.log(data);
	
	        if (data.result == "success") {
	        	alert("글이 삭제되었습니다.");
	        	listBoard();
	        } else if (data.result == "fail") {
	            alert("글 삭제과정에서 오류 발생")
	        } else if (data.result == "login") {
	            window.location.href = "/pages/login";
	        }
	    }
	</script>
</body>
</html>