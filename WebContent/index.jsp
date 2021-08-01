<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/jsp/settings.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Goupang</title>
<%@ include file="common/jsp/styleSettings.jsp" %>
</head>
<body>
    <%@ include file="/common/jsp/header.jsp"%>
    <%@ include file="/common/jsp/nav.jsp"%>
    <section>
        <!-- 광고패널 -->
        <article class="adv">
            <div class="ad_background">
                <ul>
                    <li>광고1</li>
                    <li>광고2</li>
                    <li>광고3</li>
                </ul>
            </div>
        </article>
        <!-- 광고패널 종료 -->
        <!-- 카테고리별 추천상품 -->
        <article class="main_content">
            <div class="category_list">
                <aside>
                    <ul>
                        <li>
                            <a href="guest/product/productList.html"> 과일 </a>
                        </li>
                        <li>야채</li>
                        <li>육류</li>
                        <li>유제품</li>
                        <li>음료</li>
                    </ul>
                </aside>
            </div>
            <div class="product_list">
                <div class="product_table">
                    <table border="1px" class="main_table">
                        <tr>
                            <td rowspan="2">
                                <ul class="radio_ad">
                                    <li>
                                        <img src="common/img/apple1.png" alt="광고1" width="200px" height="400px">
                                    </li>
                                </ul>
                                </input>
                            </td>
                            <td>
                                <div class="product_img">
                                    <img src="common/img/apple1.png" alt="광고1" width="150px" height="150px">
                                </div>
                                <table>
                                    <tr>
                                        <th>사과1 :</th>
                                        <td>곰곰사과</td>
                                    </tr>
                                    <tr>
                                        <th>가격 :</th>
                                        <td>13,900원</td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <div class="product_img">
                                    <img src="common/img/apple2.png" alt="광고1" width="150px" height="150px">
                                </div>
                                <table>
                                    <tr>
                                        <th>사과2 :</th>
                                        <td>프레샤인사과</td>
                                    </tr>
                                    <tr>
                                        <th>가격 :</th>
                                        <td>16,900원</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="product_item">
                                    <div class="product_img">
                                        <img src="common/img/apple2.png" alt="광고1" width="150px" height="150px">
                                    </div>
                                    <div class="">
                                        <table>
                                            <tr>
                                                <th>사과3 :</th>
                                                <td>의성사과</td>
                                            </tr>
                                            <tr>
                                                <th>가격 :</th>
                                                <td>13,110원</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="product_img">
                                    <img src="common/img/apple3.png" alt="광고1" width="150px" height="150px">
                                </div>
                                <table>
                                    <tr>
                                        <th>사과4 :</th>
                                        <td>청송사과</td>
                                    </tr>
                                    <tr>
                                        <th>가격 :</th>
                                        <td>11,800원</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </article>
    </section>
    <!-- 카테고리별 추천상품 종료 -->
    <!-- section end -->
    <%@ include file="/common/jsp/footer.jsp"%>
</body>
</html>