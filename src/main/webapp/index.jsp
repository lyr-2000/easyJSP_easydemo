<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html>
<jsp:include page="common/head.jsp"   >
    <jsp:param name="title" value="首页"/>
</jsp:include>
<body>
<h2>Hello  </h2>

<%-- java 代码 --%>
<%--<%--%>
<%--    String ll = (String) request.getAttribute("hello");--%>

<%--    out.println(ll);--%>
<%--%>--%>
${hellos}
<%--<c:set  var="hello" value="okk"  scope="request" />--%>

<c:out  value="${helloworld}"  default="ssssssssss" />


<%--&lt;%&ndash; el标签 &ndash;%&gt;--%>
<c:forEach  items="${ [1,2,3,4 ]}" var="i" varStatus="status">
<%--    <c:out value="${status.index}" />--%>
    <c:out value="${i}" />
</c:forEach>

<%--jstl演示--%>
</body>
</html>
