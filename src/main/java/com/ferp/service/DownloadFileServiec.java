package com.ferp.service;

import com.ferp.dao.InformationFileDataDao;
import com.ferp.domain.FileData;
import com.ferp.domain.InformationFileData;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by apichat on 11/4/2016 AD.
 */
@Service
public class DownloadFileServiec {

    @Autowired
    private InformationFileDataDao informationFileDataDao;

    public FileData getFileName(Long id) throws IOException {
        InformationFileData informationFileData = informationFileDataDao.findById(id);
        String name = informationFileData.getFileName();
        String contentType = informationFileData.getContentType();
        String workingDir = System.getProperty("user.dir") + "/fileData";
        File file = new File(workingDir + informationFileData.getUrl());
        FileInputStream fis = new FileInputStream(file);
        byte[] data = IOUtils.toByteArray(fis);
        FileData fileData = new FileData();
        fileData.setFileName(name);
        fileData.setContentType(contentType);
        fileData.setDataFile(data);
        return fileData;
    }
}
