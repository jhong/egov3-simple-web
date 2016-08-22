<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko" dir='ltr'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>해외전시</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/sample/default/style.css'/>" />

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.12.0.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/gep/common.js'/>"></script>
<!-- calendar js/css 추가 -->
<script type="text/javascript" src="/js/calendar/calendar.js"></script>
<script type="text/javascript" src="/js/calendar/calendar_beans_v2.0.js"></script>

<script type="text/javascript">

function winprint(){

	var o1 = document.getElementById('pLayer1');
	var o2 = document.getElementById('pLayer2');
	
	o1.style.display = 'none';
	o2.style.display = 'none';
	
	window.print();
}

function init(){
	// a link 비활성화
	$("a").each(function(idx, elmt){
		//showlog("init() idx="+idx+", elmt="+$(elmt).attr("href"));
		$(elmt).attr("href", "#");
		$(elmt).removeAttr("onclick");
	});
	
	// button 비활성화
	$("button").each(function(idx, elmt){
		$(elmt).attr("type", "button"); // type="submit" 일 경우
		
		var onclickValue = $(elmt).attr("onclick");
		if (onclickValue != "winprint()" && onclickValue != "window.close()") { // [인쇄], [닫기] 버튼이 아닐 경우
			$(elmt).removeAttr("onclick");
		}
	});
}


$(document).ready(function(){
	init();
	$("div[class='pblc_tpbox']").hide(); // social link icon 숨기기
	$("div[class='btn_trwrap']").hide(); // button 숨기기
	$("div[class='btn_rwrap']").hide(); // button 숨기기
	
});

</script>
</head>
<body>
<div class="pop_pr_wrap"><!-- <div style="print_pop"> -->
<div class="popup_pr">
<div class="pop_pr_cont">

	<div id="pLayer1">
		<h1>페이지 인쇄</h1><p style="text-align:right;font-size:18px;margin:-15px 35px 10px 0;"><strong><button type="button"  onclick="winprint()">[인쇄]</button></strong></p>
		<div style="width:907px;align:center;width:auto;border:3px solid #628dc9;margin:10px 0 0 5px; padding:5px;">
		<p style="margin:10px 0 10px 0;line-height:150%;">
		* 배경이미지까지 인쇄하시려면 인터넷 설정을 변경하셔야 합니다.<br />
		* 변경방법은 '<b>도구 > 인터넷 옵션 > 고급 > 설정</b>'의 인쇄항목에서 '<b>배경색 및 이미지 인쇄</b>'항목을 체크 하세요.
		</p>
		</div>
	</div>
	
	
	<div class="contants">
	    <div class="con" id="div4">
	        <div class="cwarp">

			<!-- s: sub content //-->
			<div id="cssContent">
			
				<tiles:insertAttribute name="content">
					<tiles:putAttribute name="content_include" value="${content_include}"></tiles:putAttribute>
				</tiles:insertAttribute>
	        </div>
	    </div>
	</div>
	
	<!-- <div id="pLayer2" style="margin:0;width:auto;text-align:center;padding:10px 0 10px 0; clear:both;">
		<a href="javascript:window.close();">[닫기]</a>
	</div>-->
	<div class="btn_pwrap"  id="pLayer2" >
	<button type="button" class="btn_pclose"  onclick="window.close()">팝업창 닫기</button>
	</div>
	
</div>
</div>
</div>
</body>
</html>