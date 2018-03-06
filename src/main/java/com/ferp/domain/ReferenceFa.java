package com.ferp.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="REFERENCE_FA")
public class ReferenceFa implements Serializable {

    @Id
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="createDate")
    private Date createDate;

    @OneToOne(fetch = FetchType.EAGER)
    private FaRequest faRequestRefer;

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

    public FaRequest getFaRequestRefer() {
        return faRequestRefer;
    }

    public void setFaRequestRefer(FaRequest faRequestRefer) {
        this.faRequestRefer = faRequestRefer;
    }

    public FaRequest getFaRequest() {
        return faRequest;
    }

    public void setFaRequest(FaRequest faRequest) {
        this.faRequest = faRequest;
    }
}