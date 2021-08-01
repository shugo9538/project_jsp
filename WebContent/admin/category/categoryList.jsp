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
<%
%>
    <%@ include file="/admin/common/jsp/header.jsp"%>
    <%@ include file="/admin/common/jsp/nav.jsp"%>
    <c:if test="${isInsert != 1}">
        <script type="text/javascript">
        	alert("카테고리 추가 오류");
        </script>
    </c:if>
    <section>
        <article>
            <div class="has_side">
                <%@ include file="/admin/common/jsp/leftSideBar.jsp"%>
                <div class="inquire">
                    <%@ include file="/admin/category/categoryAdd.jsp" %>
                    <table>
                        <tr>
                            <th>번호</th>
                            <th>카테고리명</th>
                            <th>추가/수정/삭제</th>
                        </tr>
                        <c:if test="${categoryVO != null}">
                            <c:forEach var="vo" items="${categoryVO}" begin="0" end="10" step="1" varStatus="status">
                                <tr>
                                    <td>
                                        <input type="checkbox" name="" value="${status.count}">
                                        <label for="">${status.count}</label>
                                    </td>
                                    <td>${vo.getCategoryName()}</td>
                                    <td>
                                        <ul>
                                            <li>
                                                <input type="button" name="button" onclick="window.location=''" value="수정">
                                                <input type="button" name="button" onclick="window.location=''" value="삭제">
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
    <div id="bottom" />
</body>
</html>