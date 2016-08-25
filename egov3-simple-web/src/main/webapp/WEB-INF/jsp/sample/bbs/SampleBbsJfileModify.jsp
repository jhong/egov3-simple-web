<%
 /**
  * 게시판 수정 화면
  * @Class Name  : SampleBbsModify.jsp
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="jwork" uri="http://www.egovframe.go.kr/tags/ext/jfile/jsp"%>
<%--
<title>게시판 수정</title>
--%>

<%@ include file="/WEB-INF/jsp/sample/cmm/include/jfile_include.jsp" %>

<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>" ></script>
<script type="text/javaScript" language="javascript">
<!--

/* ********************************************************
 * validation
 ******************************************************** */
$(function(){
	$("#sampleBbs").validate({
        submitHandler: function() {
            var f = confirm("<spring:message code="common.update.msg" />'");
            if(f){
            	document.sampleBbs.action = "<c:url value='/bbs/SampleBbsJfileModify.do'/>";
            	showProgress(); // 중복실행 방지 위해 progress circle 보이기
                return true;
            } else {
                return false;
            }
        },
		rules: {
			nttId: { required:false, maxbyte:25, number:true },
			bbsId: { required:true, maxbyte:20 },
			nttNo: { required:false, maxbyte:25, number:true },
			nttSj: { required:true, maxbyte:2000 },
			nttCn: { required:true },
			answerAt: { required:true, maxbyte:1 },
			parntscttNo: { required:false, maxbyte:15, number:true },

			answerLc: { required:false, maxbyte:13, number:true },
			sortOrdr: { required:false, maxbyte:13, number:true },
			rdcnt: { required:false, maxbyte:15, number:true },
			useAt: { required:true, maxbyte:1 },
			ntceBgnde: { required:false, maxbyte:20 },
			ntceEndde: { required:false, maxbyte:20 },
			ntcrId: { required:false, maxbyte:20 },

			ntcrNm: { required:false, maxbyte:20 },
			password: { required:false, maxbyte:200 },
			atchFileId: { required:false, maxbyte:20 },
			frstRegistPnttm: { required:false, maxbyte:10 },
			frstRegisterId: { required:false, maxbyte:20 },
			lastUpdtPnttm: { required:false, maxbyte:10 },
			lastUpdusrId: { required:false, maxbyte:20 }
		},
		messages: {
			nttId: { required:"NTT_ID 은(는) 필수 항목입니다."
					, maxbyte:"NTT_ID 은(는) {0}자 이하로 입력해주세요."
					, number:"NTT_ID 은(는) 숫자만 입력 가능합니다." },
			bbsId: { required:"BBS_ID 은(는) 필수 항목입니다."
					, maxbyte:"BBS_ID 은(는) {0}자 이하로 입력해주세요." },
			nttNo: { required:"NTT_NO 은(는) 필수 항목입니다."
					, maxbyte:"NTT_NO 은(는) {0}자 이하로 입력해주세요."
					, number:"NTT_NO 은(는) 숫자만 입력 가능합니다." },
			nttSj: { required:"NTT_SJ 은(는) 필수 항목입니다."
					, maxbyte:"NTT_SJ 은(는) {0}자 이하로 입력해주세요." },
			nttCn: { required:"NTT_CN 은(는) 필수 항목입니다." },
			answerAt: { required:"ANSWER_AT 은(는) 필수 항목입니다."
					, maxbyte:"ANSWER_AT 은(는) {0}자 이하로 입력해주세요." },
			parntscttNo: { required:"PARNTSCTT_NO 은(는) 필수 항목입니다."
					, maxbyte:"PARNTSCTT_NO 은(는) {0}자 이하로 입력해주세요."
					, number:"PARNTSCTT_NO 은(는) 숫자만 입력 가능합니다." },

			answerLc: { required:"ANSWER_LC 은(는) 필수 항목입니다."
					, maxbyte:"ANSWER_LC 은(는) {0}자 이하로 입력해주세요."
					, number:"ANSWER_LC 은(는) 숫자만 입력 가능합니다." },
			sortOrdr: { required:"SORT_ORDR 은(는) 필수 항목입니다."
					, maxbyte:"SORT_ORDR 은(는) {0}자 이하로 입력해주세요."
					, number:"SORT_ORDR 은(는) 숫자만 입력 가능합니다." },
			rdcnt: { required:"RDCNT 은(는) 필수 항목입니다."
					, maxbyte:"RDCNT 은(는) {0}자 이하로 입력해주세요."
					, number:"RDCNT 은(는) 숫자만 입력 가능합니다." },
			useAt: { required:"USE_AT 은(는) 필수 항목입니다."
					, maxbyte:"USE_AT 은(는) {0}자 이하로 입력해주세요." },
			ntceBgnde: { required:"NTCE_BGNDE 은(는) 필수 항목입니다."
					, maxbyte:"NTCE_BGNDE 은(는) {0}자 이하로 입력해주세요." },
			ntceEndde: { required:"NTCE_ENDDE 은(는) 필수 항목입니다."
					, maxbyte:"NTCE_ENDDE 은(는) {0}자 이하로 입력해주세요." },
			ntcrId: { required:"NTCR_ID 은(는) 필수 항목입니다."
					, maxbyte:"NTCR_ID 은(는) {0}자 이하로 입력해주세요." },

			ntcrNm: { required:"NTCR_NM 은(는) 필수 항목입니다."
					, maxbyte:"NTCR_NM 은(는) {0}자 이하로 입력해주세요." },
			password: { required:"PASSWORD 은(는) 필수 항목입니다."
					, maxbyte:"PASSWORD 은(는) {0}자 이하로 입력해주세요." },
			atchFileId: { required:"ATCH_FILE_ID 은(는) 필수 항목입니다."
					, maxbyte:"ATCH_FILE_ID 은(는) {0}자 이하로 입력해주세요." },
			frstRegistPnttm: { required:"FRST_REGIST_PNTTM 은(는) 필수 항목입니다."
					, maxbyte:"FRST_REGIST_PNTTM 은(는) {0}자 이하로 입력해주세요." },
			frstRegisterId: { required:"FRST_REGISTER_ID 은(는) 필수 항목입니다."
					, maxbyte:"FRST_REGISTER_ID 은(는) {0}자 이하로 입력해주세요." },
			lastUpdtPnttm: { required:"LAST_UPDT_PNTTM 은(는) 필수 항목입니다."
					, maxbyte:"LAST_UPDT_PNTTM 은(는) {0}자 이하로 입력해주세요." },
			lastUpdusrId: { required:"LAST_UPDUSR_ID 은(는) 필수 항목입니다."
					, maxbyte:"LAST_UPDUSR_ID 은(는) {0}자 이하로 입력해주세요." }
		}
	});
});


