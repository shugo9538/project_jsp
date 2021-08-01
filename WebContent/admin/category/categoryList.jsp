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
    <c:choose>
        <c:when test="${isError == 0}">
            <script type="text/javascript">
                alert("카테고리 추가 오류");
            </script>
        </c:when>
        <c:when test="${isError == -1}">
            <script type="text/javascript">
                alert("카테고리 삭제 오류");
            </script>
        </c:when>
        <c:otherwise>
            <c:if test="${isOk != 1}">
                <c:redirect url="categoryList.adm"/>
            </c:if>
        </c:otherwise>
    </c:choose>
    <section>
        <article>
            <div class="has_side">
                <%@ include file="/admin/common/jsp/leftSideBar.jsp"%>
                <div class="inquire">
                    <%@ include file="/admin/category/categoryAdd.jsp"%>
                    <form action="" method="post">
                        <fieldset>
                            <table>
                                <tr>
                                    <th>
                                        <input type="checkbox" id="checker" name="checker" value=""
                                            onchange="allCheck()"
                                        >
                                        <label for="checker">번호</label>
                                    </th>
                                    <th>카테고리명</th>
                                    <th>추가/수정/삭제</th>
                                </tr>
                                <c:if test="${categoryVO != null}">
                                    <c:forEach var="vo" items="${categoryVO}" begin="0" end="10" step="1"
                                        varStatus="status"
                                    >
                                        <tr>
                                            <td>
                                                <input type="checkbox" name="categoryId" id="categoryId"
                                                    value="${vo.getCategoryId()}"
                                                >
                                                <label for="categoryId">${status.count}</label>
                                            </td>
                                            <td>
                                                <input type="text" value="${vo.getCategoryName()}" readonly>
                                            </td>
                                            <td>
                                                <input type="button" name="button"
                                                    onclick="window.location='categoryDeleteAction.adm?categoryId=${vo.getCategoryId()}'"
                                                    value="삭제"
                                                >
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <tr>
                                    <td colspan="3">
                                        <input type="submit" name="button" value="체크항목삭제">
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
    <div id="bottom" />
</body>
</html>