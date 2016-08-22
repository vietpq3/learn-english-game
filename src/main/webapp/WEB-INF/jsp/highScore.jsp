<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HIGH SCORE</title>
<link href="../css/common.css?timestamp=current_time" rel="stylesheet" type="text/css" />
<link href="../css/highScore/style.css?timestamp=current_time" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="wrapper">
		<div class="content">
			<div class="content-header">
                <div class="content-left">
                    Welcome: ${loginUser}
                </div>
                <div class="content-mid">
                    BestScore: ${highScore}
                </div>
                <div class="content-right">
                    <button id="btnLogout" class="btnSubmit btnLogout">Logout</button>
                </div>
                <div class="clear"></div>
            </div>
			<div class="content-body">
				<c:if test="${not empty pageInfo && pageInfo.totalRecord > 0}">
					<c:set var="msg~" value="～"></c:set>
					<c:set var="msg/" value="/"></c:set>
				</c:if>
			</div>
			<div class="content-footer">
			</div>
		</div>
	</div>
</body>
</html>