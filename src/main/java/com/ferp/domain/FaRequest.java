package com.ferp.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apichat on 11/17/2016 AD.
 */
@Entity
@Table(name="FaRequest")
public class FaRequest implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="faNumber")
    private String faNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="createDate")
    private Date createDate;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="updateDate")
    private Date updateDate;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser updateBy;

    @Column(name="customer")
    private String customer;

    @Column(name="productGroup")
    private String productGroup;

    @Column(name="partNo")
    private String partNo;

    @Column(name="partName")
    private String partName;

    @Column(name="revision")
    private String revision;

    @Column(name="saleOut")
    private String saleOut;

    @Column(name="qwsNo")
    private String qwsNo;

    @Column(name="apqpNo")
    private String apqpNo;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="needDate")
    private Date needDate;

    @Value("0")
    @Column(name="faApproveQty")
    private Integer faApproveQty;

    @Value("0")
    @Column(name="faForSellQty")
    private Integer faForSellQty;

    @Value("0")
    @Column(name="samplTestQty")
    private Integer samplTestQty;

    @Value("0")
    @Column(name="samplePccQty")
    private Integer samplePccQty;

    @Column(name="material1")
    private String material1;

    @Column(name="material2")
    private String material2;

    @Column(name="material3")
    private String material3;

    @Column(name="material4")
    private String material4;

    @Column(name="material5")
    private String material5;

    @Column(name="material6")
    private String material6;

    @Column(name="documentRequest")
    private String documentRequest;

    @Column(name="tool")
    private String tool;

    @Column(name="remark")
    private String remark;

    @Column(name = "drawingFile")
    private Long drawingFile;

    @Column(name = "otherFile")
    private Long otherFile;

    @Column(name="status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="engineerCommitDate")
    private Date engineerCommitDate;

    @Column(name="process")
    private String process;

    @Column(name = "fileData1")
    private Long fileData1;

    @Column(name = "fileData2")
    private Long fileData2;

    @Column(name="contractName")
    private String contractName;

    @Column(name="invoice")
    private String invoice;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "faRequest")
    private Set<LogHistory> logHistories = new HashSet<LogHistory>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaNumber() {
        return faNumber;
    }

    public void setFaNumber(String faNumber) {
        this.faNumber = faNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AppUser getCreateBy() {
        return createBy;
    }

    public void setCreateBy(AppUser createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public AppUser getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(AppUser updateBy) {
        this.updateBy = updateBy;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getSaleOut() {
        return saleOut;
    }

    public void setSaleOut(String saleOut) {
        this.saleOut = saleOut;
    }

    public String getQwsNo() {
        return qwsNo;
    }

    public void setQwsNo(String qwsNo) {
        this.qwsNo = qwsNo;
    }

    public String getApqpNo() {
        return apqpNo;
    }

    public void setApqpNo(String apqpNo) {
        this.apqpNo = apqpNo;
    }

    public Date getNeedDate() {
        return needDate;
    }

    public void setNeedDate(Date needDate) {
        this.needDate = needDate;
    }

    public Integer getFaApproveQty() {
        return faApproveQty;
    }

    public void setFaApproveQty(Integer faApproveQty) {
        this.faApproveQty = faApproveQty;
    }

    public Integer getFaForSellQty() {
        return faForSellQty;
    }

    public void setFaForSellQty(Integer faForSellQty) {
        this.faForSellQty = faForSellQty;
    }

    public Integer getSamplTestQty() {
        return samplTestQty;
    }

    public void setSamplTestQty(Integer samplTestQty) {
        this.samplTestQty = samplTestQty;
    }

    public Integer getSamplePccQty() {
        return samplePccQty;
    }

    public void setSamplePccQty(Integer samplePccQty) {
        this.samplePccQty = samplePccQty;
    }

    public String getMaterial1() {
        return material1;
    }

    public void setMaterial1(String material1) {
        this.material1 = material1;
    }

    public String getMaterial2() {
        return material2;
    }

    public void setMaterial2(String material2) {
        this.material2 = material2;
    }

    public String getMaterial3() {
        return material3;
    }

    public void setMaterial3(String material3) {
        this.material3 = material3;
    }

    public String getMaterial4() {
        return material4;
    }

    public void setMaterial4(String material4) {
        this.material4 = material4;
    }

    public String getMaterial5() {
        return material5;
    }

    public void setMaterial5(String material5) {
        this.material5 = material5;
    }

    public String getMaterial6() {
        return material6;
    }

    public void setMaterial6(String material6) {
        this.material6 = material6;
    }

    public String getDocumentRequest() {
        return documentRequest;
    }

    public void setDocumentRequest(String documentRequest) {
        this.documentRequest = documentRequest;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<LogHistory> getLogHistories() {
        return logHistories;
    }

    public void setLogHistories(Set<LogHistory> logHistories) {
        this.logHistories = logHistories;
    }

    public Long getDrawingFile() {
        return drawingFile;
    }

    public void setDrawingFile(Long drawingFile) {
        this.drawingFile = drawingFile;
    }

    public Long getOtherFile() {
        return otherFile;
    }

    public void setOtherFile(Long otherFile) {
        this.otherFile = otherFile;
    }

    public Date getEngineerCommitDate() {
        return engineerCommitDate;
    }

    public void setEngineerCommitDate(Date engineerCommitDate) {
        this.engineerCommitDate = engineerCommitDate;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Long getFileData1() {
        return fileData1;
    }

    public void setFileData1(Long fileData1) {
        this.fileData1 = fileData1;
    }

    public Long getFileData2() {
        return fileData2;
    }

    public void setFileData2(Long fileData2) {
        this.fileData2 = fileData2;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }
}
