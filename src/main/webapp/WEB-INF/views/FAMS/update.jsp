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
            <form class="form-horizontal well" id="faForm" action="" method="POST">
                <legend>FA Request</legend>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="inputCustomer" class="col-sm-3 control-label">Customer :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputCustomer" value="${faRequest.customer}" placeholder="Customer" autocomplete="off" required>
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPartNo" class="col-sm-3 control-label">Part No. :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputPartNo" value="${faRequest.partNo}" placeholder="Part Number" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPartName" class="col-sm-3 control-label">Part Name. :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputPartName" value="${faRequest.partName}" placeholder="Part Name" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputRevision" class="col-sm-3 control-label">Revision :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputRevision" value="${faRequest.revision}" placeholder="Revision" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputSaleOut" class="col-sm-3 control-label">Sale Out :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputSaleOut" value="${faRequest.saleOut}" placeholder="Sale out door" autocomplete="off" required>
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputQwsNo" class="col-sm-3 control-label">QWS No. :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputQwsNo" value="${faRequest.qwsNo}" placeholder="Quatation Work Sheet Number" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputApqpNo" class="col-sm-3 control-label">APQP No. :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputApqpNo" value="${faRequest.apqpNo}" placeholder="APQP Number" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputNeedDate" class="col-sm-3 control-label">Need Date :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <fmt:formatDate pattern="dd/MM/yyyy" var="needDate" value="${faRequest.needDate}" />
                                    <input type="text" class="form-control input-group-sm" id="inputNeedDate" value="${needDate}" placeholder="dd/MM/yyyy" autocomplete="off" required>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputFaApprove" class="col-sm-3 control-label">FA Approve :</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control input-group-sm" id="inputFaApprove" value="${faRequest.faApproveQty}" placeholder="Qty" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputFaForSell" class="col-sm-3 control-label">FA For Sell :</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control input-group-sm" id="inputFaForSell"  value="${faRequest.faForSellQty}" placeholder="Qty" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputSampleTest" class="col-sm-3 control-label">Sample Test :</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control input-group-sm" id="inputSampleTest"  value="${faRequest.samplTestQty}" placeholder="Qty" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputSamplePcc" class="col-sm-3 control-label">Sample PCC :</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control input-group-sm" id="inputSamplePcc"  value="${faRequest.samplePccQty}" placeholder="Qty" autocomplete="off">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="inputMat1" class="col-sm-3 control-label">Material 1 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputMat1" placeholder="Material 1" value="${faRequest.material1}" autocomplete="off" required>
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat2" class="col-sm-3 control-label">Material 2 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <c:choose>
                                        <c:when test="${faRequest.material2 ne 'na'}">
                                            <input type="text" class="form-control input-group-sm" id="inputMat2" placeholder="Material 2" value="${faRequest.material2}" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" class="form-control input-group-sm" id="inputMat2" placeholder="Material 2" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat3" class="col-sm-3 control-label">Material 3 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <c:choose>
                                        <c:when test="${faRequest.material3 ne 'na'}">
                                            <input type="text" class="form-control input-group-sm" id="inputMat3" placeholder="Material 3" value="${faRequest.material3}" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" class="form-control input-group-sm" id="inputMat3" placeholder="Material 3" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat4" class="col-sm-3 control-label">Material 4 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <c:choose>
                                        <c:when test="${faRequest.material4 ne 'na'}">
                                            <input type="text" class="form-control input-group-sm" id="inputMat4" placeholder="Material 4" value="${faRequest.material4}" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" class="form-control input-group-sm" id="inputMat4" placeholder="Material 4" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat5" class="col-sm-3 control-label">Material 5 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <c:choose>
                                        <c:when test="${faRequest.material5 ne 'na'}">
                                            <input type="text" class="form-control input-group-sm" id="inputMat5" placeholder="Material 5" value="${faRequest.material5}" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" class="form-control input-group-sm" id="inputMat5" placeholder="Material 5" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat6" class="col-sm-3 control-label">Material 6 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <c:choose>
                                        <c:when test="${faRequest.material6 ne 'na'}">
                                            <input type="text" class="form-control input-group-sm" id="inputMat6" placeholder="Material 6" value="${faRequest.material6}" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="text" class="form-control input-group-sm" id="inputMat6" placeholder="Material 6" autocomplete="off">
                                            <span class="input-group-addon">Search</span>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Document Request :</label>
                            <div class="col-sm-9">
                                <select id="inputDocumentRequest" class="form-control input-group-sm">
                                    <option>No Need Data</option>
                                    <option>Inspection Only</option>
                                    <option>Full FA Package</option>
                                    <option>PPAP</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputTools" class="col-sm-3 control-label">Tools :</label>
                            <div class="col-sm-9">
                                <select id="inputTools" class="form-control input-group-sm">
                                    <option value="Tooling">Tooling</option>
                                    <option value="CNC">CNC</option>
                                    <option value="LASER">LASER</option>
                                    <option value="Other">Other</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputRemark" class="col-sm-3 control-label">Remark :</label>
                            <div class="col-sm-9">
                                <textarea id="inputRemark" rows="2" class="form-control input-group-sm">${faRequest.remark}<jsp:text/></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputFile1" class="col-sm-3 control-label">Drawing :</label>
                            <div class="col-sm-9 form-inline">
                                <span class="btn btn-file"><input type="file" id="inputFile1"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputFile2" class="col-sm-3 control-label">Other File :</label>
                            <div class="col-sm-9 form-inline">
                                <span class="btn btn-file"><input type="file" id="inputFile2"></span>
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
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <c:if test="${faRequest.status eq 'CREATE_FA_REQUEST' or faRequest.status eq 'UPDATE_FA_REQUEST' or faRequest.status eq 'ENGINEER_REJECT_FA_REQUEST' or faRequest.status eq 'ENGINEER_CANCEL_FA_REQUEST'}">
                                    <button type="submit" id="submit" class="btn btn-primary">Update</button>
                                    <button type="button" id="cancel" class="btn btn-danger">Cancel</button>
                                </c:if>
                            </div>
                        </div>
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
<div class="modal fade" id="alertCancelModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                <h4 class="modal-title">Cancel Reason</h4>
            </div>
            <div class="modal-body">
                <textarea class="form-control" rows="3" id="inputReasonCancel"><jsp:text/></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="btnCancelModal">confirm</button>
            </div>
        </div>
    </div>
