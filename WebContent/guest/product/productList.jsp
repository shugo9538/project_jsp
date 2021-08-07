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
					<div class="left_side_nav">
						<h3>카테고리</h3>
						<ul>
							<li>
								<ul>
									<li>
										<a href="#"> 과일 </a>
									</li>
									<li>
										<a href="#"> 채소 </a>
									</li>
									<li>
										<a href="#"> 축산 </a>
									</li>
									<li>
										<a href="#"> 음료 </a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="main_text">
						<div class="small_list">
							<h3>식품 > 과일</h3>
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
							<tr>
								<td>
									<a href="productInfo.html">
										<table>
											<tr>
												<th>
													<img src="images/product_apple.jpg" alt="이미지">
												</th>
											</tr>
											<tr>
												<td>충주 세척사과 2kg 1박스</td>
											</tr>
											<tr>
												<td>14900원</td>
											</tr>
											<tr>
												<td>내일(일) 새벽 도착 보장</td>
											</tr>
											<tr>
												<td>
													<ul class="star_point">
														<li>
															<i class="far fa-star"></i>
														</li>
														<li>
															<i class="far fa-star"></i>
														</li>
														<li>
															<i class="far fa-star"></i>
														</li>
														<li>
															<i class="far fa-star"></i>
														</li>
														<li>
															<i class="far fa-star"></i>
														</li>
													</ul>
												</td>
											</tr>
										</table>
									</a>
								</td>
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