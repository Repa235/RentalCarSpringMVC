<%--
  Created by IntelliJ IDEA.
  User: Antonio Repaci
  Date: 29/08/2022
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h2><spring:message code="parcoauto.titolo"/></h2>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col"><spring:message code="parcoauto.tabella.idveicolo"/></th>
        <th scope="col"><spring:message code="parcoauto.tabella.casacostruttrice"/></th>
        <th scope="col"><spring:message code="parcoauto.tabella.modello"/></th>
        <th scope="col"><spring:message code="parcoauto.tabella.annoimmatricolazione"/></th>
        <th scope="col"><spring:message code="parcoauto.tabella.tipo"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ve" items="${ListVeicoli}">
        <tr>
            <th scope="row">${ve.id}</th>
            <td>${ve.casaCostruttrice}</td>
            <td>${ve.modello}</td>
            <td>${ve.annoImmatricolazione}</td>
            <td>${ve.tipo}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>