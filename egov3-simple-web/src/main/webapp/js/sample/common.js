/****************************************************************
 *
 * 파일명 : common.js
 * 설  명 : gep common javascript
 *
 *    수정일		수정자		Version        Function 명
 * ------------	---------   -------------  ----------------------------
 * 2016.01.21	jhong       1.0             최초생성
 *
 *
 */


/**********************************************
 * 함수명 : showlog
 * 설  명 : 개발시 log 보여주기 (alert / console.log)
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.01.21	jhong		최초생성
 *
 */
function showlog(msg) {
	if (window.console && window.console.log) {
		console.log(msg);
	} else { // IE
		//alert(msg);
	}
}

/**********************************************
 * 함수명 : loadScript
 * 설  명 : javascript src 추가
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.23	jhong		최초생성
 *
 */
function loadScript(src, callback) {
	//showlog("loadScript() start... src="+src);
	var script = document.createElement("script");
	script.type = "text/javascript";
	if (callback) script.onload = callback;
	document.getElementsByTagName("head")[0].appendChild(script);
	try {
		script.src = src;
	} catch (e) {
		showlog("fail in loadScript() e="+e);
	}
}

/**********************************************
 * 함수명 : showProgress
 * 설  명 : 중복실행 방지 위해 progress circle 보이기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.17	jhong		최초생성
 *
 */
function showProgress() {
	//showlog("showProgress() start...");
	var container = $("#progressBack");
	var bar = $("#progressBar");
	
	var windowHeight = $(window).height();
	var documentHeight = $(document).height();
	var documentScrollTop = $(document).scrollTop();
	
	container.height(documentHeight); // container 전체 높이 지정
	container.css({ opacity: 0.7 }); // 투명도
	container.show();
	
	var barTop = documentScrollTop + windowHeight/2;
	//showlog("showProgress() windowHeight="+windowHeight+", documentHeight="+documentHeight+", documentScrollTop="+documentScrollTop+", barTop="+barTop);
	bar.css("margin-top", barTop); // spinner 위치 지정
	bar.show();
}

/**********************************************
 * 함수명 : hideProgress
 * 설  명 : 중복실행 방지 위해 progress circle 숨기기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.17	jhong		최초생성
 *
 */
function hideProgress() {
	//showlog("hideProgress() start...");
	$("#progressBar").hide();
	$("#progressBack").hide();
}

/**********************************************
 * 함수명 : textLen
 * 설  명 : text 길이 구하기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.17	jhong		최초생성
 *
 */
function textLen(value) {
	var num = 0;
	if (typeof(value) == undefined || value == null || value == "") return num; // (2014.01.06)
	
	var len = value.length;

	for(var k=0;k<len;k++) {
		var temp = value.charAt(k);

		//내장함수 escape를 통해 그 글자의 길이가 4보다 크면 한글이므로 2를 더한다.
		if(escape(temp).length > 4)
		num += 2;
		else
		num++;
	}
	//showlog("textLen() value="+value+", num="+num);
	return num;
}

/**********************************************
 * 함수명 : goMenuPage
 * 설  명 : 메뉴 클릭시 페이지 이동
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.17	jhong		최초생성
 *
 */
function goMenuPage(menuNo, menuNoTop, linkStr, contextPath){
	var menuListForm = document.forms["menuListForm"];
	menuListForm.siteMenuNo.value = menuNo;
	if (menuNoTop != "") menuListForm.siteMenuNoTop.value = menuNoTop;
	
	//showlog("[common] siteMenuNo="+menuListForm.siteMenuNo.value+", siteMenuNoTop="+menuListForm.siteMenuNoTop.value);
	//showlog("[common] goMenuPage() menuNo="+menuNo+", linkStr="+linkStr);
	
	if (linkStr != "" && linkStr.indexOf("EgovPageLink.do") >= 0) {
		menuListForm.link.value = "forward:"+linkStr;
		menuListForm.action = contextPath + "/EgovPageLink.do";
	} else {
		menuListForm.link.value = "";
		menuListForm.action = contextPath + linkStr;
	}
	
	//showlog("[common] goMenuPage() menuNo="+menuNo+", link="+(document.getElementById("link").value)+", action="+document.menuListForm.action);

	menuListForm.submit();
}

/**********************************************
 * 함수명 : toggleFrontMainTopMenu
 * 설  명 : front top menu click 에 따라 sub menu 보이기/숨기기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.24	jhong		최초생성
 *
 */
