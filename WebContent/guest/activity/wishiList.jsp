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
				<article class="has_side">
					<%@ include file="/common/jsp/nav.jsp"%>
					<div class="inquire">
						<table>
							<tr>
								<th colspan="2">
									<input type="checkbox" name="" value="">
									전체선택
								</th>
								<th>
									<input type="button" name="" value="선택삭제">
								</th>
							</tr>
							<!-- content -->
							<tr>
								<td rowspan="2">
									<input type="checkbox" name="" value="">
									<label for="">
										<img src="../../common/img/ad1.jpg" alt="" width="150px">
									</label>
								</td>
								<td>충주 사과 1kg</td>
								<td rowspan="2">
									<ul>
										<li>
											<button type="button" name="button">장바구니 담기</button>
										</li>
										<li>
											<button type="button" name="button">삭제</button>
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<td>12,900원</td>
							</tr>
							<!-- end content -->
						</table>
						<hr>
						<input type="checkbox" name="" value="">
						<label for="">전체선택</label>
						<div class="pager">
							<ul>
								<li>
									<button type="button" name="button"><<</button>
								</li>
								<li>1</li>
								<li>
									<button type="button" name="button">>></button>
								</li>
							</ul>
						</div>
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