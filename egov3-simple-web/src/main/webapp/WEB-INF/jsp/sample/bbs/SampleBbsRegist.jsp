<%
 /**
  * 게시판 등록 화면
  * @Class Name  : SampleBbsRegist.jsp
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%//@ taglib prefix="double-submit" uri="http://www.egovframe.go.kr/tags/double-submit/jsp" %><%-- 이중등록(Double Submit) 방지 --%>
<%--
<title>게시판 등록</title>
--%>
<script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/fms/EgovMultiFile.js'/>" ></script>
<script type="text/javaScript" language="javascript">

/* ********************************************************
 * validation
 ******************************************************** */
$(function(){
	$("#sampleBbs").validate({
        submitHandler: function() {
            var f = confirm("<spring:message code="common.save.msg" />'");
            if(f){
            	document.sampleBbs.action = "<c:url value='/bbs/SampleBbsRegist.do'/>";
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
	var varForm	= document.forms["sampleBbs"];
	varForm.action = "<c:url value='/bbs/SampleBbsList.do' />";
	varForm.submit();
}
/* ********************************************************
 * 저장처리화면
 ******************************************************** */
 function fnRegist(form){
 	/*
	if(confirm("<spring:message code="common.save.msg" />")){
		if(!validateSampleBbs(form)){
			return;
		}else{
			form.submit();
		}
	}
	*/
	$(form).submit();
}

/* ********************************************************
 * message 보이기
 ******************************************************** */
function fncShowMessg(){
    if("<c:out value='${message}'/>" != ''){
    alert("<c:out value='${message}'/>");
    }
}

function makeFileAttachment(){
	var form = document.forms["sampleBbs"];
	
	var maxFileNum = dform.posblAtchFileNumber.value;
	if(maxFileNum==null || maxFileNum==""){
		maxFileNum = 3;
	}
	var multi_selector = new MultiSelector( document.getElementById( 'egovComFileList' ), maxFileNum );
	multi_selector.addElement( document.getElementById( 'egovComFileUploader' ) );
}

/* ********************************************************
 * 초기화 작업
 ******************************************************** */
$(document).ready(function(){
	// message
	fncShowMessg();
	
	// calendar
	initCal({id:"frstRegistPnttm_img",type:"day",today:"y",icon:"n"});
	initCal({id:"lastUpdtPnttm_img",type:"day",today:"y",icon:"n"});
});	

</script>

<h3 class="title">게시판 등록</h3>

<form:form commandName="sampleBbs" name="sampleBbs" method="post" action="" enctype="multipart/form-data" >
<%--<double-submit:preventer/> 이중등록(Double Submit) 방지 --%>
<input name="cmd" type="hidden" value="<c:out value='save'/>"/>
<form:hidden path="nttId" />
<form:hidden path="bbsId" />
<form:hidden path="nttNo" />
<form:hidden path="sortOrdr" />
<form:hidden path="rdcnt" />
<form:hidden path="frstRegistPnttm" />
<form:hidden path="frstRegisterId" />
<form:hidden path="lastUpdtPnttm" />
<form:hidden path="lastUpdusrId" />

<%--
<input type="hidden" name="posblAtchFileNumber" value="<c:out value='${bdMstr.posblAtchFileNumber}'/>" />
<input type="hidden" name="posblAtchFileSize" value="<c:out value='${bdMstr.posblAtchFileSize}'/>" />
--%>
<input type="hidden" name="posblAtchFileNumber" value="3" />
<input type="hidden" name="posblAtchFileSize" value="" />

<!-- 검색조건 유지 start -->
<%//@ include file="/WEB-INF/jsp/gep/cmm/include/search_condition.jsp" %>
<!-- 검색조건 유지 end -->

<div class="c_box">
	<ul>
		<li><em>*</em> 표시는 필수 입력입니다.</li>
	</ul>
</div>					

<h4>게시판 정보</h4>

<!-- s: table //-->
<div class="tb_wrap">

<!-- validation 결과 표시 -->
<ul id="validationResults"><li></li></ul>

<table summary="게시판 등록 테이블이다." class="write">
	<caption>게시판 정보</caption>
	<colgroup>
		<col width="18%"/>
		<col width="30%"/>
		<col width="18%"/>
		<col width="34%"/>
	</colgroup>
	<tbody>
	<tr>
		<th scope="row"><label for="nttSj">NTT_SJ</label></th>
		<td colspan="3">
			<form:input  path="nttSj" size="20" maxlength="2000" id="nttSj" />
			<form:errors path="nttSj" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th scope="row"><label for="nttCn">NTT_CN</label></th>
		<td>
			<form:input  path="nttCn" size="-1" maxlength="-1" id="nttCn" />
			<form:errors path="nttCn" cssClass="error"/>
		</td>
		<th scope="row"><label for="answerAt">ANSWER_AT</label></th>
		<td>
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
		<td colspan="3">
			<form:input  path="atchFileId" size="20" maxlength="20" id="atchFileId" />
			<form:errors path="atchFileId" cssClass="error"/>
		</td>
	</tr>
	<tr>
		<th height="23">첨부 파일</th>
		<td colspan="3">
			<table width="100%" cellspacing="0" cellpadding="0" border="0" align="center">
			<tr>
				<td><input name="file_1" id="egovComFileUploader" type="file" title="첨부파일입력"/></td>
			</tr>
			<tr>
				<td>
					<div id="egovComFileList"></div>
				</td>
			</tr>
			</table>
		</td>
	</tr>

	</tbody>
</table>
</div>
<!--// e: table -->

<div class="btn_rwrap">				
	<button type="button" class="btn_bmbl" onclick="fnRegist(document.sampleBbs); return false;">저장</button>
	<button type="button" class="btn_bmg" onclick="fnList(); return false;">목록</button>
</div>


</form:form>
