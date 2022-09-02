<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
        <form action="searchUtenti" method="get">
            <div class="input-group">
                <span class="input-group-text">Cerca utente per: </span>
                <select class="form-select" name="filtraPer">
                    <option value="nome"> Nome</option>
                    <option value="cognome"> Cognome</option>
                </select>
                <span class="input-group-text">Testo da cercare: </span>
                <input type="text" name="text" class="form-control">
                <button type="submit" class="btn btn-outline-secondary">Cerca</button>
                <a href="profiloSuperuser" type="button" class="btn btn-outline-warning">Reset</a>
            </div>
        </form>
        <br>
        <table class="table table-bordered">
            <tr>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Data di nascita</th>
                <th>Prenotazioni</th>
                <th>Modifica</th>
                <th>Elimina</th>
            </tr>
            <c:forEach var="cliente" items="${clienti}">
                <tr>
                    <td>${cliente.nome}</td>
                    <td>${cliente.cognome}</td>
                    <td>${cliente.dataNascita}</td>
                    <td>
                        <form action="#" method="post">
                            <input type="hidden" name="id" value="${cliente.id}">
                            <input type="submit" value="Visualizza">
                        </form>
                    </td>
                    <td>
                        <form action="#" method="post">
                            <input type="hidden" name="id" value="${cliente.id}">
                            <input type="submit" value="Modifica">
                        </form>
                    </td>
                    </td>
                    <td>
                        <form action="#" method="post">
                            <input type="hidden" name="id" value="${cliente.id}">
                            <input type="submit" value="Elimina">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>