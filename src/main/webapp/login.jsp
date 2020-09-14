<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>


<html>
<jsp:include page="common/head.jsp"   >
    <jsp:param name="title" value="登录页面"/>
</jsp:include>
<body>

<%--<div class="form">--%>
<%--    <form action="login">--%>
<%--        <input type="text" placeholder="输入用户名字" name="username"> <br>--%>
<%--        <input type="password" placeholder="输入用户密码" name="password"> <br>--%>
<%--    </form>--%>
<%--</div>--%>

<c:set var="fragment">

    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"> 用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" name="username" placeholder=" 名字"  >
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">用户密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control"  name="password" placeholder="密码"  >
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
    <jsp:param name="url" value="login.do"/>
</jsp:include>

</body>
</html>
