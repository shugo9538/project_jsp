<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
    <!-- nav -->
    <nav class="nav">
        <!-- nav_category -->
        <ul class="nav_category">
            <li>
                <i class="fas fa-bars"> </i>
                카테고리
            </li>
            <li>
                <ul>
                    <li>
                        <a href="guest/product/productList.html">과일</a>
                    </li>
                    <li>
                        <a href="#">야채</a>
                    </li>
                    <li>
                        <a href="#">육류</a>
                    </li>
                    <li>
                        <a href="#">유제품</a>
                    </li>
                    <li>
                        <a href="#">음료</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- nav_category end -->
        <!-- nav_logo -->
        <div class="nav_logo">
            <a href="index.gu">
                <img src="common/img/coupang_logo.png" alt="이미지" width="180px">
            </a>
        </div>
        <!-- nav_logo end -->
        <!-- nav_search -->
        <div class="nav_search">
            <input type="text" class="input" id="search" size="40">
            <input type="submit" class="btn_search" value="검색" width="75px" style="border: 1px solid"></input>
        </div>
        <!-- nav_search end -->
        <!-- nav_service -->
        <div class="nav_service">
            <a href="myOrder.gu">
                <i class="fas fa-user"></i>
            </a>
            <a href="myCart.gu">
                <i class="fas fa-shopping-cart"></i>
            </a>
        </div>
        <!-- nav_service end -->
    </nav>
    <!-- nav end -->
</body>
</html>