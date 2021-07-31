<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Goupang - 관리자</title>
<link rel="stylesheet" href="../guest/account/css/login.css">
<script src="https://kit.fontawesome.com/a9dbc227eb.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="login">
        <form class="login_form" action="category/categoryList.html" method="post">
            <fieldset>
                <legend>
                    <img src="../common/img/coupang_logo.png" alt="이미지" width="120px">
                </legend>
                <table>
                    <tr>
                        <th>
                            <label for="login_id">
                                <i class="far fa-envelope"></i>
                            </label>
                        </th>
                        <td>
                            <input type="email" id="login_id" placeholder="아이디(이메일)" size="50" required>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <label for="login_pw">
                                <i class="fas fa-unlock-alt"></i>
                            </label>
                        </th>
                        <td>
                            <input type="password" id="login_pw" placeholder="비밀번호" size="50" required>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="" value="로그인"
                                onclick="window.location='category/categoryList.html'"
                            >
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <div class="login_copyrihgt">@Goupang Corp. All rights reserved.</div>
    </div>
</body>
</html>