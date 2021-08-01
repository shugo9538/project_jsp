<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/jsp/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goupang - 관리자</title>
<link rel="stylesheet" href="${loginStyle}style.css">
<%@ include file="common/jsp/styleSettings.jsp"%>
</head>
<body>
    <div class="account">
        <form class="accountForm" action="loginAction.adm" method="post">
            <fieldset>
                <legend>
                    <div>
                        <img src="${path}img/coupang_logo.png" alt="이미지" width="120px">
                        관리자 페이지
                    </div>
                </legend>
                <table>
                    <tr>
                        <th>
                            <label for="login_id">
                                <i class="far fa-envelope"></i>
                            </label>
                        </th>
                        <td>
                            <input type="email" id="login_id" name="email" placeholder="아이디" size="50" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="login_pw">
                                <i class="fas fa-unlock-alt"></i>
                            </label>
                        </th>
                        <td>
                            <input type="password" id="login_pw" name="pw" placeholder="비밀번호" size="50" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="로그인">
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <div class="login_copyrihgt">@Goupang Corp. All rights reserved.</div>
    </div>
</body>
</html>