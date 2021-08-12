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
        <div class="content_width">
            <div class="titleline">
                <h3>회원탈퇴</h3>
                <ul class="this1">
                    <li>
                        <b>
                            <u>본인 인증</u>
                        </b>
                    </li>
                    <li>></li>
                    <li>설문조사</li>
                    <li>></li>
                    <li>완료</li>
                </ul>
            </div>
            <form action="withdrawalAction.gu" method="post" name="withdrawalForm" class="withdrawalForm" onsubmit="return formChk();">
                <fieldset>
                    <table>
                        <tr>
                            <td colspan="8">
                                <ol>
                                    <li>회원님 구팡 서비스를 이용하시는데 불편함이 있으셨나요?</li>
                                    <li>구팡에서 발송하는 메일 수신거부는 '구팡 > 마이구팡 > 내정보'에서 확인하세요</li>
                                    <li>이용 불편 및 각종 문의 사항은 고객센터로 문의 주시면 성심 성의껏 답변 드리겠습니다.</li>
                                    <li>자주 묻는 질문 / 1:1 온라인 문의 / 전화 문의: 1577-7011 (365일 오전 9시~오후6시)</li>
                                </ol>
                                <hr>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="8">
                                <ol>
                                    <li>1. 회원탈퇴 전, 유의사항을 확인해 주시기 바랍니다.</li>
                                    <li>회원탈퇴 시 회원전용 웹 서비스 이용이 불가합니다.</li>
                                    <li>거래정보가 있는 경우, 전자상거래 등에서의 소비자 보호에 관한 법률에 따라 계약 또는 청약철회에 관한 기록, 대금결제 및 재화 등의
                                        공급에 관한 기록은 5년동안 보존됩니다.</li>
                                    <li>유효기간이 경과되지 않은 미사용 쿠폰관련 정보는 유효기간 만료일까지 보관되며, 탈퇴 후에도 유효기간 내 사용하실 수 있습니다.</li>
                                    <li>유효기간 내 사용하지 못한 미사용 쿠폰은 구매금액의 70%를 구팡캐시로 적립해 드리나, 탈퇴시 적립 받을 수 없습니다.</li>
                                    <li>보유하셨던 구팡캐시는 탈퇴와 함께 삭제되며 환불되지 않습니다.</li>
                                    <li>회원탈퇴 후 구팡 서비스에 입력하신 상품문의 및 후기, 댓글은 삭제되지 않으며, 회원정보 삭제로 인해 작성자 본인을 확인할 수 없어
                                        편집 및 삭제처리가 원천적으로 불가능 합니다.</li>
                                    <li>상품문의 및 후기, 댓글 삭제를 원하시는 경우에는 먼저 해당 게시물을 삭제하신 후 탈퇴를 신청하시기 바랍니다.</li>
                                    <li>이미 결제가 완료된 건은 탈퇴로 취소되지 않습니다.</li>
                                </ol>
                                <hr>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="8">
                                <input type="checkbox" name="chk">
                                상기 구팡 회원탈퇴 시 처리 사항 안내를 확인하였음에 동의합니다.
                                <hr>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="8">보안을 위해 회원님의 이름과 계정 이메일 및 비밀번호를 확인 합니다.<hr></td>
                        </tr>
                        <tr>
                            <td>이름 :</td>
                            <td>
                                <input type="text" value="${vo.getName()}" readonly>
                            </td>
                            <td>이메일 :</td>
                            <td>
                                <input type="email" value="${vo.getEmail()}" readonly>
                            </td>
                            <td>비밀번호 :</td>
                            <td>
                                <input type="password" name="pw" required>
                            </td>
                            <td>
                                <input type="submit" value="회원탈퇴" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>
    </section>
    <%@ include file="/common/jsp/footer.jsp"%>
</body>
</html>