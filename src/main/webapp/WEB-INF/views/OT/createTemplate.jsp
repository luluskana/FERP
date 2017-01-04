<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <div class="col-sm-12">
        <form class="form-horizontal well" id="otForm" action="" method="POST">
            <legend>Create Template</legend>
            <div class="row">
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="inputCreateBy" class="col-sm-3 control-label">Create By :</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-group-sm" id="inputCreateBy" value="${name}" readonly>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="inputDepartment" class="col-sm-3 control-label">Department :</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-group-sm" id="inputDepartment" value="${appUser.department}" readonly>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <legend>Add Employee</legend>
                    <div class="form-group form-inline">
                        <label for="inputTypeName" class="col-sm-3 control-label">Employee ID</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control input-group-sm" id="inputTypeName" placeholder="ID" autocomplete="off">
                            <input type="text" class="form-control input-group-sm" id="inputDescriptionOfWork" placeholder="Description of work">
                            <button type="button" id="addEmployee" class="btn btn-primary btn-group-sm">Add</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="table-responsive">
                        <table class="table table-hover" id="otTable">
                            <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>Name</th>
                                <th>Description of work</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody id="bodyTable">
                                <jsp:text/>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12" align="center">
                    <button id="saveTemplate" type="button" class="btn btn-primary">Save Template</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    $(document).ready(function() {

        var t = $('#otTable').DataTable();

        var today = new Date();
        $("#inputRequestDate").datepicker({
            dateFormat: "dd/mm/yy",
            minDate: today
        });

        $("#addEmployee").click(function() {

            t.row.add([
                    '90616',
                    'Apichat Eakwongsa',
                    'test',
                    '<button class="btn btn-danger btn-sm delete"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>'
            ]).draw( false );
        });
    });

    $("#saveTemplate").click(function() {
        var table = $('#otTable').DataTable();
        var data = table.rows().data();

        var str = '';

        $.each(data, function(row, array){
            console.log(array);
            str = str + array[0] +']' + array[2] + '[';
        })

        console.log(str);

        var formData = new FormData();
        formData.append("data", str);

        $.ajax({
            type: "POST",
            headers: {
                Accept: "application/json",
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "${home}ot/create/template",
            processData: false,
            contentType: false,
            data: formData,
            async: false,
            success: function(data){
                return false;
                window.location.href = "${home}ot/template";
            },
            error: function(data){
                alert("กรุณาเพิ่มข้อมูลในตารางก่อนบันทึกข้อมูล");
                return false;
            }
        });
    });
</script>