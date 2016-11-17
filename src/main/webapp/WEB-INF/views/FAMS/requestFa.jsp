<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                                    <input type="text" class="form-control input-group-sm" id="inputCustomer" placeholder="Customer" autocomplete="off" required>
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPartNo" class="col-sm-3 control-label">Part No. :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputPartNo" placeholder="Part Number" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPartName" class="col-sm-3 control-label">Part Name. :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputPartName" placeholder="Part Name" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputRevision" class="col-sm-3 control-label">Revision :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputRevision" placeholder="Revision" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputSaleOut" class="col-sm-3 control-label">Sale Out :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputSaleOut" placeholder="Sale out door" autocomplete="off" required>
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputQwsNo" class="col-sm-3 control-label">QWS No. :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputQwsNo" placeholder="Quatation Work Sheet Number" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputApqpNo" class="col-sm-3 control-label">APQP No. :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control input-group-sm" id="inputApqpNo" placeholder="APQP Number" autocomplete="off" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputNeedDate" class="col-sm-3 control-label">Need Date :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputNeedDate" placeholder="dd/MM/yyyy" autocomplete="off" required>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputFaApprove" class="col-sm-3 control-label">FA Approve :</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control input-group-sm" id="inputFaApprove" placeholder="Qty" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputFaForSell" class="col-sm-3 control-label">FA For Sell :</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control input-group-sm" id="inputFaForSell" placeholder="Qty" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputSampleTest" class="col-sm-3 control-label">Sample Test :</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control input-group-sm" id="inputSampleTest" placeholder="Qty" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputSamplePcc" class="col-sm-3 control-label">Sample PCC :</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control input-group-sm" id="inputSamplePcc" placeholder="Qty" autocomplete="off">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="inputMat1" class="col-sm-3 control-label">Material 1 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputMat1" placeholder="Material 1" autocomplete="off" required>
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat2" class="col-sm-3 control-label">Material 2 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputMat2" placeholder="Material 2" autocomplete="off">
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat3" class="col-sm-3 control-label">Material 3 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputMat3" placeholder="Material 3" autocomplete="off">
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat4" class="col-sm-3 control-label">Material 4 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputMat4" placeholder="Material 4" autocomplete="off">
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat5" class="col-sm-3 control-label">Material 5 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputMat5" placeholder="Material 5" autocomplete="off">
                                    <span class="input-group-addon">Search</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputMat6" class="col-sm-3 control-label">Material 6 :</label>
                            <div class="col-sm-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-group-sm" id="inputMat6" placeholder="Material 6" autocomplete="off">
                                    <span class="input-group-addon">Search</span>
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
                                    <option>Tooling</option>
                                    <option>CNC</option>
                                    <option>LASER</option>
                                    <option>Other</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputRemark" class="col-sm-3 control-label">Remark :</label>
                            <div class="col-sm-9">
                                <textarea id="inputRemark" rows="2" class="form-control input-group-sm"><jsp:text/></textarea>
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
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" id="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {

        $("#inputNeedDate").datepicker({ dateFormat: "dd/mm/yy" });

        addCustomer();
        addDataSaleOut();

        $("#faForm").submit(function() {
            var formData = new FormData();
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
            formData.append("drawingOther", $("#inputFile2")[0].files[0]);
            console.log(formData);
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
            },
            error: function(data){
                alert("Error");
                return false;
            }
        });
    }

</script>