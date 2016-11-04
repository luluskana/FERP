<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal well" id="materialForm" action="" method="POST">
                <legend>Create Material</legend>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Material Type</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${materialType.typeName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputMaterialName" class="col-sm-2 control-label">Material Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input-group-sm" id="inputMaterialName" placeholder="Material Name" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputUlNumber" class="col-sm-2 control-label">UL Number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control btn-group-sm" id="inputUlNumber" placeholder="UL Number" autocomplete="off" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputManufacturing" class="col-sm-2 control-label">Manufacturing</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control btn-group-sm" id="inputManufacturing" placeholder="Manufacturing Locations" autocomplete="off" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputSpec" class="col-sm-2 control-label">Spec</label>
                    <div class="col-sm-10 form-inline">
                        <span class="btn btn-file"><input type="file" id="inputSpec"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputRoHs" class="col-sm-2 control-label">RoHs</label>
                    <div class="col-sm-10 form-inline">
                        <span class="btn btn-file"><input type="file" id="inputRoHs"></span>
                        <input type="text" class="form-control btn-group-sm" id="inputDateRoHs" placeholder="Start Test Date" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputMSDS" class="col-sm-2 control-label">MSDS</label>
                    <div class="col-sm-10 form-inline">
                        <span class="btn btn-file"><input type="file" id="inputMSDS"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputHalogen" class="col-sm-2 control-label">Halogen Free</label>
                    <div class="col-sm-10 form-inline">
                        <span class="btn btn-file"><input type="file" id="inputHalogen"></span>
                        <input type="text" class="form-control btn-group-sm" id="inputDateHF" placeholder="Start Test Date" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGuarantee" class="col-sm-2 control-label">Guarantee Letter</label>
                    <div class="col-sm-10 form-inline">
                        <span class="btn btn-file"><input type="file" id="inputGuarantee"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputRedPhosphorus" class="col-sm-2 control-label">Red Phosphorus</label>
                    <div class="col-sm-10 form-inline">
                        <span class="btn btn-file"><input type="file" id="inputRedPhosphorus"></span>
                    </div>
                </div>
                <input type="text" class="form-control hidden" id="inputId" value="${materialType.id}">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="submit" class="btn btn-default btn-group-sm">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $("#inputDateRoHs").datepicker({ dateFormat: "dd/mm/yy" });
        $("#inputDateHF").datepicker({ dateFormat: "dd/mm/yy" });

        $("#materialForm").submit(function() {
            var formData = new FormData();
            formData.append("inputSpec", $("#inputSpec")[0].files[0]);

            formData.append("inputRoHs", $('#inputRoHs')[0].files[0]);
            formData.append("inputDateRoHs", $("#inputDateRoHs").val());
            if($('#inputRoHs')[0].files[0] != null) {
                if(!$("#inputDateRoHs").val() ) {
                    $("#inputDateRoHs").focus();
                    return false;
                }
            }
            formData.append("inputMSDS", $('#inputMSDS')[0].files[0]);

            formData.append("inputHalogen", $('#inputHalogen')[0].files[0]);
            formData.append("inputDateHF", $("#inputDateHF").val());
            if($('#inputHalogen')[0].files[0] != null) {
                if(!$("#inputDateHF").val()) {
                    $("#inputDateHF").focus();
                    return false;
                }
            }
            formData.append("inputGuarantee", $('#inputGuarantee')[0].files[0]);
            formData.append("inputRedPhosphorus", $('#inputRedPhosphorus')[0].files[0]);
            formData.append("inputMaterialName", $("#inputMaterialName").val());
            formData.append("inputManufacturing", $("#inputManufacturing").val());
            formData.append("inputUlNumber", $("#inputUlNumber").val());
            formData.append("id", "${materialType.id}");
            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}mtms/create/material",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}mtms/${materialType.id}";
                },
                error: function(data){
                    alert("saved error.");
                    return false;
                }
            });
            return false;
        });
    });
</script>