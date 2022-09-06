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
            <h4>Form utente</h4>
        </div>

        <form:form method="post" action="modificaAggiungiUtente" modelAttribute="customerDto" cssClass="form-control">
            <form:errors path="*" element="div"/>
            <form:hidden path="id" value="${customer.id}"/>
            <form:hidden path="tipo" value="customer"/>
            <div class="input-group mb-3">
                <span class="input-group-text">Nome</span>
                <form:input path="nome" type="text" placeholder="Nome" class="form-control" value="${customer.nome}"/>
                <span class="input-group-text">Cognome</span>
                <form:input path="cognome" type="text" placeholder="Cognome" class="form-control"
                            value="${customer.cognome}"/>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Data di nascita</span>
                <form:input path="dataNascita" type="date" class="form-control" value="${customer.dataNascita}"/>
            </div>

            <div class="input-group mb-3">
                <span class="input-group-text">Username</span>
                <form:input path="username" type="text" class="form-control" placeholder="Username"
                            value="${customer.username}"/>
                <span class="input-group-text">Password</span>
                <form:input path="password" type="text" class="form-control" placeholder="Password"
                            value="${customer.password}"/>
            </div>

            <button type="submit" class="btn btn-primary">Invia dati</button>
        </form:form>


    </div>
</div>
