<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<style>
    .error {
        color: red;
    }
</style>
<jsp:include page="/jsp/common/nav.jsp" ></jsp:include>

<div class="container">
    <br>
    <h1>Danh sách tài khoản</h1>

    <h2 style="color: red">${message}</h2>
    <br>
    <jsp:include page="/jsp/common/paging_head.jsp" ></jsp:include>


    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Họ và tên</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Tài khoản</th>
            <th scope="col">Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list.list}" var="user" varStatus="s">
            <tr>
                <th scope="row">${s.index + 1} </th>
                <td><a href="/backend/user/${user.id}">${user.fullName}</a></td>
                <td>${user.address}</td>
                <td>${user.userName}</td>
                <td><a href="/backend/user/edit/${user.id}">Sửa</a>
                    <a href="/backend/user/delete/${user.id}" data-bs-toggle="modal"
                       data-bs-target="#deleteUserModal" data-bs-id="${user.id}">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="/jsp/common/paging_foot.jsp" ></jsp:include>
</div>


<div class="modal fade" id="deleteUserModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Bạn có chắc chắn xóa tài khoản không</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="close" data-bs-dismiss="modal">Close</button>
                <button type="button" id="delete" onclick="deleteButton()" class="btn btn-primary">Xóa</button>
            </div>
        </div>
    </div>
</div>

<script>
    var id = null;
    var exampleModal = document.getElementById('deleteUserModal');
    exampleModal.addEventListener('show.bs.modal', function (event) {
        // Button that triggered the modal
        var a = event.relatedTarget;
        // Extract info from data-bs-* attributes
        id = a.getAttribute('data-bs-id');

    })
    function deleteButton() {
        fetch('/backend/user/delete/' + id, {
            method: 'DELETE'
        }).then(async data => {
            alert(await data.text());
            window.location.href = "/backend/user/list";
        }).catch(function() {
            console.log("Booo");
        })
    }
</script>