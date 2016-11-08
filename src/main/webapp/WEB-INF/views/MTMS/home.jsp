<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <div class="row">
        <div class="col-sm-7">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Material Type</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 table-responsive">
                            <table id="materialTypeList" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Type Name</th>
                                    <th>Total Material</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                    <th>Zoom In</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="materialType" items="${materialTypes}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${materialType.typeName}</td>
                                            <td>${fn:length(materialType.materials)}</td>
                                            <c:choose>
                                                <c:when test="${roleName eq 'admin' or roleName eq 'user'}">
                                                    <td><button class="btn btn-warning btn-sm update" value="${materialType.id}_${materialType.typeName}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td>
                                                    <td><button class="btn btn-danger btn-sm delete" value="${materialType.id}_${materialType.typeName}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><button class="btn btn-warning btn-sm update" disabled><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td>
                                                    <td><button class="btn btn-danger btn-sm" disabled><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td><a href="${home}mtms/${materialType.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <c:if test="${roleName eq 'admin' or roleName eq 'user'}">
                        <div class="row" id="rowAddMaterialType">
                            <div class="col-sm-12">
                                <button type="button" id="btnAddMaterialType" class="btn btn-default btn-group-sm">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Material Type
                                </button>
                            </div>
                        </div>
                    </c:if>
                    <div class="row hidden" id="formCreateMaterialType">
                        <div class="col-sm-12">
                            <form class="form-horizontal well" id="createMaterialType" action="" method="POST">
                                <fieldset>
                                    <legend>Create Material Type</legend>
                                    <div class="form-group">
                                        <label for="inputTypeName" class="col-sm-3 control-label">Type Name</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control input-group-sm" id="inputTypeName" placeholder="Type Name" required="required" autocomplete="off">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-3 col-sm-9">
                                            <button type="submit" class="btn btn-default btn-group-sm">Submit</button>
                                            <button type="button" id="btnCancelCreate" class="btn btn-warning btn-group-sm">Cancel</button>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                    <div class="row hidden" id="formUpdateMaterialType">
                        <div class="col-sm-12">
                            <form class="form-horizontal well" id="updateMaterialType" action="" method="POST">
                                <fieldset>
                                    <legend>Update Material Type</legend>
                                    <input type="text" class="hidden" id="inputIdTypeName">
                                    <div class="form-group">
                                        <label for="inputTypeNameUpdate" class="col-sm-3 control-label">Type Name</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control input-group-sm" id="inputTypeNameUpdate" placeholder="Type Name" required="required" autocomplete="off">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-3 col-sm-9">
                                            <button type="submit" class="btn btn-primary btn-group-sm">Update</button>
                                            <button type="button" id="btnCancelUpdate" class="btn btn-warning btn-group-sm">Cancel</button>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Option Menu</h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <a href="${home}mtms/waitingApprove" class="list-group-item list-group-item-text">
                            <span class="badge">${fn:length(materialsWaitingApprove)}</span>
                            Waiting Approve
                        </a>
                        <a href="${home}mtms/additionalMaterial" class="list-group-item list-group-item-text">
                            <span class="badge">${fn:length(materialsAdditionalOrReject)}</span>
                            Additional requests or reject
                        </a>
                        <a href="#" class="list-group-item list-group-item-text">
                            <span class="badge">20</span>
                            Material Expired
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $('#materialTypeList').DataTable();

        $("#btnAddMaterialType").click(function() {
            $("#rowAddMaterialType").addClass("hidden");
            $("#formCreateMaterialType").removeClass("hidden");
            $("#inputTypeName").focus();
        });

        $("#btnCancelCreate").click(function() {
            $("#rowAddMaterialType").removeClass("hidden");
            $("#formCreateMaterialType").addClass("hidden");
        });

        $(".update").click(function() {
            $("#formUpdateMaterialType").removeClass("hidden");
            $("#rowAddMaterialType").addClass("hidden");
            $("#formCreateMaterialType").addClass("hidden");
            $("#inputIdTypeName").val($(this).attr("value").split("_")[0]);
            $("#inputTypeNameUpdate").val($(this).attr("value").split("_")[1]);
            $("#inputTypeNameUpdate").focus();
        });

        $("#btnCancelUpdate").click(function() {
            $("#rowAddMaterialType").removeClass("hidden");
            $("#formUpdateMaterialType").addClass("hidden");
        });

        $("#createMaterialType").submit(function() {
            var formData = new FormData();
            formData.append("typeName", $("#inputTypeName").val());
            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}mtms/create/materialType",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}mtms";
                },
                error: function(data){
                    alert("Error");
                    return false;
                }
            });
            return false;
        });

        $("#formUpdateMaterialType").submit(function() {
            var formData = new FormData();
            formData.append("id", $("#inputIdTypeName").val());
            formData.append("typeName", $("#inputTypeNameUpdate").val());
            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}mtms/update/materialType",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}mtms";
                },
                error: function(data){
                    alert("Error");
                    return false;
                }
            });
            return false;
        });

        $(".delete").click(function() {
            $("#formUpdateMaterialType").addClass("hidden");
            $("#formCreateMaterialType").addClass("hidden");
            if (confirm('Are you sure you want to delete this thing into the database?')) {
                var formData = new FormData();
                formData.append("id", $(this).attr("value").split("_")[0]);
                $.ajax({
                    type: "POST",
                    headers: {
                        Accept: "application/json",
                    },
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    url: "${home}mtms/delete/materialType",
                    processData: false,
                    contentType: false,
                    data: formData,
                    async: false,
                    success: function(data){
                        window.location.href = "${home}mtms";
                    },
                    error: function(data){
                        alert("Error");
                        return false;
                    }
                });
            } else {
                return false;
            }
            return false;
        });
    } );
</script>