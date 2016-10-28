<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <form class="form-horizontal well" id="appUserId" action="" method="GET">
        <fieldset>
            <legend>Create User</legend>
                <div class="form-group">
                    <label for="inputUser" class="col-sm-2 control-label">Username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input-group-sm" id="inputUser" placeholder="Username" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input-group-sm" id="inputPassword" placeholder="Password" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputName" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input-group-sm" id="inputName" placeholder="Name" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDepartment" class="col-sm-2 control-label">Department</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input-group-sm" id="inputDepartment" placeholder="Department" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control input-group-sm" id="inputEmail" placeholder="Email" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputTelephoneNumber" class="col-sm-2 control-label">Telephone Number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input-group-sm" id="inputTelephoneNumber" placeholder="Telephone Number" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputRoleName" class="col-sm-2 control-label">Role Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input-group-sm" id="inputRoleName" placeholder="Role Name" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default btn-group-sm">Submit</button>
                    </div>
                </div>
            </fieldset>
    </form>
</div>
<script>
    $(document).ready(function() {


    });
</script>