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
					<div class="review">
						<h3>작성 리뷰 관리</h3>
						<hr>
						<table>
							<!-- 리스트2 -->
							<tr>
								<td>
									<table border="1px solid">
										<tr>
											<td>
												<img alt="" src="../../common/img/apple1.png" width="150px">
											</td>
											<td>맛있어요</td>
											<td rowspan="2">
												<ul>
													<li>
														<button type="button">수정</button>
													</li>
													<li>
														<button type="button">삭제</button>
													</li>
												</ul>
											</td>
										</tr>
										<tr>
											<td>별점</td>
											<td>2021.07.11</td>
										</tr>
									</table>
								</td>
							</tr>
							<!-- 리스트2 -->
							<tr>
								<td>
									<table border="1px solid">
										<tr>
											<td>
												<img alt="" src="../../common/img/apple2.png" width="150px">
											</td>
											<td>신선해요</td>
											<td rowspan="2">
												<ul>
													<li>
														<button type="button">수정</button>
													</li>
													<li>
														<button type="button">삭제</button>
													</li>
												</ul>
											</td>
										</tr>
										<tr>
											<td>별점</td>
											<td>2021.07.11</td>
										</tr>
									</table>
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