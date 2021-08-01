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
    <div class="inquire">
          <table>
            <tr>
              <th>번호</th>
              <th>재고명</th>
              <th>재고분류</th>
              <th>가격</th>
              <th>추가/수정/삭제</th>
            </tr>
            <tr>
              <td>
                <input type="checkbox" name="" value="1">
                <label for="">1</label>
              </td>
              <td>
                충주 사과 1kg
              </td>
              <td>
                과일
              </td>
              <td>
                12,000원
              </td>
              <td>
                <ul>
                  <li>
                    <button type="button" name="button">수정</button>
                    <button type="button" name="button">삭제</button>
                  </li>
                </ul>
              </td>
            </tr>
          </table>
          <div class="pager">
            <ul>
              <li>
                <button type="button" name="button">추가</button>
              </li>
            </ul>
          </div>
        </div>
</body>
</html>