<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row" style="padding-bottom: 30px">
    <div class="col-2">
        <a href="/backend/${list.path}/create" style="float: right" class="btn btn-primary" type="submit">Tạo mới</a>
    </div>

    <div class="col-4">
    </div>
    <div class="col-4">
        <div class="d-flex">
            <input class="form-control me-2" id="input-search-list" value="${list.key}"
                   type="search" placeholder="Tìm kiếm" aria-label="Tìm kiếm">
            <button class="btn btn-outline-success" onclick="searchList();" >Tìm</button>
        </div>
    </div>
    <div class="col-2">
        <div class="form-outline">
            <select class="form-select" id="numberPage" onchange="changePage();">
                <option value="4" <c:if test="${list.perpage == 4}"> selected </c:if>>Hiển thị 4 phần tử</option>
                <option value="5" <c:if test="${list.perpage == 5}"> selected </c:if> >Hiển thị 5 phần tử</option>
                <option value="6" <c:if test="${list.perpage == 6}"> selected </c:if>>Hiển thị 6 phần tử</option>
                <option value="7" <c:if test="${list.perpage == 7}"> selected </c:if>>Hiển thị 7 phần tử</option>
            </select>
        </div>
    </div>
    <script>
        function changePage() {
            document.location.href = "/backend/${list.path}/list?page=1&key=${list.key}&perpage=" + document.getElementById("numberPage").value
        }

        function searchList() {
            var key = document.getElementById("input-search-list").value;
            var url = "/backend/${list.path}/list?page=1&perpage=${list.perpage}&key=" + key;
            document.location.href = url;
        }
    </script>
</div>