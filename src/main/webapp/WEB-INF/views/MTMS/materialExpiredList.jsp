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
            <div class="panel panel-info">
                <div class="panel-heading" align="center">
                    <h3 class="panel-title">Material Expired</h3>
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
                                    <th>Spec</th>
                                    <th>MSDS</th>
                                    <th>RoHs</th>
                                    <th>Halogen Free</th>
                                    <th>Guarantee</th>
                                    <th>Red Phosphorus</th>
                                    <th>Update</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="material" items="${materialsExpiredList}" varStatus="loop">
                                    <c:set var="materialType" value="${material.materialType}"/>
                                    <c:if test="${material.numberDateExpired eq 1}">
                                        <tr class="danger">
                                    </c:if>
                                    <c:if test="${material.numberDateExpired eq 2}">
                                        <tr class="warning">
                                    </c:if>
                                    <c:if test="${material.numberDateExpired eq 3}">
                                        <tr class="success">
                                    </c:if>
                                        <td>${loop.index + 1}</td>
                                        <td>${materialType.typeName}</td>
                                        <td>${material.materialName}</td>
                                        <c:choose>
                                            <c:when test="${not empty material.spec}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty material.msds}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty material.rosh}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span><font color="red"> <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.rohsEndDateTest}" /></font></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty material.halogen}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span><font color="red"> <fmt:formatDate pattern="dd/MM/yyyy"  value="${material.halogenEndDateTest}" /></font></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty material.guaranteeLetter}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${not empty material.redPhosphorus}">
                                                <td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></td>
                                            </c:otherwise>
                                        </c:choose>
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