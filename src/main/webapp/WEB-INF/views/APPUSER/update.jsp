<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <form class="form-horizontal well" id="appUserId" action="" method="GET">
        <legend>Update User</legend>
        <div class="form-group">
            <label for="inputUser" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-group-sm" id="inputUser" placeholder="Username" required="required" value="${appUser.username}" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-group-sm" id="inputPassword" placeholder="Password" required="required" value="${appUser.password}" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-group-sm" id="inputName" placeholder="Name" required="required" value="${appUser.name}" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputDepartment" class="col-sm-2 control-label">Department</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-group-sm" id="inputDepartment" placeholder="Department" required="required" value="${appUser.department}" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control input-group-sm" id="inputEmail" placeholder="Email" required="required" value="${appUser.emailAddress}" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputTelephoneNumber" class="col-sm-2 control-label">Telephone Number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-group-sm" id="inputTelephoneNumber" placeholder="Telephone Number" required="required" value="${appUser.phoneNumber}" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <label for="inputRoleName" class="col-sm-2 control-label">Role Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-group-sm" id="inputRoleName" placeholder="Role Name" required="required" value="${appUser.roleName}" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary btn-group-sm">Update</button>
            </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function() {
        $("#appUserId").submit(function() {
            var formData = new FormData();
            formData.append("id", "${appUser.id}");
            formData.append("username", $("#inputUser").val());
            formData.append("password", $("#inputPassword").val());
            formData.append("name", $("#inputName").val());
            formData.append("department", $("#inputDepartment").val());
            formData.append("emailAddress", $("#inputEmail").val());
            formData.append("phoneNumber", $("#inputTelephoneNumber").val());
            formData.append("roleName", $("#inputRoleName").val());
            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}appuser/update",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}appuser?list";
                },
                error: function(data){
                    alert("Error");
                    return false;
                }
            });
            return false;
        });
    });
</script>