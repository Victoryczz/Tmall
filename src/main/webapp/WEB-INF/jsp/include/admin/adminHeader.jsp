<%--
  Created by IntelliJ IDEA.
  User: vczz
  Date: 2018/3/2
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
        pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/back/style.css" rel="stylesheet">

    <!--一些函数-->
    <script>
        <!--检查是否为空-->
        function checkEmpty(id, name) {
            var value = $("#"+id).val();
            if (value.length == 0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }
        <!--检查是否为数字-->
        function checkNumber(id, name) {
            var value = $("#"+id).val();
            if (value.length == 0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            if (isNaN(value)){
                alert(name+"必须是数字");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }
        <!--检查是否是整数-->
        function checkInt(id, name) {
            var value = $("#"+id).val();
            if (value.length == 0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            if (parseInt(value)!=value){
                alert(name+"必须是整数");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }
        <!--删除提醒-->
        $(function () {
            $("a").click(function () {
                var deleteLink = $(this).attr("deleteLink");
                console.log(deleteLink);
                if ("true" == deleteLink){
                    var confirmDelete = confirm("确认要删除");
                    if (confirmDelete)
                        return true;
                    return false;
                }
            });
        })
    </script>

</head>
<body>

</body>
</html>
