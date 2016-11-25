package com.ferp.service;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.dao.FaRequestDao;
import com.ferp.domain.FaRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by apichat on 11/17/2016 AD.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FamsServiceTests {

    @Autowired
    private FamsService famsService;

    @Autowired
    private FaRequestDao faRequestDao;

    @Test
    public void createFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","A12345");
        multipartHttpServletRequestWrapper.setParameter("partName","test1");
        multipartHttpServletRequestWrapper.setParameter("revision","02");
        multipartHttpServletRequestWrapper.setParameter("saleOut","LLLLLL");
        multipartHttpServletRequestWrapper.setParameter("qwsNo","12");
        multipartHttpServletRequestWrapper.setParameter("apqaNo","asd");
        multipartHttpServletRequestWrapper.setParameter("needDate","11/11/2016");
        multipartHttpServletRequestWrapper.setParameter("faApproveQty","2");
        multipartHttpServletRequestWrapper.setParameter("faForSellQty","4");
        multipartHttpServletRequestWrapper.setParameter("sampleTestQty","0");
        multipartHttpServletRequestWrapper.setParameter("samplePccQty", "");
        multipartHttpServletRequestWrapper.setParameter("material1","ASDASD");
        multipartHttpServletRequestWrapper.setParameter("material2","Foam");
        multipartHttpServletRequestWrapper.setParameter("material3","Foam");
        multipartHttpServletRequestWrapper.setParameter("material4","Foam");
        multipartHttpServletRequestWrapper.setParameter("material5","Foam");
        multipartHttpServletRequestWrapper.setParameter("material6", "");
        multipartHttpServletRequestWrapper.setParameter("documentRequest","gh");
        multipartHttpServletRequestWrapper.setParameter("tools","Foam");
        multipartHttpServletRequestWrapper.setParameter("remark","Foam");
        multipartHttpServletRequestWrapper.setParameter("drawingFile","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper.setParameter("otherFile","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.createFa(multipartHttpServletRequestWrapper);

        FaRequest faRequest = faRequestDao.findByPartNumber("A12345");
        assertNotNull(faRequest);
        assertEquals("A12345", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());
    }

    @Test
    public void cancelFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","cancelFaRequestTest");
        multipartHttpServletRequestWrapper.setParameter("partName","test1");
        multipartHttpServletRequestWrapper.setParameter("revision","02");
        multipartHttpServletRequestWrapper.setParameter("saleOut","LLLLLL");
        multipartHttpServletRequestWrapper.setParameter("qwsNo","12");
        multipartHttpServletRequestWrapper.setParameter("apqaNo","asd");
        multipartHttpServletRequestWrapper.setParameter("needDate","11/11/2016");
        multipartHttpServletRequestWrapper.setParameter("faApproveQty","2");
        multipartHttpServletRequestWrapper.setParameter("faForSellQty","4");
        multipartHttpServletRequestWrapper.setParameter("sampleTestQty","0");
        multipartHttpServletRequestWrapper.setParameter("samplePccQty", "");
        multipartHttpServletRequestWrapper.setParameter("material1","ASDASD");
        multipartHttpServletRequestWrapper.setParameter("material2","Foam");
        multipartHttpServletRequestWrapper.setParameter("material3","Foam");
        multipartHttpServletRequestWrapper.setParameter("material4","Foam");
        multipartHttpServletRequestWrapper.setParameter("material5","Foam");
        multipartHttpServletRequestWrapper.setParameter("material6", "");
        multipartHttpServletRequestWrapper.setParameter("documentRequest","gh");
        multipartHttpServletRequestWrapper.setParameter("tools","Foam");
        multipartHttpServletRequestWrapper.setParameter("remark","Foam");
        multipartHttpServletRequestWrapper.setParameter("drawingFile","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper.setParameter("otherFile","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.createFa(multipartHttpServletRequestWrapper);

        FaRequest faRequest = faRequestDao.findByPartNumber("cancelFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("cancelFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("reason","no ok");

        famsService.saleCancelFa(multipartHttpServletRequestWrapper2);

        FaRequest faRequest2 = faRequestDao.findByPartNumber("cancelFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("cancelFaRequestTest", faRequest2.getPartNo());
        assertEquals("SALE_CANCEL_FA_REQUEST", faRequest2.getStatus());
        assertEquals("gh", faRequest2.getDocumentRequest());
    }

    @Test
    public void updateFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","updateFaRequestTest");
        multipartHttpServletRequestWrapper.setParameter("partName","test1");
        multipartHttpServletRequestWrapper.setParameter("revision","02");
        multipartHttpServletRequestWrapper.setParameter("saleOut","LLLLLL");
        multipartHttpServletRequestWrapper.setParameter("qwsNo","12");
        multipartHttpServletRequestWrapper.setParameter("apqaNo","asd");
        multipartHttpServletRequestWrapper.setParameter("needDate","11/11/2016");
        multipartHttpServletRequestWrapper.setParameter("faApproveQty","2");
        multipartHttpServletRequestWrapper.setParameter("faForSellQty","4");
        multipartHttpServletRequestWrapper.setParameter("sampleTestQty","0");
        multipartHttpServletRequestWrapper.setParameter("samplePccQty", "");
        multipartHttpServletRequestWrapper.setParameter("material1","ASDASD");
        multipartHttpServletRequestWrapper.setParameter("material2","Foam");
        multipartHttpServletRequestWrapper.setParameter("material3","Foam");
        multipartHttpServletRequestWrapper.setParameter("material4","Foam");
        multipartHttpServletRequestWrapper.setParameter("material5","Foam");
        multipartHttpServletRequestWrapper.setParameter("material6", "");
        multipartHttpServletRequestWrapper.setParameter("documentRequest","gh");
        multipartHttpServletRequestWrapper.setParameter("tools","Foam");
        multipartHttpServletRequestWrapper.setParameter("remark","Foam");
        multipartHttpServletRequestWrapper.setParameter("drawingFile","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper.setParameter("otherFile","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.createFa(multipartHttpServletRequestWrapper);

        FaRequest faRequest = faRequestDao.findByPartNumber("updateFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("updateFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper2.setParameter("partNo","updateFaRequestTest02");
        multipartHttpServletRequestWrapper2.setParameter("partName","test1");
        multipartHttpServletRequestWrapper2.setParameter("revision","02");
        multipartHttpServletRequestWrapper2.setParameter("saleOut","LLLLLL");
        multipartHttpServletRequestWrapper2.setParameter("qwsNo","12");
        multipartHttpServletRequestWrapper2.setParameter("apqaNo","asd");
        multipartHttpServletRequestWrapper2.setParameter("needDate","11/11/2016");
        multipartHttpServletRequestWrapper2.setParameter("faApproveQty","2");
        multipartHttpServletRequestWrapper2.setParameter("faForSellQty","4");
        multipartHttpServletRequestWrapper2.setParameter("sampleTestQty","0");
        multipartHttpServletRequestWrapper2.setParameter("samplePccQty", "");
        multipartHttpServletRequestWrapper2.setParameter("material1","ASDASD");
        multipartHttpServletRequestWrapper2.setParameter("material2","Foam");
        multipartHttpServletRequestWrapper2.setParameter("material3","FILM");
        multipartHttpServletRequestWrapper2.setParameter("material4","Foam");
        multipartHttpServletRequestWrapper2.setParameter("material5","Foam");
        multipartHttpServletRequestWrapper2.setParameter("material6", "");
        multipartHttpServletRequestWrapper2.setParameter("documentRequest","gh");
        multipartHttpServletRequestWrapper2.setParameter("tools","Foam");
        multipartHttpServletRequestWrapper2.setParameter("remark","Foam");
        multipartHttpServletRequestWrapper2.setParameter("drawingFile","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setParameter("otherFile","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.updateFa(multipartHttpServletRequestWrapper2);

        FaRequest faRequest2 = faRequestDao.findByPartNumber("updateFaRequestTest02");
        assertNotNull(faRequest2);
        assertEquals("FILM", faRequest2.getMaterial3());
        assertEquals("UPDATE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("gh", faRequest2.getDocumentRequest());
    }

    @Test
    public void engineerApproveFaRequestTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","engineerApproveFaRequestTest");
        multipartHttpServletRequestWrapper.setParameter("partName","test1");
        multipartHttpServletRequestWrapper.setParameter("revision","02");
        multipartHttpServletRequestWrapper.setParameter("saleOut","LLLLLL");
        multipartHttpServletRequestWrapper.setParameter("qwsNo","12");
        multipartHttpServletRequestWrapper.setParameter("apqaNo","asd");
        multipartHttpServletRequestWrapper.setParameter("needDate","11/11/2016");
        multipartHttpServletRequestWrapper.setParameter("faApproveQty","2");
        multipartHttpServletRequestWrapper.setParameter("faForSellQty","4");
        multipartHttpServletRequestWrapper.setParameter("sampleTestQty","0");
        multipartHttpServletRequestWrapper.setParameter("samplePccQty", "");
        multipartHttpServletRequestWrapper.setParameter("material1","ASDASD");
        multipartHttpServletRequestWrapper.setParameter("material2","Foam");
        multipartHttpServletRequestWrapper.setParameter("material3","Foam");
        multipartHttpServletRequestWrapper.setParameter("material4","Foam");
        multipartHttpServletRequestWrapper.setParameter("material5","Foam");
        multipartHttpServletRequestWrapper.setParameter("material6", "");
        multipartHttpServletRequestWrapper.setParameter("documentRequest","gh");
        multipartHttpServletRequestWrapper.setParameter("tools","Foam");
        multipartHttpServletRequestWrapper.setParameter("remark","Foam");
        multipartHttpServletRequestWrapper.setParameter("drawingFile","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper.setParameter("otherFile","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.createFa(multipartHttpServletRequestWrapper);

        FaRequest faRequest = faRequestDao.findByPartNumber("engineerApproveFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("engineerApproveFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("engineerApproveFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("engineerApproveFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());
    }

    @Test
    public void engineerWaitingFaRequestTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","engineerWaitingFaRequestTest");
        multipartHttpServletRequestWrapper.setParameter("partName","test1");
        multipartHttpServletRequestWrapper.setParameter("revision","02");
        multipartHttpServletRequestWrapper.setParameter("saleOut","LLLLLL");
        multipartHttpServletRequestWrapper.setParameter("qwsNo","12");
        multipartHttpServletRequestWrapper.setParameter("apqaNo","asd");
        multipartHttpServletRequestWrapper.setParameter("needDate","11/11/2016");
        multipartHttpServletRequestWrapper.setParameter("faApproveQty","2");
        multipartHttpServletRequestWrapper.setParameter("faForSellQty","4");
        multipartHttpServletRequestWrapper.setParameter("sampleTestQty","0");
        multipartHttpServletRequestWrapper.setParameter("samplePccQty", "");
        multipartHttpServletRequestWrapper.setParameter("material1","ASDASD");
        multipartHttpServletRequestWrapper.setParameter("material2","Foam");
        multipartHttpServletRequestWrapper.setParameter("material3","Foam");
        multipartHttpServletRequestWrapper.setParameter("material4","Foam");
        multipartHttpServletRequestWrapper.setParameter("material5","Foam");
        multipartHttpServletRequestWrapper.setParameter("material6", "");
        multipartHttpServletRequestWrapper.setParameter("documentRequest","gh");
        multipartHttpServletRequestWrapper.setParameter("tools","Foam");
        multipartHttpServletRequestWrapper.setParameter("remark","Foam");
        multipartHttpServletRequestWrapper.setParameter("drawingFile","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper.setParameter("otherFile","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.createFa(multipartHttpServletRequestWrapper);

        FaRequest faRequest = faRequestDao.findByPartNumber("engineerWaitingFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("engineerWaitingFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("reason","haha");

        famsService.engineerWaitingFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("engineerWaitingFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("engineerWaitingFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_WAITING_FA_REQUEST", faRequest2.getStatus());
        assertEquals("gh", faRequest2.getDocumentRequest());
    }

    @Test
    public void engineerRejectFaRequestTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","engineerRejectFaRequestTest");
        multipartHttpServletRequestWrapper.setParameter("partName","test1");
        multipartHttpServletRequestWrapper.setParameter("revision","02");
        multipartHttpServletRequestWrapper.setParameter("saleOut","LLLLLL");
        multipartHttpServletRequestWrapper.setParameter("qwsNo","12");
        multipartHttpServletRequestWrapper.setParameter("apqaNo","asd");
        multipartHttpServletRequestWrapper.setParameter("needDate","11/11/2016");
        multipartHttpServletRequestWrapper.setParameter("faApproveQty","2");
        multipartHttpServletRequestWrapper.setParameter("faForSellQty","4");
        multipartHttpServletRequestWrapper.setParameter("sampleTestQty","0");
        multipartHttpServletRequestWrapper.setParameter("samplePccQty", "");
        multipartHttpServletRequestWrapper.setParameter("material1","ASDASD");
        multipartHttpServletRequestWrapper.setParameter("material2","Foam");
        multipartHttpServletRequestWrapper.setParameter("material3","Foam");
        multipartHttpServletRequestWrapper.setParameter("material4","Foam");
        multipartHttpServletRequestWrapper.setParameter("material5","Foam");
        multipartHttpServletRequestWrapper.setParameter("material6", "");
        multipartHttpServletRequestWrapper.setParameter("documentRequest","gh");
        multipartHttpServletRequestWrapper.setParameter("tools","Foam");
        multipartHttpServletRequestWrapper.setParameter("remark","Foam");
        multipartHttpServletRequestWrapper.setParameter("drawingFile","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper.setParameter("otherFile","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.createFa(multipartHttpServletRequestWrapper);

        FaRequest faRequest = faRequestDao.findByPartNumber("engineerRejectFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("engineerRejectFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("reason","haha");

        famsService.engineerRejectFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("engineerRejectFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("engineerRejectFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_REJECT_FA_REQUEST", faRequest2.getStatus());
        assertEquals("gh", faRequest2.getDocumentRequest());
    }

    @Test
    public void engineerSendFirstShotFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","engineerSendFirstShotFaRequestTest");
        multipartHttpServletRequestWrapper.setParameter("partName","test1");
        multipartHttpServletRequestWrapper.setParameter("revision","02");
        multipartHttpServletRequestWrapper.setParameter("saleOut","LLLLLL");
        multipartHttpServletRequestWrapper.setParameter("qwsNo","12");
        multipartHttpServletRequestWrapper.setParameter("apqaNo","asd");
        multipartHttpServletRequestWrapper.setParameter("needDate","11/11/2016");
        multipartHttpServletRequestWrapper.setParameter("faApproveQty","2");
        multipartHttpServletRequestWrapper.setParameter("faForSellQty","4");
        multipartHttpServletRequestWrapper.setParameter("sampleTestQty","0");
        multipartHttpServletRequestWrapper.setParameter("samplePccQty", "");
        multipartHttpServletRequestWrapper.setParameter("material1","ASDASD");
        multipartHttpServletRequestWrapper.setParameter("material2","Foam");
        multipartHttpServletRequestWrapper.setParameter("material3","Foam");
        multipartHttpServletRequestWrapper.setParameter("material4","Foam");
        multipartHttpServletRequestWrapper.setParameter("material5","Foam");
        multipartHttpServletRequestWrapper.setParameter("material6", "");
        multipartHttpServletRequestWrapper.setParameter("documentRequest","gh");
        multipartHttpServletRequestWrapper.setParameter("tools","Foam");
        multipartHttpServletRequestWrapper.setParameter("remark","Foam");
        multipartHttpServletRequestWrapper.setParameter("drawingFile","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper.setParameter("otherFile","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.createFa(multipartHttpServletRequestWrapper);

        FaRequest faRequest = faRequestDao.findByPartNumber("engineerSendFirstShotFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("engineerSendFirstShotFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("engineerSendFirstShotFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("engineerSendFirstShotFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("engineerSendFirstShotFaRequestTest");

        assertNotNull(faRequest3);
        assertEquals("engineerSendFirstShotFaRequestTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_SEND_FIRST_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());
    }
}
