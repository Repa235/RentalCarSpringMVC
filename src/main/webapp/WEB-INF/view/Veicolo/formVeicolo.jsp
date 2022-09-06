<%--
  Created by IntelliJ IDEA.
  User: Antonio Repaci
  Date: 01/09/2022
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
        <div align="center">
            <h4>Form veicolo</h4>
        </div>
        <form:form method="post" action="aggiungiVeicolo" modelAttribute="veicoloDto" cssClass="form-control">
            <form:errors path="*" element="div"/>
            <div class="input-group mb-3">
                <span class="input-group-text">Casa costruttrice</span>
                <form:input path="casaCostruttrice" type="text" placeholder="Casa costruttrice" class="form-control"/>
                <span class="input-group-text">Modello</span>
                <form:input path="modello" type="text" placeholder="Modello" class="form-control"/>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Anno Immatricolazione</span>
                <form:input path="annoImmatricolazione" type="text" placeholder="Anno Immatricolazione" class="form-control"/>
                <span class="input-group-text">Tipo</span>
                <form:input path="tipo" type="text" placeholder="Tipo" class="form-control"/>
            </div>
            <button type="submit" class="btn btn-primary">Invia dati</button>
        </form:form>
    </div>
</div>
