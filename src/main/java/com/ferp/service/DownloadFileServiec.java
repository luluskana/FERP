package com.ferp.service;

import com.ferp.domain.FileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by apichat on 11/4/2016 AD.
 */
@Service
public class DownloadFileServiec {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FileData getFileName(Long id) {
        String sqlSelect = "SELECT * FROM ITEM_FILE WHERE ID = ?";
        List<Map<String, Object>> lists =  jdbcTemplate.queryForList(sqlSelect, id);
        if(lists.size() != 0) {
            String name = (String) lists.get(0).get("fileName");
            String contentType = (String) lists.get(0).get("contentType");
            byte[] data = (byte[]) lists.get(0).get("dataFile");
            FileData fileData = new FileData();
            fileData.setFileName(name);
            fileData.setContentType(contentType);
            fileData.setDataFile(data);
            return fileData;
        } else {
            return null;
        }
    }
}
