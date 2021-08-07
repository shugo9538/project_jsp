<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="category_list">
	<aside>
		<ul>
			<c:forEach items="${sessionScope.categoryList}" var="vo">
				<li>
					<a href="productList.gu?categoryId=${vo.getCategoryId()}"> ${vo.getCategoryName()} </a>
				</li>
			</c:forEach>
		</ul>
	</aside>
</div>