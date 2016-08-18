<%
 /**
  * 게시판 상세 화면
  * @Class Name  : SampleBbsDetail.jsp
  * @author jhong 
  * @since 2016-08-17
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
<title>게시판 상세조회</title>
--%>
<script type="text/javaScript" language="javascript">
<!--
/* ********************************************************
 * 초기화
 ******************************************************** */
function fnInit(){
}
/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fnList(){
	//location.href = "<c:url value='/bbs/SampleBbsList.do' />";
	var varForm	= document.getElementById("detailForm");
	varForm.action = "<c:url value='/bbs/SampleBbsList.do' />";
	varForm.submit();
}
/* ********************************************************
 * 수정화면으로  바로가기
 ******************************************************** */
function fnModify(){
	var varForm = document.forms["detailForm"];
	varForm.action = "<c:url value='/bbs/SampleBbsEdit.do'/>";
	varForm.nttId.value = "${result.nttId}";
	varForm.bbsId.value = "${result.bbsId}";
	varForm.submit();
}
/* ********************************************************
 * 삭제 처리 함수
 ******************************************************** */
function fnDelete(){
	if (confirm("<spring:message code="common.delete.msg" />")) {
		var varForm = document.forms["detailForm"];
		varForm.action = "<c:url value='/bbs/SampleBbsRemove.do'/>";
		varForm.nttId.value = "${result.nttId}";
		varForm.submit();
	}
}
-->
</script>

<h3 class="title">게시판 상세조회</h3>

<!-- s: box  //-->
<div class="tb_wrap">
<table summary="게시판 상세조회 테이블이다." class="write">
<caption>게시판 상세조회</caption>
<colgroup>
	<col width="15%"/>
	<col width="35%"/>
	<col width="15%"/>
	<col width="35%"/>
</colgroup>
<tbody>
	<tr>
		<th scope="row">NTT_ID</th>
		<td> ${result.nttId}</td>
		<th scope="row">BBS_ID</th>
		<td> ${result.bbsId}</td>
	</tr>
	<tr>
		<th scope="row">NTT_NO</th>
		<td> ${result.nttNo}</td>
		<th scope="row">NTT_SJ</th>
		<td> ${result.nttSj}</td>
	</tr>
	<tr>
		<th scope="row">NTT_CN</th>
		<td> ${result.nttCn}</td>
		<th scope="row">ANSWER_AT</th>
		<td> ${result.answerAt}</td>
	</tr>
	<tr>
		<th scope="row">PARNTSCTT_NO</th>
		<td> ${result.parntscttNo}</td>
		<th scope="row">ANSWER_LC</th>
		<td> ${result.answerLc}</td>
	</tr>
	<tr>
		<th scope="row">SORT_ORDR</th>
		<td> ${result.sortOrdr}</td>
		<th scope="row">RDCNT</th>
		<td> ${result.rdcnt}</td>
	</tr>
	<tr>
		<th scope="row">USE_AT</th>
		<td> ${result.useAt}</td>
		<th scope="row">NTCE_BGNDE</th>
		<td> ${result.ntceBgnde}</td>
	</tr>
	<tr>
		<th scope="row">NTCE_ENDDE</th>
		<td> ${result.ntceEndde}</td>
		<th scope="row">NTCR_ID</th>
		<td> ${result.ntcrId}</td>
	</tr>
	<tr>
		<th scope="row">NTCR_NM</th>
		<td> ${result.ntcrNm}</td>
		<th scope="row">PASSWORD</th>
		<td> ${result.password}</td>
	</tr>
	<tr>
		<th scope="row">ATCH_FILE_ID</th>
		<td> ${result.atchFileId}</td>
		<th scope="row">FRST_REGIST_PNTTM</th>
		<td><fmt:formatDate value="${result.frstRegistPnttm}" type="date" pattern="yyyy-MM-dd" var="frstRegistPnttmFormat" />
			 ${frstRegistPnttmFormat}
		</td>
	</tr>
	<tr>
		<th scope="row">FRST_REGISTER_ID</th>
		<td> ${result.frstRegisterId}</td>
		<th scope="row">LAST_UPDT_PNTTM</th>
		<td><fmt:formatDate value="${result.lastUpdtPnttm}" type="date" pattern="yyyy-MM-dd" var="lastUpdtPnttmFormat" />
			 ${lastUpdtPnttmFormat}
		</td>
	</tr>
	<tr>
		<th scope="row">LAST_UPDUSR_ID</th>
		<td> ${result.lastUpdusrId}</td>
		<th scope="row"></th>
		<td> </td>
	</tr>
	<tr>
		<th height="23">첨부파일 목록</th>
		<td colspan="5">
		<c:import url="/cmm/fms/selectFileInfs.do" charEncoding="utf-8">
			<c:param name="param_atchFileId" value="${result.atchFileId}" />
		</c:import>
		</td>
	</tr>

</tbody>
</table>
</div>
<!--// e: box -->

<div class="btn_rwrap">				
	<button type="button" class="btn_bmbl" onclick="fnModify(); return false;">수정</button>
	<button type="button" class="btn_bmbl" onclick="fnDelete(); return false;">삭제</button>
	<button type="button" class="btn_bmg" onclick="fnList(); return false;">목록</button>
</div>

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
