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
                    window.location = ${nextPage};
                }, 10);
            </script>
        </c:when>
        
        <c:otherwise>
            <script type="text/javascript">
                setTimeout(() => {
                    alert(${insertError});
                    window.history.back();
                }, 10);
            </script>
        </c:otherwise>
    </c:choose>
</body>
</html>