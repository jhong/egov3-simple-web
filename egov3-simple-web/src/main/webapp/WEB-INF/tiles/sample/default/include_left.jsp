<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="sample.cmm.util.SampleMenuUtil" %>
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

		<aside id="sidebar"><!-- sidebar -->
				<h3>[default] left.jsp</h3>
				<ul>
					<li><a href="#"> </a></li>
					<%--
					<li><a href="#">Chat With Friends</a></li>
					<li><a href="#">Swap Stories</a></li>
					<li><a href="#">Sell Stuff</a></li>
					<li><a href="#">Buy Stuff</a></li>
					<li><a href="#">Trade Stuff</a></li>
					--%>
				</ul>
					
				<%--
				<h3>Sponsors</h3>
				<img src="images/ad180.png" alt="" /><br /><br />

				<h3>Connect With Us</h3>
				<ul>
					<li><a href="#">Twitter</a></li>
					<li><a href="#">Facebook</a></li>
					<li><a href="#">LinkedIn</a></li>
					<li><a href="#">Flickr</a></li>
				</ul>
				--%>

		</aside><!-- end of sidebar -->

<%=SampleMenuUtil.selectMenuList()%>
