<%
 /**
  * 게시판 목록 화면
  * @Class Name  : SampleBbsList.jsp
  * @Modification Information
  * @author jhong 
  * @since 2016-08-11
  * @version 1.0
  */
%>

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--
<title>게시판 목록</title>
--%>
<script type="text/javaScript" language="javascript">
<!--
/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	var listForm = document.forms["listForm"];
	listForm.pageIndex.value = pageNo;
	listForm.action = "<c:url value='/bbs/SampleBbsList.do'/>";
   	listForm.submit();
}
/* ********************************************************
 * 조회 처리
 ******************************************************** */
function fnSearch(){
	var listForm = document.forms["listForm"];
	listForm.action = "<c:url value='/bbs/SampleBbsList.do'/>";
	listForm.pageIndex.value = 1;
   	listForm.submit();
}
/* ********************************************************
 * 등록 화면 호출 함수
 ******************************************************** */
function fnRegist(){
	var listForm = document.forms["listForm"];
	listForm.action = "<c:url value='/bbs/SampleBbsEntry.do'/>";
	listForm.pageIndex.value = 1;
   	listForm.submit();
}
/* ********************************************************
 * 수정 화면 호출 함수
 ******************************************************** */
function fnModify(){
	location.href = "";
}
/* ********************************************************
 * 상세회면 호출 함수
 ******************************************************** */
function fnDetail(selectedKey, selectedKey2){
	var varForm = document.forms["detailForm"];
	varForm.action = "<c:url value='/bbs/SampleBbsDetail.do'/>";
	varForm.nttId.value = selectedKey;
	varForm.bbsId.value = selectedKey2;
	varForm.submit();
}
/* ********************************************************
 * 초기화 작업
 ******************************************************** */
$(document).ready(function(){
}); 
-->
</script>

<h3 class="title">게시판</h3>   

<form name="listForm" action="<c:url value='/bbs/SampleBbsList.do'/>" method="post">
<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>

<!-- 사이트정보 유지 start -->
<%//@ include file="/WEB-INF/jsp/gep/cmm/include/site_condition.jsp" %>
<!-- 사이트정보 유지 end -->


<ul>
	<li><a href="<c:url value='/bbs/SampleBbsList.do?bbsId=BBSMSTR_000000000001'/>">일반게시판</a></li>
	<li><a href="<c:url value='/bbs/SampleBbsList.do?bbsId=BBSMSTR_000000000002'/>">익명게시판</a></li>
	<li><a href="<c:url value='/bbs/SampleBbsList.do?bbsId=BBSMSTR_000000000003'/>">공지게시판</a></li>
	<li><a href="<c:url value='/bbs/SampleBbsList.do?bbsId=BBSMSTR_000000000007'/>">갤러리</a></li>
</ul>




</form>

<form name="detailForm" id="detailForm" method="post" action="">
	<input type="hidden" name="nttId"/>
	<input type="hidden" name="bbsId"/>
    <%--
    <input type="submit" id="invisible" class="invisible"/>
    --%>
   <!-- 검색조건 유지 start -->
    <%//@ include file="/WEB-INF/jsp/gep/cmm/include/search_condition.jsp" %>
    <!-- 검색조건 유지 end -->
</form>
