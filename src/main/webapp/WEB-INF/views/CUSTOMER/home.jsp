<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <c:if test="${roleName eq 'admin' or roleName eq 'user' or roleName eq 'qa'}">
        <div class="row">
            <div class="col-sm-12">
                <form class="form-inline" id="formCreateCustomer">
                    <legend>Create Customer</legend>
                    <div class="form-group">
                        <label for="customerName">Customer Name</label>
                        <input type="text" class="form-control" id="customerName" placeholder="Foamtec" autocomplete="off" size="30" required>
                    </div>
                    <div class="form-group">
                        <label for="groupType">Group Type</label>
                        <select class="form-control" id="groupType">
                            <option>Electronics</option>
                            <option>Automotive</option>
                            <option>Cosmetic</option>
                            <option>HDD</option>
                            <option>Consumer</option>
                            <option>General</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-default">Create</button>
                </form>
            </div>
        </div>
        <br>
    </c:if>
    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title" align="center">Customer</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12 table-responsive">
                            <table id="customerList" class="table table-striped table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Customer Name</th>
                                    <th>Group Type</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                    <th>Zoom in</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="customer" items="${customers}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${customer.name}</td>
                                            <td>${customer.groupType}</td>
                                            <c:choose>
                                                <c:when test="${roleName eq 'admin' or roleName eq 'user'}">
                                                    <td><button class="btn btn-warning btn-sm update" value="${customer.id}_${customer.groupType}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td>
                                                    <td><button class="btn btn-danger btn-sm delete" value="${customer.id}_${customer.groupType}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><button class="btn btn-warning btn-sm" disabled><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></td>
                                                    <td><button class="btn btn-danger btn-sm" disabled><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td><a href="#" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
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
        $('#customerList').DataTable();

        $("#formCreateCustomer").submit(function() {
            var formData = new FormData();
            formData.append("customerName", $("#customerName").val());
            formData.append("groupType", $("#groupType").val());
            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}customer/create/customer",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}customer";
                },
                error: function(data){
                    alert("Error");
                    return false;
                }
            });
            return false;
        });
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
                url: "${home}customer/delete/customer",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}customer";
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
</script>