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
    <h1>Chi tiết sản phẩm</h1>
    <h2 style="color: red">${message}</h2>
    <br>
    <f:form action="/backend/product/save" modelAttribute="productDto" method="post" class=" g-3 needs-validation" enctype="multipart/form-data">
        <f:input type="text" class="form-control" path="id"  cssStyle="display: none"/>
        <div class="row mb-4">
            <div class="col-3">
                <label for="validationCustom08" class="form-label">Tên bí danh</label>
                <f:input type="text" class="form-control" path="alias" id="validationCustom08"/>
            </div>
            <div class="col-3">
                <label for="validationCustom14" class="form-label">Tên sản phẩm</label>
                <f:input type="text" class="form-control" path="name" id="validationCustom14"/>
            </div>
            <div class="col-3">
                <label for="validationCustom15" class="form-label">Giá sản phẩm</label>
                <f:input type="text" class="form-control" path="price" id="validationCustom15"/>
            </div>
            <div class="col-3">
                <label for="validationCustom09" class="form-label">Phần trăm giảm giá</label>
                <f:input type="text" class="form-control" path="discountPercent" id="validationCustom09"/>
            </div>
        </div>


        <div class="row mb-4">
            <div class="col-3">
                <label for="validationCustom04" class="form-label">Trạng thái</label>
                <f:select class="form-select" path="enabled" id="validationCustom04">
                    <f:option value="true">Kích hoạt</f:option>
                    <f:option value="false">Tạm dừng</f:option>
                </f:select>
            </div>

            <div class="col-3">
                <label for="validationCustom04" class="form-label">Trạng thái kho</label>
                <f:select class="form-select" path="inStock" id="validationCustom04">
                    <f:option value="true">Còn hàng</f:option>
                    <f:option value="false">Hết hàng</f:option>
                </f:select>
            </div>

            <div class="col-3">
                <label for="validationCustom0224" class="form-label">Thương hiệu</label>
                <select class="form-select" name="brandId" id="validationCustom0224">
                    <c:forEach items="${brands}" var="brand">
                    <option value="${brand.id}" <c:if test="${brand.id == 1}"> selected</c:if> >${brand.name}</option>
                        <%--                        <f:option value="${brand.id}" >${brand.name}</f:option>--%>
                    </c:forEach>
                    <select>
            </div>
            <div class="col-3">
                <label for="validationCustom024" class="form-label">Thể loại</label>
                <select class="form-select" name="categoryId" id="validationCustom024">
                    <c:forEach items="${categories}" var="category">
                        <%--                        <f:option value="${category.id}" <c:if test="${category.id == productDto.categoryId}"> selected</c:if>>${category.name}</f:option>--%>
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>

        </div>

        <div class="row mb-4">
            <div class="col-9">
                <label for="validationCustom10" class="form-label">Mổ tả sản phẩm</label>
                <f:input type="text" class="form-control" path="fullDescription" id="validationCustom10"/>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-9">
                <label for="validationCustom17" class="form-label">Mổ tả ngắn</label>
                <f:input type="text" class="form-control" path="shortDescription" id="validationCustom17"/>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-3">
                <label for="validationCustom11" class="form-label">Chiều cao</label>
                <f:input type="text" class="form-control" path="height" id="validationCustom11"/>
            </div>

            <div class="col-3">
                <label for="validationCustom12" class="form-label">Chiều rộng</label>
                <f:input type="text" class="form-control" path="width" id="validationCustom12"/>
            </div>

            <div class="col-3">
                <label for="validationCustom13" class="form-label">Chiều dài</label>
                <f:input type="text" class="form-control" path="length" id="validationCustom13"/>
            </div>

            <div class="col-3">
                <label for="validationCustom14" class="form-label">Cân nặng</label>
                <f:input type="text" class="form-control" path="weight" id="validationCustom14"/>
            </div>
        </div>

        <div class="row mb-4">
            <div class="col-3">
                <label for="choose-file" class="form-label">Ảnh</label>
                <input type="file" class="form-control" accept="image/*" name="fileImage" id="choose-file"/>
            </div>
            <div class="col-3">
                <f:input type="text" cssStyle="display: none" class="form-control" path="mainImage" id="validationCustom16"/>
                <div id="img-preview"><img width="150px" src="/image-product/${productDto.mainImage}"/></div>

            </div>
        </div>
        <script>
            const chooseFile = document.getElementById("choose-file");
            const imgPreview = document.getElementById("img-preview");
            chooseFile.addEventListener("change", function () {
                getImgData();
            });
            function getImgData() {
                const files = chooseFile.files[0];
                if (files) {
                    const fileReader = new FileReader();
                    fileReader.readAsDataURL(files);
                    fileReader.addEventListener("load", function () {
                        imgPreview.style.display = "block";
                        imgPreview.innerHTML = '<img width="150px" src="' + this.result + '" />';
                    });
                }
            }
        </script>

        <div class="row mb-4">
            <div class="col-5">
                <a href="/backend/product/list" class="btn btn-info"><i class="fa-solid fa-arrow-turn-down-left"></i>Trở về</a>
            </div>
            <div class="col-6">
                <button class="btn btn-primary" type="submit">Sửa</button>
            </div>
        </div>

    </f:form>
</div>