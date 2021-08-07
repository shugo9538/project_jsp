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
								<th colspan="3">택배 오배송</th>
								<td>미해결</td>
							</tr>
							<tr>
								<td>작성자</td>
								<td>홍길동</td>
								<td>작성일</td>
								<td>2021/07/11</td>
							</tr>
							<tr>
								<td colspan="4">
									<input type="file" name="">
								</td>
							</tr>
							<tr>
								<td colspan="4">
									<input type="file" name="">
								</td>
							</tr>
							<tr>
								<td colspan="4">택배가 오배송됨</td>
							</tr>
						</table>
						<div class="sub_menu">
							<input type="button" name="" value="목록">
							<div>
								<input type="button" name="" value="수정">
								<input type="button" name="" value="삭제">
							</div>
						</div>
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