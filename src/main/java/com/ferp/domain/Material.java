package com.ferp.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by apichat on 11/1/2016 AD.
 */
@Entity
@Table(name="MATERIAL")
public class Material implements Serializable {

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

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="updateDate")
    private Date updateDate;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser updateBy;

    @Column(name="materialName", unique = true)
    private String materialName;

    @Column(name="manufacturing")
    private String manufacturing;

    @Column(name = "ulNumber")
    private String ulNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "reason")
    private String reason;

    @Column(name = "spec")
    private Long spec;

    @Column(name = "rosh")
    private Long rosh;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "rohsDateTest")
    private Date rohsDateTest;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "rohsAlertDateTest")
    private Date rohsAlertDateTest;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "rohsEndDateTest")
    private Date rohsEndDateTest;

    @Column(name = "msds")
    private Long msds;

    @Column(name = "halogen")
    private Long halogen;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "halogenDateTest")
    private Date halogenDateTest;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "halogenAlertDateTest")
    private Date halogenAlertDateTest;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "halogenEndDateTest")
    private Date halogenEndDateTest;

    @Column(name = "guaranteeLetter")
    private Long guaranteeLetter;

    @Column(name = "redPhosphorus")
    private Long redPhosphorus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materialType")
    private MaterialType materialType;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "material", orphanRemoval = true)
    private Set<SapCode> sapCodes = new HashSet<SapCode>();

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "material", orphanRemoval = true)
    private Set<LogHistory> logHistories = new HashSet<LogHistory>();

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

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }

    public String getUlNumber() {
        return ulNumber;
    }

    public void setUlNumber(String ulNumber) {
        this.ulNumber = ulNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Date getRohsDateTest() {
        return rohsDateTest;
    }

    public void setRohsDateTest(Date rohsDateTest) {
        this.rohsDateTest = rohsDateTest;
    }

    public Date getRohsAlertDateTest() {
        return rohsAlertDateTest;
    }

    public void setRohsAlertDateTest(Date rohsAlertDateTest) {
        this.rohsAlertDateTest = rohsAlertDateTest;
    }

    public Date getRohsEndDateTest() {
        return rohsEndDateTest;
    }

    public void setRohsEndDateTest(Date rohsEndDateTest) {
        this.rohsEndDateTest = rohsEndDateTest;
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

    public Date getHalogenDateTest() {
        return halogenDateTest;
    }

    public void setHalogenDateTest(Date halogenDateTest) {
        this.halogenDateTest = halogenDateTest;
    }

    public Date getHalogenAlertDateTest() {
        return halogenAlertDateTest;
    }

    public void setHalogenAlertDateTest(Date halogenAlertDateTest) {
        this.halogenAlertDateTest = halogenAlertDateTest;
    }

    public Date getHalogenEndDateTest() {
        return halogenEndDateTest;
    }

    public void setHalogenEndDateTest(Date halogenEndDateTest) {
        this.halogenEndDateTest = halogenEndDateTest;
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

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public Set<SapCode> getSapCodes() {
        return sapCodes;
    }

    public void setSapCodes(Set<SapCode> sapCodes) {
        this.sapCodes = sapCodes;
    }

    public Set<LogHistory> getLogHistories() {
        return logHistories;
    }

    public void setLogHistories(Set<LogHistory> logHistories) {
        this.logHistories = logHistories;
    }
}
