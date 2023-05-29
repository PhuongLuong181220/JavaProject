<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<style>
    .error {
        color: red;
    }
</style>
<jsp:include page="/jsp/common/nav.jsp"></jsp:include>

<div class="container">
    <br>
    <h1>Chi tiết tài khoản</h1>
    <h2 style="color: red">${message}</h2>
    <br>
    <div class="row mb-4">
        <div class="col-md-4">
            <label for="validationCustomUsername" class="form-label">Tên đăng nhập</label>
            <div class="input-group has-validation">
                <span class="input-group-text" id="inputGroupPrepend">@</span>
                <input type="text" class="form-control" value="${user.userName}" id="validationCustomUsername"
                       aria-describedby="inputGroupPrepend" readonly="true"/>
            </div>
        </div>

    </div>
    <div class="row mb-4">
        <div class="col-md-6">
            <label for="validationCustom03" class="form-label">Họ và tên</label>
            <input type="text" class="form-control" value="${user.fullName}" readonly="true" path="fullName"
                   id="validationCustom03"/>
        </div>
        <div class="col-md-3">
            <label for="validationCustom04" class="form-label">Trạng thái</label>
            <select class="form-select" path="status" id="validationCustom04" disabled>
                <option value="-1">Trạng thái</option>
                <option <c:if test="${user.status == 1}"> selected</c:if> value="1">Kích hoạt</option>
                <option  <c:if test="${user.status == 1}"> selected</c:if> value="0">Tạm dừng</option>
            </select>
        </div>
        <div class="col-md-3">
            <label for="validationCustom14" class="form-label">Quyền</label>
            <select class="form-select" path="role" id="validationCustom14" disabled>
                <option value="">Danh sách quyền</option>
                <option  <c:if test="${user.role == 'ADMIN'}"> selected</c:if> value="ADMIN">Người quản trị</option>
                <option <c:if test="${user.role == 'USER'}"> selected</c:if> value="USER">Nhân viên</option>
                <option <c:if test="${user.role == 'CUSTOMER'}"> selected</c:if> value="CUSTOMER">Khách hàng</option>
            </select>
        </div>
    </div>
    <div class="row mb-4">
        <div class="col-12">
            <label for="validationCustom08" class="form-label">Địa chỉ</label>
            <input type="text" readonly="true" value="${user.address}" class="form-control" path="address"
                   id="validationCustom08"/>

        </div>
    </div>
    <div class="row mb-4">
        <div class="col-12">
            <a href="/backend/user/list" class="btn btn-info" >Trở về</a>
        </div>
    </div>

</div>