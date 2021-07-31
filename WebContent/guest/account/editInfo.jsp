<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<%@ page import="jsp_pj_lsj.vo.UserVO"%>
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
</head>
<body>
    <%@ include file="/common/jsp/header.jsp"%>
    <%@ include file="/common/jsp/nav.jsp"%>
    <section class="edit_info">
        <form class="editForm" name="editForm" action="editInfoAction.gu" method="post"
            onsubmit="return editFormCheck();"
        >
            <legned>
            <h1>회원정보 수정</h1>
            </legned>
            <fieldset>
                <table>
                    <tr>
                        <td>아이디(이메일)</td>
                        <td>
                            <input type="email" value="shugo9538@gmail.com" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td>
                            <input type="text" value="${sessionScope.vo.getName()}" name="name" disabled>
                            <button name="reName" onclick="editName()">이름변경</button>
                        </td>
                    </tr>
                    <tr>
                        <td>휴대폰 번호</td>
                        <td>
                            <input type="text" id="reTel" name="reTel" value="${sessionScope.vo.getTel()}"
                                maxlength="11" onkeyup="editTelCheck()"
                            >
                            <div id="telChecker" name="reTelChk" value="0">(-)없이 번호만 작성해주세요</div>
                        </td>
                    </tr>
                    <tr>
                        <td>현재 비밀번호</td>
                        <td>
                            <input type="password" name="pw">
                        </td>
                    </tr>
                    <tr>
                        <td>새 비밀번호</td>
                        <td>
                            <input type="password" name="rePw1">
                        </td>
                    </tr>
                    <tr>
                        <td>비밀번호 다시 입력</td>
                        <td>
                            <input type="password" name="rePw2">
                        </td>
                    </tr>
                    <tr>
                        <td>수신설정</td>
                        <td>
                            <input type="checkbox" name="alert" value="${sessionScope.vo.isAlertChk()}"
                                onclick="changeVal(this)"
                            >
                            광고 수신 동의
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input id="btn" type="submit" value="회원정보 수정">
                            <button id="btn" type="button" onclick="window.history.back();">나가기</button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <div>
            탈퇴를 원하시면 우측의 회원탈퇴 버튼을 눌러주세요.
            <button type="button" onclick="withdrawal.gu">회원탈퇴</button>
        </div>
    </section>
    <%@ include file="/common/jsp/footer.jsp"%>
</body>
</html>