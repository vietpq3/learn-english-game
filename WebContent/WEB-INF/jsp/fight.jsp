<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FIGHT</title>
<link href="../css/common.css?timestamp=${timestamp}" rel="stylesheet" type="text/css" />
<link href="../css/fight/style.css?timestamps=${timestamp}" rel="stylesheet" type="text/css" />
<script src="../js/jquery-2.2.4.min.js?timestamp=${timestamp}" type="text/javascript"></script>
<script src="../js/fight/script.js?timestamp=${timestamp}" type="text/javascript"></script>
</head>
<body>
<div class="wrapper">
    <div class="content">
        <div class="content-header">
            <form:form id="formRedirect" method="POST" modelAttribute="form">
                <div class="content-left">
                    <button id="btnHome" class="btnSubmit btnHome">Home</button>
                </div>
                <div class="content-mid">
                    <span>FIGHT</span>
                </div>
                <div class="content-right">
                    <button id="btnLogout" class="btnSubmit btnLogout">Logout</button>
                </div>
                <div class="clear"></div>
            </form:form>
        </div>
        <div class="clear"></div>
        
        <div class="content-body">
            <c:if test="${empty picInfoList}">
                <h2 class="title">CHOOSE ACTIVITY</h2>
                <div class="content-body-mid">
                    <form:form id="formActivities" method="POST" modelAttribute="form">
                        <button id="btnPicture" class="btnSubmit btnActivities">Picture</button>
                        <button id="btnFillIn" class="btnSubmit btnActivities">Fill in</button>
                        <button id="btnOther" class="btnSubmit btnActivities">Other</button>
                        <form:hidden id="gameMode" path="gameMode"/>
                    </form:form>
                </div>
            </c:if>
            <c:if test="${not empty picInfoList}">
                <form:form id="formActivities" method="POST" modelAttribute="form">
                    <div class="question">
                        <span>${question}</span>
                    </div>
                    <div class="content-body-images">
                        <c:forEach items="${picInfoList}" var="picInfo" >
                            <img alt="Image" src="${picInfo.url}" answer="${picInfo.encryptPictureName}" class="picture" />
                        </c:forEach>
                    </div>
                    <form:hidden path="gameMode"/>
                    <form:hidden path="question" value="${question}"/>
                    <form:hidden path="answer" id="answer" />
                    <form:hidden id="alreadyUseQuestionList" path="alreadyUseQuestionList" value="${alreadyUseQuestionList}" />
                </form:form>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>