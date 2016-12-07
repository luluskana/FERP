package com.ferp.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by apichat on 11/24/2016 AD.
 */
@Entity
@Table(name="InformationFileData")
public class InformationFileData implements Serializable {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name="fileName")
    private String fileName;

    @Column(name="contentType")
    private String contentType;

    @Column(name="url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
