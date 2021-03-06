<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/settings.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/guest/account/styleSettings.jsp"%>
</head>
<body onload="checkAlert();">
	<%@ include file="/common/jsp/header.jsp"%>
	<%@ include file="/common/jsp/nav.jsp"%>
	<section>
		<article>
			<div class="align_center">
				<div class="select_product">
					<table>
						<tr>
							<td>
								<img src="upload/product/${ProductVO.productImg}" alt="이미지" width="100%" height="100%">
							</td>
							<td>
								<table class="">
									<tr>
										<td colspan="2">${ProductVO.productName}</td>
										<td rowspan="2">
											<ul class="good_share">
												<li>
													<i class="far fa-heart"></i>
												</li>
												<li></li>
												<li>
													<i class="fas fa-share-alt"></i>
												</li>
											</ul>
										</td>
									</tr>
									<tr>
										<td>
											<ul class="small_star_point">
												<li>
													<i class="far fa-star"></i>
												</li>
											</ul>
										</td>
										<td>상품평</td>
									</tr>
									<tr>
										<td colspan="4">${ProductVO.getProductPrice()}</td>
									</tr>
									<tr>
										<td colspan="4">내일(일) 7/11 새벽 7시 전 도착 보장</td>
									</tr>
									<tr>
										<td>
											<input type="number" id="orderCnt" min="1">
										</td>
										<td>
											<input type="button" name="" value="장바구니">
										</td>
										<td>
											<input type="button" name="" value="바로구매" onclick="order(${ProductVO.productId}, orderCnt.value)">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
				<div class="nav_info">
					<ul>
						<li>
							<a href="#details"> 상품상세 </a>
						</li>
						<li>
							<a href="#evaluations"> 상품평 </a>
						</li>
						<li>
							<a href="#product_inquire"> 상품문의 </a>
						</li>
					</ul>
				</div>
				<div id="details"></div>
				<div class="nec_info">
					<table border="1px solid">
						<tr>
							<th colspan="4">필수 표기정보</th>
						</tr>
						<tr>
							<td>품목명</td>
							<td>사과</td>
							<td>단위</td>
							<td>${ProductVO.getProductEa()}</td>
						</tr>
						<tr>
							<td>생산자(수입자)</td>
							<td>${ProductVO.getProductProducer()}</td>
							<td>원산지</td>
							<td>${ProductVO.getProductOrigin()}</td>
						</tr>
					</table>
					<div class="">
						<pre>${ProductVO.getProductContent()}</pre>
					</div>
					<hr>
					<div id="evaluations"></div>
					<div class="titleline">
						<h3>상품평</h3>
					</div>
					<div class="small_play_list">
						<ul class="star_point">
							<li>
								<i class="far fa-star"></i>
							</li>
						</ul>
					</div>
					<div class="titleline">
						호평순 최신순
						<div class="">
							<input type="text" name="" size="15">
							<input type="submit" name="" value="검색">
							<select class="" name="">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</div>
					</div>
					<div class="review_list">
						<table>
							<tr>
								<td colspan="3">
									<ul class="" name="">
										<li value="1">
											<img src="images/product_apple.jpg" alt="" width="80px">
										</li>
										<li value="2">
											<img src="images/product_apple.jpg" alt="" width="80px">
										</li>
										<li value="3">
											<img src="images/product_apple.jpg" alt="" width="80px">
										</li>
										<li value="4">
											<img src="images/product_apple.jpg" alt="" width="80px">
										</li>
										<li value="5">
											<img src="images/product_apple.jpg" alt="" width="80px">
										</li>
									</ul>
								</td>
							</tr>
						</table>
						<table>
							<tr>
								<td rowspan="2">
									<i class="fas fa-user-circle"></i>
								</td>
								<td colspan="2">홍길동</td>
							</tr>
							<tr>
								<td colspan="2">
									<ul class="star_point">
										<li>
											<i class="far fa-star"></i>
										</li>
										<li>
											<i class="far fa-star"></i>
										</li>
										<li>
											<i class="far fa-star"></i>
										</li>
										<li>
											<i class="far fa-star"></i>
										</li>
										<li>
											<i class="far fa-star"></i>
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<td colspan="3">맛있어요</td>
							</tr>
							<tr>
								<table>
									<td>
										<button type="button" name="button">추천</button>
										<button type="button" name="button">비추천</button>
									</td>
									<td>
										<button type="button" name="button">신고</button>
									</td>
								</table>
							</tr>
						</table>
					</div>
					<br>
					<div id="product_inquire"></div>
					<div class="product_inquire">
						<div class="titleline">
							<h3>상품문의</h3>
							<button name="" value="문의하기">문의하기</button>
						</div>
						<hr>
						<table>
							<tr>
								<td colspan="2">
									<ul class="sec_small_list">
										<li>구매한 상품의 취소/반품은 마이쿠팡 구매내역에서 신청 가능합니다.</li>
										<li>상품문의 및 후기게시판을 통해 취소나 환불, 반품 등은 처리되지 않습니다.</li>
										<li>가격, 판매자, 교환/환불 및 배송 등 해당 상품 자체와 관련 없는 문의는 고객센터 내 1:1 문의하기를 이용해주세요.</li>
										<li>"해당 상품 자체"와 관계없는 글, 양도, 광고성, 욕설, 비방, 도배 등의 글은 예고 없이 이동, 노출제한, 삭제 등의 조치가 취해질 수 있습니다.</li>
										<li>공개 게시판이므로 전화번호, 메일 주소 등 고객님의 소중한 개인정보는 절대 남기지 말아주세요.</li>
									</ul>
								</td>
							</tr>
						</table>
						<table>
							<tr>
								<td>번호</td>
								<td>질문</td>
								<td>hong@gmail.com</td>
							</tr>
							<tr>
								<td>1</td>
								<td>충주사과 1박스</td>
								<td>오배송되어서 물건을 못받았습니다.</td>
							</tr>
						</table>
						</td>
						</tr>
						</table>
					</div>
				</div>
			</div>
			<%@ include file="/common/jsp/rightSideBar.jsp"%>
		</article>
	</section>
	<%@ include file="/common/jsp/footer.jsp"%>
	<div id="bottom" />
</body>
</html>