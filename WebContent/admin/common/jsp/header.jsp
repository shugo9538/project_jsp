<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
    <!-- header -->
    <header id="top">
        <div class="user_state">
            ${sessionScope.vo.getName()}
            <a href="logout.adm"> 로그아웃 </a>
        </div>
    </header>
    <!-- header end -->
</body>
</html>