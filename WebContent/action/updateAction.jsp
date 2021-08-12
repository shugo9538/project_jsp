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
        <c:when test="${isUpdated == 1}">
            <script type="text/javascript">
            	setTimeout(() => {
                    window.location = "${redirectURL}";
                }, 10);
            </script>
        </c:when>
        
        <c:otherwise>
            <script type="text/javascript">
                setTimeout(() => {
                    alert("정보 수정 중 오류가 발생했습니다.");
                    window.history.back();
                }, 10);
            </script>
        </c:otherwise>
    </c:choose>
</body>
</html>