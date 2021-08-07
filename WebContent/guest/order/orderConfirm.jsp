<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/jsp/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Goupang</title>
<%@ include file="common/jsp/styleSettings.jsp"%>
</head>
<body>
	<%@ include file="/common/jsp/header.jsp"%>
	<%@ include file="/common/jsp/nav.jsp"%>
	<!-- 엎을 부분 -->
	<section>
		<div class="titleline">
			<h2>주문이 완료되었습니다.</h2>
		</div>
		<hr>
		<div class="main_content">
			<div>
				<h3>받는사람 정보</h3>
				<table>
					</tr>
					<tr>
						<th>받는사람</th>
						<td>홍길동</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>서울시 금천구 남부순환로</td>
					</tr>
					<tr>
						<th>배송 요청사항</th>
						<td>경비실에 맡겨주세요</td>
					</tr>
				</table>
			</div>
			<div class="">
				<h3>결제 정보</h3>
				<table>
					</tr>
					<tr>
						<th>주문금액</th>
						<td>12,900원</td>
					</tr>
					<tr>
						<th>배송비</th>
						<td>+0원</td>
					</tr>
					<tr>
						<th>총 결제금액</th>
						<td>12,900원</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="">
			<button type="button" name="button">주문 상세보기</button>
			<button type="button" name="button">쇼핑 계속하기</button>
		</div>
	</section>
	<!-- 카테고리별 추천상품 종료 -->
	<!-- section end -->
	<%@ include file="/common/jsp/footer.jsp"%>
</body>
</html>