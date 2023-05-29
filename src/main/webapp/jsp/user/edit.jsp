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
    <h1>Tạo mới tài khoản</h1>
    <h2 style="color: red">${message}</h2>
    <br>
    <f:form action="/backend/user/update" modelAttribute="user" method="post" class=" g-3 needs-validation" >
        <f:input type="text" class="form-control" path="id" id="validationCustomUsername"
                 aria-describedby="inputGroupPrepend" cssStyle="display: none" />
        <div class="row mb-4">
            <div class="col-md-4">
                <label for="validationCustomUsername" class="form-label">Tên đăng nhập</label>
                <div class="input-group has-validation">
                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                    <f:input type="text" class="form-control" path="userName" id="validationCustomUsername"
                             aria-describedby="inputGroupPrepend" disabled="true"/>
                </div>
                <f:errors cssClass="error" path="userName"/>
            </div>

        </div>
        <div class="row mb-4">
            <div class="col-md-6">
                <label for="validationCustom03" class="form-label">Họ và tên</label>
                <f:input type="text" class="form-control" path="fullName" id="validationCustom03" />
                <f:errors cssClass="error" path="fullName"/>
            </div>
            <div class="col-md-3">
                <label for="validationCustom04" class="form-label">Trạng thái</label>
                <f:select class="form-select" path="status" id="validationCustom04" >
                    <f:option  value="-1">Trạng thái</f:option>
                    <f:option value="1">Kích hoạt</f:option>
                    <f:option value="0">Tạm dừng</f:option>
                </f:select>
                <f:errors cssClass="error" path="status"/>
            </div>
            <div class="col-md-3">
                <label for="validationCustom14" class="form-label">Quyền</label>
                <f:select class="form-select" path="role" id="validationCustom14" >
                    <f:option value="">Danh sách quyền</f:option>
                    <f:option value="ADMIN">Người quản trị</f:option>
                    <f:option value="USER">Nhân viên</f:option>
                    <f:option value="CUSTOMER">Khách hàng</f:option>
                </f:select>
                <f:errors cssClass="error" path="role"/>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-12">
                <label for="validationCustom08" class="form-label">Địa chỉ</label>
                <f:input type="text" class="form-control" path="address" id="validationCustom08" />

            </div>
        </div>

        <div class="row mb-4">
            <div class="col-5">
                <a href="/backend/user/list" class="btn btn-info" ><i class="fa-solid fa-arrow-turn-down-left"></i>Trở về</a>
            </div>
            <div class="col-6">
                <button class="btn btn-primary" type="submit">Cập nhật</button>
            </div>
        </div>

    </f:form>
</div>