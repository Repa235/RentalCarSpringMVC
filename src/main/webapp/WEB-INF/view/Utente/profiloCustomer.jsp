<%--
  Created by IntelliJ IDEA.
  User: Antonio Repaci
  Date: 29/08/2022
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
        <div align="center">
            <h4>Le tue prenotazioni</h4>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Data inizio</th>
                <th scope="col">Data fine</th>
                <th scope="col">Veicolo</th>
                <th scope="col">Approvata</th>
                <th scope="col">Modifica</th>
                <th scope="col">Elimina</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="prenotazione" items="${customer.prenotazioni}">
                <tr>
                    <td>${prenotazione.dataInizio}</td>
                    <td>${prenotazione.dataFine}</td>
                    <td>${prenotazione.veicolo.casaCostruttrice} ${prenotazione.veicolo.modello}</td>
                    <td>
                        <c:choose>
                            <c:when test="${prenotazione.approvato}">SI</c:when>
                            <c:otherwise>NO</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${now gt prenotazione.dataFine}">
                                <p>Scaduta</p>
                            </c:when>
                            <c:otherwise>
                                <c:url value="/prenotazione/dateSelector" var="formDatePrenotazione">
                                    <c:param name="prenId" value="${prenotazione.id}"/>
                                </c:url>
                                <a href="${formDatePrenotazione}">Modifica</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${now gt prenotazione.dataFine}">
                                <p>Scaduta</p>
                            </c:when>
                            <c:otherwise>
                                <c:url value="/prenotazione/eliminaPrenotazione" var="eliminaPrenotazione">
                                    <c:param name="prenId" value="${prenotazione.id}"/>
                                </c:url>
                                <a href="${eliminaPrenotazione}">Elimina</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
