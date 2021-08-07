<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="" action="stockAddAction.adm" method="post">
	<legend>상품 추가</legend>
	<fieldset>
		<table>
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="productName" size="50">
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="text" name="productPrice" size="50">
				</td>
			</tr>
			<tr>
				<th>수량</th>
				<td>
					<input type="text" name="productStock" size="50">
				</td>
			</tr>
			<tr>
				<th>분류</th>
				<td>
					<select name="categoryId">
						<c:forEach items="${categoryVO}" var="category">
							<option value="${category.getCategoryId()}">
								${category.getCategoryName()}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>IMG</td>
				<td>
					<label for="upload_img"></label>
					<input type="file" id="upload_img" name="productImg" value="" accept="image/*">
				</td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td>
					<textarea name="productContent" rows="10" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<th>생산지</th>
				<td>
					<input type="text" name="productOrigin" size="50">
				</td>
			</tr>
			<tr>
				<th>생산자</th>
				<td>
					<input type="text" name="productProducer" size="50">
				</td>
			</tr>
			<tr>
				<th>EA</th>
				<td>
					<input type="text" name="productEA" size="50">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="추가"
				</td>
			</tr>
		</table>
	</fieldset>
</form>