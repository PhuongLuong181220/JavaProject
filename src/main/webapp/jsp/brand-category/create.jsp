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
    <h1>Tạo mới ${title}</h1>
    <br>
    <form  id="brandForm" action="/backend/${path}/save" method="post" enctype="application/x-www-form-urlencoded">
        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Tên ${title}</label>
                    <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                </div>
            </div>
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Mô tả</label>
                    <input type="text" name="description" class="form-control" id="exampleInputPassword1">
                </div>
            </div>

        </div>
        <!-- Submit button -->
        <button style="width: 10%" type="submit" class="btn btn-primary btn-block mb-4">Tạo mới</button>

    </form>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>


<script>

    $( document ).ready(function() {
        $("#brandForm").validate({
            rules: {
                name: {
                    required: true
                },
                password : {
                    minlength : 6
                },
                rePassword : {
                    minlength : 6,
                    equalTo : "#password"
                }
            },
            highlight: function(element) {
                $(element).parent().addClass('has-error');
            },
            unhighlight: function(element) {
                $(element).parent().removeClass('has-error');
            },
            errorElement: 'span',
            errorClass: 'validation-error-message help-block form-helper bold',
            errorPlacement: function(error, element) {
                if(element.parent('.input-group').length) {
                    error.insertAfter(element.parent());
                } else {
                    error.insertAfter(element);
                }
            },
            messages: {
                name: {required: "Vui lòng nhập tên thương hiệu"},
                password : {
                    minlength : "Tối thiếu 6 ký tự"
                },
                rePassword : {
                    minlength : "Tối thiếu 6 ký tự",
                    equalTo : "Mật khẩu không trùng khớp"
                }
            }
        });
    });

</script>