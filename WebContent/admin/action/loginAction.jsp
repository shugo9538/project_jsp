<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:choose>
        <c:when test="${isUser == 1}">
            <c:redirect url="loginComplete.adm?id=${id}"/>
        </c:when>
        <c:when test="${isUser == -1}">
            <script type="text/javascript">
                setTimeout(() => {
                    alert("비밀번호가 틀렸습니다. 다시확인해주세요.");
                    window.history.back();
                }, 10);
            </script>
        </c:when>
        <c:otherwise>
            <script type="text/javascript">
                setTimeout(() => {
                    alert("관리자 아이디가 아닙니다. 다시확인해주세요.");
                    window.history.back();
                }, 10);
            </script>
        </c:otherwise>
    </c:choose>
</body>
</html>