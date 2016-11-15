package com.ferp.service;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.dao.MaterialDao;
import com.ferp.dao.MaterialTypeDao;
import com.ferp.dao.SapCodeDao;
import com.ferp.domain.Material;
import com.ferp.domain.MaterialType;
import com.ferp.domain.SapCode;
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

    @Autowired
    private MaterialDao materialDao;

    @Autowired
    private SapCodeDao sapCodeDao;

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
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapperFull = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapperFull.setParameter("typeName","createMaterialTestFull");
        MaterialType materialTypeFull = mtmsService.createMaterialType(multipartHttpServletRequestWrapperFull);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapperFull2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapperFull2.setParameter("id","" + materialTypeFull.getId());
        multipartHttpServletRequestWrapperFull2.setParameter("inputMaterialName","createMaterialTestFull");
        multipartHttpServletRequestWrapperFull2.setParameter("inputManufacturing","Thailand");
        multipartHttpServletRequestWrapperFull2.setParameter("inputUlNumber","Z1121");
        multipartHttpServletRequestWrapperFull2.setMultipartFile("inputSpec","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperFull2.setMultipartFile("inputRoHs","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperFull2.setParameter("inputDateRoHs","01/11/2016");
        multipartHttpServletRequestWrapperFull2.setMultipartFile("inputMSDS","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperFull2.setMultipartFile("inputHalogen","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperFull2.setParameter("inputDateHF","01/11/2016");
        multipartHttpServletRequestWrapperFull2.setMultipartFile("inputGuarantee","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperFull2.setMultipartFile("inputRedPhosphorus","/Users/apichat/Workspace/temp/01Test.pdf");

        Material materialFull = mtmsService.createMaterial(multipartHttpServletRequestWrapperFull2);
        assertNotNull(materialFull);
        assertEquals("createMaterialTestFull", materialFull.getMaterialName());
        assertEquals("Thailand", materialFull.getManufacturing());
        assertEquals("Z1121", materialFull.getUlNumber());
        assertEquals("CREATE_MATERIAL_DOCUMENT_FULL", materialFull.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapperNotFull = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapperNotFull.setParameter("typeName","createMaterialTestNotFull11111");
        MaterialType materialTypeNotFull = mtmsService.createMaterialType(multipartHttpServletRequestWrapperNotFull);
        assertNotNull(materialTypeNotFull);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapperNotFull2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapperNotFull2.setParameter("id","" + materialTypeNotFull.getId());
        multipartHttpServletRequestWrapperNotFull2.setParameter("inputMaterialName","createMaterialTestNotFull11111");
        multipartHttpServletRequestWrapperNotFull2.setParameter("inputManufacturing","Thailand");
        multipartHttpServletRequestWrapperNotFull2.setParameter("inputUlNumber","Z1121");
        multipartHttpServletRequestWrapperNotFull2.setMultipartFile("inputSpec",null);
        multipartHttpServletRequestWrapperNotFull2.setMultipartFile("inputRoHs","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperNotFull2.setParameter("inputDateRoHs","01/11/2016");
        multipartHttpServletRequestWrapperNotFull2.setMultipartFile("inputMSDS","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperNotFull2.setMultipartFile("inputHalogen","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperNotFull2.setParameter("inputDateHF","01/11/2016");
        multipartHttpServletRequestWrapperNotFull2.setMultipartFile("inputGuarantee","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapperNotFull2.setMultipartFile("inputRedPhosphorus","/Users/apichat/Workspace/temp/01Test.pdf");

        Material materialNotFull = mtmsService.createMaterial(multipartHttpServletRequestWrapperNotFull2);
        assertNotNull(materialNotFull);
        assertEquals("createMaterialTestNotFull11111", materialNotFull.getMaterialName());
        assertEquals("Thailand", materialNotFull.getManufacturing());
        assertEquals("Z1121", materialNotFull.getUlNumber());
        assertEquals("CREATE_MATERIAL_DOCUMENT_NOT_FULL", materialNotFull.getStatus());
    }

    @Test
    public void updateMaterialTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","updateMaterialTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("inputMaterialName","updateMaterialTest");
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

        mtmsService.createMaterial(multipartHttpServletRequestWrapper2);

        Material material1 = materialDao.findByMaterialName("updateMaterialTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + material1.getId());
        multipartHttpServletRequestWrapper3.setParameter("inputMaterialName","updateMaterialTest001");
        multipartHttpServletRequestWrapper3.setParameter("inputManufacturing","Thailand");
        multipartHttpServletRequestWrapper3.setParameter("inputUlNumber","Z1121");
        multipartHttpServletRequestWrapper3.setMultipartFile("inputSpec","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper3.setMultipartFile("inputRoHs","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper3.setParameter("inputDateRoHs","01/11/2016");
        multipartHttpServletRequestWrapper3.setMultipartFile("inputMSDS","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper3.setMultipartFile("inputHalogen","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper3.setParameter("inputDateHF","01/11/2016");
        multipartHttpServletRequestWrapper3.setMultipartFile("inputGuarantee","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputRedPhosphorus","/Users/apichat/Workspace/temp/01Test.pdf");

        Material material2 = mtmsService.updateMaterial(multipartHttpServletRequestWrapper3);
        assertNotNull(material2);
        assertEquals("updateMaterialTest001", material2.getMaterialName());
        assertEquals("UPDATE_MATERIAL_DOCUMENT_FULL", material2.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapperNotFull = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapperNotFull.setParameter("typeName","updateMaterialTestNotFull");
        MaterialType materialTypeNotFull = mtmsService.createMaterialType(multipartHttpServletRequestWrapperNotFull);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2NotFull = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2NotFull.setParameter("id","" + materialTypeNotFull.getId());
        multipartHttpServletRequestWrapper2NotFull.setParameter("inputMaterialName","updateMaterialTestNotFull");
        multipartHttpServletRequestWrapper2NotFull.setParameter("inputManufacturing","Thailand");
        multipartHttpServletRequestWrapper2NotFull.setParameter("inputUlNumber","Z1121");
        multipartHttpServletRequestWrapper2NotFull.setMultipartFile("inputSpec","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2NotFull.setMultipartFile("inputRoHs","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2NotFull.setParameter("inputDateRoHs", "01/11/2016");
        multipartHttpServletRequestWrapper2NotFull.setMultipartFile("inputMSDS","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2NotFull.setMultipartFile("inputHalogen","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2NotFull.setParameter("inputDateHF","01/11/2016");
        multipartHttpServletRequestWrapper2NotFull.setMultipartFile("inputGuarantee","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2NotFull.setMultipartFile("inputRedPhosphorus","/Users/apichat/Workspace/temp/01Test.pdf");

        mtmsService.createMaterial(multipartHttpServletRequestWrapper2NotFull);

        Material material1NotFull = materialDao.findByMaterialName("updateMaterialTestNotFull");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3NotFull = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3NotFull.setParameter("id","" + material1NotFull.getId());
        multipartHttpServletRequestWrapper3NotFull.setParameter("inputMaterialName","updateMaterialTest001NotFull");
        multipartHttpServletRequestWrapper3NotFull.setParameter("inputManufacturing","Thailand");
        multipartHttpServletRequestWrapper3NotFull.setParameter("inputUlNumber","Z1121");
        multipartHttpServletRequestWrapper3NotFull.setMultipartFile("inputSpec","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper3NotFull.setMultipartFile("inputRoHs",null);
        multipartHttpServletRequestWrapper3NotFull.setParameter("inputDateRoHs","01/11/2016");
        multipartHttpServletRequestWrapper3NotFull.setMultipartFile("inputMSDS","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper3NotFull.setMultipartFile("inputHalogen","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper3NotFull.setParameter("inputDateHF","01/11/2016");
        multipartHttpServletRequestWrapper3NotFull.setMultipartFile("inputGuarantee","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper2NotFull.setMultipartFile("inputRedPhosphorus","/Users/apichat/Workspace/temp/01Test.pdf");

        Material material2NotFull = mtmsService.updateMaterial(multipartHttpServletRequestWrapper3NotFull);
        assertNotNull(material2NotFull);
        assertEquals("updateMaterialTest001NotFull", material2NotFull.getMaterialName());
        assertEquals("UPDATE_MATERIAL_DOCUMENT_NOT_FULL", material2NotFull.getStatus());
    }

    @Test
    public void deleteMaterialTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","deleteMaterialTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("inputMaterialName","deleteMaterialTest");
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

        Material materialFull = mtmsService.createMaterial(multipartHttpServletRequestWrapper2);
        assertNotNull(materialFull);
        assertEquals("deleteMaterialTest", materialFull.getMaterialName());
        assertEquals("Thailand", materialFull.getManufacturing());
        assertEquals("Z1121", materialFull.getUlNumber());
        assertEquals("CREATE_MATERIAL_DOCUMENT_FULL", materialFull.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id", "" + materialDao.findByMaterialName("deleteMaterialTest").getId());
        mtmsService.deleteMaterial(multipartHttpServletRequestWrapper3);

        Material material = materialDao.findByMaterialName("deleteMaterialTest");
        assertNull(material);
    }

    @Test
    public void approveMaterialTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","approveMaterialTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("inputMaterialName","approveMaterialTest");
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

        Material materialFull = mtmsService.createMaterial(multipartHttpServletRequestWrapper2);
        assertNotNull(materialFull);
        assertEquals("approveMaterialTest", materialFull.getMaterialName());
        assertEquals("Thailand", materialFull.getManufacturing());
        assertEquals("Z1121", materialFull.getUlNumber());
        assertEquals("CREATE_MATERIAL_DOCUMENT_FULL", materialFull.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id", "" + materialDao.findByMaterialName("approveMaterialTest").getId());
        mtmsService.approveMaterial(multipartHttpServletRequestWrapper3);

        Material material = materialDao.findByMaterialName("approveMaterialTest");
        assertNotNull(material);
        assertEquals("APPROVE_MATERIAL", material.getStatus());
    }

    @Test
    public void rejectMaterialTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","rejectMaterialTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("inputMaterialName","rejectMaterialTest");
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

        Material materialFull = mtmsService.createMaterial(multipartHttpServletRequestWrapper2);
        assertNotNull(materialFull);
        assertEquals("rejectMaterialTest", materialFull.getMaterialName());
        assertEquals("Thailand", materialFull.getManufacturing());
        assertEquals("Z1121", materialFull.getUlNumber());
        assertEquals("CREATE_MATERIAL_DOCUMENT_FULL", materialFull.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id", "" + materialDao.findByMaterialName("rejectMaterialTest").getId());
        multipartHttpServletRequestWrapper3.setParameter("remark", "reject test");
        mtmsService.rejectMaterial(multipartHttpServletRequestWrapper3);

        Material material = materialDao.findByMaterialName("rejectMaterialTest");
        assertNotNull(material);
        assertEquals("REJECT_MATERIAL", material.getStatus());
    }

    @Test
    public void createSapCodeTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","createSapCodeTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("inputMaterialName","createSapCodeTest");
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

        Material materialFull = mtmsService.createMaterial(multipartHttpServletRequestWrapper2);
        assertNotNull(materialFull);
        assertEquals("createSapCodeTest", materialFull.getMaterialName());
        assertEquals("Thailand", materialFull.getManufacturing());
        assertEquals("Z1121", materialFull.getUlNumber());
        assertEquals("CREATE_MATERIAL_DOCUMENT_FULL", materialFull.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id", "" + materialDao.findByMaterialName("createSapCodeTest").getId());
        multipartHttpServletRequestWrapper3.setParameter("name", "123456qwasdf");
        mtmsService.createSapCode(multipartHttpServletRequestWrapper3);

        Material material = materialDao.findByMaterialName("createSapCodeTest");
        assertNotNull(material);
        assertEquals("CREATE_MATERIAL_DOCUMENT_FULL", material.getStatus());
        assertNotNull(material.getSapCodes());

    }

    @Test
    public void deleteSapCodeTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","deleteSapCodeTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("inputMaterialName","deleteSapCodeTest");
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

        Material materialFull = mtmsService.createMaterial(multipartHttpServletRequestWrapper2);
        assertNotNull(materialFull);
        assertEquals("deleteSapCodeTest", materialFull.getMaterialName());
        assertEquals("Thailand", materialFull.getManufacturing());
        assertEquals("Z1121", materialFull.getUlNumber());
        assertEquals("CREATE_MATERIAL_DOCUMENT_FULL", materialFull.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id", "" + materialDao.findByMaterialName("deleteSapCodeTest").getId());
        multipartHttpServletRequestWrapper3.setParameter("name", "deleteSapCodeTest");
        mtmsService.createSapCode(multipartHttpServletRequestWrapper3);

        Material material = materialDao.findByMaterialName("deleteSapCodeTest");
        assertNotNull(material);
        assertEquals("CREATE_MATERIAL_DOCUMENT_FULL", material.getStatus());
        assertNotNull(material.getSapCodes());

        SapCode sapCode = sapCodeDao.findByName("deleteSapCodeTest");
        assertNotNull(sapCode);

        sapCodeDao.delete(sapCode.getId());

        SapCode sapCode2 = sapCodeDao.findByName("deleteSapCodeTest");
        assertNull(sapCode2);

    }
}
