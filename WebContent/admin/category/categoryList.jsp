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
        <article class="">
            <div class="has_side">
                <%@ include file="/admin/common/jsp/leftSideBar.jsp"%>
                <div class="inquire">
                    <table>
                        <tr>
                            <th>번호</th>
                            <th>카테고리명</th>
                            <th>추가/수정/삭제</th>
                        </tr>
                        <c:if test="${param.categoryVO eq not null}">
                            <c:forEach items="${param.categoryVO}" var="vo">
                                <tr>
                                    <td>
                                        <input type="checkbox" name="" value="${vo.getCategoryId}">
                                        <label for="">${vo.getCategoryId}</label>
                                    </td>
                                    <td>${vo.getCategoryName}</td>
                                    <td>
                                        <ul>
                                            <li>
                                                <button type="button" name="button">수정</button>
                                                <button type="button" name="button">삭제</button>
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
                                <input type="button" name="addBtn" onclick="window.location='categoryAdd.adm'" value="추가">
                            </li>
                        </ul>
                    </div>
                </div>
                <%@ include file="/admin/common/jsp/rightSideBar.jsp"%>
            </div>
        </article>
    </section>
    <div id="bottom" />
</body>
</html>