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
            <ul>
                <b>${sessionScope.vo.getName()}</b>
                <li onclick="window.location='logout.adm'">로그아웃</li>
            </ul>
        </div>
    </header>
    <!-- header end -->
</body>
</html>