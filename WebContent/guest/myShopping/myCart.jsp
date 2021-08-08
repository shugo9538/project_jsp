<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<%@ page import="jsp_pj_lsj.vo.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/guest/account/page/styleSettings.jsp"%>
</head>
<body onload="checkAlert();">
	<c:choose>
		<c:when test="${sessionScope.vo != null}">
			<%@ include file="/common/jsp/header.jsp"%>
			<%@ include file="/common/jsp/nav.jsp"%>
			<section>
				<div class="content_width">
					<div class="titleline">
						<i class="fas fa-shopping-cart"> 장바구니 </i>
						<ul>
							<li>
								<b>장바구니</b>
								>
							</li>
							<li>주문/결제 ></li>
							<li>주문완료</li>
						</ul>
					</div>
					<hr>
					<div class="cart">
						<table>
							<tr>
								<th>
									<input type="checkbox" name="" value="">
									<label for="">전체선택</label>
								</th>
								<th>상품정보</th>
								<th>상품금액</th>
								<th>배송비</th>
							</tr>
							
							<!-- content -->
							<tr>
								<td rowspan="2">
									<input type="checkbox" name="" value="">
									<label for=""> img </label>
								</td>
								<td>충주사과</td>
								<td rowspan="2">12,900원</td>
								<td rowspan="2">무료</td>
							</tr>
							<tr>
								<td>
									7/15까지 도착 보장
									<select class="" name="">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
									12,900원
									<input type="button" name="" value="X">
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div border="1px solid">
					<table>
						<tr>
							<td>총 상품 가격 15,900원 + 배송비 0원 = 총 주문금액 15,900원</td>
						</tr>
					</table>
				</div>
				<div class="pager">
					<ul>
						<li>
							<button type="button" name="button">
								<a href="index.gu"> 계속 쇼핑하기 </a>
							</button>
						</li>
						<li>
							<button type="button" name="button">
								<a href="order.gu"> 구매하기 </a>
							</button>
						</li>
					</ul>
				</div>
			</section>
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