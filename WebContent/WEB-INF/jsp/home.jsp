<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<link href="../css/common.css?timestamp=current_time" rel="stylesheet" type="text/css" />
<link href="../css/home/style.css?timestamp=current_time" rel="stylesheet" type="text/css" />
<script src="../js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="../js/home/script.js" type="text/javascript"></script>
</head>
<body>
<div class="wrapper">
    <div class="content">
        <form:form id="form" action="" method="POST" modelAttribute="form">
            <div class="content-header">
                <div class="content-left">
                    Welcome
                </div>
                <div class="content-mid">
                    BestScore
                </div>
                <div class="content-right">
                    <input type="button" id="btnLogout" value="Logout" class="btnSubmit btnLogout" />
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="content-body">
                <input type="button" id="btnFight" value="Fight" class="btnSubmit btnFight" />
            </div>
            
            <div class="content-footer">
                <div class="content-left footer-fix">
                    <input type="button" id="btnHighScore" value="HighScore" class="btnSubmit btnLogout" />
                </div>
                <div class="content-right">
                    <input type="button" id="btnTraining" value="Training" class="btnSubmit btnLogout" />
                </div>
                <div class="clear"></div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>