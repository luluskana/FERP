package com.ferp.service;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.dao.MaterialTypeDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.Material;
import com.ferp.domain.MaterialType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by apichat on 11/2/2016 AD.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MtmsServiceTests {

    @Autowired
    private MtmsService mtmsService;

    @Autowired
    private MaterialTypeDao materialTypeDao;

    @Test
    public void createMaterialTypeTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","Foam");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);
        assertNotNull(materialType);
        assertEquals("Foam", materialType.getTypeName());
    }

    @Test
    public void updateMaterialTypeTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","Foam01");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id", ""+ materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("typeName","Film");
        MaterialType materialTypeTest = mtmsService.updateMaterialType(multipartHttpServletRequestWrapper2);
        assertNotNull(materialTypeTest);
        assertEquals("Film", materialTypeTest.getTypeName());
    }

    @Test
    public void deleteMaterialTypeTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","Foam02");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());

        mtmsService.deleteMaterialType(multipartHttpServletRequestWrapper2);

        MaterialType materialTypeTest = materialTypeDao.findById(materialType.getId());
        assertNull(materialTypeTest);
    }

    @Test
    public void createMaterialTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","createMaterialTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("inputMaterialName","Z470");
        multipartHttpServletRequestWrapper2.setParameter("inputManufacturing","Thailand");
        multipartHttpServletRequestWrapper2.setParameter("inputUlNumber","Z1121");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputSpec","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputRoHs","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setParameter("inputDateRoHs","01/11/2016");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputMSDS","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputHalogen","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setParameter("inputDateHF","01/11/2016");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputGuarantee","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputRedPhosphorus","/Users/apichat/Workspace/temp/01Test.pdf");

        Material material = mtmsService.createMaterial(multipartHttpServletRequestWrapper2);
        assertNotNull(material);
    }
}
