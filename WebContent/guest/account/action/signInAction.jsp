<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:choose>
        <c:when test="${isInsert == 1}">
            <script type="text/javascript">
            	setTimeout(() => {
            	    alert("회원가입되셨습니다. 이메일 인증 후 이용해 주세요. 로그인 후 이용해 주세요.");
                    window.location = "index.gu";
                }, 10);
            </script>
        </c:when>
        
        <c:when test="${isInsert == 2}">
            <script type="text/javascript">
                setTimeout(() => {
                    alert("이미 가입된 이메일입니다. 다시확인해주세요.");
                    window.history.back();
                }, 10);
            </script>
        </c:when>
        
        <c:otherwise>
            <script type="text/javascript">
                setTimeout(() => {
                    alert("회원가입에 실패했습니다. 다시확인해주세요.");
                    window.history.back();
                }, 10);
            </script>
        </c:otherwise>
    </c:choose>
</body>
</html>