package com.ferp.domain;

import java.io.Serializable;

/**
 * Created by apichat on 11/4/2016 AD.
 */
public class FileData implements Serializable {

    private String fileName;

    private String contentType;

    private byte[] dataFile;

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

    public byte[] getDataFile() {
        return dataFile;
    }

    public void setDataFile(byte[] dataFile) {
        this.dataFile = dataFile;
    }
}
