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
 * 등록 화면 호출 함수 (jfile 사용)
 ******************************************************** */
function fnRegistJfile(){
	var listForm = document.forms["listForm"];
	listForm.action = "<c:url value='/bbs/SampleBbsJfileEntry.do'/>";
	listForm.pageIndex.value = 1;
   	listForm.submit();
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
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
<input type="hidden" name="bbsId" value="<c:out value='${searchVO.bbsId}'/>"/>

<!-- 사이트정보 유지 start -->
<%//@ include file="/WEB-INF/jsp/gep/cmm/include/site_condition.jsp" %>
<!-- 사이트정보 유지 end -->

<!-- s: box  //-->
<div class="box_g">
    <table summary="전체 게시판 검색:">
        <caption>전체 게시판 검색</caption>
        <colgroup>
            <col width="10%"/>
            <col width="35%"/>
            <col width="15%"/>
            <col width="40%"/>
        </colgroup>
        <tbody>
            <tr>
                <th scope="row"><label for="searchKeyword">전시회명</label>
                    <input type="hidden" name="searchCondition" value="edNameKr"/>
		<%-- 
   		<select id="searchCondition" name="searchCondition">
			<option selected="selected" value=''>--선택하세요--</option>
			<option value='nttSj' <c:if test="${searchVO.searchCondition == 'nttSj'}">selected="selected"</c:if>>NTT_SJ</option>
			<option value='ntcrId' <c:if test="${searchVO.searchCondition == 'ntcrId'}">selected="selected"</c:if>>NTCR_ID</option>
			<option value='ntcrNm' <c:if test="${searchVO.searchCondition == 'ntcrNm'}">selected="selected"</c:if>>NTCR_NM</option>		   
	   	</select>	   
		--%>
                </th>
                <td>
                    <input id="searchKeyword" name="searchKeyword" type="text" size="40" value="${searchVO.searchKeyword}" />
                </td>
                <th scope="row">[날짜항목명]
                    <input type="hidden" name="searchDateCondition" value=""/>
                    <%--
                    <select id="searchDateCondition" name="searchDateCondition">
                        <option value='openDate' <c:if test="${searchVO.searchCondition == 'openDate'}">selected="selected"</c:if>>전시회 시작일</option>
                    </select>
                    --%>
                </th>
                <td>
                    <label for="searchStartDate" class="blind">기간선택 시작</label>
                    <fmt:formatDate value="${searchVO.searchStartDate}" type="date" pattern="yyyy-MM-dd" var="searchStartDateFormat" />
                    <input type="text" id="searchStartDate" name="searchStartDate" size="11" maxlength="10" value="${searchStartDateFormat}" alt="시작기간 선택" onkeydown="allowNumberOnly(event);" onkeyup="convertDateKeyUp(this);" onfocus="convertDateFocus(this);" onblur="convertDateBlur(this);"/>
                    <a href="here" onclick="fn_jq_calendar('searchStartDate'); return false;" id="searchStartDate_img" title="검색시작일자 달력창 열림"><img src="${pageContext.request.contextPath}/images/sample/default/calendar.gif" name="searchStartDate_img" class="" alt="겁색시작일자 달력창 열림" /></a>
                    &nbsp;&nbsp;~&nbsp;&nbsp;
                    <label for="searchEndDate" class="blind">기간선택 끝</label>
                    <fmt:formatDate value="${searchVO.searchEndDate}" type="date" pattern="yyyy-MM-dd" var="searchEndDateFormat" />
                    <input type="text" id="searchEndDate" name="searchEndDate" size="11" maxlength="10" value="${searchEndDateFormat}" alt="끝나는 기간 선택" onkeydown="allowNumberOnly(event);" onkeyup="convertDateKeyUp(this);" onfocus="convertDateFocus(this);" onblur="convertDateBlur(this);"/>
                    <a href="here" onclick="fn_jq_calendar('searchEndDate'); return false;" id="searchEndDate_img" title="검색시작일자 달력창 열림"><img src="${pageContext.request.contextPath}/images/sample/default/calendar.gif" name="searchEndDate_img" class="" alt="겁색시작일자 달력창 열림" /></a>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<!--// e: box -->
<div class="btn_cwrap">
    <button type="submit" onclick="fnSearch(); return false;"  class="btn_bemp">검색</button>             
</div>

<h2>게시판 목록</h2>
<p class="count">총건수 <strong class="em_brd">${paginationInfo.totalRecordCount}</strong>건</p>


<!-- s: table //-->
<div class="tb_swrap">
    <table summary="게시판목록:" class="list">
		<caption>게시판 목록</caption>
		<colgroup>
           <col width="10%"/>
           <col width="10%"/>
           <col width="10%"/>
           <col width="10%"/>
           <col width="10%"/>
           <col width="10%"/>
           <col width="10%"/>
           <col width="10%"/>
           <col width="10%"/>
           <col width="10%"/>
		</colgroup>
		<thead>
		<tr>
			<th scope="col">순번</th>
			<th scope="col">링크</th>
			<th class="title" width="10%" scope="col">NTT_ID</th>
	<th class="title" width="10%" scope="col">BBS_ID</th>
	<th class="title" width="10%" scope="col">NTT_NO</th>
	<th class="title" width="10%" scope="col">NTT_SJ</th>
	<th class="title" width="10%" scope="col">NTT_CN</th>
	<th class="title" width="10%" scope="col">ANSWER_AT</th>
	<th class="title" width="10%" scope="col">PARNTSCTT_NO</th>
	<th class="title" width="10%" scope="col">ANSWER_LC</th>
	<th class="title" width="10%" scope="col">SORT_ORDR</th>
	<th class="title" width="10%" scope="col">RDCNT</th>
	<!--
	<th class="title" width="10%" scope="col">USE_AT</th>
	<th class="title" width="10%" scope="col">NTCE_BGNDE</th>
	<th class="title" width="10%" scope="col">NTCE_ENDDE</th>
	<th class="title" width="10%" scope="col">NTCR_ID</th>
	<th class="title" width="10%" scope="col">NTCR_NM</th>
	<th class="title" width="10%" scope="col">PASSWORD</th>
	<th class="title" width="10%" scope="col">ATCH_FILE_ID</th>
	<th class="title" width="10%" scope="col">FRST_REGIST_PNTTM</th>
	<th class="title" width="10%" scope="col">FRST_REGISTER_ID</th>
	<th class="title" width="10%" scope="col">LAST_UPDT_PNTTM</th>
	<th class="title" width="10%" scope="col">LAST_UPDUSR_ID</th>
	-->
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${resultList}" var="resultInfo" varStatus="status">
		<tr>
			<td><c:out value="${(searchVO.pageIndex - 1) * searchVO.pageSize + status.count}"/></td>
			<td class="lft">
				<a href="#" onclick="fnDetail('${resultInfo.nttId}', '${resultInfo.bbsId}'); return false;">
					${resultInfo.nttId}
				</a>
			</td>
			<td class="lt_text3">${resultInfo.nttId}</td>
	<td class="lt_text3">${resultInfo.bbsId}</td>
	<td class="lt_text3">${resultInfo.nttNo}</td>
	<td class="lt_text3">${resultInfo.nttSj}</td>
	<td class="lt_text3">${resultInfo.nttCn}</td>
	<td class="lt_text3">${resultInfo.answerAt}</td>
	<td class="lt_text3">${resultInfo.parntscttNo}</td>
	<td class="lt_text3">${resultInfo.answerLc}</td>
	<td class="lt_text3">${resultInfo.sortOrdr}</td>
	<td class="lt_text3">${resultInfo.rdcnt}</td>
	<!--
	<td class="lt_text3">${resultInfo.useAt}</td>
	<td class="lt_text3">${resultInfo.ntceBgnde}</td>
	<td class="lt_text3">${resultInfo.ntceEndde}</td>
	<td class="lt_text3">${resultInfo.ntcrId}</td>
	<td class="lt_text3">${resultInfo.ntcrNm}</td>
	<td class="lt_text3">${resultInfo.password}</td>
	<td class="lt_text3">${resultInfo.atchFileId}</td>
	<td class="lt_text3">
		<fmt:formatDate value="${resultInfo.frstRegistPnttm}" type="date" pattern="yyyy-MM-dd" var="frstRegistPnttmFormat" />
		${frstRegistPnttmFormat}
	</td>
	<td class="lt_text3">${resultInfo.frstRegisterId}</td>
	<td class="lt_text3">
		<fmt:formatDate value="${resultInfo.lastUpdtPnttm}" type="date" pattern="yyyy-MM-dd" var="lastUpdtPnttmFormat" />
		${lastUpdtPnttmFormat}
	</td>
	<td class="lt_text3">${resultInfo.lastUpdusrId}</td>
	-->	
		</tr>
		</c:forEach>

		<c:if test="${fn:length(resultList) == 0}">
		<tr>
			<td colspan="4"><spring:message code="common.nodata.msg" /></td>
		</tr>
		</c:if>

	</tbody>
</table>
</div>
<!--// e: table -->

<div class="btn_rwrap">				
	<button type="button" class="btn_mbl" onclick="fnRegist();">등록 (egov 기본 파일업로드 사용)</button>
	<button type="button" class="btn_mg" onclick="fnRegistJfile();">등록 (jfile 사용)</button>
</div>

<!-- s: paging //-->
<div class="page_wrap">
	<ul><ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="linkPage" /></ul>
</div>
<!--// e: paging -->

</form>

<form name="detailForm" id="detailForm" method="post" action="">
	<input type="hidden" name="nttId"/>
	<input type="hidden" name="bbsId"/>

	<!-- 검색조건 유지 start -->
    <%//@ include file="/WEB-INF/jsp/gep/cmm/include/search_condition.jsp" %>
    <!-- 검색조건 유지 end -->
</form>
