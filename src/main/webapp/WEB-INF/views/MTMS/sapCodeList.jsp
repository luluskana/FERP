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
                    <h3 class="panel-title">All SAP Code</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 table-responsive">
                            <table id="materialList" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Material Name</th>
                                    <th>SAP Code</th>
                                    <th>Status</th>
                                    <th>Zoom In</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="sapCode" items="${sapCodes}" varStatus="loop">
                                    <tr>
                                        <c:set var="material" value="${sapCode.material}"/>
                                        <td>${loop.index + 1}</td>
                                        <td>${material.materialName}</td>
                                        <td>${sapCode.name}</td>
                                        <td>${material.status}</td>
                                        <td><a href="${home}mtms/detailMaterial/${material.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
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