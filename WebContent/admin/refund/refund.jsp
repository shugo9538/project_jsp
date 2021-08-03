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
							<th>리뷰 번호</th>
							<th>리뷰 상품</th>
							<th>리뷰 내용</th>
							<th>작성자</th>
							<th>삭제</th>
						</tr>
						<tr>
							<td>
								<input type="checkbox" name="" value="">
								<label for="">1</label>
							</td>
							<td>충주사과</td>
							<td>맛있어요.</td>
							<td>홍길동</td>
							<td>
								<button type="button" name="button">삭제</button>
							</td>
						</tr>
					</table>
					<button type="button" name="button">선택항목 삭제</button>
				</div>
				<%@ include file="/admin/common/jsp/rightSideBar.jsp"%>
			</div>
		</article>
	</section>
	<div id="bottom" />
</body>
</html>