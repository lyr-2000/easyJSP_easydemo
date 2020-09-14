<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav aria-label="Page navigation" class="col-lg-offset-4">
    <ul class="pagination ">
<%--        <li>--%>
<%--            <a href="#" aria-label="Previous">--%>
<%--                <span aria-hidden="true">&laquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>

    <c:forEach  begin="1" var="i"  end="${param.totalPage}">
        <!-- 判断当前页 -->
        <c:if test="${requestScope.curPage==i}">
            <li class="active"><a href="javascript:void(0);">${i}</a></li>
        </c:if>

        <c:if test="${requestScope.curPage!=i}">
            <li><a href="${pageContext.request.contextPath}/${param.url}?page=${i}">${i}</a></li>
        </c:if>
    </c:forEach>

<%--        <li>--%>
<%--            <a href="#" aria-label="Next">--%>
<%--                <span aria-hidden="true">&raquo;</span>--%>
<%--            </a>--%>
<%--        </li>--%>
    </ul>
</nav>