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
            <div class="panel-group" id="accordionGoodFlow">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse1">
                                Sale Request <span class="badge">${fn:length(faStatusCreateList)}</span>
                            </a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse">
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
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="faRequest" items="${faStatusCreateList}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${faRequest.faNumber}</td>
                                            <td>${faRequest.partNo}</td>
                                            <td>${faRequest.customer}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.needDate}" /></td>
                                            <td>${faRequest.saleOut}</td>
                                            <c:set var="appuserCreate" value="${faRequest.createBy}"/>
                                            <td>${appuserCreate.name}</td>
                                            <td><a href="${home}fams/detail/create/${faRequest.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse2">
                                Engineer ประเมิณว่าสามารถทำงานได้ กำลังทำงานเพื่อส่งตรวจ First shot <span class="badge">${fn:length(faStatusEngineerApprove)}</span>
                            </a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableEngineerApproveWaitFirstList" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="faRequest" items="${faStatusEngineerApprove}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${faRequest.faNumber}</td>
                                            <td>${faRequest.partNo}</td>
                                            <td>${faRequest.customer}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.needDate}" /></td>
                                            <td>${faRequest.saleOut}</td>
                                            <c:set var="appuserCreate" value="${faRequest.createBy}"/>
                                            <td>${appuserCreate.name}</td>
                                            <td><a href="${home}fams/detail/create/${faRequest.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse3">
                                Engineer ส่งงานแล้วรอ QA ตรวจ First shot <span class="badge">${fn:length(faStatusEngineerSendFirstShot)}</span>
                            </a>
                        </h4>
                    </div>
                    <div id="collapse3" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableWaitQaFirst" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="faRequest" items="${faStatusEngineerSendFirstShot}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${faRequest.faNumber}</td>
                                            <td>${faRequest.partNo}</td>
                                            <td>${faRequest.customer}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.needDate}" /></td>
                                            <td>${faRequest.saleOut}</td>
                                            <c:set var="appuserCreate" value="${faRequest.createBy}"/>
                                            <td>${appuserCreate.name}</td>
                                            <td><a href="${home}fams/detail/create/${faRequest.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse4">
                                QA ตรวจ First Shot ผ่านแล้ว Engineer กำลังทำงานเพื่อส่งตรวจครั้งสุดท้าย <span class="badge">${fn:length(faStatusQaApproveFirst)}</span>
                            </a>
                        </h4>
                    </div>
                    <div id="collapse4" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableEngineerWorkWaitLast" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="faRequest" items="${faStatusQaApproveFirst}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${faRequest.faNumber}</td>
                                            <td>${faRequest.partNo}</td>
                                            <td>${faRequest.customer}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.needDate}" /></td>
                                            <td>${faRequest.saleOut}</td>
                                            <c:set var="appuserCreate" value="${faRequest.createBy}"/>
                                            <td>${appuserCreate.name}</td>
                                            <td><a href="${home}fams/detail/create/${faRequest.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse5">
                                Engineer ส่งงานแล้วรอ QA ตรวจครั้งสุดท้ายก่อนส่งลูกค้า
                            </a>
                        </h4>
                    </div>
                    <div id="collapse5" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableWaitQaLast" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse6">
                                QA inspection ตรวจสอบผ่านแล้ว รอ QA Engineer ตรวจสอบเอกสาร
                            </a>
                        </h4>
                    </div>
                    <div id="collapse6" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableWaitRewiewDocument" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse7">
                                งานเสร็จเรียบร้อย รอ sale Co จัดส่งลูกค้า
                            </a>
                        </h4>
                    </div>
                    <div id="collapse7" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableWaitSaleCoSendItem" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse8">
                                sale Co ส่งงานลูกค้าแล้ว รอ Sale Out ติดตามผล
                            </a>
                        </h4>
                    </div>
                    <div id="collapse8" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableSaleOutFollow" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse9">
                                Engineer ติดปัญหากำลังหาทางแก้ไข <span class="badge">${fn:length(faStatusEngineerWaiting)}</span>
                            </a>
                        </h4>
                    </div>
                    <div id="collapse9" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableEngineerWait" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="faRequest" items="${faStatusEngineerWaiting}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${faRequest.faNumber}</td>
                                            <td>${faRequest.partNo}</td>
                                            <td>${faRequest.customer}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.needDate}" /></td>
                                            <td>${faRequest.saleOut}</td>
                                            <c:set var="appuserCreate" value="${faRequest.createBy}"/>
                                            <td>${appuserCreate.name}</td>
                                            <td><a href="${home}fams/detail/create/${faRequest.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse10">
                                QA ติดปัญหากำลังหาทางแก้ไข
                            </a>
                        </h4>
                    </div>
                    <div id="collapse10" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableQAWait" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse11">
                                Engineer ไม่สามารถทำงานได้ (Reject Sale) <span class="badge">${fn:length(faStatusEngineerReject)}</span>
                            </a>
                        </h4>
                    </div>
                    <div id="collapse11" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableEngineerRejectSale" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="faRequest" items="${faStatusEngineerReject}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${faRequest.faNumber}</td>
                                            <td>${faRequest.partNo}</td>
                                            <td>${faRequest.customer}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.needDate}" /></td>
                                            <td>${faRequest.saleOut}</td>
                                            <c:set var="appuserCreate" value="${faRequest.createBy}"/>
                                            <td>${appuserCreate.name}</td>
                                            <td><a href="${home}fams/detail/create/${faRequest.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse12">
                                QA Reject First Shot <span class="badge">${fn:length(faStatusQaRejectFirst)}</span>
                            </a>
                        </h4>
                    </div>
                    <div id="collapse12" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableQaRejectFirst" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="faRequest" items="${faStatusQaRejectFirst}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${faRequest.faNumber}</td>
                                            <td>${faRequest.partNo}</td>
                                            <td>${faRequest.customer}</td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.createDate}" /></td>
                                            <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${faRequest.needDate}" /></td>
                                            <td>${faRequest.saleOut}</td>
                                            <c:set var="appuserCreate" value="${faRequest.createBy}"/>
                                            <td>${appuserCreate.name}</td>
                                            <td><a href="${home}fams/detail/create/${faRequest.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse13">
                                QA Reject Last Shot
                            </a>
                        </h4>
                    </div>
                    <div id="collapse13" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableQaRejectLast" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordionGoodFlow" href="#collapse14">
                                QA Engineer Reject Document
                            </a>
                        </h4>
                    </div>
                    <div id="collapse14" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="col-sm-12 table-responsive">
                                <table id="tableQaRejectDoc" class="table table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>FA Number</th>
                                        <th>Part Number</th>
                                        <th>Customer</th>
                                        <th>Request Date</th>
                                        <th>Need Date</th>
                                        <th>Sale Out</th>
                                        <th>Request By</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                        <td>1</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $("#tableSaleRequestList").DataTable();
        $("#tableEngineerApproveWaitFirstList").DataTable();
        $("#tableWaitQaFirst").DataTable();
        $("#tableEngineerWorkWaitLast").DataTable();
        $("#tableWaitQaLast").DataTable();
        $("#tableWaitRewiewDocument").DataTable();
        $("#tableWaitSaleCoSendItem").DataTable();
        $("#tableSaleOutFollow").DataTable();
        $("#tableEngineerWait").DataTable();
        $("#tableQAWait").DataTable();
        $("#tableEngineerRejectSale").DataTable();
        $("#tableQaRejectFirst").DataTable();
        $("#tableQaRejectLast").DataTable();
        $("#tableQaRejectDoc").DataTable();
    });
</script>