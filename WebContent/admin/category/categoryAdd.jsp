<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form action="categoryAddAction.adm" method="post">
    <fieldset>
        <legend>카테고리 추가</legend>
        <table>
            <tr>
                <th>카테고리 명</th>
                <td>
                    <input type="text" name="category_name" required>
                </td>
                <td>
                    <input type="submit" value="카테고리 추가">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
