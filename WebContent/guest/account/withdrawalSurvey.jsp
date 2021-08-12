<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/guest/account/styleSettings.jsp"%>
</head>
<body>
    <%@ include file="/common/jsp/header.jsp"%>
    <%@ include file="/common/jsp/nav.jsp"%>
    <section>
        <form action="deleteUserAction.gu" class="withdrawalSForm" method="post">
            <fieldset>
                <legend> 회원 탈퇴 </legend>
                <table>
                    <tr>
                        <td>설문조사 탈퇴 사유를 체크해주세요.</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="reason" id="choice1" value="회원탈퇴 후 재가입을 위해서" checked>
                            <label for="choice1">회원탈퇴 후 재가입을 위해서</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="reason" id="choice2" value="구매 빈도가 낮아 이용할 필요가 없어서">
                            <label for="choice2">구매 빈도가 낮아 이용할 필요가 없어서</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="reason" id="choice3" value="서비스 및 고객지원이 만족스럽지 못해서">
                            <label for="choice3">서비스 및 고객지원이 만족스럽지 못해서</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="reason" id="choice4" value="인터넷 익스플로러 이외 브라우저 사용">
                            <label for="choice4">인터넷 익스플로러 이외 브라우저 사용</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="reason" id="choice5" value="타 플랫폼으로 이용이 어려워서">
                            <label for="choice5">타 플랫폼으로 이용이 어려워서</label>
                        </td>
                    </tr>
                    <tr>
                        <td id="submit">
                            <input type="submit" id="btn" value="탈퇴신청">
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </section>
    <%@ include file="/common/jsp/footer.jsp"%>
</body>
</html>