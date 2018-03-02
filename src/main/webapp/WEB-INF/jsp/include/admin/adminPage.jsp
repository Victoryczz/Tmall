<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vczz
  Date: 2018/3/2
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script>
    $(function () {
        $("ul.pagination li.disabled a").click(function () {
           return false;
        });
    })
</script>

<nav>
    <ul class="pagination">
        <!--首页-->
        <!--自动调用isHasPrevious()方法-->
        <li <c:if test="${!page.hasPrevious}">class="disabled" </c:if>>
            <a href="?start=0${page.param}" aria-label="Previous">
                <span aria-hidden="true">首页</span>
            </a>
        </li>
        <!--上一页-->
        <li <c:if test="${!page.hasPrevious}">class="disabled"</c:if>>
            <a href="?start=${page.start-page.count}${page.param}" aria-label="Previous">
                <span aria-hidden="true"><</span>
            </a>
        </li>
        <!--中间-->
        <!--当在当前页面的时候，当前页面的连接不可点击disable，其变为current属性-->
        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a href="?start=${status.index*page.count}${page.param}"
                        <c:if test="${status.index*page.count==page.start}">class="current"</c:if>>${status.count}
                    </a>
                </li>
        </c:forEach>
        <!--下一页-->
        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="?start=${page.start+page.count}${page.param}" aria-label="Next">
                <span aria-hidden="true">> </span>
            </a>
        </li>
        <!--末页-->
        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="?start=${page.last}${page.param}" aria-label="Next">
                <span aria-hidden="true">末页</span>
            </a>
        </li>
    </ul>
</nav>