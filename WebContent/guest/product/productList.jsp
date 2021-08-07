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
	<section>
		<article class="has_side">
			<%@ include file="/common/jsp/categoryList.jsp"%>
			<div class="main_text">
				<div class="small_list">
					<c:set var="category_id" value="${categoryId}"></c:set>
					<c:forEach items="${sessionScope.categoryList}" var="vo">
						<c:if test="${vo.getCategoryId() == category_id}">
							<h3>식품 > ${vo.getCategoryName()}</h3>
						</c:if>
					</c:forEach>
					<br>
					<ul>
						<li>인기순</li>
						<li>낮은가격순</li>
						<li>높은 가격순</li>
						<li>판매량순</li>
						<li>최신순</li>
					</ul>
				</div>
				<hr>
				<table>
					<c:if test="${list != null}">
						<c:forEach items="${list}" var="vo">
							<tr>
								<td>
									<a href="productDetail.gu?id=${vo.getProductId()}">
										<table>
											<tr>
												<th>
													<img src="images/product_apple.jpg" alt="이미지">
												</th>
											</tr>
											<tr>
												<td>${vo.getProductName()}</td>
											</tr>
											<tr>
												<td>${vo.getProductPrice()}</td>
											</tr>
											<tr>
												<td>내일(일) 새벽 도착 보장</td>
											</tr>
											<tr>
												<!-- 												<td> -->
												<!-- 													<ul class="star_point"> -->
												<%-- 														<c:forEach begin="1" end="${vo.getStarPoint}" --%>
												<%-- 														<li> --%>
												<%-- 															<i class="far fa-star" color="black"></i> --%>
												<%-- 														</li> --%>
												<%-- 														</c:forEach> --%>
												<!-- 													</ul> -->
												<!-- 												</td> -->
											</tr>
										</table>
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${list == null}">
						<tr>
							<th>
								<h2>상품이 존재하지 않습니다.</h2>
							</th>
						</tr>
					</c:if>
				</table>
			</div>
			<%@ include file="/common/jsp/rightSideBar.jsp"%>
		</article>
	</section>
	<%@ include file="/common/jsp/footer.jsp"%>
	<div id="bottom" />
</body>
</html>