<%@ page import="java.util.ArrayList"%>
<%@ page import="jsp_pj_lsj.vo.CategoryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goupang - 관리자</title>
<%@ include file="/admin/common/jsp/styleSettings.jsp"%>
</head>
<body>
	<%@ include file="/admin/common/jsp/header.jsp"%>
	<%@ include file="/admin/common/jsp/nav.jsp"%>
	<section>
		<article>
			<div class="has_side">
				<%@ include file="/admin/common/jsp/leftSideBar.jsp"%>
				<div class="inquire">
					<table border="1px">
						<tr>
							<th>게시번호</th>
							<th>상품명</th>
							<th>닉네임</th>
							<th>후기 이미지</th>
							<th>후기</th>
							<th>리뷰날짜</th>
							<th>점수</th>
						</tr>
						<c:if test="${list != null}">
							<c:forEach items="${list}" var="reviewVO">
								<tr>
									<td>${reviewVO.review_id}</td>
									<td>${reviewVO.product_name}</td>
									<td>${reviewVO.user_name}</td>
									<td>
										<img src="upload/review/${reviewVO.review_img}" />
									</td>
									<td>${reviewVO.review_comment}</td>
									<td>${reviewVO.review_enrollment}</td>
									<td>${reviewVO.star_point}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${list == null}">
							<tr>
								<th>
									<h2>리뷰가 존재하지 않습니다.</h2>
								</th>
							</tr>
						</c:if>
					</table>
				</div>
				<%@ include file="/admin/common/jsp/rightSideBar.jsp"%>
			</div>
		</article>
	</section>
	<div id="bottom" />
</body>
</html>