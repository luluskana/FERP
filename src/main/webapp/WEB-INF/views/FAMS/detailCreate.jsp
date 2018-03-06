<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/" var="home" />
<div class="container">
    <div class="row">
        <div class="col-sm-12 well">
            <form class="form-horizontal">
                <legend>FA Detail</legend>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">FA Number :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.faNumber}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Customer :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.customer}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Part No. :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.partNo}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Part Name :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.partName}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Revision :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.revision}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Sale Out :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.saleOut}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">QWS No. :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.qwsNo}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">APQP No. :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.apqpNo}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Need Date :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static"><fmt:formatDate pattern="dd/MM/yyyy"  value="${faRequest.needDate}" /></label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">FA Approve :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.faApproveQty} pcs</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">FA For Sell :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.faForSellQty} pcs</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Sample Test :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.samplTestQty} pcs</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Sample PCC :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.samplePccQty} pcs</label>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Material 1 :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.material1}</label>
                        </div>
                    </div>
                    <c:if test="${faRequest.material2 ne 'na'}">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Material 2 :</label>
                            <div class="col-sm-8">
                                <label class="form-control-static">${faRequest.material2}</label>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${faRequest.material3 ne 'na'}">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Material 3 :</label>
                            <div class="col-sm-8">
                                <label class="form-control-static">${faRequest.material3}</label>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${faRequest.material4 ne 'na'}">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Material 4 :</label>
                            <div class="col-sm-8">
                                <label class="form-control-static">${faRequest.material4}</label>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${faRequest.material5 ne 'na'}">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Material 5 :</label>
                            <div class="col-sm-8">
                                <label class="form-control-static">${faRequest.material5}</label>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${faRequest.material6 ne 'na'}">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Material 6 :</label>
                            <div class="col-sm-8">
                                <label class="form-control-static">${faRequest.material6}</label>
                            </div>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Document Request :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.documentRequest}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">Tools :</label>
                        <div class="col-sm-8">
                            <label class="form-control-static">${faRequest.tool}</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputRemark" class="col-sm-4 control-label">Remark :</label>
                        <div class="col-sm-8">
                            <textarea id="inputRemark" rows="2" class="form-control"  disabled>${faRequest.remark}</textarea>
                        </div>
                    </div>
                    <c:if test="${not empty faRequest.drawingFile}">
                        <div class="form-group form-inline">
                            <label class="col-sm-4 control-label">Drawing :</label>
                            <div class="col-sm-8">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}mtms/file/${faRequest.drawingFile}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty faRequest.otherFile}">
                        <div class="form-group form-inline">
                            <label class="col-sm-4 control-label">Other :</label>
                            <div class="col-sm-8">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}mtms/file/${faRequest.otherFile}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty faRequest.engineerCommitDate}">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Commit Date :</label>
                            <div class="col-sm-8">
                                <label class="form-control-static"><fmt:formatDate pattern="dd/MM/yyyy"  value="${faRequest.engineerCommitDate}" /></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputProcess" class="col-sm-4 control-label">Process :</label>
                            <div class="col-sm-8">
                                <textarea id="inputProcess" rows="4" class="form-control" disabled>${faRequest.process}</textarea>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty faRequest.fileData1}">
                        <div class="form-group form-inline">
                            <label class="col-sm-4 control-label">File Data 1 :</label>
                            <div class="col-sm-8">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}mtms/file/${faRequest.fileData1}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty faRequest.fileData2}">
                        <div class="form-group form-inline">
                            <label class="col-sm-4 control-label">File Data 2 :</label>
                            <div class="col-sm-8">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}mtms/file/${faRequest.fileData2}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty faRequest.contractName}">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Contract :</label>
                            <div class="col-sm-8">
                                <label class="form-control-static">${faRequest.contractName}</label>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty faRequest.invoice}">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">Invoice :</label>
                            <div class="col-sm-8">
                                <label class="form-control-static">${faRequest.invoice}</label>
                            </div>
                        </div>
                    </c:if>
                    <div class="form-group form-inline">
                        <label class="col-sm-4 control-label">Print :</label>
                        <div class="col-sm-8">
                            <p class="form-control-static">
                                <a class="btn btn-primary" href="${home}fams/createreport/${faRequest.id}" target="_blank" role="button"><span class="glyphicon glyphicon glyphicon-print" aria-hidden="true"></span></a>
                            </p>
                        </div>
                    </div>
                    <c:if test="${not empty faRequest.referenceFas}">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Refer FA :</label>
                            <div class="col-sm-9 form-inline">
                                <ul>
                                    <c:forEach var="referFa" items="${faRequest.referenceFas}" varStatus="loop">
                                        <c:set var="faRequestRefer" value="${referFa.faRequestRefer}"/>
                                        <li><a href="${home}fams/detail/create/${faRequestRefer.id}" target="_blank">${faRequestRefer.faNumber}</a></li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty faRequest.fileCustomerApprove}">
                        <div class="form-group form-inline">
                            <label class="col-sm-4 control-label">Customer Approve :</label>
                            <div class="col-sm-8">
                                <p class="form-control-static">
                                    <a class="btn btn-info" href="${home}mtms/file/${faRequest.fileCustomerApprove}" target="_blank" role="button"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span></a>
                                </p>
                            </div>
                        </div>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-primary">
                <div class="panel-heading" align="center">History</div>
                <div class="panel-body table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>No.</th>
                            <th>Update Date</th>
                            <th>Status</th>
                            <th>Remark</th>
                            <th>Tooling No</th>
                            <th>Qty</th>
                            <th>Pick slip</th>
                            <th>Update By</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="documentHistorys" value="${faRequest.logHistories}"/>
                        <c:forEach var="documentHistory" items="${documentHistorys}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${documentHistory.createDate}" /></td>
                                <td>
                                    <c:if test="${documentHistory.status eq 'CREATE_FA_REQUEST'}">
                                        <span class="label label-primary">create</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'UPDATE_FA_REQUEST'}">
                                        <span class="label label-primary">update</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'ENGINEER_APPROVE_FA_REQUEST'}">
                                        <span class="label label-success">engineer approve</span>
                                     </c:if>
                                    <c:if test="${documentHistory.status eq 'ENGINEER_WAITING_FA_REQUEST'}">
                                        <span class="label label-warning">engineer waiting</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'ENGINEER_REJECT_FA_REQUEST'}">
                                        <span class="label label-danger">engineer reject</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'ENGINEER_SEND_FIRST_FA_REQUEST'}">
                                        <span class="label label-success">first shot</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'ENGINEER_CANCEL_FA_REQUEST'}">
                                        <span class="label label-danger">engineer cancel</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'QA_APPROVE_FIRST_FA_REQUEST'}">
                                        <span class="label label-success">qa approve first</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'QA_REJECT_FIRST_FA_REQUEST'}">
                                        <span class="label label-danger">qa reject first</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'ENGINEER_SEND_FINAL_FA_REQUEST'}">
                                        <span class="label label-success">engineer send final</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'QA_APPROVE_FINAL_FA_REQUEST'}">
                                        <span class="label label-success">qa approve final</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'QA_REJECT_FINAL_FA_REQUEST'}">
                                        <span class="label label-danger">qa reject final</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'QA_WAITING_FINAL_FA_REQUEST'}">
                                        <span class="label label-warning">qa waiting</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'QA_REJECT_DOCUMENT_FA_REQUEST'}">
                                        <span class="label label-danger">qa reject document</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'QA_APPROVE_DOCUMENT_FA_REQUEST'}">
                                        <span class="label label-success">qa approve document</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'SALE_CO_FOLLOW_UP_FA_REQUEST'}">
                                        <span class="label label-success">sale follow</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'SALE_OUT_APPROVE_FA_REQUEST'}">
                                        <span class="label label-success">customer approve</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'SALE_OUT_REJECT_FA_REQUEST'}">
                                        <span class="label label-danger">customer reject</span>
                                    </c:if>
                                    <c:if test="${documentHistory.status eq 'SALE_OUT_RESUBMIT_FA_REQUEST'}">
                                        <span class="label label-warning">request refer</span>
                                    </c:if>
                                </td>
                                <td>${documentHistory.remark}</td>
                                <td>${documentHistory.methodFirst}</td>
                                <td>${documentHistory.qtyFirst}</td>
                                <td>${documentHistory.slipMatNo}</td>
                                <c:set var="createBy" value="${documentHistory.createBy}"/>
                                <td>${createBy.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>