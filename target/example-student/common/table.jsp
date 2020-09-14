<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table table-bordered table-hover"  style="margin: auto;width: 60%">

    <thead>
    <tr>

        <c:forEach  items="${param.titles }" var="i" varStatus="status">
           <th><c:out value="${i}" /></th>

        </c:forEach>

    </tr>
    </thead>
    <tbody>
        ${param.rows}

    </tbody>
</table>
