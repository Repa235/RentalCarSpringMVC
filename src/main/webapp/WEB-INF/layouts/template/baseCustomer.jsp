<%--
  Created by IntelliJ IDEA.
  User: Antonio Repaci
  Date: 25/08/2022
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <title><tiles:insertAttribute name="titolo"/></title>
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <h3 style="color: white">SpringAutoRental</h3>
            </a>
            <div style="width: 100px"></div>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="../Homepage" class="nav-link px-2 text-white"><spring:message code="header.home"/></a></li>
                <c:url var="parcoAuto" value="veicolo"/>
                <li><a href="../${parcoAuto}" class="nav-link px-2 text-white"><spring:message
                        code="header.parcoauto"/></a></li>
                <c:url var="toProfilo" value="/utente/toProfilo" />
                <li><a href="${toProfilo}" class="nav-link px-2 text-white">Profilo utente</a></li>
                <sec:authorize access="isAuthenticated()">
                    <c:url var="toLogout" value="/logout" />
                    <li><a href="${toLogout}" class="nav-link px-2 text-white">Logout</a></li>
                </sec:authorize>
            </ul>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a class="nav-link px-2 text-white" href="?language=en">EN</a></li>
                <li><a class="nav-link px-2 text-white" href="?language=it">IT</a></li>
            </ul>
        </div>
    </div>
</header>
<header class="p-3 mb-3 border-bottom">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <h3 style="color: black"><spring:message code="header.customer.benvenuto"/> ${customer.nome} ${customer.cognome} </h3>
        </div>
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li>
                    <c:url value="/veicolo/visualizzaVeicoliUtente" var="veicoliUtente"/>
                    <a href="${veicoliUtente}" class="btn btn-link"><spring:message code="header.customer.visualizzaveicoli"/></a>
                </li>
                <c:url value="/prenotazione/dateSelector" var="formDatePrenotazione">
                    <c:param name="prenId" value="new"/>
                </c:url>
                <li><a href="${formDatePrenotazione}" class="btn btn-link"><spring:message code="header.customer.prenotaveicolo"/></a></li>

                <li>
                    <form action="../utente/formUtente" method="get">
                        <input type="hidden" name="customerId" value="${customer.id}">
                        <input type="hidden" name="utenteRichiedente" value="customer">
                        <button type="submit" class="btn btn-link"><spring:message code="header.customer.modifica"/></button>
                    </form>

                </li>
            </ul>

        </div>
    </div>
</header>

<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>
</html>