function toggleFrontMainTopMenu(id) {
	/*
	var menuNo = (id+"").replace(/^tm1_/, "");
	//showlog("toggleFrontTopMenu() id="+id+", menuNo="+menuNo);
	
	// 2 depth h2
	var th2Arr = $("h2[id^=th2_]");
	$(th2Arr).each(function(idx, elmt){
		//showlog("toggleFrontTopMenu() th2Arr idx="+idx+", elmt.id="+elmt.id);
		if ((elmt.id+"") === "th2_"+menuNo) $(elmt).show();
		else $(elmt).hide();
	});
	
	// 2 depth ul
	var tu2Arr = $("ul[id^=tu2_]");
	$(tu2Arr).each(function(idx, elmt){
		//showlog("toggleFrontTopMenu() tu2Arr idx="+idx+", elmt.id="+elmt.id);
		if ((elmt.id+"") === "tu2_"+menuNo) $(elmt).show();
		else $(elmt).hide();
	});
	*/
	/*
	$('div#gnb ul li').hover(
		function () { //appearing on hover
			$('ul', this).fadeIn();
		},
		function () { //disappearing on hover
			$('ul', this).fadeOut();
		}
	);
	*/
	$('div#mpg_gnb').hover(
		function () { //appearing on hover
			$(this).stop()
			.find('ul ul').stop().slideDown(300, function(){
				//$('div.submn_bg').show();
			});
		},
		function () { //disappearing on hover
			$(this).stop()
			.find('ul ul').stop().slideUp(500, function(){
				//$('div.submn_bg').hide();
			});
		}
	);
	
	$('#gnb_menu').hover(
			function () { //appearing on hover
				$(this).stop()
				.find('ul').stop().slideDown(300, function(){
					//$('#submn_bg_id').show();
				});
			},
			function () { //disappearing on hover
				$(this).stop()
				.find('ul').stop().slideUp(500, function(){
					//$('#submn_bg_id').hide();
				});
			}
		);
	
	$('#gnb_menu ul li a').focus(function(){
		$(this).stop()
		.find('ul').stop().slideDown(300, function(){});
	});

	$('#gnb_menu ul li a').blur(function(){
		$(this).stop()
		.find('ul').stop().slideUp(500, function(){});
	});
}



/**********************************************
 * 함수명 : toggleFrontTopMenu
 * 설  명 : front top menu click 에 따라 sub menu 보이기/숨기기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.24	jhong		최초생성
 *
 */
function toggleFrontTopMenu(id) {
	/*
	var menuNo = (id+"").replace(/^tm1_/, "");
	//showlog("toggleFrontTopMenu() id="+id+", menuNo="+menuNo);
	
	// 2 depth h2
	var th2Arr = $("h2[id^=th2_]");
	$(th2Arr).each(function(idx, elmt){
		//showlog("toggleFrontTopMenu() th2Arr idx="+idx+", elmt.id="+elmt.id);
		if ((elmt.id+"") === "th2_"+menuNo) $(elmt).show();
		else $(elmt).hide();
	});
	
	// 2 depth ul
	var tu2Arr = $("ul[id^=tu2_]");
	$(tu2Arr).each(function(idx, elmt){
		//showlog("toggleFrontTopMenu() tu2Arr idx="+idx+", elmt.id="+elmt.id);
		if ((elmt.id+"") === "tu2_"+menuNo) $(elmt).show();
		else $(elmt).hide();
	});
	*/
	/*
	$('div#gnb ul li').hover(
		function () { //appearing on hover
			$('ul', this).fadeIn();
		},
		function () { //disappearing on hover
			$('ul', this).fadeOut();
		}
	);
	*/
	$('#gnb_menu').hover(
		function () { //appearing on hover
			$(this).stop()
			.find('ul').stop().slideDown(300, function(){
				//$('#submn_bg_id').show();
			});
		},
		function () { //disappearing on hover
			$(this).stop()
			.find('ul').stop().slideUp(500, function(){
				//$('#submn_bg_id').hide();
			});
		}
	);
	
	$('#gnb_menu li a').focus(function(){
		$('#gnb_menu').stop()
		.find('ul').stop().slideDown(300, function(){});
	});

	$('#gnb_menu li a').blur(function(){
		$('#gnb_menu').stop()
		.find('ul').stop().slideUp(500, function(){});
	});
}

/**********************************************
 * 함수명 : toggleFrontLeftMenu
 * 설  명 : front left menu click 에 따라 sub menu 보이기/숨기기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.24	jhong		최초생성
 *
 */
