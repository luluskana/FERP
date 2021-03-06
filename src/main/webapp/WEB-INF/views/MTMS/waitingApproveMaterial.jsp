<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/" var="home" />
<%@page session="true"%>
<c:set var="materialType" value="${material.materialType}"/>
<div class="container">
    <div class="row">
        <div class="col-sm-7">
            <form class="form-horizontal well" action="" method="POST">
                <legend>Material</legend>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Material Type</label>
                    <div class="col-sm-9">
                        <p class="form-control-static">${materialType.typeName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Material Name</label>
                    <div class="col-sm-9">
                        <p class="form-control-static">${material.materialName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">UL Number</label>
                    <div class="col-sm-9">
                        <p class="form-control-static">${material.ulNumber}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Manufacturing</label>
                    <div class="col-sm-9">
                        <p class="form-control-static">${material.manufacturing}</p>
                    </div>
                </div>
                <c:if test="${not empty material.spec}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Spec</label>
                        <div class="col-sm-9 form-inline">
                            <p class="form-control-static">
                                <a class="btn btn-info btn-sm" href="${home}mtms/file/${material.spec}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                            </p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty material.rosh}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">RoHs</label>
                        <div class="col-sm-9 form-inline">
                            <p class="form-control-static">
                                <a class="btn btn-info btn-sm" href="${home}mtms/file/${material.rosh}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                            </p>
                            <p class="form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Expired Date : <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.rohsEndDateTest}" /></p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty material.msds}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">MSDS</label>
                        <div class="col-sm-9 form-inline">
                            <p class="form-control-static">
                                <a class="btn btn-info btn-sm" href="${home}mtms/file/${material.msds}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                            </p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty material.halogen}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Halogen Free</label>
                        <div class="col-sm-9 form-inline">
                            <p class="form-control-static">
                                <a class="btn btn-info btn-sm" href="${home}mtms/file/${material.halogen}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                            </p>
                            <p class="form-control-static">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Expired Date : <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.halogenEndDateTest}" /></p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty material.guaranteeLetter}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Guarantee Letter</label>
                        <div class="col-sm-9 form-inline">
                            <p class="form-control-static">
                                <a class="btn btn-info btn-sm" href="${home}mtms/file/${material.guaranteeLetter}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                            </p>
                        </div>
                    </div>
                </c:if>
                <c:if test="${not empty material.redPhosphorus}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">Red Phosphorus</label>
                        <div class="col-sm-9 form-inline">
                            <p class="form-control-static">
                                <a class="btn btn-info btn-sm" href="${home}mtms/file/${material.redPhosphorus}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                            </p>
                        </div>
                    </div>
                </c:if>
            </form>
        </div>
        <div class="col-sm-5">
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-success">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>SAP Code</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="sapCode" items="${material.sapCodes}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${sapCode.name}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <form class="form-horizontal well">
                        <div class="form-group">
                            <div class="col-sm-12" align="center">
                                <button type="button" id="approve" class="btn btn-success btn-group-sm">Approve</button>
                                <button type="button" id="reject" class="btn btn-danger btn-group-sm">Reject</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-warning">
                <div class="panel-heading" align="center">
                    <h3 class="panel-title">History</h3>
                </div>
                <div class="panel-body">
                    <div class="col-sm-12 table-responsive">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Date</th>
                                <th>Status</th>
                                <th>Reason</th>
                                <c:if test="${roleName eq 'admin'}">
                                    <th>Spec</th>
                                    <th>MSDS</th>
                                    <th>RoHs</th>
                                    <th>Halogen Free</th>
                                    <th>Guarantee</th>
                                    <th>Red Phosphorus</th>
                                </c:if>
                                <th>By</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="logHistory" items="${material.logHistories}" varStatus="loop">
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"  value="${logHistory.createDate}" /></td>
                                    <c:if test="${logHistory.status eq 'CREATE_MATERIAL_DOCUMENT_FULL' or logHistory.status eq 'CREATE_MATERIAL_DOCUMENT_NOT_FULL'}">
                                        <td><span class="glyphicon glyphicon-file" aria-hidden="true"></span> Create</td>
                                    </c:if>
                                    <c:if test="${logHistory.status eq 'UPDATE_MATERIAL_DOCUMENT_FULL' or logHistory.status eq 'UPDATE_MATERIAL_DOCUMENT_NOT_FULL'}">
                                        <td><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Update</td>
                                    </c:if>
                                    <c:if test="${logHistory.status eq 'REJECT_MATERIAL'}">
                                        <td><span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span> Reject</td>
                                    </c:if>
                                    <c:if test="${logHistory.status eq 'APPROVE_MATERIAL'}">
                                        <td><span class="glyphicon glyphicon-check" aria-hidden="true"></span> Approve</td>
                                    </c:if>
                                    <td>${logHistory.remark}</td>
                                    <c:if test="${roleName eq 'admin'}">
                                        <td><a class="btn btn-warning btn-sm" href="${home}mtms/file/${logHistory.spec}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a></td>
                                        <td><a class="btn btn-warning btn-sm" href="${home}mtms/file/${logHistory.msds}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a></td>
                                        <td><a class="btn btn-warning btn-sm" href="${home}mtms/file/${logHistory.rosh}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a></td>
                                        <td><a class="btn btn-warning btn-sm" href="${home}mtms/file/${logHistory.halogen}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a></td>
                                        <td><a class="btn btn-warning btn-sm" href="${home}mtms/file/${logHistory.guaranteeLetter}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a></td>
                                        <td><a class="btn btn-warning btn-sm" href="${home}mtms/file/${logHistory.redPhosphorus}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a></td>
                                    </c:if>
                                    <c:set var="appUser" value="${logHistory.createBy}"/>
                                    <td>${appUser.name}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="alertRejectModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title">Reject Reason</h4>
            </div>
            <div class="modal-body">
                <textarea class="form-control" rows="3" id="inputReason"><jsp:text/></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="btnReject">reject</button>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $("#approve").click(function() {
            if (confirm('Are you sure you want to Approve ?')) {
                var formData = new FormData();
                formData.append("id", "${material.id}");
                $.ajax({
                    type: "POST",
                    headers: {
                        Accept: "application/json",
                    },
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    url: "${home}mtms/approve/material",
                    processData: false,
                    contentType: false,
                    data: formData,
                    async: false,
                    success: function(data){
                        window.location.href = "${home}mtms/waitingApprove";
                    },
                    error: function(data){
                        alert("Error");
                        return false;
                    }
                });
            } else {
                return false;
            }
        });

        $("#reject").click(function() {
            $("#alertRejectModal").modal({show:true});
        });

        $("#btnReject").click(function() {
            var formData = new FormData();
            formData.append("id", "${material.id}");
            formData.append("remark", $("#inputReason").val());
            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}mtms/reject/material",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}mtms/waitingApprove";
                },
                error: function(data){
                    alert("Error");
                    return false;
                }
            });
        });
    });
</script>
