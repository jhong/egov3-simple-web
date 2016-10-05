<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="egovframework.rte.psl.dataaccess.util.EgovMap" %>
<%@ page import ="egovframework.com.sym.mnu.mpm.service.MenuManageVO" %>
<%@ page import ="java.util.List" %>
<%@ page import ="sample.cmm.util.SampleMenuUtil" %>
<%@ page import ="sample.cmm.service.MenuNode" %>

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
					<%--
					<li><a href="#">Chat With Friends</a></li>
					<li><a href="#">Swap Stories</a></li>
					<li><a href="#">Sell Stuff</a></li>
					<li><a href="#">Buy Stuff</a></li>
					<li><a href="#">Trade Stuff</a></li>
					--%>
<%
/*
List menuList = SampleMenuUtil.selectMenuList();
for (int i=0; menuList!=null && i<menuList.size(); i++) {
	EgovMap menu = (EgovMap)menuList.get(i);
	if ("0".equals(menu.get("upperMenuId")+"")) {
		out.println("<li><a href=\"#\">"+menu.get("menuNm")+"</a></li>");
	}
}
*/

MenuManageVO vo = new MenuManageVO();
vo.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN

MenuNode leftMenuTree = SampleMenuUtil.selectMenuTree(vo);
//out.println(leftMenuTree);
StringBuffer sb = new StringBuffer();
SampleMenuUtil.displayMenuTree(leftMenuTree, leftMenuTree.getDepth(), sb);
out.print(sb.toString().replaceAll("\\n", "<br/>"));
%>
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

