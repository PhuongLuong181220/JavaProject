<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/font/fontawesome.min.css" rel="stylesheet">
<script src="/js/bootstrap.bundle.min.js"></script>


<nav class="navbar navbar-dark bg-primary navbar-expand-lg ">
    <div class="container">
        <a class="navbar-brand" href="#">T3H</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link <c:if test="${path == null}">active</c:if>" aria-current="page" href="#">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <c:if test="${path == 'user'}">active</c:if> " href="/backend/user/list">Tài khoản</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle <c:if test="${path == 'brand' || path == 'category'}">active</c:if>" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Nhãn hiệu
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item <c:if test="${path == 'brand'}">active</c:if>" href="/backend/brand/list">Thương hiệu</a></li>
                        <li><a class="dropdown-item <c:if test="${path == 'category'}">active</c:if>" href="/backend/category/list">Thể loại</a></li>
                    </ul>
                </li>
            </ul>
            <span class="navbar-text">
      </span>
        </div>
    </div>
</nav>