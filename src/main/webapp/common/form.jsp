<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-lg-6">
    <div class="panel panel-default">
        <div class="panel-heading"> </div>
        <div class="panel-body" style="min-height: 214px;">
            <form class="form-horizontal" action="${param.url}" method="${param.method}">
                ${param.fragment}
<%--                <div class="form-group">--%>
<%--                    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>--%>
<%--                    <div class="col-sm-10">--%>
<%--                        <input type="password" class="form-control" id="inputPassword3" placeholder="Password">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <div class="col-sm-offset-2 col-sm-10">--%>
<%--                        <div class="checkbox">--%>
<%--                            <label>--%>
<%--                                <input type="checkbox">--%>
<%--                                Remember me--%>
<%--                            </label>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="form-group" style="margin-bottom:0">--%>
<%--                    <div class="col-sm-offset-2 col-sm-10 text-right">--%>
<%--                        <button type="reset" class="btn btn-default">Cancel</button>--%>
<%--                        <button type="submit" class="btn btn-primary">Sign in</button>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </form>
        </div>
    </div>
</div>