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
<link rel="stylesheet" type="text/css" href="<c:url value='/css/gep/front/ovs/import.css'/>" />
<link rel="stylesheet" type="text/css" href="/js/calendar/calendar.css" />

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.12.0.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/gep/common.js'/>"></script>
<!-- calendar js/css 추가 -->
<script type="text/javascript" src="/js/calendar/calendar.js"></script>
<script type="text/javascript" src="/js/calendar/calendar_beans_v2.0.js"></script>

<script type="text/javascript">
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
		$(elmt).removeAttr("onclick");
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
<!-- s: wrap //-->
<div id="wrap">


	<!-- s: content //-->
	<div id="content">
		
		<!-- s: cont_bg //-->
		<div id="cont_bg">

			<!-- s: sub content //-->
			<div class="sub_content" id="print_container">
			
				<tiles:insertAttribute name="content">
					<tiles:putAttribute name="content_include" value="${content_include}"></tiles:putAttribute>
				</tiles:insertAttribute>
				
			</div>
			<!--// e: sub content -->

		</div><!-- // cont_bg -->
	</div>
	<!--// e: content -->

</div>
<!-- //wrap end -->
</body>
</html>