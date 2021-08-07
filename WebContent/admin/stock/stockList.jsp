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
   	<c:choose>
		<c:when test="${isError == 0}">
			<script type="text/javascript">
                alert("제품 추가 오류");
            </script>
		</c:when>
		<c:when test="${isError == -1}">
			<script type="text/javascript">
                alert("제품 삭제 오류");
            </script>
		</c:when>
		<c:otherwise>
			<c:if test="${isOk != 1}">
				<c:redirect url="stockList.adm" />
			</c:if>
		</c:otherwise>
	</c:choose>
    <section>
        <article>
            <div class="has_side">
                <%@ include file="/admin/common/jsp/leftSideBar.jsp"%>
                <div class="inquire">
                	<c:if test="${isModify eq null}">
                	<input id="toggleBtn" type="button" onclick="toggleAdd();" value="상품 추가">
		                <div id="addProduct">
		                	<%@ include file="/admin/stock/stockAdd.jsp"%>
		                </div>
	                </c:if>
	                <c:if test="${isModify eq not null}">
		                <div>
		                	<%@ include file="/admin/stock/stockModify.jsp"%>
		                </div>
	                </c:if>
                    <table>
                        <tr>
                            <th>번호</th>
                            <th>재고명</th>
                            <th>재고분류</th>
                            <th>가격</th>
                            <th>추가/수정/삭제</th>
                        </tr>
                        <c:if test="${productVO != null}">
                        <c:forEach items="${productVO}" var="vo" varStatus="status" >
                            <tr>
                                <td>
                                    <input type="checkbox" name="${vo.getProductId()}" id="${vo.getProductId()}"
                                        value="${vo.getProductId()}"
                                    >
                                    <label for="${vo.getProductId()}">${status.count}</label>
                                </td>
                                <td>
                                    <input type="text" name="" value="${vo.getProductName()}" readonly>
                                </td>
                                <td>
                                    <input type="text" name="" value="${vo.getCategoryName()}" readonly>
                                </td>
                                </td>
                                <td>
                                    <input type="text" name="" value="${vo.getProductPrice()}" readonly>
                                </td>
                                </td>
                                <td>
                                    <ul>
                                        <li>
                                            <input type="button" name="modiBtn" onclick="window.location='stockModifyAction.adm?id=${vo.getProductId()}'" value="수정">
                                            <input type="button" name="delBtn" onclick="window.location='stockDeleteAction.adm?id=${vo.getProductId()}'" value="삭제">
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                        </c:forEach>
                        </c:if>
                    </table>
                </div>
                <%@ include file="/admin/common/jsp/rightSideBar.jsp"%>
            </div>
        </article>
    </section>
</body>
</html>