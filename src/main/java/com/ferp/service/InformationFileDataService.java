package com.ferp.service;

import com.ferp.dao.InformationFileDataDao;
import com.ferp.domain.InformationFileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by apichat on 11/24/2016 AD.
 */
@Service
public class InformationFileDataService {

    @Autowired
    private InformationFileDataDao informationFileDataDao;

    public InformationFileData createFile(String fileName, String contentType) {
        InformationFileData informationFileData = new InformationFileData();
        informationFileData.setFileName(fileName);
        informationFileData.setContentType(contentType);
        informationFileDataDao.create(informationFileData);
        informationFileData.setUrl("/" + informationFileData.getId() + "/" + fileName);
        informationFileDataDao.update(informationFileData);
        return informationFileData;
    }
}
