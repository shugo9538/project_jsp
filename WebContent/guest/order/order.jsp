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
			<h2>주문/결제</h2>
			<ul class="small_play_list">
				<li>
					<u>
						<b>주문결제</b>
					</u>
				</li>
				<li>></li>
				<li>주문완료</li>
			</ul>
		</div>
		<hr>
		<div class="order_content">
			<h3>구매자</h3>
			<hr>
			<table>
				<tr>
					<td>이름</td>
					<td>홍길동</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>hong@gmail.com</td>
				</tr>
				<tr>
					<td rowspan="2">휴대폰 번호</td>
					<td>
						<div class="">
							<input type="text" name="" value="">
							<input type="button" name="" value="수정">
							쿠폰/티켓정보는 구매한 분의 번호로 전송됩니다.
						</div>
					</td>
				</tr>
				<tr>
					<td>* 인증 번호를 못 받았다면, 1577-7011 번호 차단 및 스팸 설정을 확인해 주세요.</td>
				</tr>
			</table>
		</div>
		<br>
		<div class="order_content">
			<div class="titleline">
				<h3>받는사람정보</h3>
				<div class="">
					<button>배송지변경</button>
				</div>
			</div>
			<hr>
			<table>
				<tr>
					<td>이름</td>
					<td>홍길동</td>
				</tr>
				<tr>
					<td>배송주소</td>
					<td>서울특별시 금천구 남부순환로</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>010-2816-4228</td>
				</tr>
				<tr>
					<td>배송 요청사항</td>
					<td>
						<select class="" name="" value="">
							<option value="">문 앞</option>
							<option value="">직접받고 부재 시 문 앞</option>
							<option value="">경비실</option>
							<option value="">택배함</option>
							<option value="">기타사항</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<div class="order_content">
			<div class="titleline">
				<h3>결제정보</h3>
			</div>
			<hr>
			<table>
				<tr>
					<td>총상품가격</td>
					<td>21,900원</td>
				</tr>
				<tr>
					<td>총결제가격</td>
					<td>21,900원</td>
				</tr>
				<tr>
					<td rowspan="2">결제방법</td>
					<td>
						<form class="" action="index.html" method="post">
							<fieldset>
								<input type="radio" name="" value="" select>
								<label for="">계좌이체</label>
								<input type="radio" name="" value="">
								<label for="">신용/체크카드</label>
								<input type="radio" name="" value="">
								<label for="">휴대폰</label>
								<input type="radio" name="" value="">
								<label for="">무통장입금(가상계좌)</label>
							</fieldset>
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td>선택</td>
								<td>
									<select class="" name="">
										<option value="농협">농협</option>
										<option value="신한">신한</option>
										<option value="우리">우리</option>
									</select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<div class="cfBtn">
			<input type="button" name="" value="결제하기" onclick="location.href='orderConfirm.html'">
			<input type="button" name="" value="취소하기" onclick="location.href='../../index.html'">
		</div>
	</section>
	<!-- section end -->
	<%@ include file="/common/jsp/footer.jsp"%>
</body>
</html>