function toggleFrontLeftMenu(id) {
	var menuNo = id;
	if (typeof(menuNo) == "undefined" || menuNo == "") {
		
		// menuNo 값이 없는 경우 url 사용하여 메뉴 찾기
		var url = $(location).attr('href');
		//showlog("toggleFrontLeftMenu() id="+id+", menuNo="+menuNo+", url="+url);
		$("div[id=left]").find("a").each(function (idx, elmt){
			var m = (elmt.href).match(/(\/.*)'/); // 정규표현식으로 링크값 찾기
			//showlog("toggleFrontLeftMenu() idx="+idx+", elmt.href="+elmt.href+"===>"+(m == null ? "" : m[0]));
			if (m != null) {
				var link = (m[0]+"").replace(/'|,|\s/g, '');
				link = link.replace(/\/$/, '').replace(/s$/, ''); // 마지막 "s/" 제거
				if (url.indexOf(link) >= 0) {
					//showlog("toggleFrontLeftMenu() link="+link+", url="+url);
					$(elmt).parents('ul[id^=lu]').show().prev().show();
				}
			}
		});
		return;
	}
	
	// 2 depth div
	var ld2Arr = $("div[id^=ld2_]");
	$(ld2Arr).each(function(idx, elmt){
		//showlog("toggleFrontLeftMenu() ld2Arr idx="+idx+", elmt.id="+elmt.id+", "+(elmt.id+"").substring(0,8)+", "+("ld2_"+menuNo).substring(0,8));
		if ((elmt.id+"").substring(0,8) === ("ld2_"+menuNo).substring(0,8)) {
			$(elmt).show();
			$(elmt).next().show();
		} else {
			$(elmt).hide();
			$(elmt).next().hide();
		}
	});
	
	/*
	// 2 depth ul
	var lu2Arr = $("ul[id^=lu2_]");
	$(lu2Arr).each(function(idx, elmt){
		//showlog("toggleFrontLeftMenu() lu2Arr idx="+idx+", elmt.id="+elmt.id);
		if ((elmt.id+"").substring(0,8) === ("lu2_"+menuNo).substring(0,8)) $(elmt).show();
		else $(elmt).hide();
	});
	*/
}

/**********************************************
 * 함수명 : toggleAdminLeftMenu
 * 설  명 : admin left menu click 에 따라 sub menu 보이기/숨기기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.07	jhong		최초생성
 *
 */
function toggleAdminLeftMenu(id) {
	var menuNo = id;
	//showlog("toggleAdminLeftMenu() id="+id+", typeof(menuNo)="+typeof(menuNo));
	if (menuNo === "null") return;
	
	// 2 depth div
	var ld2Arr = $("div[id^=ld2_]");
	$(ld2Arr).each(function(idx, elmt){
		//showlog("toggleFrontLeftMenu() ld2Arr idx="+idx+", elmt.id="+elmt.id);
		if ((elmt.id+"") === "ld2_"+menuNo) $(elmt).show();
		else $(elmt).hide();
	});
	
	// 2 depth ul
	var lu2Arr = $("ul[id^=lu2_]");
	$(lu2Arr).each(function(idx, elmt){
		//showlog("toggleFrontLeftMenu() lu2Arr idx="+idx+", elmt.id="+elmt.id);
		if ((elmt.id+"") === "lu2_"+menuNo) $(elmt).show();
		else $(elmt).hide();
	});
}

/**********************************************
 * 함수명 : openPagePrintPopup
 * 설  명 : 페이지 인쇄 팝업
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.19	jhong		최초생성
 *
 */
function openPagePrintPopup(contextPath){
	
	var url = contextPath+"/EgovPageLink.do?link=/gep/cmm/PagePrintPopup";
	if (typeof(getPrinterLinkUrl) == "function") {
		// chart 존재하는 페이지 등에서 사용할 수 있도록 추가 by jhong (2016.05.23)
		url = getPrinterLinkUrl();
	}
	
	//alert("openPagePrintPopup() url="+url);
	window.open(url, "", "width=1021, height=600, scrollbars=yes,");
	// /EgovPageLink.do
}

/**********************************************
 * 함수명 : allowNumberOnly
 * 사용법 : 접근성을 위해 onkeydown으로 하셔야 합니다.
 */
function allowNumberOnly(e) {

	var obj = e.srcElement||e.target;
    var key = e.keyCode;
    //if((key < 48 || key > 57) && (key < 96 || key > 105) && key != 9 && key != 8) {
    if((key < 48 || key > 57) && (key < 96 || key > 105) && key != 9 && key != 8 && key != 46) { // delete key 작동 가능하도록 수정 - 요청 by 고기봉 (2016.05.02)
    	obj.blur(); 
      	setTimeout(function() { //오페라 때문에 이짓을 함(오페라가 제대로 표준을 지키는 것임)
      		obj.focus();
      	}, 30); //크롬 때문에 수치를 지정하였습니다.( 블로킹이 안되는 상황에... ) 
    }

	/*
	if ( window.event.keyCode >= 48 && window.event.keyCode <= 57 ) {

	} else {

		window.event.keyCode = "";

	}
	*/
}


/**********************************************
 * 함수명 : convertDateKeyUp
 * 
 */
function convertDateKeyUp(obj) {

	convertKeyUp(obj, 8);
}

/**********************************************
 * 함수명 : convertKeyUp
 * 
 */
function convertKeyUp(obj, i) {

	var val = obj.value;

	if (val.length > i) {
		val = val.substring(0, i);
		obj.value = val;
		return;
	}
}


/**********************************************
 * 함수명 : convertDateFocus
 * 
 */
function convertDateFocus(obj) {

	var val = obj.value;
	val = convertAll(val, "-", "");
	obj.value = val;
	obj.select();
	obj.focus();
}

/**********************************************
 * 함수명 : convertAll
 * 
 */
function convertAll(data, specStr, convStr) {

	if (data == null) return;

	if (convStr == null) {
		return data.split(specStr).join("");

	} else {
		return data.split(specStr).join(convStr);
	}
}

/**********************************************
 * 함수명 : convertDateBlur
 * 설  명 : 날자 Input가 포커스 잃을때  '-' 추가
 */
function convertDateBlur(obj) {

	var val = obj.value;
	if (val.length == 0) return;

	if (val.length != 8) {
		alert ("잘못된 형식입니다.[" + val + "]"); // 요청 by 진세환 (2016.05.17)
		obj.value = "";
		return;
	}

	if (isDateTypeChk(val)) {
		var date = val.substring(0, 4) + "-";
		date += val.substring(4, 6) + "-";
		date += val.substring(6);
		obj.value = date;

	} else {
		alert ("잘못된 형식입니다.[" + val + "]");
		obj.value = "";
		obj.focus();
	}
}


/**********************************************
 * 함수명 : isDateTypeChk
 * 설  명 : 년월일이 같이 있는 Input box 상에서 년월일을 체크하는 함수
 */
function isDateTypeChk(sDate) {

	if (sDate == null || sDate == "") return false;

	sDate=sDate.replace(/(\,|\.|\-|\/|[ ])/g,"");
	//var sFormat="YYYYMMDD";
	if(!chkNumeric(sDate)) {
		return false;
	}

	var aDaysInMonth=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
	if (sDate.length == 0) {
		return false;
	}

	if (sDate.length != 8 ) {
		return false;

	} else {
		var iYear=eval(sDate.substr(0,4));
		var iMonth=eval(sDate.substr(4,2));
		var iDay=eval(sDate.substr(6,2));
		var iDaysInMonth=(iMonth!=2)?aDaysInMonth[iMonth-1]:((iYear%4==0 && iYear%100!=0 || iYear % 400==0)?29:28);

		if( (iDay!=null && iMonth!=null && iYear!=null  && iMonth<13 && iMonth>0 && iDay>0 && iDay<=iDaysInMonth) == false ) {
			return false;

		} else {
			return true;
		}
	}
}


/**********************************************
 * 함수명 : chkNumeric
 */
function chkNumeric(strCompare) {

	for(var k=0; k<strCompare.length; k++){
		if(strCompare.charCodeAt(k)<48 || strCompare.charCodeAt(k)>57){  // 입력값이 숫자인지 체크
			return false;
		}
	}

	return true;
}

/**********************************************
 * 함수명 : getFormObject
 * 설  명 : form 엘리먼트 구하기
 */
function getFormObject(formName, objName) {
	var form = document.forms[formName];
	var obj = form[objName];
	if (obj != null && obj.length > 1) {
		// 부모창에 같은 name 을 가진 엘리먼트가 두 개 이상 존재할 경우 (서로 다른 form 에 존재해도 IE에서는 문제 발생!!)
		
    	$(obj).each(function(idx, elmt){
    		// parent 엘리먼트 중 form 을 조사하기
    		var parentForms = $(elmt).parents("form"); // 상위에 존재하는 forms
    		var myFormIdx = 0, anotherFormIdx = 100;
    		$(parentForms).each(function(idx2, elmt2){
    			if (elmt2.name == formName) myFormIdx = idx2;
    			else anotherFormIdx = idx2;
    		});
    		//alert("idx="+idx+", myFormIdx="+myFormIdx+", anotherFormIdx="+anotherFormIdx);
    		if (myFormIdx < anotherFormIdx) obj = elmt; // parent form 순서 비교하여 "myForm" 이 먼저 나올 경우 사용!!
    	});
	}
	return obj;
}

/**********************************************
 * 함수명 : getObjValueStr
 * 설  명 : 주어진 object의 value 문자열 구하기 (값이 없을 경우 "" 반환)
 */
function getObjValueStr(obj, key) {
	if (typeof(obj) == "undefined" || typeof(key) == "undefined") return;
	
	var value = obj[key];
	if (typeof(value) == "undefined") return "";
	
	return value+"";
}

/**********************************************
 * 함수명 : openPopup
 * 설  명 : 팝업 띄우기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.24	jhong		최초생성
 *
 */
function openPopup(target, url, width, height, left, top) {
	//showlog("openPopup() url="+url);
	if (url == null) url = ""; // url 넘기지 않고 일단 팝업만 띄울 경우 대비
	var name = (target+"").replace(/\s/g, ""); // 공백있으면 에러 발생함!!
	var options = "width="+width+",height="+height+",left="+left+",top="+top+",toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes";
	var openWindows = window.open(url,name,options);
	if (window.focus) {openWindows.focus();}
}


/**********************************************
 * 함수명 : initSiteCondition
 * 설  명 : 사이트정보 유지위해 추가 by jhong (2015.02.04)
 * 		등록 후 상세페이지로 redirect할 경우 "redirectAttribute"에서 siteVO 한 번 꺼내고 나면 사라짐
 * 		=> menuListForm 값은 세팅되지만 각 페이지의 데이터 form 의 SiteVO 정보는 세팅되지 않는 오류 해결위해 추가
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.04	jhong		최초생성
 *
 */
function initSiteCondition() {
	var menuListForm = document.forms["menuListForm"];
	if (menuListForm != null && menuListForm.siteMenuNo.value === "") return;
	
	var formList = document.forms;
	$(formList).each(function(idx, elmt){
		if ("menuListForm" !== elmt.name) {
			var menuNoObj = elmt["siteMenuNo"];
			var menuNoTopObj = elmt["siteMenuNoTop"];
			var designTypeObj = elmt["siteDesignType"];
			
			//showlog("initSiteCondition() idx="+idx+", elmt.name="+elmt.name+", menuno=>"+typeof(menuNoObj)+", menuNoTopObj="+typeof(menuNoTopObj));
			if(typeof(menuNoObj) != "undefined") {
				if (menuNoObj.value === "") menuNoObj.value = menuListForm.siteMenuNo.value;
			}
			if (typeof(menuNoTopObj) != "undefined") {
				if (menuNoTopObj.value === "") menuNoTopObj.value = menuListForm.siteMenuNoTop.value;
			}
			if (typeof(designTypeObj) != "undefined") {
				if (designTypeObj.value === "") designTypeObj.value = menuListForm.siteDesignType.value;
			}
		}
	});
}

/**********************************************
 * 함수명 : initSiteCondition
 * 설  명 : 사이트정보 유지위해 추가 by jhong (2015.02.25)
 * 		등록 후 상세페이지로 redirect할 경우 "redirectAttribute"에서 siteVO 한 번 꺼내고 나면 사라짐
 * 		=> menuListForm 이 footer에 존재하는 경우 대비하기 위해 추가함
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.02.25	jhong		최초생성
 *
 */
function initSiteConditionByValue(siteMenuNo, siteMenuNoTop, siteDesignType) {
	var menuListForm = document.forms["menuListForm"];
	if (menuListForm == null) return;
	
	if (siteMenuNo != "") menuListForm.siteMenuNo.value = siteMenuNo;
	if (siteMenuNoTop != "") menuListForm.siteMenuNoTop.value = siteMenuNoTop;
	if (siteDesignType != "") menuListForm.siteDesignType.value = siteDesignType;
	//showlog("initSiteConditionByValue() end... menuListForm.siteMenuNo.value="+menuListForm.siteMenuNo.value+", menuListForm.siteMenuNoTop.value="+menuListForm.siteMenuNoTop.value+", menuListForm.siteDesignType.value="+menuListForm.siteDesignType.value);
}

/**********************************************
 * 함수명 : shareTwitter
 * 설  명 : twitter 연동 함수
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.14	jhong		최초생성
 *
 */
function shareTwitter(username) {
	var target = "_social";
	var title = $("meta[name='twitter:description']").attr("content");
	var canonicalUrl = $("link[rel='canonical']").attr("href");
	/* ie에서 403 오류 발생하여 주석처리 by jhong (2016.05.10)
	var url = "https://twitter.com/intent/tweet?url="+encodeURIComponent(canonicalUrl)+"&text="+title+"&via="+username;
	*/
	var url = "https://twitter.com/intent/tweet?url="+encodeURIComponent(canonicalUrl)+"&text="+encodeURIComponent(title);
	//showlog("shareTwitter() url="+url);
	if (typeof(getTwitterLinkUrl) == "function") {
		url = getTwitterLinkUrl();
	}
	var width = 895;
	var height = 700;
	var left = 0;
	var top = 0;
	openPopup(target, url, width, height, left, top);
}
/**********************************************
 * 함수명 : shareFacebook
 * 설  명 : facebook 연동 함수
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.14	jhong		최초생성
 *
 */
function shareFacebook() {
	var target = "_social";
	var canonicalUrl = $("link[rel='canonical']").attr("href");
	var url = "https://www.facebook.com/sharer/sharer.php?u="+canonicalUrl;
	if (typeof(getFacebookLinkUrl) == "function") {
		url = getFacebookLinkUrl();
	}
	var width = 895;
	var height = 700;
	var left = 0;
	var top = 0;
	openPopup(target, url, width, height, left, top);
}
/**********************************************
 * 함수명 : shareLinkedin
 * 설  명 : linkedin 연동 함수
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.14	jhong		최초생성
 *
 */
function shareLinkedin() {
	var target = "_social";
	var canonicalUrl = $("link[rel='canonical']").attr("href");
	var url = "http://www.linkedin.com/shareArticle?mini=true&url="+canonicalUrl;
	if (typeof(getLinkedinLinkUrl) == "function") {
		url = getLinkedinLinkUrl();
	}
	var width = 895;
	var height = 700;
	var left = 0;
	var top = 0;
	openPopup(target, url, width, height, left, top);
}
/**********************************************
 * 함수명 : initKakao
 * 설  명 : kakao 초기화 함수 (include_social_view.jsp 페이지에서 호출함)
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.04.19	jhong		최초생성
 *
 */
function initKakao(appKey, defaultImgUrl) {
	var title = $("title").text();
	var desc = $("meta[name='Description']").attr("content");
	var canonicalUrl = $("link[rel='canonical']").attr("href");
	var imageUrl = $("meta[property='og:image']").attr("content");
	//alert("initKakao() appKey="+appKey+", imageUrl="+imageUrl+", "+typeof(imageUrl));
	
	if (typeof(imageUrl) == "undefined") imageUrl = defaultImgUrl;
	
	//사용할 앱의 JavaScript 키를 설정
	Kakao.init(appKey);
	
	// 카카오톡 링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
	Kakao.Link.createTalkLinkButton({
		container: '#kakao-link-btn',
		label: desc,
		image: {
			src: imageUrl,
			width: '200',
			height: '200'
		},
		webButton: {
			text: title,
			url: canonicalUrl // 앱 설정의 웹 플랫폼에 등록한 도메인의 URL이어야 합니다.
		}
	});
}
/**********************************************
 * 함수명 : shareKakao
 * 설  명 : kakao 연동 함수
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.14	jhong		최초생성
 *
 */
function shareKakao() {
	
	/*
	var title = $("title").text();
	var desc = $("meta[name='Description']").attr("content");
	var canonicalUrl = $("link[rel='canonical']").attr("href");
	var imageUrl = $("meta[property='og:image']").attr("content");

	var param = "sendurl?msg=" + encodeURIComponent(title);
	param += "&url=" + canonicalUrl;
	param += "&type=link";
	param += "&apiver=2.0.1";
	param += "&appver=2.0";
	param += "&appid=GEP";
	param += "&appname=" + encodeURIComponent("글로벌 전시포탈");
	alert("shareKakao() param="+param);
 
	if(navigator.userAgent.match(/android/i)) {
		setTimeout(function(){
		    location.href = "intent://" + param + "#Intent;package=com.kakao.talk;end";
		}, 100);
		
	} else if(navigator.userAgent.match(/(iphone)|(ipod)|(ipad)/i)) {
		setTimeout(function(){
		    location.href = "itms-apps://itunes.apple.com/app/id362057947?mt=8";
		}, 200);
		setTimeout(function(){
		    location.href = "kakaolink://" + param;
		}, 100);
	}
	*/
}
/**********************************************
 * 함수명 : shareLine
 * 설  명 : line 연동 함수
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.14	jhong		최초생성
 *
 */
function shareLine() {
	var title = $("title").text();
	var canonicalUrl = $("link[rel='canonical']").attr("href");

	var target = "_social";
	var url = "http://line.me/R/msg/text/?" + encodeURIComponent(title) + " " + encodeURIComponent(canonicalUrl);
	//alert("shareLine() url="+url);
	var width = 895;
	var height = 700;
	var left = 0;
	var top = 0;
	openPopup(target, url, width, height, left, top);

	/*
	var param = "create/post?text=" + encodeURIComponent(title);
	//alert("shareLine() param="+param);
	 
	if(navigator.userAgent.match(/android/i)) {
	    setTimeout(function(){
	        location.href = "intent://" + param + "#Intent;package=com.nhn.android.band;end";
	    }, 100);
	    
	} else if(navigator.userAgent.match(/(iphone)|(ipod)|(ipad)/i)) {
	    setTimeout(function(){
	        location.href = "itms-apps://itunes.apple.com/app/id443904275?mt=8";
	    }, 200);
	    setTimeout(function(){
	        //location.href = "bandapp://" + param; // TODO:
	    }, 100);
	}
	*/
	
}
/**********************************************
 * 함수명 : shareBand
 * 설  명 : band 연동 함수
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.14	jhong		최초생성
 *
 */
function shareBand(domainName) {
	//var title = $("title").text();
	var title = $("meta[name='Description']").attr("content");
	var canonicalUrl = $("link[rel='canonical']").attr("href");
	//showlog("shareBand() title="+title);

	/* web 페이지 연결 */
	var target = "_social";
	//var url = "https://auth.band.us/login_page?_s=1&display=popup&next_url=";
	//var url = "http://band.us/plugin/share?body="+encodeURIComponent(title)+"  "+encodeURIComponent(canonicalUrl)+ "&route="+domainName;
	var url = "http://band.us/plugin/share?body="+encodeURIComponent(title) + "&route="+domainName;
	//alert("shareBand() url="+url);
	var width = 410;
	var height = 540;
	var left = 0;
	var top = 0;
	openPopup(target, url, width, height, left, top);
	

	/*
	var param = "create/post?text=" + encodeURIComponent(title) +"&body=" + encodeURIComponent(title) + "&route="+canonicalUrl;
	alert("shareBand() param="+param);
	 
	if(navigator.userAgent.match(/android/i)) {
	    setTimeout(function(){
	        location.href = "intent://" + param + "#Intent;package=com.nhn.android.band;end";
	    }, 100);
	    
	} else if(navigator.userAgent.match(/(iphone)|(ipod)|(ipad)/i)) {
	    setTimeout(function(){
	        location.href = "itms-apps://itunes.apple.com/app/id542613198?mt=8";
	    }, 200);
	    setTimeout(function(){
	        location.href = "bandapp://" + param;
	    }, 100);
	}
	*/
}
/**********************************************
 * 함수명 : openPrint
 * 설  명 : 출력 팝업 열기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.14	jhong		최초생성
 *
 */
function openPrint(contextPath) {
	if (typeof(openPagePrintPopup) == "function") {
		openPagePrintPopup(contextPath);
	}
}
/**********************************************
 * 함수명 : openPdf
 * 설  명 : PDF 저장 팝업 열기
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.03.14	jhong		최초생성
 *
 */
function openPdf() {
	var target = "pdf";
	var url = "";
	if (typeof(getPdfLinkUrl) == "function") {
		url = getPdfLinkUrl();
	}
	var width = 895;
	var height = 700;
	var left = 0;
	var top = 0;
	openPopup(target, url, width, height, left, top);
}
/**********************************************
 * 함수명 : 우편번호 팝업
 * 설  명 : 우편번호 팝업 열기 - SMARTCRM 소스 참고
 */
function zipSearchPopup(sFormName
					, sZiperFieldNames   	//우편번호 필드들(,로 분리->우편번호필드,주소필드,상세주소 필드)
					, sSECTFieldNames		//관서필드들(,로 분리->sectid1,sectid2,sectid3)
					, sEtcParamNameValues ){


	if(arguments[2]==null) sSECTFieldNames = ""; 	
	if(arguments[3]==null) sEtcParamNameValues = ""; 	
	var sZIPCD_FieldName = "";		
	var sADDR_FieldName = "";		
	var sDETAIL_ADDR_FieldName = "";		
	
	var sSECTID1_FieldName = "";
	var sSECTID2_FieldName = "";
	var sSECTID3_FieldName = "";
	
	if(isNull(sZiperFieldNames)==false){
		var arrCUSTOMER = sZiperFieldNames.trim().split(",");
		if(arrCUSTOMER.length>0) sZIPCD_FieldName       		= arrCUSTOMER[0];
		if(arrCUSTOMER.length>1) sADDR_FieldName     			= arrCUSTOMER[1];
	}
	
	if(isNull(sSECTFieldNames)==false){
		var arrSECTID = sSECTFieldNames.trim().split(",");
		if(arrSECTID.length>0) sSECTID1_FieldName = arrSECTID[0];
		if(arrSECTID.length>1) sSECTID2_FieldName = arrSECTID[1];
	}
      
	var sZipCd      = $("#"+ sZIPCD_FieldName ).val();		//우편번호
	var sADDR	    = $("#"+ sADDR_FieldName ).val();		//주소
  
	var get_list_onload="false";

	var url = "crm/dr.DR01A01/initOpenAPI?formname=" 	 + sFormName + 
				"&zipcd="		 + sZIPCD_FieldName +		//우편번호
				"&addr=" 		 + encodeURIComponent(sADDR_FieldName);			//주소1

	var w = 600;
	var h = 748;
	//var left = (screen.width / 2) - (width / 2);
	//var top = (screen.height / 2) - (height / 2);
	
	var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;
	var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;
	
	var width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
	var height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;
	
	var left_ = ((width / 2) - (w / 2)) + dualScreenLeft;
	var top_ = ((height / 2) - (h / 2)) + dualScreenTop;
	
	//window.open(url, "PopupZipSearch", "width=" + w + ", height=" + h + ", top=" + top_ + ", left=" + left_ + ", toolbar=no, scrollbars=yes, resizable=yes");
	window.open(url, "PopupZipSearch", "width=" + w + ", height=" + h + ", toolbar=no, scrollbars=yes, resizable=yes");
}

/**********************************************
 * 함수명 : null여부 체크
 * 설  명 : null여부 체크 - SMARTCRM 소스 참고
 */
function isNull(sValue) {
	
	if((typeof sValue)=="number") sValue = sValue.toString();

	if (sValue == null || sValue == "")
		return true;
	var esc = sValue.match(/\S/);
	if (esc == null || esc == "")
		return true;
	return false;
}


/**********************************************
 * 함수명 : 숫자 Comma제거
 * 설  명 : 넘어온 수치데이터 obj.value에 Comma제거
 */
function expNumberComma(obj) {
	obj.value = getNoComma(obj.value);
}

function getNoComma(val){
	var result;
	result = val.replace(/,/g, "");
	return result;
}

/**********************************************
 * 함수명 : 금액의 comma추가
 * 설  명 : 금액의 comma추가 (cf_AddComma() 참고)
 */
function getAddComma(str) {
	var nstr = '';
	str = '' + str + '';
	var minus = '';
	var flootstr = '';
	if (str.charAt(0) == '-') {
		minus = '-';
		str = str.substring(1);
	}
	if (str.indexOf('.') > -1) {
		flootstr = str.substring(str.indexOf('.'));
		str = str.substring(0, str.indexOf('.'));
	}
	if (str.length < 4)
		return (minus + str + flootstr);

	c = str.length % 3;

	for (ci = 0; ci < str.length; ci++) {
		if ((ci % 3) == c && ci != 0)
			nstr += ',';

		nstr += str.charAt(ci);
	}
	return (minus + nstr + flootstr);
}


/**********************************************
 * 함수명 : 두개의 value 총합계를 계산하여 SET
 * 설  명 : val1, val2 한개 이상 값이 입력된 경우 합한 금액 sumId에 SET
 */
function setSumTotal(sumId, val1Id, val2Id) {
	
	if (typeof(sumId) == "undefined" || typeof(val1Id) == "undefined" || typeof(val2Id) == "undefined") return;
	
	//var sum = $("#" + sumId ).val();
	var val1 = $("#" + val1Id ).val();
	var val2 = $("#" + val2Id ).val();
	/*
	if(sum != '' && val1 != '') {
		$("#" + val2Id ).val(Number(sum) - Number(val1));
	}
	if(val1 != '' && val2 != '') {
		$("#" + sumId ).val(Number(val1) + Number(val2));
	}
	if(val2 != '' && sum != '') {
		$("#" + val1Id ).val(Number(sum) - Number(val2));
	}
	*/
	if(val1 != '' || val2 != '') {
		$("#" + sumId ).val(Number(val1) + Number(val2));
	}
}

/**********************************************
 * 함수명 : 나모에디터 데이터 입력 여부 체크
 * 설  명 : 나모에디터 데이터 입력 여부 체크
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.06.02	jhong		최초생성
 */
function isNamoEditorEmpty(str) {
	var isEmpty = false;
	if (typeof(str) == "undefined" || str == "") {
		isEmpty = true;
		
	} else if (str == "<p><br></p>" || str == "<br>" || str == "<p>&nbsp;</p>" ) { // 아무것도 입력하지 않아도 기본으로 저장되는 태그
		isEmpty = true;
	}
	
	//showlog("isNamoEditorEmpty() isEmpty="+isEmpty+", str="+str);
	return isEmpty;
}

/**********************************************
 * 함수명 : 업로드 파일 체크
 * 설  명 : 업로드 파일 체크
 *
 * 수정일			수정자		수정내용
 * ------		------		-------------------
 * 2016.06.03	jhong		최초생성
 */
function fnCheckFileMulti(flag, posblDivId, imposblDivId) {
	//showlog("fnCheckFileMulti() flag="+flag+", posblDivId="+posblDivId+", imposblDivId="+imposblDivId);
	if (typeof(posblDivId) == "undefined") posblDivId = "file_upload_posbl";
	if (typeof(imposblDivId) == "undefined") imposblDivId = "file_upload_imposbl";
	//showlog("fnCheckFileMulti() posblDivId="+posblDivId+", imposblDivId="+imposblDivId);
	
	if (flag=="Y") {
		$("#"+posblDivId).show();
		$("#"+imposblDivId).hide();
		
	} else {
		$("#"+posblDivId).hide();
		$("#"+imposblDivId).show();
	}
}
