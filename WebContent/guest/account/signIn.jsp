<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Goupang</title>
<link rel="stylesheet" href="guest/account/css/style.css">
<script src="https://kit.fontawesome.com/a9dbc227eb.js" crossorigin="anonymous"></script>
<script src="guest/account/js/scripts.js"></script>
</head>
<body>
    <div class="account">
        <form class="accountForm" name="signInForm" action="signInAction.gu" method="post" onsubmit="return formCheck();">
            <fieldset>
                <img src="common/img/coupang_logo.png" alt="이미지" width="195px" onclick="window.location='index.gu'">
                <table>
                    <tr>
                        <td colspan="2" align="left">
                            <b>회원정보를 입력해주세요.</b>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="signup_id">
                                <i class="far fa-envelope"></i>
                            </label>
                        </th>
                        <td>
                            <input type="email" id="signup_id" name="email" placeholder="아이디(이메일)" maxlength="50"
                                required
                            >
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="signup_pw">
                                <i class="fas fa-unlock-alt"></i>
                            </label>
                        </th>
                        <td>
                            <input type="password" id="signup_pw" name="pw" placeholder="비밀번호" maxlength="50" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="signup_repw">
                                <i class="fas fa-unlock-alt"></i>
                            </label>
                        </th>
                        <td>
                            <input type="password" id="signup_repw" name="repw" placeholder="비밀번호 확인" maxlength="50"
                                required
                            >
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="signup_name">
                                <i class="fas fa-user"></i>
                            </label>
                        </th>
                        <td>
                            <input type="text" id="signup_name" name="name" placeholder="이름" maxlength="50" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="signup_phone">
                                <i class="fas fa-mobile-alt"></i>
                            </label>
                        </th>
                        <td>
                            <input type="text" id="signup_phone" name="tel" placeholder="휴대폰번호" maxlength="11"
                                onkeyup="telCheck();" required
                            >
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="telChecker" name="telChecker" value="0">(-)없이 번호만 작성해주세요</div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" id="btn" value="회원가입">
                            <input type="reset" id="btn" value="취소" onclick="window.history.back();">
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <div class="login_copyrihgt">@Goupang Corp. All rights reserved.</div>
    </div>
</body>
</html>