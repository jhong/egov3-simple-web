<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Member Login</title>
<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.12.0.min.js'/>"></script>
<script type="text/javascript">
function doLogin() {
	var form = document.forms["logInForm"];
	form.submit();
}

$(document).ready(function(){
	doLogin();
});
</script>    
</head>
<body>
resultVO : ${resultVO}
<form id="logInForm" name="logInForm" method="POST" action="<c:url value='${loginProcessingUrl}'/>">
	<input type="text" id="j_username" name="j_username" value="${resultVO.userSe}${resultVO.id}"/>
	<input type="password"  name="j_password" id="j_password" value="${resultVO.uniqId}"/>
</form>
</body>
</html>