/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fnList(){
	//location.href = "<c:url value='/bbs/SampleBbsList.do' />";
	var varForm	= document.getElementById("sampleBbs");
	varForm.action = "<c:url value='/bbs/SampleBbsList.do' />";
	varForm.submit();
}
/* ********************************************************
 * 저장처리화면
 ******************************************************** */
function fnModify(form){
	/*
	if(confirm("<spring:message code="common.save.msg" />")){
			$(form).submit();
	}
	*/
	$(form).submit();
}


/* ********************************************************
 * 초기화 작업
 ******************************************************** */
$(document).ready(function(){

});	
-->
</script>

<h3 class="title">게시판 수정</h3>

<form:form commandName="sampleBbs" name="sampleBbs" method="post" action="" enctype="multipart/form-data" >
<input name="cmd" type="hidden" value="Modify"/>
<form:hidden path="nttId"/>
<input type="hidden" name="fileListCnt" value="0" />
<%--
<input type="hidden" name="posblAtchFileNumber" value="<c:out value='${bdMstr.posblAtchFileNumber}'/>" />
<input type="hidden" name="posblAtchFileSize" value="<c:out value='${bdMstr.posblAtchFileSize}'/>" />
--%>
<input type="hidden" name="posblAtchFileNumber" value="3" />
<input type="hidden" name="posblAtchFileSize" value="" />
<input type="hidden" name="returnUrl" value="<c:url value='/bbs/SampleBbsEdit.do'/>"/>

<!-- 검색조건 유지 start -->
<%//@ include file="/WEB-INF/jsp/gep/cmm/include/search_condition.jsp" %>
<!-- 검색조건 유지 end -->

<div class="c_box">
	<ul>
		<li><em>*</em> 표시는 필수 입력입니다.</li>
	</ul>
</div>					
<!--  s:button -->
<div class="btn_rwrap">				
	<button type="button" class="btn_bmbl" onclick="fnModify(document.sampleBbs); return false;">저장</button>
	<button type="button" class="btn_bmg" onclick="fnList(); return false;">목록</button>
</div>
<!--  e:button -->			

<h4>게시판 정보</h4>

<!-- s: table //-->
<div class="tb_wrap">

<!-- validation 결과 표시 -->
<ul id="validationResults"><li></li></ul>

