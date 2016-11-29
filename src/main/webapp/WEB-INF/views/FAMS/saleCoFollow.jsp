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
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="inputContract" class="col-sm-3 control-label">Contact Person :</label>
                    <div class="col-sm-6">
                        <div class="input-group">
                            <input type="text" class="form-control" id="inputContract" placeholder="Name" autocomplete="off" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputInvoice" class="col-sm-3 control-label">Invoice No. :</label>
                    <div class="col-sm-6">
                        <div class="input-group">
                            <input type="text" class="form-control" id="inputInvoice" placeholder="Invoice No" autocomplete="off" required>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-list"></span></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-4" align="center">
                        <button type="button" id="btnApprove" class="btn btn-success">Save Data</button>
                    </div>
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
                            <th>Update By</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="documentHistorys" value="${faRequest.logHistories}"/>
                        <c:forEach var="documentHistory" items="${documentHistorys}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy [hh:mm]"  value="${documentHistory.createDate}" /></td>
                                <td>${documentHistory.status}</td>
                                <td>${documentHistory.remark}</td>
                                <td>${documentHistory.methodFirst}</td>
                                <td>${documentHistory.qtyFirst}</td>
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
<div class="modal fade" id="alertApproveModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title">Save</h4>
            </div>
            <div class="modal-body">
                Confirm save
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" id="btnApproveReason">confirm</button>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {

        $("#btnApprove").click(function() {
            $("#alertApproveModal").modal({show:true});
        });

        $("#btnApproveReason").click(function() {
            var formData = new FormData();
            formData.append("id", "${faRequest.id}");
            formData.append("contractName", $("#inputContract").val());
            formData.append("invoice", $("#inputInvoice").val());

            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}fams/saleCo/followUp",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}fams/listSaleCoFollow";
                },
                error: function(data){
                    alert("Error");
                    return false;
                }
            });
            return false;
        });
    });
</script>