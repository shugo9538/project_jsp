<%@page import="jsp_pj_lsj.vo.QnaVO"%>
<%@page import="java.util.ArrayList"%>
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
		<c:when test="${isError == 0}">
			<script type="text/javascript">
                alert("문의 추가 오류");
            </script>
		</c:when>
		<c:when test="${isError == -1}">
			<script type="text/javascript">
                alert("문의 삭제 오류");
            </script>
		</c:when>
		<c:when test="${isError == -2}">
			<script type="text/javascript">
                alert("문의 수정 오류");
            </script>
		</c:when>
		<c:when test="${isOk != 1}">
			<c:redirect url="inquireList.qa" />
		</c:when>
		<c:when test="${sessionScope.vo != null}">
			<%@ include file="/common/jsp/header.jsp"%>
			<%@ include file="/common/jsp/nav.jsp"%>
			<section>
				<article class="has_side">
					<%@ include file="/common/jsp/leftSideBar.jsp"%>
					<div class="inquire_list">
						<table>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>첨부파일</th>
							</tr>
							<c:forEach items="${qnaList}" var="vo">
								<tr>
									<td>${vo.getQnaId()}</td>
									<td>
										<a href="inquireModify.qa?id="> ${vo.getQnaComment()} </a>
									</td>
									<td>${vo.getUserName()}</td>
									<td>${vo.getQnaDate()}</td>
									<td>
										<img src="upload/qna/${vo.getQnaImg()}" width="150px" height="150px"/>
									</td>
								</tr>
							</c:forEach>
						</table>
						<table align="center">
							<tr>
								<th align="center">
									<c:if test="${cnt > 0}">
										<c:if test="${startPage > pageBlock}">
											<a href="inquireList.qa">[◀◀ ]</a>
											<a href="inquireList.qa?pageNum=${startPage - pageBlock}">[◀ ]</a>
										</c:if>
										<c:forEach var="i" begin="${startPage}" end="${endPage}">
											<c:if test="${i == currentPage}">
												<span>
													<b>[${i}]</b>
												</span>
											</c:if>
											<c:if test="${i != currentPage}">
												<a href="inquireList.qa?pageNum=${i}">[${i}]</a>
											</c:if>
										</c:forEach>
										<c:if test="${pageCnt > endPage}">
											<a href="inquireList.qa?pageNum=${startPage + pageBlock}">[▶ ]</a>
											<a href="inquireList.qa?pageNum=${pageCnt}">[▶▶ ]</a>
										</c:if>
									</c:if>
								</th>
							</tr>
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