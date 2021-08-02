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
                    <table>
                        <tr>
                            <th>번호</th>
                            <th>재고명</th>
                            <th>재고분류</th>
                            <th>가격</th>
                            <th>추가/수정/삭제</th>
                        </tr>
                        <c:if test="${productVO != null}">
                        <c:forEach items="productVO" var="vo" varStatus="status">
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
                                    <input type="text" name="" value="${vo.getProductName()}" readonly>
                                </td>
                                </td>
                                <td>
                                    <input type="text" name="" value="${vo.getProductPrice()}" readonly>
                                </td>
                                </td>
                                <td>
                                    <ul>
                                        <li>
                                            <input type="button" name="button" onclick="" value="수정">
                                            <input type="button" name="button" onclick="" value="삭제">
                                        </li>
                                    </ul>
                                </td>
                            </tr>
                        </c:forEach>
                        </c:if>
                    </table>
                    <div class="pager">
                        <ul>
                            <li>
                                <button type="button" name="button">추가</button>
                            </li>
                        </ul>
                    </div>
                </div>
                <%@ include file="/admin/common/jsp/rightSideBar.jsp"%>
            </div>
        </article>
    </section>
</body>
</html>