<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignUp</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<%@ include file="taglib.jsp" %>
<link href='<c:url value="/css/login/signup.css"/>'" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
  <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-info">
      <!-- Panel heading -->
      <div class="panel-heading">
        <div class="panel-title">Sign In</div>
        <div style="float:right; font-size: 80%; position: relative; top:-10px">
          <a href="#">Forgot password?</a>
        </div>
      </div>

      <!-- Panel body -->
      <div style="padding-top:30px" class="panel-body">
        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
        <form:form id="loginform" class="form-horizontal" role="form" action="login" modelAttribute="form">
          <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon">
              <i class="glyphicon glyphicon-user"></i>
            </span>
            <form:input path="username" type="text" class="form-control" name="username" value="${form.username}" placeholder="username"/>
          </div>

          <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon">
              <i class="glyphicon glyphicon-lock"></i>
            </span>
            <form:input path="password" type="password" class="form-control" name="password" placeholder="password" value="${form.password}"/>
          </div>

          <div class="input-group">
            <div class="checkbox">
              <label>
                <input path="login-remember" type="checkbox" name="remember" value="1"/> Remember me
              </label>
            </div>
          </div>

          <div style="margin-top:10px" class="form-group">
            <!-- Button -->
            <div class="col-sm-12 controls">
              <form:input path="submit" type="submit" value="Login" class="btn btn-success" />
              <!-- <a id="btn-login" href="#" class="btn btn-success">Login </a> -->
              <a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-12 control">
              <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
                Don't have an account!
                <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                  Sign Up Here
                </a>
              </div>
            </div>
          </div>
        </form:form>
      </div>

    </div>
  </div>

  <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="panel-title">Sign Up</div>
        <div style="float:right; font-size: 85%; position: relative; top:-10px">
          <a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a>
        </div>
      </div>
      <div class="panel-body">
        <form id="signupform" class="form-horizontal" role="form">
          <div id="signupalert" style="display:none" class="alert alert-danger">
            <p>Error:</p>
            <span></span>
          </div>

          <div class="form-group">
            <label for="email" class="col-md-3 control-label">Email</label>
            <div class="col-md-9">
              <input type="text" class="form-control" name="email" placeholder="Email Address">
            </div>
          </div>

          <div class="form-group">
            <label for="firstname" class="col-md-3 control-label">First Name</label>
            <div class="col-md-9">
              <input type="text" class="form-control" name="firstname" placeholder="First Name">
            </div>
          </div>
          <div class="form-group">
            <label for="lastname" class="col-md-3 control-label">Last Name</label>
            <div class="col-md-9">
              <input type="text" class="form-control" name="lastname" placeholder="Last Name">
            </div>
          </div>
          <div class="form-group">
            <label for="password" class="col-md-3 control-label">Password</label>
            <div class="col-md-9">
              <input type="password" class="form-control" name="passwd" placeholder="Password">
            </div>
          </div>

          <div class="form-group">
            <label for="icode" class="col-md-3 control-label">Invitation Code</label>
            <div class="col-md-9">
              <input type="text" class="form-control" name="icode" placeholder="">
            </div>
          </div>

          <div class="form-group">
            <!-- Button -->
            <div class="col-md-offset-3 col-md-9">
              <button id="btn-signup" type="button" class="btn btn-info">
                <i class="icon-hand-right"></i>&nbsp;Sign Up</button>
              <span style="margin-left:8px;">or</span>
            </div>
          </div>

          <div style="border-top: 1px solid #999; padding-top:20px" class="form-group">
            <div class="col-md-offset-3 col-md-9">
              <button id="btn-fbsignup" type="button" class="btn btn-primary">
                <i class="icon-facebook"></i>&nbsp;&nbsp;Sign Up with Facebook</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>