<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="wrapper">
    <div class="content">
        <div class="formLogin">
            <form:form action="login" modelAttribute="form">
                <ul>
                    <li>
                        <form:input path="username" class="inputClass" placeholder="username" />
                    </li>
                    <li>
                        <form:password path="password" class="inputClass" placeholder="password"/>
                    </li>
                    <li>
                        <input type="submit" value="Login" class="inputClass btnSubmit" />
                    </li>
                    <li>
                        <p>Not registered? <a onclick="" href="#">Create an account</a></p>
                    </li>
                </ul>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>