<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@ page import ="gep.cmm.GepConstant" %>
<%@ page import ="gep.cmm.service.impl.SiteVO" %>
<%
	SiteVO siteVO = (SiteVO)request.getAttribute("siteVO");
	String currentMenuNo = siteVO == null ? null : siteVO.getSiteMenuNo();
	request.setAttribute("currentMenuNo", currentMenuNo);
	// 해외전시 최상위메뉴
	request.setAttribute("MENUNO_TOP_FRONT_OVS", GepConstant.MENUNO_TOP_FRONT_OVS);
%>
<c:import url="/frt/main/frtMainMenuLeft.do?tmpUpperMenuId=${MENUNO_TOP_FRONT_OVS}&currentMenuNo=${currentMenuNo}" />
--%>
[default] left.jsp