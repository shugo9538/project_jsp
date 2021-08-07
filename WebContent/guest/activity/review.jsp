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
					<%@ include file="/common/jsp/leftSideBar.jsp"%>
					<div class="review">
						<h3>작성 리뷰 관리</h3>
						<hr>
						<table>
							<c:forEach item="" var="">
								<tr>
									<td>
										<table border="1px solid">
											<tr>
												<td>
													<img alt="" src="upload/review/apple1.png" width="150px">
												</td>
												<td>맛있어요</td>
												<td rowspan="2">
													<ul>
														<li>
															<input type="button" onclick="window.location='reviewModify.gu?id='" value="수정">
														</li>
														<li>
															<input type="button" onclick="window.location='reviewDelete.gu?id='" value="삭제">
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
							</c:forEach>
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
                   	window.history.back();
                }, 10);
            </script>
		</c:otherwise>
	</c:choose>
</body>
</html>