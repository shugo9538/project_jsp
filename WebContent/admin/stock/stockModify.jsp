<%@ page import="java.util.ArrayList"%>
<%@ page import="jsp_pj_lsj.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<form action="stockModifyAction.pr" method="post" enctype="multipart/form-data">
						<input type="hidden" name="productId" value="${vo.getProductId()}">
						<legend>상품 수정</legend>
						<fieldset>
							<table>
								<tr>
									<th>상품명</th>
									<td>
										<input type="text" name="productName" size="50" value="${vo.getProductName()}">
									</td>
								</tr>
								<tr>
									<th>가격</th>
									<td>
										<input type="text" name="productPrice" size="50" value="${vo.getProductPrice()}">
									</td>
								</tr>
								<tr>
									<th>수량</th>
									<td>
										<input type="text" name="productStock" size="50" value="${vo.getProductStock()}">
									</td>
								</tr>
								<tr>
									<th>분류</th>
									<td>
										<select name="categoryId">
											<c:forEach items="${categoryVO}" var="category">
												<option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td>IMG</td>
									<td>
										<label for="upload_img"></label>
										<input type="file" id="upload_img" name="productImg" value="${vo.getProductImg()}" accept="image/*">
									</td>
								</tr>
								<tr>
									<th>상품설명</th>
									<td>
										<textarea name="productContent" rows="10" cols="50">${vo.getProductContent()}</textarea>
									</td>
								</tr>
								<tr>
									<th>생산지</th>
									<td>
										<input type="text" name="productOrigin" size="50" value="${vo.getProductOrigin()}">
									</td>
								</tr>
								<tr>
									<th>생산자</th>
									<td>
										<input type="text" name="productProducer" size="50" value="${vo.getProductProducer()}">
									</td>
								</tr>
								<tr>
									<th>EA</th>
									<td>
										<input type="text" name="productEA" size="50" value="${vo.getProductEa()}">
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" value="수정">
										<input type="reset" value="취소" onclick="window.history.back()">
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</div>
				<%@ include file="/admin/common/jsp/rightSideBar.jsp"%>
			</div>
		</article>
	</section>
</body>
</html>