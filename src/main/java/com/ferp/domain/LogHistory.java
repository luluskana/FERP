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
    private String actionTYpe;

    @Column(name = "status")
    private String status;

    @Column(name = "remark")
    private String remark;

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
    @JoinColumn(name = "sapCode")
    private SapCode sapCode;

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
        return actionTYpe;
    }

    public void setActionTYpe(String actionTYpe) {
        this.actionTYpe = actionTYpe;
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

    public SapCode getSapCode() {
        return sapCode;
    }

    public void setSapCode(SapCode sapCode) {
        this.sapCode = sapCode;
    }
}
