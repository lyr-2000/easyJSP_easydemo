<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html>
<jsp:include page="common/head.jsp"   >
    <jsp:param name="title" value="学生管理"/>
</jsp:include>
<body>

<br><br><br><br><br><br>

<c:set var="rows">
    <c:forEach  items="${rows}" var="i" varStatus="status">
        <tr>
            <td><c:out value="${i.studentId}" /></td>
            <td><c:out value="${i.studentName}" /></td>
            <td><c:out value="${i.sex}" /></td>
            <td><c:out value="${i.gmtCreate}" /></td>
            <td><c:out value="${i.gmtModified}" /></td>
            <td>
                <button class="btn btn-primary" onclick="edit(${i.studentId})"  >编辑</button>
                <button class="btn btn-warning">删除</button>
            </td>
        </tr>

    </c:forEach>
</c:set>
<jsp:include page="common/table.jsp"   >
    <jsp:param name="titles" value='${["ID","名字","性别","创建时间","更新时间","操作"]}'/>


    <jsp:param name="rows" value="${rows}" />

</jsp:include>
<br><br><br><br><br><br>
<h3  style="text-align: center">
    总记录数为 ${count}, 总页数 ${totalPage}
</h3>

<jsp:include page="common/pagination.jsp" >
     <jsp:param name="totalPage"  value="${totalPage}"/>
     <jsp:param name="url"  value="student"/>
</jsp:include>
<script>
    function edit(studentId) {
        window.location.href="editStudent?studentId="+studentId;
    }
</script>
</body>
</html>
