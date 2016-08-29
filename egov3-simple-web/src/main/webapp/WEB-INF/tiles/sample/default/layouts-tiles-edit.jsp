<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko" dir='ltr'>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	 
	<title>글로벌전시포탈 - 해외전시</title>
	
<link rel="stylesheet" type="text/css" href="<c:url value='/css/sample/default/style.css'/>" />
	
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.12.0.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/sample/common.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/jquery-validation-1.14.0/dist/jquery.validate.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery-validation-1.14.0/dist/additional-methods.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery-validation-1.14.0/dist/localization/messages_ko.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>"></script>

<script type="text/javascript">
/* ********************************************************
 * validation 기본 세팅
 ******************************************************** */
$.validator.setDefaults({
	debug: false,
	onkeyup:false,
	onclick:false,
	onfocusout:false,
	//errorLabelContainer: "#validationResults",
	wrapper: "li",
	showErrors:function(errorMap, errorList){
		// error메시지를 하나씩 alert으로 보여줌
		if(this.numberOfInvalids()) {
			//var caption = $(errorList[0].element).attr('caption') || $(errorList[0].element).attr('name');
			alert(errorList[0].message);
			$(errorList[0].element).focus();
		}
		
		//alert("Your form contains "+ this.numberOfInvalids() + " errors, see details below.");
        //this.defaultShowErrors();
        //alert($("#validationResults").html());
        /*
        if ($("#validationResults").text() != "") {
        	$("#validationResults").dialog({ title: "다음 입력항목을 확인해주세요." });
        }
        */
	}
});
</script>


	<tiles:insertAttribute name="header"/> <!-- header : head 종료 / body start 포함 -->

	<section id="main"><!-- #main content and sidebar area -->
		<section id="content"><!-- #content -->

			<tiles:insertAttribute name="content">
				<tiles:putAttribute name="content_include" value="${content_include}"></tiles:putAttribute>
			</tiles:insertAttribute>

		</section><!-- end of #content -->

		<tiles:insertAttribute name="left"/>

	</section><!-- end of #main content and sidebar-->

	<tiles:insertAttribute name="footer"/>

<!-- progress circle -->
<div id="progressBack" class="progressBack"></div>
<div id="progressBar" class="progressBar">
	<center><img src="<c:url value='/images/sample/default/progress_circle.gif'/>" alt="progress_circle"/></center>
</div>

<script type="text/javascript">
/**
 * ajax 실행시 progress circle 보이기/숨기기
 */
$(document)
.ajaxStart(function(){ showProgress(); })
.ajaxStop(function(){ hideProgress(); });
</script>

</div>
<!-- //wrap end -->
</body>
</html>