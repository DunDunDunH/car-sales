<%@ page import="java.util.List" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>汽车销售系统-订单管理</title>
    <style type="text/css">
        * {
            padding: 0;
            margin: 0;
        }

        .nav {
            height: 30px;
            width: 100%;
            box-shadow: 5px 5px 8px 0px gray;
        }

        .icon {
            float: left;
        }

        ul {
            list-style-type: none;
        }

        ul li:first-child {
            padding-left: 50px;
        }

        ul li {
            float: left;
            line-height: 30px;
            text-align: center;
            box-sizing: border-box;
            cursor: pointer;
            padding-left: 20px;
        }

        ul > li > a:hover {
            color: lightblue;
        }

        a {
            text-decoration: none;
            color: black;
        }

        .lnr {
            font-size: 20px;
            vertical-align: -5px;
        }

        .rightside-nav {
            float: right;
        }

        .rightside-nav a {
            line-height: 30px;
            text-align: center;
            box-sizing: border-box;
            cursor: pointer;
        }

        .rightside-nav a:last-child {
            padding-right: 80px;
        }
    </style>
</head>
<body style="margin:0px;background: url(${pageContext.request.contextPath}/static/images/empty.jpg) no-repeat;background-size:100% 100%;background-attachment:fixed;">
<div class="nav" style="background-color: antiquewhite">
    <div class="rightside-nav" style="color: white">
        <a href="${pageContext.request.contextPath}/car/index"><span class="lnr lnr-user"></span><span>Hi,${userName}</span></a>&nbsp&nbsp&nbsp&nbsp
        <a href="${pageContext.request.contextPath}/car/index"><span class="lnr lnr-home"></span><span>首页</span></a>&nbsp&nbsp&nbsp&nbsp
        <a href="${pageContext.request.contextPath}/car/order"><span class="lnr lnr-home"></span><span>订单管理</span></a>&nbsp&nbsp&nbsp&nbsp
        <a href="${pageContext.request.contextPath}/car/getList"><span class="lnr lnr-home"></span><span>价格查询</span></a>&nbsp&nbsp&nbsp&nbsp
        <a href="${pageContext.request.contextPath}/user/logout"><span class="lnr lnr-home"></span><span>注销</span></a>
    </div>
</div>
<div align="center" style="padding-top: 100px">
    <h1>订单管理</h1>
</div>
</body>
</html>

