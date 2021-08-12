<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<%@ page import="jsp_pj_lsj.vo.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/guest/account/styleSettings.jsp"%>
</head>
<body onload="checkAlert();">
	<c:choose>
		<c:when test="${sessionScope.vo != null}">
			<%@ include file="/common/jsp/header.jsp"%>
			<%@ include file="/common/jsp/nav.jsp"%>
			<section>
				<article class="has_side">
					<%@ include file="/common/jsp/leftSideBar.jsp"%>
					<!-- content -->
					<div class="main_body">
						<div class="headline">
							<h3>2021. 7. 15.</h3>
						</div>
						<table border="1px">
							<tr>
								<th colspan="3">오늘 도착 예정</th>
								<td rowspan="3">
									<button type="button" name="button">주문취소</button>
								</td>
							</tr>
							<tr>
								<td rowspan="2">
									<img src="../../common/img/ad1.jpg" alt="" width="150px">
								</td>
								<td colspan="2">사과</td>
							</tr>
							<tr>
								<td>12,900원</td>
								<td>
									<button type="button" name="button">장바구니 담기</button>
								</td>
							</tr>
						</table>
					</div>
					<%@ include file="/common/jsp/rightSideBar.jsp"%>
				</article>
			</section>
		<%@ include file="/common/jsp/footer.jsp"%>
	<div id="bottom" />
	</c:when>
		<c:otherwise>
			<script type="text/javascript">
            	setTimeout(() => {
                    alert("로그인 후에 이용해 주세요!");
                   	window.location="login.gu";
                }, 10);
            </script>
		</c:otherwise>
	</c:choose>
</body>
</html>