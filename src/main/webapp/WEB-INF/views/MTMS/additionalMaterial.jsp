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
            <div class="panel panel-danger">
                <div class="panel-heading" align="center">
                    <h3 class="panel-title">Additional Or Reject</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 table-responsive">
                            <table id="materialList" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Material Type</th>
                                    <th>Material Name</th>
                                    <th>Reason</th>
                                    <th>By</th>
                                    <th>Zoom In</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="material" items="${materialsAdditionalOrReject}" varStatus="loop">
                                    <c:set var="materialType" value="${material.materialType}"/>
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${materialType.typeName}</td>
                                        <td>${material.materialName}</td>
                                        <c:forEach var="logHistory" items="${material.logHistories}" varStatus="loopStatus">
                                            <c:if test="${loopStatus.last}">
                                                <c:set var="appuser" value="${logHistory.createBy}"/>
                                                <td>${logHistory.remark}</td>
                                                <td>${appuser.name}</td>
                                            </c:if>
                                        </c:forEach>
                                        <td><a href="${home}mtms/updateMaterial/${material.id}" class="btn btn-warning btn-sm"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
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
</div>
<script>
    $(document).ready(function() {
        $("#materialList").DataTable();
    });
</script>