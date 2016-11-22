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
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#saleRequest">Waiting Review</a></li>
            <li><a data-toggle="tab" href="#engineerApprove">Waiting First Sample</a></li>
            <li><a data-toggle="tab" href="#qaApproveFirst">Waiting Final Sample</a></li>
        </ul>
        <div class="tab-content">
            <div id="saleRequest" class="tab-pane fade in active">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title" align="center">Waiting Review</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-hover" id="faStatusCreateUpdate">
                                <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>FA No.</th>
                                    <th>Request Date</th>
                                    <th>Need Date</th>
                                    <th>Customer</th>
                                    <th>Part No.</th>
                                    <th>Sale Out</th>
                                    <th>Request By</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="faRequest" items="${faStatusCreateList}" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${faRequest.faNumber}</td>
                                        <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                        <td><fmt:formatDate pattern="dd/MM/yyyy"  value="${faRequest.needDate}" /></td>
                                        <td>${faRequest.customer}</td>
                                        <td>${faRequest.partNo}</td>
                                        <td>${faRequest.saleOut}</td>
                                        <c:set var="appuser" value="${faRequest.createBy}"/>
                                        <td>${appuser.name}</td>
                                        <td>
                                            <a class="btn btn-primary btn-sm" href="${home}fams/engineerReview/${faRequest.id}" role="button">
                                                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                            </a>
                                        </td>
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
        $("#faStatusCreateUpdate").DataTable();
    });
</script>