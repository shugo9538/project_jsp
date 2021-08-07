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
					<div class="inquire_list">
						<table>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>해결여부</th>
								<th>조회수</th>
							</tr>
							<tr>
								<td>1</td>
								<td>
									<a href="inquire.html"> 택배 오배송으로 도착하지 않았습니다. </a>
								</td>
								<td>홍길동</td>
								<td>2021.07.12.</td>
								<td>미해결</td>
								<td>11</td>
							</tr>
						</table>
					</div>
					<div class="right_sidebar">
						<ul>
							<li>
								<a href="#top"> 위로 </a>
							</li>
							<li>
								<a href="#bottom"> 아래로 </a>
							</li>
						</ul>
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