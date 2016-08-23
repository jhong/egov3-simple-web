<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
		xmlns:og="http://ogp.me/ns#"
		xmlns:fb="https://www.facebook.com/2008/fbml" lang="ko" xml:lang="ko" dir='ltr'>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<%-- 
	<title>글로벌전시포탈</title>
	--%>
<tiles:useAttribute name="content_include" />
<tiles:insertDefinition name="layouts-default-blank">
  <tiles:putAttribute name="content" value="${content_include}" />
</tiles:insertDefinition>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/sample/default/style.css'/>" />

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.12.0.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/sample/common.js'/>"></script>

<%-- 
<script type="text/javascript">
// js error 처리
window.onerror = function(error, url, line) {
	errorSend(error, url, "${HOUSEKEY}", "${REMOTEADDR}", line);
	hideProgress(); // 에러 alert 띄운 후에는 progress circle 숨기기 (2013.10.02)
	return false;
};
</script>

<script type="text/javascript">
<!--
// InternetVersion
function getInternetVersion(ver) { 
 var rv = -1; // Return value assumes failure.      
 var ua = navigator.userAgent;  
 var re = null;
 if(ver == "MSIE"){
  re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
 }else{
  re = new RegExp(ver+"/([0-9]{1,}[\.0-9]{0,})");
 }
 if (re.exec(ua) != null){ 
  rv = parseFloat(RegExp.$1);
 } 
 return rv;  
} 
//브라우저 종류 및 버전확인  
 function browserCheck(){ 
  var ver = 0; // 브라우저  버전정보 
  if(navigator.appName.charAt(0) == "M"){
   ver = getInternetVersion("MSIE");
   
   if(ver == '6'){
	   alert("인터넷 익스플로러"+ver+"버전을 사용하고 계십니다. 브라우저를 업그레이드 해주세요.");
   }
  }
  } 
//-->
</script>
--%>

	<tiles:insertAttribute name="header"/> <!-- header : head 종료 / body start 포함 -->

	<!-- s: content //-->
	<div id="content">

		<tiles:insertAttribute name="left"/>

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

	<tiles:insertAttribute name="footer"/>

</div>
<!-- //wrap end -->
</body>
</html>