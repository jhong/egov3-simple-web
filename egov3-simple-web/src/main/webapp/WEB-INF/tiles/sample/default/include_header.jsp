<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%//@ page import ="gep.cmm.GepConstant" %>
</head>
<body>
<div id="wrapper"><!-- #wrapper -->

	<header><!-- header -->
		<h1><a href="#">Simple eFovFrame3</a></h1>
		<h2>[default] header.jsp</h2>
		<img src="<c:url value='/images/sample/default/headerimg.jpg'/>" width="940" height="200" alt=""><!-- header image -->
	</header><!-- end of header -->
	
	<nav><!-- top nav -->
		<div class="menu">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Products</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Support</a></li>
				<li><a href="#">Contact Us</a></li>
			</ul>
		</div>
	</nav><!-- end of top nav -->


<%--
<%
// 해외전시 최상위메뉴
request.setAttribute("MENUNO_TOP_FRONT_OVS", GepConstant.MENUNO_TOP_FRONT_OVS);
request.setAttribute("DESIGN_TYPE", GepConstant.DESIGN_TYPE_FRONT_OVS);
%>
<c:import url="/frt/main/frtMainMenuHead.do?tmpUpperMenuId=${MENUNO_TOP_FRONT_OVS}&designType=${DESIGN_TYPE}" />
--%>
