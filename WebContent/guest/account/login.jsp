<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goupang</title>
<%@ include file="/guest/account/styleSettings.jsp"%>
</head>
<body>
    <div class="account">
        <form class="accountForm" action="loginAction.gu" method="post">
            <fieldset>
                <legend>
                    <img src="common/img/coupang_logo.png" alt="이미지" width="195px" onclick="window.location='index.gu'">
                </legend>
                <table>
                    <tr>
                        <th>
                            <label for="login_id">
                                <i class="far fa-envelope"></i>
                            </label>
                        </th>
                        <td>
                            <input type="email" id="login_id" name="email" placeholder="아이디(이메일)" size="50" required>
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
                            <div class="other_chk">
                                <div class="finder">
                                    <input type="checkbox" id="auto_login">
                                    <label for="auto_login">자동로그인</label>
                                </div>
                                <div class="finder">
                                    <div onclick="">비밀번호 찾기</div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" id="btn" value="로그인">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="button" id="btn" onclick="window.location='signIn.gu'" value="회원가입">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div class="login_copyrihgt">@Goupang Corp. All rights reserved.</div>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</body>
</html>