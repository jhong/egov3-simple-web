<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javaScript" language="javascript">
//<![CDATA[
/* ********************************************************
 * top 버튼 조절
 ******************************************************** */
$(document).ready(function(){
	$(window).scroll(function(){
		if($(this).scrollTop() > 0) {
			$('.btn_top').fadeIn();
		} else {
			$('.btn_top').fadeOut();
		}
	});
	
	$(".btn_top").click(function(){
		$("html,body").animate({scrollTop:0}, 450);
		return false;
	});
});


/* ********************************************************
 * 브라우저 뒤로 가가 막기
 ******************************************************** */
 var backSpaceBlock = '${backSpaceBlock}';
 if("1" == backSpaceBlock){
	history.pushState(null, null, location.href);
	window.onpopstate = function(event){history.go(1);} 
 }
/* ********************************************************
 * F5 버튼 막기
 ******************************************************** */
 $(document).keydown(function(e){
	key = (e) ? e.keyCode : event.keyCode;
	if(key == 116){
		if(e){
			e.preventDefault();
		}else{
			event.keyCode = 0;
			event.returnValue =false;
		}
	}
});

// ]]>
</script>

<footer>
	<section id="footer-area">

		<section id="footer-outer-block">
			<aside class="footer-segment">
				<h4>[default] footer.jsp</h4>
				<ul>
					<li><a href="#">개인정보보호정책</a></li>
					<li><a href="#">이용약관</a></li>
					<li><a href="http://freehtml5templates.com">Free HTML5 Templates</a></li>
				</ul>
			</aside><!-- end of #first footer segment -->

			<aside class="footer-segment">
				<h4> </h4>
				<p>&copy; 2016 <a href="#">Sample</a>  All rights reserved.</p>
			</aside><!-- end of #fourth footer segment -->

			<aside class="footer-segment">
				<h4> </h4>
				<ul>
					<li><button type="button" class="btn_top">페이지 상단으로 가기</button></li>
				</ul>
			</aside><!-- end of #first footer segment -->
		</section><!-- end of footer-outer-block -->

	</section><!-- end of footer-area -->
</footer>
	
</div><!-- #wrapper -->
	