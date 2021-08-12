<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<%@ page import="jsp_pj_lsj.vo.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/guest/account/styleSettings.jsp"%>
</head>
<body onload="checkAlert();">
	<c:choose>
		<c:when test="${sessionScope.vo != null}">
			<%@ include file="/common/jsp/header.jsp"%>
			<%@ include file="/common/jsp/nav.jsp"%>
			<section>
				<article class="has_side">
					<%@ include file="/common/jsp/leftSideBar.jsp"%>
					<div class="inquire">
						<form action="inquireAction.gu" method="post" enctype="multipart/form-data">
							<input type="hidden" name="userId" value="${vo.getEmail()}">
							<table>
								<tr>
									<th colspan="4">
										<input type="text" name="qnaTitle">
									</th>
								</tr>
								<tr>
									<td>작성자 :</td>
									<td>
										<input type="text" value="${vo.getName()}">
									</td>
									<td>작성일 :</td>
									<td>오늘</td>
								</tr>
								<tr>
									<td colspan="4">
										<input type="file" name="qnaImg1">
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<input type="file" name="qnaImg1">
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<textarea rows="5" cols="30" namen="qnaComment"></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<input type="submit" value="제출">
									</td>
								</tr>
							</table>
						</form>
						<div class="sub_menu">
							<div>
								<input type="button" onclick="window.location='inquireList.gu'" value="목록">
								<input type="button" onclick="window.location='qnaModify.gu'" value="수정">
								<input type="button" onclick="window.location='qnaDelete.gu'" value="삭제">
							</div>
						</div>
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