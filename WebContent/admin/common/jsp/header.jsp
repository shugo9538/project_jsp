<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- header -->
<header id="top">
	<div class="user_state">
		<c:if test="${sessionScope.vo != null}">
			<ul>
				<b>${sessionScope.vo.getName()}</b>
				<li onclick="window.location='logout.adm'">로그아웃</li>
			</ul>
		</c:if>
		<c:if test="${sessionScope.vo eq null}">
			<script>
                alert("비정상적인 접근입니다.");
                window.location = "admin.adm";
            </script>
		</c:if>
	</div>
</header>
<!-- header end -->
