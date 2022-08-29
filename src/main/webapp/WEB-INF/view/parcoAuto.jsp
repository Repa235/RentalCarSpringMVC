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
<h2>Ecco i veicoli che si trovano nel nostro parco auto</h2>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Id veicolo</th>
        <th scope="col">Casa costruttrice</th>
        <th scope="col">Modello</th>
        <th scope="col">Anno immatricolazione</th>
        <th scope="col">Tipo</th>
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