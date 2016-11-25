package com.ferp.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by apichat on 10/26/2016 AD.
 */
@Entity
@Table(name="LOG_HISTORY")
public class LogHistory implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="createDate")
    private Date createDate;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser createBy;

    @Column(name = "actionTYpe")
    private String actionType;

    @Column(name = "status")
    private String status;

    @Column(name = "remark")
    private String remark;

    @Column(name = "spec")
    private Long spec;

    @Column(name = "rosh")
    private Long rosh;

    @Column(name = "msds")
    private Long msds;

    @Column(name = "halogen")
    private Long halogen;

    @Column(name = "guaranteeLetter")
    private Long guaranteeLetter;

    @Column(name = "redPhosphorus")
    private Long redPhosphorus;

    @Column(name = "drawingFile")
    private Long drawingFile;

    @Column(name = "otherFile")
    private Long otherFile;

    @Column(name="methodFirst")
    private String methodFirst;

    @Column(name="slipMatNo")
    private String slipMatNo;

    @Column(name="qtyFirst")
    private Integer qtyFirst;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appUser")
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materialType")
    private MaterialType materialType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material")
    private Material material;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faRequest")
    private FaRequest faRequest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getActionTYpe() {
        return actionType;
    }

    public void setActionTYpe(String actionType) {
        this.actionType = actionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSpec() {
        return spec;
    }

    public void setSpec(Long spec) {
        this.spec = spec;
    }

    public Long getRosh() {
        return rosh;
    }

    public void setRosh(Long rosh) {
        this.rosh = rosh;
    }

    public Long getMsds() {
        return msds;
    }

    public void setMsds(Long msds) {
        this.msds = msds;
    }

    public Long getHalogen() {
        return halogen;
    }

    public void setHalogen(Long halogen) {
        this.halogen = halogen;
    }

    public Long getGuaranteeLetter() {
        return guaranteeLetter;
    }

    public void setGuaranteeLetter(Long guaranteeLetter) {
        this.guaranteeLetter = guaranteeLetter;
    }

    public Long getRedPhosphorus() {
        return redPhosphorus;
    }

    public void setRedPhosphorus(Long redPhosphorus) {
        this.redPhosphorus = redPhosphorus;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public FaRequest getFaRequest() {
        return faRequest;
    }

    public void setFaRequest(FaRequest faRequest) {
        this.faRequest = faRequest;
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

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getMethodFirst() {
        return methodFirst;
    }

    public void setMethodFirst(String methodFirst) {
        this.methodFirst = methodFirst;
    }

    public Integer getQtyFirst() {
        return qtyFirst;
    }

    public void setQtyFirst(Integer qtyFirst) {
        this.qtyFirst = qtyFirst;
    }

    public String getSlipMatNo() {
        return slipMatNo;
    }

    public void setSlipMatNo(String slipMatNo) {
        this.slipMatNo = slipMatNo;
    }
}
