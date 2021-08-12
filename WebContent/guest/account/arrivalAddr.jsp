<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<article class="has_side">
			<%@ include file="/common/jsp/leftSideBar.jsp"%>
			<!-- main_content -->
			<div class="shippingAdd_list">
			<form action="arrivalAddrAddAction.gu" method="post">
				<table>
					<tr>
						<th>이름 :</th>
						<td>
							<input type="text" name="userName" value="${sessionScope.vo.getName()}">
					</tr>
					<tr>
						<th>주소 :</th>
						<td>
							<input type="text" name="arrival_address">
						</td>
					</tr>
					<tr>
						<th>전화번호 :</th>
						<td>
							<input type="text" name="arrival_phone" value="${sessionScope.vo.getTel()}">
						</td>
					</tr>
					<tr>
						<th>특이사항</th>
						<td>
							<select name="arrival_comment">
								<option value="부재시 문자주세요.">부재시 문자주세요.</option>
								<option value="부재시 문자주세요.">부재시 문자주세요.</option>
								<option value="부재시 문자주세요.">부재시 문자주세요.</option>
								<option value="부재시 문자주세요.">부재시 문자주세요.</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="배송지 추가 버튼">
						</td>
					</tr>
				</table>
			</form>
				<table>
					<tr>
						<td>홍길동</td>
						<td rowspan="4">
							<input type="button" name="" value="수정">
						</td>
					</tr>
					<tr>
						<td>서울특별시 금천구 남부순환로</td>
					</tr>
					<tr>
						<td>010-1234-5678</td>
					</tr>
					<tr>
						<td>부재시 문자주세요.</td>
					</tr>
				</table>
			</div>
			<%@ include file="/common/jsp/rightSideBar.jsp"%>
		</article>
	</section>
	<%@ include file="/common/jsp/footer.jsp"%>
	<div id="bottom" />
</body>
</html>