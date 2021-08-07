<%@ page import="jsp_pj_lsj.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="settings.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
    <!-- header -->
    <header>
        <div class="user_state">
            <ul>
                <c:choose>
                    <c:when test="${sessionScope.vo.getName() eq null}">
                        <li onclick="window.location='login.gu'"> 로그인 </li>
                        <br>
                        <li onclick="window.location='signIn.gu'"> 회원가입 </li>
                        <br>
                    </c:when>
                    <c:otherwise>
                    <b> ${sessionScope.vo.getName()}님 환영합니다. </b>
                        <br>
                    <li onclick="window.location='logout.gu'"> 로그아웃 </li>
                        <br>
                    </c:otherwise>
                </c:choose>
                <li onclick="window.location='inquireList.gu'">고객센터</li>
            </ul>
        </div>
    </header>
    <!-- header end -->
</body>
</html>