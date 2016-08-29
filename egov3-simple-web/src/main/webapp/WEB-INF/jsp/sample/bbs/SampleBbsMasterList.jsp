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

	
				
<form name="listForm" action="<c:url value='/bbs/SampleBbsList.do'/>" method="post">
<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>

<!-- 사이트정보 유지 start -->
<%//@ include file="/WEB-INF/jsp/gep/cmm/include/site_condition.jsp" %>
<!-- 사이트정보 유지 end -->


      		<%--
      		<article>
					<h2><a href="#">First Interesting Article or Section Title</a></h2>
					<img src="images/flowersky.jpg" alt="flower" class="alignleft" /><p>This one was created as I think of my friends in New Zealand going through an earthquake, hoping they stay safe. <a href="#">Duis sagittis ipsum</a>. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.  Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc. Duo partem graeco repudiare ne, vix cu graeci nostrud blandit. Agam graecis omnesque usu ut, veniam commune ne sit, vide lucilius complectitur at ius.</p> 
					<p>Eu eirmod interesset temporibus eum, sea cu amet reque quaestio. Qui erroribus assentior disputando an, quo quot accumsan menandri te, accumsan aliquando dissentias mei ea. Autem verear molestiae an mel, nominavi expetenda similique sit ei. Commodo utroque scribentur id nam, an ferri eruditi perpetua his, et has esse facer nominavi. Mei et essent dictas aliquip. Saepe eligendi phaedrum ne vix, sit putant eruditi eloquentiam at.</p>
		</article>
		--%>
				
      		<article>
					<h2><a href="#">게시판 종류</a></h2>
					<ul>
						<li><a href="<c:url value='/bbs/SampleBbsList.do?bbsId=BBSMSTR_000000000001'/>">일반게시판</a></li>
						<li><a href="<c:url value='/bbs/SampleBbsList.do?bbsId=BBSMSTR_000000000002'/>">익명게시판</a></li>
						<li><a href="<c:url value='/bbs/SampleBbsList.do?bbsId=BBSMSTR_000000000003'/>">공지게시판</a></li>
						<li><a href="<c:url value='/bbs/SampleBbsList.do?bbsId=BBSMSTR_000000000007'/>">갤러리</a></li>
					</ul>
		</article>

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
