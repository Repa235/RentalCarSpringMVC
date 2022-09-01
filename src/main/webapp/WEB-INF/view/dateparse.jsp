<%--
  Created by IntelliJ IDEA.
  User: Antonio Repaci
  Date: 01/09/2022
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
        <div class="col-10 col-sm-8 col-lg-6">
            <img src="https://i.giphy.com/media/Q0OqU2N1MN3KU/giphy.webp" class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes" width="350" loading="lazy">
        </div>
        <div class="col-lg-6">
            <h1 class="display-5 fw-bold lh-1 mb-3">
                Data non inserita
            </h1>
            <p class="lead">La data di inizio o fine non è stata inderita</p>
            <p>${url}</p>
            <p class="lead">${exception}</p>
        </div>
    </div>
</div>