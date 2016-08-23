<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko" dir='ltr'>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>글로벌전시포탈 팝업</title>

	<link rel="stylesheet" type="text/css" href="<c:url value='/css/sample/default/style.css'/>" />

	<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.12.0.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/gep/common.js'/>"></script>

	<script type="text/javascript" src="<c:url value='/js/jquery-validation-1.14.0/dist/jquery.validate.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jquery-validation-1.14.0/dist/additional-methods.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jquery-validation-1.14.0/dist/localization/messages_ko.js'/>"></script>


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

</head>
<body>
<%--
[front-ovs] popup
--%>
<!-- s: popup wrap //-->
<div class="pop_wrap">
<div class="popup">
	<div class="pop_cont">
			
		<tiles:insertAttribute name="content">
			<tiles:putAttribute name="content_include" value="${content_include}"></tiles:putAttribute>
		</tiles:insertAttribute>
				
	</div>
</div>
</div>
<!--// e: popup wrap   -->
</body>
</html>