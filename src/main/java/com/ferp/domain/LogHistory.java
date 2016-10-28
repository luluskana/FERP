package com.ferp.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by apichat on 10/26/2016 AD.
 */
@Entity
@Table(name="Log_History")
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
}
