<%--
  Created by IntelliJ IDEA.
  User: vczz
  Date: 2018/3/3
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<title>编辑分类</title>

<script>
    $(function () {
        $("#editForm").submit(function () {
           if (!checkEmpty("name", "分类名称"))
               return false;
           return true;
        });
    })
</script>

<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a> </li>
        <!--该页面是编辑页面，所以编辑分类标签恒active-->
        <li class="active">编辑分类</li>
    </ol>

    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑分类</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin_category_update" enctype="multipart/form-data">
                <table class="editTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input id="name" name="name" value="${category.name}" type="text" class="from-control"/></td>
                    </tr>
                    <tr>
                        <td>分类图片</td>
                        <td><input type="file" id="categoryPic" accept="image/*" name="image"/></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${category.id}"/>
                            <button type="submit" class="btn btn-success">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>