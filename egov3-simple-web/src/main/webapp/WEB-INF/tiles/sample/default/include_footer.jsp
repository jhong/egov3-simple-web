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
	<!-- s: footer //-->
	<div id="footer">
		<div class="ft_link">
			<ul>
				<li>
					<a href="/etc/personal" class="priv">개인정보보호정책</a><span>l</span><a href="/etc/used">이용약관</a>	
				</li>
			</ul>
		</div>
		<ul>
			<li class="address">address / TEL:  / FAX: <br/>Copyright &copy; Sample. All rights reserved.</li>
		</ul>
		<!-- s: goto top //-->
		<div class="btn_topwrap">
			<ul>
				<li>
					<!-- 
					<button type="button" onclick="location.href='#header'" class="btn_top">페이지 상단으로 가기</button>
					 -->
					<button type="button" class="btn_top">페이지 상단으로 가기</button>
				</li>
			</ul>
		</div>
		<!--// e: goto top -->	
	</div>
	<!--// e: footer -->
