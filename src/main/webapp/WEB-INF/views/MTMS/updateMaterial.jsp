<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal well" id="materialForm" action="" method="POST">
                <legend>Update Material</legend>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Material Type</label>
                    <div class="col-sm-10">
                        <c:set var="materialType" value="${material.materialType}"/>
                        <p class="form-control-static">${materialType.typeName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputMaterialName" class="col-sm-2 control-label">Material Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control input-group-sm" id="inputMaterialName" value="${material.materialName}" placeholder="Material Name" required="required" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputUlNumber" class="col-sm-2 control-label">UL Number</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control btn-group-sm" id="inputUlNumber" value="${material.ulNumber}" placeholder="UL Number" autocomplete="off" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputManufacturing" class="col-sm-2 control-label">Manufacturing</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control btn-group-sm" id="inputManufacturing" value="${material.manufacturing}" placeholder="Manufacturing Locations" autocomplete="off" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputSpec" class="col-sm-2 control-label">Spec</label>
                    <div class="col-sm-10 form-inline">
                        <c:choose>
                            <c:when test = "${not empty material.spec}">
                                <input type="text" class="hidden" id="currentSpecFile" value="yes">
                                <div class="alert alert-success col-sm-3" role="alert">
                                    <button id="alertSpec" type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <a href="${home}mtms/file/${material.spec}" target="_blank" class="alert-link">SPEC <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </div>
                                <span id="spanInputSpec" class="btn btn-file hidden"><input type="file" id="inputSpec"></span>
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="hidden" id="currentSpecFile" value="no">
                                <span class="btn btn-file"><input type="file" id="inputSpec"></span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputRoHs" class="col-sm-2 control-label">RoHs</label>
                    <div class="col-sm-10 form-inline">
                        <c:choose>
                            <c:when test = "${not empty material.rosh}">
                                <input type="text" class="hidden" id="currentRoshFile" value="yes">
                                <div class="alert alert-success col-sm-3" role="alert">
                                    <button id="alertRosh" type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <a href="${home}mtms/file/${material.rosh}" target="_blank" class="alert-link">RoHS <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </div>
                                <span id="spanInputRoHs" class="btn btn-file hidden"><input type="file" id="inputRoHs"></span>&nbsp;&nbsp;&nbsp;&nbsp; Date test :
                                <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.rohsDateTest}" var="roshDate"/>
                                <input type="text" class="form-control btn-group-sm" id="inputDateRoHs" autocomplete="off" value="${roshDate}">
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="hidden" id="currentRoshFile" value="no">
                                <span class="btn btn-file"><input type="file" id="inputRoHs"></span>&nbsp;&nbsp;&nbsp;&nbsp; Date test :
                                <input type="text" class="form-control btn-group-sm" id="inputDateRoHs" placeholder="Start Test Date" autocomplete="off"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputMSDS" class="col-sm-2 control-label">MSDS</label>
                    <div class="col-sm-10 form-inline">
                        <c:choose>
                            <c:when test = "${not empty material.msds}">
                                <input type="text" class="hidden" id="currentMsdsFile" value="yes">
                                <div class="alert alert-success col-sm-3" role="alert">
                                    <button id="alertMSDS" type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <a href="${home}mtms/file/${material.msds}" target="_blank" class="alert-link">MSDS <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </div>
                                <span id="spanInputMSDS" class="btn btn-file hidden"><input type="file" id="inputMSDS"></span>
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="hidden" id="currentMsdsFile" value="no">
                                <span class="btn btn-file"><input type="file" id="inputMSDS"></span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputHalogen" class="col-sm-2 control-label">Halogen Free</label>
                    <div class="col-sm-10 form-inline">
                        <c:choose>
                            <c:when test = "${not empty material.halogen}">
                                <input type="text" class="hidden" id="currentHalogenFile" value="yes">
                                <div class="alert alert-success col-sm-3" role="alert">
                                    <button id="alertHalogen" type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <a href="${home}mtms/file/${material.halogen}" target="_blank" class="alert-link">Halogen Free <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </div>
                                <span id="spanInputHalogen" class="btn btn-file hidden"><input type="file" id="inputHalogen"></span>&nbsp;&nbsp;&nbsp;&nbsp; Date test :
                                <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.halogenDateTest}" var="halogenDate"/>
                                <input type="text" class="form-control btn-group-sm" id="inputDateHF" autocomplete="off" value="${halogenDate}">
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="hidden" id="currentHalogenFile" value="no">
                                <span class="btn btn-file"><input type="file" id="inputHalogen"></span>&nbsp;&nbsp;&nbsp;&nbsp; Date test :
                                <input type="text" class="form-control btn-group-sm" id="inputDateHF" placeholder="Start Test Date" autocomplete="off">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGuarantee" class="col-sm-2 control-label">Guarantee Letter</label>
                    <div class="col-sm-10 form-inline">
                        <c:choose>
                            <c:when test = "${not empty material.guaranteeLetter}">
                                <input type="text" class="hidden" id="currentGuaruntreeLetterFile" value="yes">
                                <div class="alert alert-success col-sm-3" role="alert">
                                    <button id="alertGuarantee" type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <a href="${home}mtms/file/${material.guaranteeLetter}" target="_blank" class="alert-link">Guarantee Letter <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </div>
                                <span id="spanInputGuarantee" class="btn btn-file hidden"><input type="file" id="inputGuarantee"></span>
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="hidden" id="currentGuaruntreeLetterFile" value="no">
                                <span class="btn btn-file"><input type="file" id="inputGuarantee"></span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputRedPhosphorus" class="col-sm-2 control-label">Red Phosphorus</label>
                    <div class="col-sm-10 form-inline">
                        <c:choose>
                            <c:when test = "${not empty material.redPhosphorus}">
                                <input type="text" class="hidden" id="currentRedPhosphorusFile" value="yes">
                                <div class="alert alert-success col-sm-3" role="alert">
                                    <button id="alertRedPhosphorus" type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <a href="${home}mtms/file/${material.redPhosphorus}" target="_blank" class="alert-link">Red Phosphorus <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </div>
                                <span id="spanInputRedPhosphorus" class="btn btn-file hidden"><input type="file" id="inputRedPhosphorus"></span>
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="hidden" id="currentRedPhosphorusFile" value="no">
                                <span class="btn btn-file"><input type="file" id="inputRedPhosphorus"></span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="submit" class="btn btn-primary btn-group-sm">Update</button>
                    </div>
                </div>
            </form>
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
<script>
    $(document).ready(function() {
        $("#alertSpec").click(function () {
            $("#spanInputSpec").removeClass("hidden");
            $("#currentSpecFile").val("no");
        });

        $("#alertRosh").click(function () {
            $("#spanInputRoHs").removeClass("hidden");
            $("#inputDateRoHs").val("");
            $("#inputDateRoHs").attr("placeholder","Start Test Date");
            $("#currentRoshFile").val("no");
        });

        $("#alertMSDS").click(function () {
            $("#spanInputMSDS").removeClass("hidden");
            $("#currentMsdsFile").val("no");
        });

        $("#alertHalogen").click(function () {
            $("#spanInputHalogen").removeClass("hidden");
            $("#inputDateHF").val("");
            $("#inputDateHF").attr("placeholder","Start Test Date");
            $("#currentHalogenFile").val("no");
        });

        $("#alertGuarantee").click(function () {
            $("#spanInputGuarantee").removeClass("hidden");
            $("#currentGuaruntreeLetterFile").val("no");
        });

        $("#alertRedPhosphorus").click(function () {
            $("#spanInputRedPhosphorus").removeClass("hidden");
            $("#currentRedPhosphorusFile").val("no");
        });

        $("#inputDateRoHs").datepicker({ dateFormat: "dd/mm/yy" });
        $("#inputDateHF").datepicker({ dateFormat: "dd/mm/yy" });

        $("#materialForm").submit(function() {
            var formData = new FormData();
            formData.append("id", "${material.id}");
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

            formData.append("currentSpecFile", $("#currentSpecFile").val());
            formData.append("currentRoshFile", $("#currentRoshFile").val());
            formData.append("currentMsdsFile", $("#currentMsdsFile").val());
            formData.append("currentHalogenFile", $("#currentHalogenFile").val());
            formData.append("currentGuaruntreeLetterFile", $("#currentGuaruntreeLetterFile").val());
            formData.append("currentRedPhosphorusFile", $("#currentRedPhosphorusFile").val());
            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}mtms/update/material",
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