<table summary="게시판 수정 테이블이다." class="write">
	<caption>게시판 정보</caption>
	<colgroup>
		<col width="18%"/>
		<col width="30%"/>
		<col width="18%"/>
		<col width="34%"/>
	</colgroup>
	<tbody>
	<tr>
		<th scope="row"><label for="nttId">NTT_ID</label></th>
		<td>
			<form:input  path="nttId" size="10" maxlength="25" id="nttId" />
			<form:errors path="nttId" cssClass="error"/>
		</td>
		<th scope="row"><label for="bbsId">BBS_ID</label></th>
		<td>
			<form:input  path="bbsId" size="20" maxlength="20" id="bbsId" />
			<form:errors path="bbsId" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="nttNo">NTT_NO</label></th>
		<td>
			<form:input  path="nttNo" size="10" maxlength="25" id="nttNo" />
			<form:errors path="nttNo" cssClass="error"/>
		</td>
		<th scope="row"><label for="nttSj">NTT_SJ</label></th>
		<td>
			<form:input  path="nttSj" size="20" maxlength="2000" id="nttSj" />
			<form:errors path="nttSj" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="nttCn">NTT_CN</label></th>
		<td colspan="3">
			<form:textarea  path="nttCn" id="nttCn" cols="70" rows="7" htmlEscape="False" />
			<form:errors path="nttCn" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="answerAt">ANSWER_AT</label></th>
		<td colspan="3">
			<form:input  path="answerAt" size="1" maxlength="1" id="answerAt" />
			<form:errors path="answerAt" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="parntscttNo">PARNTSCTT_NO</label></th>
		<td>
			<form:input  path="parntscttNo" size="10" maxlength="15" id="parntscttNo" />
			<form:errors path="parntscttNo" cssClass="error"/>
		</td>
		<th scope="row"><label for="answerLc">ANSWER_LC</label></th>
		<td>
			<form:input  path="answerLc" size="10" maxlength="13" id="answerLc" />
			<form:errors path="answerLc" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="sortOrdr">SORT_ORDR</label></th>
		<td>
			<form:input  path="sortOrdr" size="10" maxlength="13" id="sortOrdr" />
			<form:errors path="sortOrdr" cssClass="error"/>
		</td>
		<th scope="row"><label for="rdcnt">RDCNT</label></th>
		<td>
			<form:input  path="rdcnt" size="10" maxlength="15" id="rdcnt" />
			<form:errors path="rdcnt" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="useAt">USE_AT</label></th>
		<td>
			<form:input  path="useAt" size="1" maxlength="1" id="useAt" />
			<form:errors path="useAt" cssClass="error"/>
		</td>
		<th scope="row"><label for="ntceBgnde">NTCE_BGNDE</label></th>
		<td>
			<form:input  path="ntceBgnde" size="20" maxlength="20" id="ntceBgnde" />
			<form:errors path="ntceBgnde" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="ntceEndde">NTCE_ENDDE</label></th>
		<td>
			<form:input  path="ntceEndde" size="20" maxlength="20" id="ntceEndde" />
			<form:errors path="ntceEndde" cssClass="error"/>
		</td>
		<th scope="row"><label for="ntcrId">NTCR_ID</label></th>
		<td>
			<form:input  path="ntcrId" size="20" maxlength="20" id="ntcrId" />
			<form:errors path="ntcrId" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="ntcrNm">NTCR_NM</label></th>
		<td>
			<form:input  path="ntcrNm" size="20" maxlength="20" id="ntcrNm" />
			<form:errors path="ntcrNm" cssClass="error"/>
		</td>
		<th scope="row"><label for="password">PASSWORD</label></th>
		<td>
			<form:input  path="password" size="20" maxlength="200" id="password" />
			<form:errors path="password" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="atchFileId">ATCH_FILE_ID</label></th>
		<td>
			<%-- [/cmm/fms/selectFileInfsForUpdate.do] 결과 atchFileId hidden element 자동 추가됨
			<form:input  path="atchFileId" size="20" maxlength="20" id="atchFileId" />
			--%>
			${sampleBbs.atchFileId}
			<form:errors path="atchFileId" cssClass="error"/>
		</td>
		<th scope="row"><label for="frstRegistPnttm">FRST_REGIST_PNTTM</label></th>
		<td>
			<fmt:formatDate value="${sampleBbs.frstRegistPnttm}" type="date" pattern="yyyy-MM-dd" var="frstRegistPnttmFormat" />
			<form:input  path="frstRegistPnttm" size="0" maxlength="10" id="frstRegistPnttm" value="${frstRegistPnttmFormat}" onkeydown="allowNumberOnly(event);" onkeyup="convertDateKeyUp(this);" onfocus="convertDateFocus(this);" onblur="convertDateBlur(this);"/>
			<a href="here" onclick="fn_jq_calendar('frstRegistPnttm'); return false;" id="frstRegistPnttm_img" title="FRST_REGIST_PNTTM 달력창 열림" ><img src="${pageContext.request.contextPath}/images/sample/default/calendar.gif" name="frstRegistPnttm_img" class="" alt="FRST_REGIST_PNTTM 달력창 열림" /></a>
			<form:errors path="frstRegistPnttm" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="frstRegisterId">FRST_REGISTER_ID</label></th>
		<td>
			<form:input  path="frstRegisterId" size="20" maxlength="20" id="frstRegisterId" />
			<form:errors path="frstRegisterId" cssClass="error"/>
		</td>
		<th scope="row"><label for="lastUpdtPnttm">LAST_UPDT_PNTTM</label></th>
		<td>
			<fmt:formatDate value="${sampleBbs.lastUpdtPnttm}" type="date" pattern="yyyy-MM-dd" var="lastUpdtPnttmFormat" />
			<form:input  path="lastUpdtPnttm" size="0" maxlength="10" id="lastUpdtPnttm" value="${lastUpdtPnttmFormat}" onkeydown="allowNumberOnly(event);" onkeyup="convertDateKeyUp(this);" onfocus="convertDateFocus(this);" onblur="convertDateBlur(this);"/>
			<a href="here" onclick="fn_jq_calendar('lastUpdtPnttm'); return false;" id="lastUpdtPnttm_img" title="LAST_UPDT_PNTTM 달력창 열림" ><img src="${pageContext.request.contextPath}/images/sample/default/calendar.gif" name="lastUpdtPnttm_img" class="" alt="LAST_UPDT_PNTTM 달력창 열림" /></a>
			<form:errors path="lastUpdtPnttm" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="lastUpdusrId">LAST_UPDUSR_ID</label></th>
		<td colspan="3">
			<form:input  path="lastUpdusrId" size="20" maxlength="20" id="lastUpdusrId" />
			<form:errors path="lastUpdusrId" cssClass="error"/>
		</td>
	</tr>
	<c:if test="${not empty sampleBbs.atchFileId}">
	<tr>
		<th height="23">파일</th>
		<td colspan="6">
		<c:import url="/cmm/fms/selectFileInfsForUpdate.do" charEncoding="utf-8">
			<c:param name="param_atchFileId" value="${sampleBbs.atchFileId}" />
		</c:import>
		</td>
	</tr>
	</c:if>
	<tr>
		<th scope="row"><label>파일첨부</label></th>
		<td colspan="3">
		    <div id="file_upload_posbl"  style="display:none;" >
	            <table width="100%" cellspacing="0" cellpadding="0" border="0" align="center">
				    <tr>
				        <td><input name="file_1" id="egovComFileUploader" type="file" title="첨부파일명 입력"/></td>
				    </tr>
				    <tr>
				        <td>
				        	<div id="egovComFileList"></div>
				        </td>
				    </tr>
	   	        </table>
			</div>
			<div id="file_upload_imposbl"  style="display:none;" >
	            <table width="100%" cellspacing="0" cellpadding="0" border="0" align="center">
				    <tr>
				        <td><spring:message code="common.imposbl.fileupload" /></td>
				    </tr>
	   	        </table>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="4">
		   <div id="simple">
			<fieldset> 
			<legend><b>파일 업로드1</b></legend>
				<jwork:fileuploader 
				       objectId="fileUploadObj1"  
				       uploadCompletedEvent="uploadCompleted1"
				       fileType="all" 
				       maxFileSize="10000" 
				       maxFileCount="30" 
				       usePreview="true"
				       useSecurity="false"
				       uploadMode="db"
				       />
				<input type="button" onclick="send1()" value="전송" style="width: 110px; height: 24px; font-size: 11px"/>		
			</fieldset>
			
			<script type="text/javascript">	
				function send1(){		
					fileUploadObj1.startUpload();
				}
				function uploadCompleted1(){
					fileUploadObj1.refresh();
					//alert(fileUploadObj1.fileId);
					$("#atchFileId").val(fileUploadObj1.fileId);
				}
				function loadDownload() {
					var fileId= $.trim("${sampleBbs.atchFileId}");
					console.log("loadDownload() fileId="+fileId);
					if (fileId === "") return;
					
					fileUploadObj1.setFileId(fileId);
					fileUploadObj1.refresh();
				}
				$(window).load(function(){
					loadDownload();
				}); 
			</script>

		</td>
	</tr>

	</tbody>
</table>
</div>
<!--// e: table -->
<!--  s:button -->
<div class="btn_rwrap">				
	<button type="button" class="btn_bmbl" onclick="fnModify(document.sampleBbs); return false;">저장</button>
	<button type="button" class="btn_bmg" onclick="fnList(); return false;">목록</button>
</div>
<!--  e:button -->			


</form:form>
