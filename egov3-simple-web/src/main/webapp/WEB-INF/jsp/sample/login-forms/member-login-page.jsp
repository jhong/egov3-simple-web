<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member Login</title>
</head>
<body>
<c:import url="../header.jsp"/>

<h3>Member Login</h3>

<form id="logInForm" method="POST" action="<c:url value='/member/login-process'/>">

    <fieldset>
        <label>
            <span>
                <input type="text" id="id" name="id"/>
            </span>
        </label>

        <label>
            <span>
                <input type="password"  name="password" id="password"/>
            </span>
        </label>

        <label>
            <span>
                <input type="text" id="userSe" name="userSe" value="GNR"/>
            </span>
        </label>

        <div>
            <button>
                Login
            </button>
        </div>
    </fieldset>
</form>
<div>
loginStatus parameter : ${param.loginStatus}
<br/>
loginMessage attribute : ${loginMessage}
</div>
</body>
</html>
