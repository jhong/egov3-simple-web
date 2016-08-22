<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
		xmlns:og="http://ogp.me/ns#"
		xmlns:fb="https://www.facebook.com/2008/fbml" lang="ko" xml:lang="ko" dir='ltr'>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="content-language" content="ko"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<%-- 
	<title>국내전시관리자</title>
	--%>
<tiles:useAttribute name="content_include" />
<tiles:insertDefinition name="layouts-default-blank">
  <tiles:putAttribute name="content" value="${content_include}" />
</tiles:insertDefinition>
	
<link rel="stylesheet" type="text/css" href="<c:url value='/css/sample/default/style.css'/>" />

<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.12.0.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/sample/common.js'/>"></script>
<%--
<!-- calendar js/css 추가 -->
<script type="text/javascript" src="/js/calendar/calendar.js"></script>
<script type="text/javascript" src="/js/calendar/calendar_beans_v2.0.js"></script>
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