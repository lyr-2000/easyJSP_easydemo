<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="common/head.jsp">
    <jsp:param name="title" value="编辑"/>
</jsp:include>
<body>
<c:set var="fragment">
<%--    <c:forEach items="list" >--%>
        <input type="hidden" name="studentId" value="${student.studentId}">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">学生名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="studentName" placeholder="学生名字" value="${student.studentName}">
            </div>
        </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">学生密码</label>
        <div class="col-sm-10">
            <input type="text" class="form-control"  name="studentPassword" placeholder="学生名字" value="${student.studentPassword}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" for="sex">性别</label>
        <div class="col-sm-10">
            <select class=" form-control" id="sex" name="sex"  >
                <option value="1" ${student.sex==1?"selected":""}>男</option>
                <option value="0" ${student.sex==0?"selected":""}>女</option>

            </select>
        </div>
    </div>

    <div class="col-sm-offset-2 col-sm-10 text-right">

        <button type="submit" class="btn btn-primary">点击提交</button>
    </div>
<%--    </c:forEach>--%>
</c:set>
<jsp:include page="common/form.jsp" >
    <jsp:param name="fragment" value="${fragment}"/>
    <jsp:param name="method" value="POST"/>
    <jsp:param name="url" value="editStudent"/>
</jsp:include>

</body>
</html>