</div>
<script>
    var customerList = [];
    var saleOutList = [];
    var materialList = [];

    $(document).ready(function() {
        $('#inputTools option[value=${faRequest.tool}]').attr('selected','selected');
        $("#inputDocumentRequest option").filter(function() {
            return this.text == '${faRequest.documentRequest}';
        }).attr('selected', true);

        $("#inputNeedDate").datepicker({ dateFormat: "dd/mm/yy" });

        addCustomer();
        addDataSaleOut();
        addMaterial();
        $("#faForm").submit(function() {

            if(customerList.indexOf($("#inputCustomer").val()) < 0) {
                $("#inputCustomer").focus();
                return false;
            }

            if(saleOutList.indexOf($("#inputSaleOut").val()) < 0) {
                $("#inputSaleOut").focus();
                return false;
            }

            var inputMat1 = $("#inputMat1").val();
            if(materialList.indexOf(inputMat1) < 0) {
                $("#inputMat1").focus();
                return false;
            }
            var inputMat2 = $("#inputMat2").val();
            if(materialList.indexOf(inputMat2) < 0 && inputMat2.length > 0) {
                $("#inputMat2").focus();
                return false;
            }
            var inputMat3 = $("#inputMat3").val();
            if(materialList.indexOf(inputMat3) < 0 && inputMat3.length > 0) {
                $("#inputMat3").focus();
                return false;
            }
            var inputMat4 = $("#inputMat4").val();
            if(materialList.indexOf(inputMat4) < 0 && inputMat4.length > 0) {
                $("#inputMat4").focus();
                return false;
            }
            var inputMat5 = $("#inputMat5").val();
            if(materialList.indexOf(inputMat5) < 0 && inputMat5.length > 0) {
                $("#inputMat5").focus();
                return false;
            }
            var inputMat6 = $("#inputMat6").val();
            if(materialList.indexOf(inputMat6) < 0 && inputMat6.length > 0) {
                $("#inputMat6").focus();
                return false;
            }

            var formData = new FormData();
            formData.append("id", ${faRequest.id});
            formData.append("customer", $("#inputCustomer").val());
            formData.append("partNo", $("#inputPartNo").val());
            formData.append("partName", $("#inputPartName").val());
            formData.append("revision", $("#inputRevision").val());
            formData.append("saleOut", $("#inputSaleOut").val());
            formData.append("qwsNo", $("#inputQwsNo").val());
            formData.append("apqaNo", $("#inputApqpNo").val());
            formData.append("needDate", $("#inputNeedDate").val());
            formData.append("faApproveQty", $("#inputFaApprove").val());
            formData.append("faForSellQty", $("#inputFaForSell").val());
            formData.append("sampleTestQty", $("#inputSampleTest").val());
            formData.append("samplePccQty", $("#inputSamplePcc").val());
            formData.append("material1", $("#inputMat1").val());
            formData.append("material2", $("#inputMat2").val());
            formData.append("material3", $("#inputMat3").val());
            formData.append("material4", $("#inputMat4").val());
            formData.append("material5", $("#inputMat5").val());
            formData.append("material6", $("#inputMat6").val());
            formData.append("documentRequest", $("#inputDocumentRequest").val());
            formData.append("tools", $("#inputTools").val());
            formData.append("remark", $("#inputRemark").val());
            formData.append("drawingFile", $("#inputFile1")[0].files[0]);
            formData.append("otherFile", $("#inputFile2")[0].files[0]);

            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}fams/update/fa",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}fams/listSale";
                },
                error: function(data){
                    alert("Error");
                    return false;
                }
            });

            return false;
        });

        $("#cancel").click(function() {
            $("#alertCancelModal").modal({show:true});
        });

        $("#btnCancelModal").click(function() {
            var formData = new FormData();
            formData.append("id", "${faRequest.id}");
            formData.append("reason", $("#inputReasonCancel").val());

            $.ajax({
                type: "POST",
                headers: {
                    Accept: "application/json",
                },
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                url: "${home}fams/cancel/fa",
                processData: false,
                contentType: false,
                data: formData,
                async: false,
                success: function(data){
                    window.location.href = "${home}fams/listSale";
                },
                error: function(data){
                    alert("Error");
                    return false;
                }
            });
            return false;
        });
    });

    function addCustomer() {
        $.ajax({
            type: "POST",
            headers: {
                Accept: "application/json",
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "${home}customer/all",
            processData: false,
            contentType: false,
            async: false,
            success: function(data){
                $("#inputCustomer").autocomplete({
                    source: data
                });
                customerList = data;
            },
            error: function(data){
                alert("Error");
                return false;
            }
        });
    }

    function addDataSaleOut() {
        var formData = new FormData();
        formData.append("roleName", "saleOut");
        $.ajax({
            type: "POST",
            headers: {
                Accept: "application/json",
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "${home}appuser/findInRoleName",
            processData: false,
            contentType: false,
            data: formData,
            async: false,
            success: function(data){
                $("#inputSaleOut").autocomplete({
                    source: data
                });
                saleOutList = data;
            },
            error: function(data){
                alert("Error");
                return false;
            }
        });
    }

    function addMaterial() {
        $.ajax({
            type: "POST",
            headers: {
                Accept: "application/json",
            },
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "${home}material/all",
            processData: false,
            contentType: false,
            async: false,
            success: function(data){
                $("#inputMat1").autocomplete({
                    source: data
                });

                $("#inputMat2").autocomplete({
                    source: data
                });

                $("#inputMat3").autocomplete({
                    source: data
                });

                $("#inputMat4").autocomplete({
                    source: data
                });

                $("#inputMat5").autocomplete({
                    source: data
                });

                $("#inputMat6").autocomplete({
                    source: data
                });
                materialList = data;
            },
            error: function(data){
                alert("Error");
                return false;
            }
        });
    }

</script>