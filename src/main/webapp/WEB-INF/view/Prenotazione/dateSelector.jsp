<%--
  Created by IntelliJ IDEA.
  User: Antonio Repaci
  Date: 29/08/2022
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
        <div align="center">
            <h4>Per quanto tempo ti serve il nostro veicolo ?</h4>
        </div>

        <form method="post" action="selectVeicoloByDates" class="form-control">
            <input type="hidden" name="prenId" value="${prenotazione.id}">
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Dal:</span>
                <input type="date" value="${prenotazione.dataInizio}" name="dal" class="form-control">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Al:</span>
                <input type="date" value="${prenotazione.dataFine}" name="al" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Fammi vedere i veicoli disponibili per queste date</button>
        </form>
    </div>
</div>
