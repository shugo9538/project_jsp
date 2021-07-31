<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}css/default.css">
<link rel="stylesheet" href="${path}css/nav.css">
<link rel="stylesheet" href="${path}css/header.css">
<link rel="stylesheet" href="${path}css/section.css">
<link rel="stylesheet" href="${path}css/footer.css">
<script src="https://kit.fontawesome.com/a9dbc227eb.js" crossorigin="anonymous"></script>
<script src="guest/account/js/scripts.js"></script>
<link rel="stylesheet" href="guest/account/css/style.css">
<link rel="stylesheet" href="guest/css/productList.css">
</head>
<body>
    <%@ include file="/common/jsp/header.jsp"%>
    <%@ include file="/common/jsp/nav.jsp"%>
    <section>
        <h1>회원 탈퇴</h1>
        설문조사 탈퇴 사유를 체크해주세요.
        <form class="" action="withdrawalComplete.gu" method="post">
            <table>
                <tr>
                    <td>
                        <input type="radio" name="reason" id="choice1" value="reason1" checked>
                        <label for="choice1">회원탈퇴 후 재가입을 위해서</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="reason" id="choice2" value="reason1">
                        <label for="choice2">구매 빈도가 낮아 이용할 필요가 없어서</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="reason" id="choice3" value="reason1">
                        <label for="choice3">서비스 및 고객지원이 만족스럽지 못해서</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="reason" id="choice4" value="reason1">
                        <label for="choice4">인터넷 익스플로러 이외 브라우저 사용</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="reason" id="choice5" value="reason1">
                        <label for="choice5">타 플랫폼으로 이용이 어려워서</label>
                    </td>
                </tr>
            </table>
            <input type="submit" value="탈퇴신청">
        </form>
    </section>
    <%@ include file="/common/jsp/footer.jsp"%>
</body>
</html>