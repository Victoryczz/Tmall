<%--
  Created by IntelliJ IDEA.
  User: vczz
  Date: 2018/3/1
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>

<script>
    $(function () {
        $("#addForm").submit(function () {
            if(!checkEmpty("name", "分类名称"))
                return false;
            if (! checkEmpty("categoryPic", "分类图片"))
                return false;
            return true;
        });
    });
</script>

<html>
<head>
    <title>分类管理</title>
</head>
<body>
<div class="workingArea">
<div class="listDataTableDiv">
    <table class="table table-striped table-bordered table-hover table-condensed">
        <thead>
            <tr class="success">
                <th>ID</th>
                <th>图片</th>
                <th>分类名称</th>
                <th>属性管理</th>
                <th>产品管理</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${categories}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <!--根据图片的id来获取图片-->
                    <td><img height="40px" src="img/category/${c.id}.jpg"></td>
                    <td>${c.name}</td>
                    <td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span> </a> </td>
                    <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart" ></span> </a> </td>
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span> </a> </td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="glyphicon glyphicon-trash"></span> </a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="pageDiv">
    <%@include file="../include/admin/adminPage.jsp" %>
</div>

<div class="panel panel-warning addDiv">
    <div class="panel-heading">新增分类</div>
    <div class="panel-body">
        <!--上传文件时必须使用enctype="multipart/form-data",为了保证中文，使用了post方式提交-->
        <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
            <table class="addTable">
                <tr>
                    <td>分类名称</td>
                    <td><input id="name" name="name" type="text" class="form-control"/> </td>
                </tr>
                <tr>
                    <td>分类图片</td>
                    <td><input id="categoryPic" accept="image/*" type="file" name="image"/></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <button type="submit" class="btn btn-success">提  交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</div>
<%@include file="../include/admin/adminFooter.jsp"%>
</body>
</html>





