<%@ page import="java.util.List" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" th:href="@{/api/css/jquery.pagination.css}">
<script th:src="@{/api/js/jquery.pagination.min.js}"></script>
<html>
<head>
    <title>汽车销售系统-价格查询</title>
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
<body style="margin:0px;background: url(${pageContext.request.contextPath}/static/images/main.jpg) no-repeat;background-size:100% 100%;background-attachment:fixed;">
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
    <h1>价格查询</h1>
    <table border="2" style="font-size: 25px">
        <tr>
            <td colspan="6">
                <form action="${pageContext.request.contextPath}/car/getList" method="get">
                    名称：<input type="text" id="name" name="name" value="${query.name}">
                    品牌：
                    <select name="brand" id="brand">
                        <option value="">请选择：</option>
                        <c:forEach items="${brandList}" var="brand">
                            <option value="${brand}"
                                    <c:if test="${brand==query.brand}">selected</c:if>>${brand}</option>
                        </c:forEach>
                    </select>
                    类型：
                    <select name="type" id="type">
                        <option value="">请选择：</option>
                        <c:forEach items="${typeList}" var="type">
                            <option value="${type}" <c:if test="${type==query.type}">selected</c:if>>${type}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" class="button" value="搜索">
                </form>
            </td>
        </tr>
        <tr>
            <th>名称</th>
            <th>品牌</th>
            <th>类型</th>
            <th>价格</th>
            <th>销售量</th>
        </tr>
        <c:forEach var="car" items="${carList}">
            <tr>
                <td>${car.name}</td>
                <td>${car.brand}</td>
                <td>${car.type}</td>
                <td align="right">${car.startPrice}-${car.endPrice}万元</td>
                <td align="right">${car.count}辆</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6">
                <div>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:if test="${pages == 1}">
                                <li class="disabled">
                                </li>
                            </c:if>
                            <c:if test="${pages != 1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/car/getList?name=${query.name}&brand=${query.brand}&type=${query.type}&pageNum=${pageNum - 1}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:forEach begin="1" end="${pages}" var="i">
                                <c:if test="${pageNum == i}">
                                    <li class="active"><a
                                            href="${pageContext.request.contextPath}/car/getList?name=${query.name}&brand=${query.brand}&type=${query.type}&pageNum=${i}">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageNum != i}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/car/getList?name=${query.name}&brand=${query.brand}&type=${query.type}&pageNum=${i}">${i}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${pages == 1}">
                                <li class="disabled">
                                </li>
                            </c:if>
                            <c:if test="${pages != 1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/car/getList?name=${query.name}&brand=${query.brand}&type=${query.type}&pageNum=${pageNum + 1}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <span style="font-size: 25px;margin-left: 5px;">
                                共${total}条记录，共${pages}页
                            </span>
                        </ul>
                    </nav>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

