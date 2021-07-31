<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/guest/account/page/styleSettings.jsp"%>
</head>
<body>
    <%@ include file="/common/jsp/header.jsp"%>
    <%@ include file="/common/jsp/nav.jsp"%>
    
    <section>
    <article class="has_side">
      <div class="left_side_nav">
        <h3>
          MY Goupang
        </h3>
        <ul>
          <li>
            <h4>MY 쇼핑</h4>
            <ul>
              <li>주문목록/배송조회</li>
              <li>취소/반품/교환/환불 내역</li>

            </ul>
          </li>
          <li>
            <h4>MY 활동</h4>
            <ul>
              <li>문의하기</li>
              <li>문의내역 확인</li>
              <li>리뷰관리</li>
              <li>찜 리스트</li>
            </ul>
          </li>
          <li>
            <h4>MY 정보</h4>
            <ul>
              <li>개인정보확인/수정</li>

              <li>배송지 관리</li>
            </ul>
          </li>
        </ul>
      </div>
      <!-- sidebar end-->

      <!-- main_content -->
      <div class="shippingAdd_list">
        <table>
          <tr>
            <td>홍길동</td>
          </tr>
          <tr>
            <td>서울특별시 금천구 남부순환로</td>
          </tr>
          <tr>
            <td>010-1234-5678</td>
          </tr>
          <tr>
            <td>
              부재시 문자주세요.
            </td>
            <td>
              <input type="button" name="" value="수정">
            </td>
          </tr>
        </table>
        <input type="button" name="" value="배송지 추가 버튼">
      </div>

      <div class="right_sidebar">
        <ul>
          <li>
            <a href="#top">
              위로
            </a>
          </li>
          <li>
            <a href="#bottom">
              아래로
            </a>
          </li>
        </ul>
      </div>
    </article>
  </section>
  <div id="bottom" />
  <%@ include file="/common/jsp/footer.jsp"%>
</body>
</html>