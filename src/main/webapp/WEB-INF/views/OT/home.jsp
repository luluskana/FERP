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
        <div class="col-sm-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">OT Menu</h3>
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <a href="${home}ot/template" class="list-group-item list-group-item-text">
                            * Template
                        </a>
                        <a href="${home}ot/createOt" class="list-group-item list-group-item-text">
                            * Request OT
                        </a>
                        <a href="#" class="list-group-item list-group-item-text">
                            * OT list request by ${name}
                        </a>
                        <a href="#" class="list-group-item list-group-item-text">
                            Supervisor
                        </a>
                        <a href="#" class="list-group-item list-group-item-text">
                            Operation Manager
                        </a>
                        <a href="#" class="list-group-item list-group-item-text">
                            General Manager
                        </a>
                        <a href="#" class="list-group-item list-group-item-text">
                            HR
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="panel-title" align="center">
                            OT Request
                        </h4>
                    </div>
                    <div class="panel-body">
                        <div class="col-sm-12 table-responsive">
                            <table id="tableOtRequestList" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>OT Number</th>
                                    <th>Status</th>
                                    <th>Department</th>
                                    <th>Request Date</th>
                                    <th>Supervisor</th>
                                    <th>Request By</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>OT00001</td>
                                            <td>CREATE</td>
                                            <td>Production</td>
                                            <td>17/12/2016</td>
                                            <td>Singha</td>
                                            <td>Monoi</td>
                                            <td><a href="#" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
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
        $("#tableOtRequestList").DataTable();
    });
</script>