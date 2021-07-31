<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/common/jsp/page/settings.jsp"%>
</head>
<body>
    <form action="" name="editNameForm" method="post">
        <table>
            <tr>
                <th>개명한 이름 :</th>
                <td>
                    <input class="input" type="text" name="reName" maxlength="20" style="width: 150px" autofocus
                        required
                    >
                </td>
            </tr>
            <tr>
                <th colspan="2">
                    <input class="inputButton" type="button" value="확인" onclick="setName();">
                    <input class="inputButton" type="reset" value="취소" onclick="self.close();">
                </th>
            </tr>
        </table>
    </form>
</body>
</html>