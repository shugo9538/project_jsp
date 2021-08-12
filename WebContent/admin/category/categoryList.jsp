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
					<%@ include file="/admin/category/categoryAdd.jsp"%>
					<form action="" method="post">
						<fieldset>
							<table>
								<tr>
									<th>
										<input type="checkbox" id="checker" name="checker" value="" onchange="allCheck()">
										<label for="checker">번호</label>
									</th>
									<th>카테고리명</th>
									<th>추가/수정/삭제</th>
								</tr>
								<c:if test="${sessionScope.categoryList != null}">
									<c:forEach var="vo" items="${sessionScope.categoryList}">
										<tr>
											<td>
												<input type="checkbox" name="categoryId" id="categoryId" value="${vo.getCategoryId()}">
												<label for="categoryId">${vo.getCategoryId()}</label>
											</td>
											<td>
												<input type="text" value="${vo.getCategoryName()}" readonly>
											</td>
											<td>
												<input type="button" name="button"
													onclick="window.location='categoryDeleteAction.pr?categoryId=${vo.getCategoryId()}'" value="삭제"
												>
											</td>
										</tr>
									</c:forEach>
								</c:if>
								<tr>
									<td colspan="3">
										<input type="submit" name="button" value="체크항목삭제">
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
					<table align="center">
						<tr>
							<th align="center">
								<c:if test="${cnt > 0}">
									<c:if test="${startPage > pageBlock}">
										<a href="categoryList.pr">[◀◀]</a>
										<a href="categoryList.pr?pageNum=${startPage - pageBlock}">[◀]</a>
									</c:if>
									<c:forEach var="i" begin="${startPage}" end="${endPage}">
										<c:if test="${i == currentPage}">
											<span>
												<b>[${i}]</b>
											</span>
										</c:if>
										<c:if test="${i != currentPage}">
											<a href="categoryList.pr?pageNum=${i}">[${i}]</a>
										</c:if>
									</c:forEach>
									<c:if test="${pageCnt > endPage}">
										<a href="categoryList.pr?pageNum=${startPage + pageBlock}">[▶]</a>
										<a href="categoryList.pr?pageNum=${pageCnt}">[▶▶]</a>
									</c:if>
								</c:if>
							</th>
						</tr>
					</table>
				</div>
				<%@ include file="/admin/common/jsp/rightSideBar.jsp"%>
			</div>
		</article>
	</section>
	<div id="bottom" />
</body>
</html>