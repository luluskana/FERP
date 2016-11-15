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
            <div class="panel panel-success">
                <div class="panel-heading" align="center">
                    <h3 class="panel-title">${materialType.typeName}</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 table-responsive">
                            <table id="materialList" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Material Name</th>
                                    <th>Total SAP Code</th>
                                    <th>Status</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                    <th>Zoom In</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="material" items="${materialType.materials}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${material.materialName}</td>
                                        <td>${fn:length(material.sapCodes)}</td>
                                        <c:if test="${material.status eq 'CREATE_MATERIAL_DOCUMENT_FULL' or material.status eq 'UPDATE_MATERIAL_DOCUMENT_FULL'}">
                                            <td><span class="glyphicon glyphicon-hourglass" aria-hidden="true"></span> Waiting QA approve</td>
                                        </c:if>
                                        <c:if test="${material.status eq 'CREATE_MATERIAL_DOCUMENT_NOT_FULL' or material.status eq 'UPDATE_MATERIAL_DOCUMENT_NOT_FULL'}">
                                            <td><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> Additional or reject</td>
                                        </c:if>
                                        <c:if test="${material.status eq 'APPROVE_MATERIAL'}">
                                            <td><span class="glyphicon glyphicon-check" aria-hidden="true"></span> Approve</td>
                                        </c:if>
                                        <c:if test="${material.status eq 'REJECT_MATERIAL'}">
                                            <td><span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span> Reject</td>
                                        </c:if>
                                        <c:choose>
                                            <c:when test="${roleName eq 'admin' or roleName eq 'user' or roleName eq 'purchase' or roleName eq 'qa' or roleName eq 'qaEngineer'}">
                                                <td><button class="btn btn-warning btn-sm update" value="${material.id}_${material.materialName}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td>
                                                <td><button class="btn btn-danger btn-sm delete" value="${material.id}_${material.materialName}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><button class="btn btn-warning btn-sm update" disabled><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td>
                                                <td><button class="btn btn-danger btn-sm" disabled><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td><a href="${home}mtms/detailMaterial/${material.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <c:if test="${roleName eq 'admin' or roleName eq 'user' or roleName eq 'qa' or roleName eq 'purchase'}">
                        <div class="row" id="rowAddMaterialType">
                            <div class="col-sm-12">
                                <a href="${home}mtms/createMaterial/${materialType.id}" id="btnAddMaterial" class="btn btn-default btn-group-sm">
                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Material
                                </a>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $("#materialList").DataTable();

        $(".update").click(function() {
            window.location.href = "${home}mtms/updateMaterial/" + $(this).attr("value").split("_")[0];
        });

        $(".delete").click(function() {
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
                    url: "${home}mtms/delete/material",
                    processData: false,
                    contentType: false,
                    data: formData,
                    async: false,
                    success: function(data){
                        window.location.href = "${home}mtms/${materialType.id}";
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
    });
</script>