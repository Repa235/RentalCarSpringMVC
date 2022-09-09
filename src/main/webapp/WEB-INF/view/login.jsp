<%--
  Created by IntelliJ IDEA.
  User: Antonio Repaci
  Date: 07/09/2022
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:url value="/login" var="loginUrl"/>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
        <form action="${loginUrl}" method="post">
            <h1 class="h3 mb-3 fw-normal">Effettua il login</h1>
            <c:if test="${param.error != null}">
                <p><spring:message code="login.form.error"/></p>
            </c:if>
            <c:if test="${param.forbidden!=null}">
                <p><spring:message code="login.form.forbidden"/></p>
            </c:if>
            <c:if test="${param.logout!=null}">
                <p><spring:message code="login.form.logout"/></p>
            </c:if>
            <div class="form-floating">
                <input type="text" name="userId" class="form-control" id="floatingInput" placeholder="username" required>
                <label for="floatingInput">Username</label>
            </div>
            <div class="form-floating">
                <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password" required>
                <label for="floatingPassword">Password</label>
            </div>

            <div class="checkbox mb-3">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>

        </form>
    </div>
</div>
