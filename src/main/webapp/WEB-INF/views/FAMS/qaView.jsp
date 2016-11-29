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
            <li class="active"><a data-toggle="tab" href="#qaWaitingFirst">Waiting First Shot <span class="badge">${fn:length(faStatusFirst)}</span></a></li>
            <li><a data-toggle="tab" href="#qaWaitingFinal">Waiting Final <span class="badge">${fn:length(faStatusFinal)}</span></a></li>
            <li><a data-toggle="tab" href="#qaProblem">Problem <span class="badge">${fn:length(faStatusWaiting)}</span></a></li>
            <li><a data-toggle="tab" href="#qaDocumentReject">Document Reject <span class="badge">${fn:length(faStatusRejectDocument)}</span></a></li>
        </ul>
        <div class="tab-content">
            <div id="qaWaitingFirst" class="tab-pane fade in active">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title" align="center">Waiting First Shot</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-hover" id="faStatusWaitingFirstShot">
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
                                <c:forEach var="faRequest" items="${faStatusFirst}" varStatus="loop">
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
                                            <a class="btn btn-primary btn-sm" href="${home}fams/qaFirst/${faRequest.id}" role="button">
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
            <div id="qaWaitingFinal" class="tab-pane fade">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title" align="center">Waiting Final</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-hover" id="faStatusWaitingFinal">
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
                                <c:forEach var="faRequest" items="${faStatusFinal}" varStatus="loop">
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
                                            <a class="btn btn-primary btn-sm" href="${home}fams/qaFinal/${faRequest.id}" role="button">
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
            <div id="qaProblem" class="tab-pane fade">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <h3 class="panel-title" align="center">Problem</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-hover" id="faStatusQaWaiting">
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
                                <c:forEach var="faRequest" items="${faStatusWaiting}" varStatus="loop">
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
                                            <a class="btn btn-primary btn-sm" href="${home}fams/qaFinal/${faRequest.id}" role="button">
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
            <div id="qaDocumentReject" class="tab-pane fade">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h3 class="panel-title" align="center">Document Reject</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-hover" id="faStatusRejectDocument">
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
                                <c:forEach var="faRequest" items="${faStatusRejectDocument}" varStatus="loop">
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
                                            <a class="btn btn-primary btn-sm" href="${home}fams/qaFinal/${faRequest.id}" role="button">
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
        $("#faStatusWaitingFirstShot").DataTable();
        $("#faStatusWaitingFinal").DataTable();
        $("#faStatusQaWaiting").DataTable();
        $("#faStatusRejectDocument").DataTable();
    });
</script>