<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="" action="" method="post">
<legend>상품 수정</legend>
	<fieldset>
		<table>
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="" size="50">
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<input type="text" name="" size="50">
				</td>
			</tr>
			<tr>
				<th>수량</th>
				<td>
					<input type="text" name="" size="50">
				</td>
			</tr>
			<tr>
				<th>분류</th>
				<td>
					<selector>
						<c:forEach items="">
							<optional>
							</optional>
						</c:forEach>
					</selector>
				</td>
			</tr>
			<tr>
				<td>IMG</td>
				<td>
					<label for="upload_img"></label>
					<input type="file" id="upload_img" name="" value="" accept="image/*">
				</td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td>
					<textarea name="name" rows="10" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<th>생산지</th>
				<td>
					<input type="text" name="" size="50">
				</td>
			</tr>
			<tr>
				<th>생산자</th>
				<td>
					<input type="text" name="" size="50">
				</td>
			</tr>
			<tr>
				<th>EA</th>
				<td>
					<input type="text" name="" size="50">
				</td>
			</tr>
		</table>
	</fieldset>
</form>