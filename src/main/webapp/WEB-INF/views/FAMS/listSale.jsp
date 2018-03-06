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
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4 class="panel-title" align="center">
                        ${name} Request
                    </h4>
                </div>
                <div class="panel-body">
                    <div class="col-sm-12 table-responsive">
                        <table id="tableSaleRequestList" class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>FA Number</th>
                                <th>Part Number</th>
                                <th>Customer</th>
                                <th>Request Date</th>
                                <th>Need Date</th>
                                <th>Sale Out</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="faRequest" items="${faByUserList}" varStatus="loop">
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td>${faRequest.faNumber}</td>
                                    <td>${faRequest.partNo}</td>
                                    <td>${faRequest.customer}</td>
                                    <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                    <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.needDate}" /></td>
                                    <td>${faRequest.saleOut}</td>
                                    <td>
                                        <c:if test="${faRequest.status eq 'CREATE_FA_REQUEST'}">
                                            <span class="label label-primary">create</span>
                                        </c:if>
                                        <c:if test="${faRequest.status eq 'UPDATE_FA_REQUEST'}">
                                            <span class="label label-primary">update</span>
                                        </c:if>
                                        <c:if test="${faRequest.status eq 'ENGINEER_APPROVE_FA_REQUEST'}">
                                            <span class="label label-success">engineer approve</span>
                                         </c:if>
                                        <c:if test="${faRequest.status eq 'ENGINEER_WAITING_FA_REQUEST'}">
                                            <span class="label label-warning">engineer waiting</span>
                                        </c:if>
                                        <c:if test="${faRequest.status eq 'ENGINEER_REJECT_FA_REQUEST'}">
                                            <span class="label label-danger">engineer reject</span>
                                        </c:if>
                                        <c:if test="${faRequest.status eq 'ENGINEER_SEND_FIRST_FA_REQUEST'}">
                                            <span class="label label-success">first shot</span>
                                        </c:if>
                                        <c:if test="${faRequest.status eq 'ENGINEER_CANCEL_FA_REQUEST'}">
                                            <span class="label label-danger">engineer cancel</span>
                                        </c:if>
                                    </td>
                                    <td><a href="${home}fams/update/${faRequest.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
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
        $("#tableSaleRequestList").DataTable();
    });
</script>