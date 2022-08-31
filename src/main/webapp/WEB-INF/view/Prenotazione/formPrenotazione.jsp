<%--
  Created by IntelliJ IDEA.
  User: Antonio Repaci
  Date: 30/08/2022
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
        <div align="center">
            <h4>Completa la prenotazione del veicolo</h4>
        </div>
        <form:form method="POST" action="inserisciPrenotazione" modelAttribute="newPrenotazioneDto" class="form-control">
            <form:hidden path="id_utente" value="2"/>
            <form:hidden path="dataInizio" value="${dal}"/>
            <form:hidden path="dataFine" value="${al}"/>
            <p>Dal: ${dal}</p>
            <p>Al: ${al}</p>
            <form:select path="id_veicolo" cssClass="form-control">
                <c:forEach var="v" items="${lv}">
                    <form:option value="${v.id}" label="${v.casaCostruttrice} ${v.modello}"/>
                </c:forEach>
            </form:select>
            <input type="submit">
        </form:form>
    </div>
</div>
