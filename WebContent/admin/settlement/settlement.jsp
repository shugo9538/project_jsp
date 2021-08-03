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
							<th>총 판매액</th>
							<td>12,000원</td>
						</tr>
						<tr>
							<td colspan="2">
								<img alt="" src="../../common/img/다운로드.png">
							</td>
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