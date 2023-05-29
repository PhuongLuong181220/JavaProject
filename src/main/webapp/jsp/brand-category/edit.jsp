<%@ page pageEncoding="UTF-8" %>
<%@include file="/jsp/common/nav.jsp"%>
<style>
    .error {
        color: red;
    }
    input:focus,textarea:focus{
        border-color: initial;
    }

    input.error, textarea.error, .has-error{
        border:1px solid red;
    }
</style>
<div class="container">
    <br>
    <span style="color: red">${message}</span>
    <h1>Cập nhật ${title}</h1>
    <br>
    <form id="brandForm" action="/backend/${path}/save" method="post" enctype="application/x-www-form-urlencoded">
        <input type="text" hidden value="${model.id}" name="id" class="form-control" id="exampleInputPassword1">
        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Tên ${title}</label>
                    <input value="${model.name}" type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                </div>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Mô tả</label>
                    <input type="text" value="${model.description}" name="description" class="form-control" id="exampleInputPassword1">
                </div>
            </div>

        </div>
        <!-- Submit button -->
        <button style="width: 10%" type="submit" class="btn btn-primary btn-block mb-4">Cập nhật</input>

    </form>
</div>
