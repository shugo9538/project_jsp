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
					<!-- 중앙 컨텐츠 -->
					<div class="main_body">
						<ul>
							<li>취소/반품/교환</li>
						</ul>
						<table class="refund">
							<tr>
								<th>반품접수일</th>
								<td>2021/07/04</td>
								<th>주문일</th>
								<td>2021/07/02</td>
								<th>주문번호</th>
								<td>5000000</td>
								<th>총 환불금액</th>
								<td>16,000원</td>
							</tr>
							<tr>
								<td colspan="5">사과</td>
								<td>1개</td>
								<td rowspan="2">환불 완료</td>
								<td rowspan="2">
									<ul>
										<li>
											<input type="button" name="" value="상세">
										</li>
										<li>
											<input type="button" name="" value="조회">
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<td colspan="5">충주 사과 1박스</td>
								<td>12,900원</td>
							</tr>
						</table>
					</div>
					<%@ include file="/common/jsp/rightSideBar.jsp"%>
				</article>
			</section>
			<div id="bottom" />
			<%@ include file="/common/jsp/footer.jsp"%>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
            	setTimeout(() => {
                    alert("로그인 후에 이용해 주세요!");
                   	window.history.back();
                }, 10);
            </script>
		</c:otherwise>
	</c:choose>
</body>
</html>