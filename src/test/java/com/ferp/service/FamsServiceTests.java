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

    @Test
    public void engineerCancelFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","engineerCancelFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("engineerCancelFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("engineerCancelFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("engineerCancelFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("engineerCancelFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("reason","nana");

        famsService.engineerCancelFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("engineerCancelFaRequestTest");

        assertNotNull(faRequest3);
        assertEquals("engineerCancelFaRequestTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_CANCEL_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());
    }

    @Test
    public void qaApproveFirstShotFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","qaApproveFirstShotFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("qaApproveFirstShotFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("qaApproveFirstShotFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("qaApproveFirstShotFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("qaApproveFirstShotFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("qaApproveFirstShotFaRequestTest");

        assertNotNull(faRequest3);
        assertEquals("qaApproveFirstShotFaRequestTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_SEND_FIRST_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("qaApproveFirstShotFaRequestTest");

        assertNotNull(faRequest4);
        assertEquals("qaApproveFirstShotFaRequestTest", faRequest4.getPartNo());
        assertEquals("QA_APPROVE_FIRST_FA_REQUEST", faRequest4.getStatus());
        assertEquals("test test", faRequest4.getProcess());
        assertEquals("gh", faRequest4.getDocumentRequest());
    }

    @Test
    public void qaRejectFirstShotFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","qaRejectFirstShotFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("qaRejectFirstShotFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("qaRejectFirstShotFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("qaRejectFirstShotFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("qaRejectFirstShotFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("qaRejectFirstShotFaRequestTest");

        assertNotNull(faRequest3);
        assertEquals("qaRejectFirstShotFaRequestTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_SEND_FIRST_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaRejectFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("qaRejectFirstShotFaRequestTest");

        assertNotNull(faRequest4);
        assertEquals("qaRejectFirstShotFaRequestTest", faRequest4.getPartNo());
        assertEquals("QA_REJECT_FIRST_FA_REQUEST", faRequest4.getStatus());
        assertEquals("test test", faRequest4.getProcess());
        assertEquals("gh", faRequest4.getDocumentRequest());
    }

    @Test
    public void engineerSendFinalFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","engineerSendFinalFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("engineerSendFinalFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("engineerSendFinalFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("engineerSendFinalFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("engineerSendFinalFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("engineerSendFinalFaRequestTest");

        assertNotNull(faRequest3);
        assertEquals("engineerSendFinalFaRequestTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_SEND_FIRST_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("engineerSendFinalFaRequestTest");

        assertNotNull(faRequest4);
        assertEquals("engineerSendFinalFaRequestTest", faRequest4.getPartNo());
        assertEquals("QA_APPROVE_FIRST_FA_REQUEST", faRequest4.getStatus());
        assertEquals("test test", faRequest4.getProcess());
        assertEquals("gh", faRequest4.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("engineerSendFinalFaRequestTest");

        assertNotNull(faRequest5);
        assertEquals("engineerSendFinalFaRequestTest", faRequest5.getPartNo());
        assertEquals("ENGINEER_SEND_FINAL_FA_REQUEST", faRequest5.getStatus());
    }

    @Test
    public void qaApproveFinalFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","qaApproveFinalFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("qaApproveFinalFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("qaApproveFinalFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("qaApproveFinalFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("qaApproveFinalFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("qaApproveFinalFaRequestTest");

        assertNotNull(faRequest3);
        assertEquals("qaApproveFinalFaRequestTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_SEND_FIRST_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("qaApproveFinalFaRequestTest");

        assertNotNull(faRequest4);
        assertEquals("qaApproveFinalFaRequestTest", faRequest4.getPartNo());
        assertEquals("QA_APPROVE_FIRST_FA_REQUEST", faRequest4.getStatus());
        assertEquals("test test", faRequest4.getProcess());
        assertEquals("gh", faRequest4.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("qaApproveFinalFaRequestTest");

        assertNotNull(faRequest5);
        assertEquals("qaApproveFinalFaRequestTest", faRequest5.getPartNo());
        assertEquals("ENGINEER_SEND_FINAL_FA_REQUEST", faRequest5.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper6 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper6.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper6.setParameter("reason","juhy i");
        multipartHttpServletRequestWrapper6.setParameter("file1","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper6.setParameter("file2","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.qaApproveFinalFa(multipartHttpServletRequestWrapper6);
        FaRequest faRequest6 = faRequestDao.findByPartNumber("qaApproveFinalFaRequestTest");
        assertEquals("QA_APPROVE_FINAL_FA_REQUEST", faRequest6.getStatus());
    }

    @Test
    public void qaWaitingFinalFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","qaWaitingFinalFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("qaWaitingFinalFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("qaWaitingFinalFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("qaWaitingFinalFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("qaWaitingFinalFaRequestTest");

        assertNotNull(faRequest3);
        assertEquals("qaWaitingFinalFaRequestTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_SEND_FIRST_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("qaWaitingFinalFaRequestTest");

        assertNotNull(faRequest4);
        assertEquals("qaWaitingFinalFaRequestTest", faRequest4.getPartNo());
        assertEquals("QA_APPROVE_FIRST_FA_REQUEST", faRequest4.getStatus());
        assertEquals("test test", faRequest4.getProcess());
        assertEquals("gh", faRequest4.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("qaWaitingFinalFaRequestTest");

        assertNotNull(faRequest5);
        assertEquals("qaWaitingFinalFaRequestTest", faRequest5.getPartNo());
        assertEquals("ENGINEER_SEND_FINAL_FA_REQUEST", faRequest5.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper6 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper6.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper6.setParameter("reason","juhy i");

        famsService.qaWaitingFinalFa(multipartHttpServletRequestWrapper6);
        FaRequest faRequest6 = faRequestDao.findByPartNumber("qaWaitingFinalFaRequestTest");
        assertEquals("QA_WAITING_FINAL_FA_REQUEST", faRequest6.getStatus());
    }

    @Test
    public void qaRejectFinalFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","qaRejectFinalFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("qaRejectFinalFaRequestTest");
        assertNotNull(faRequest);
        assertEquals("qaRejectFinalFaRequestTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("qaRejectFinalFaRequestTest");

        assertNotNull(faRequest2);
        assertEquals("qaRejectFinalFaRequestTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("qaRejectFinalFaRequestTest");

        assertNotNull(faRequest3);
        assertEquals("qaRejectFinalFaRequestTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_SEND_FIRST_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("qaRejectFinalFaRequestTest");

        assertNotNull(faRequest4);
        assertEquals("qaRejectFinalFaRequestTest", faRequest4.getPartNo());
        assertEquals("QA_APPROVE_FIRST_FA_REQUEST", faRequest4.getStatus());
        assertEquals("test test", faRequest4.getProcess());
        assertEquals("gh", faRequest4.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("qaRejectFinalFaRequestTest");

        assertNotNull(faRequest5);
        assertEquals("qaRejectFinalFaRequestTest", faRequest5.getPartNo());
        assertEquals("ENGINEER_SEND_FINAL_FA_REQUEST", faRequest5.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper6 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper6.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper6.setParameter("reason","juhy i");

        famsService.qaRejectFinalFa(multipartHttpServletRequestWrapper6);
        FaRequest faRequest6 = faRequestDao.findByPartNumber("qaRejectFinalFaRequestTest");
        assertEquals("QA_REJECT_FINAL_FA_REQUEST", faRequest6.getStatus());
    }

    @Test
    public void qaApproveDocumentFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","qaApproveDocumentFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("qaApproveDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("qaApproveDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("qaApproveDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("qaApproveDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("qaApproveDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper6 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper6.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper6.setParameter("reason","juhy i");
        multipartHttpServletRequestWrapper6.setParameter("file1","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper6.setParameter("file2","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.qaApproveFinalFa(multipartHttpServletRequestWrapper6);
        FaRequest faRequest6 = faRequestDao.findByPartNumber("qaApproveDocumentFaRequestTest");
        assertEquals("QA_APPROVE_FINAL_FA_REQUEST", faRequest6.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper7 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper7.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper7.setParameter("reason","juhy i");

        famsService.qaApproveDocumentFa(multipartHttpServletRequestWrapper7);
        FaRequest faRequest7 = faRequestDao.findByPartNumber("qaApproveDocumentFaRequestTest");
        assertEquals("QA_APPROVE_DOCUMENT_FA_REQUEST", faRequest7.getStatus());
    }

    @Test
    public void qaRejectDocumentFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","qaRejectDocumentFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("qaRejectDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("qaRejectDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("qaRejectDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("qaRejectDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("qaRejectDocumentFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper6 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper6.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper6.setParameter("reason","juhy i");
        multipartHttpServletRequestWrapper6.setParameter("file1","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper6.setParameter("file2","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.qaApproveFinalFa(multipartHttpServletRequestWrapper6);
        FaRequest faRequest6 = faRequestDao.findByPartNumber("qaRejectDocumentFaRequestTest");
        assertEquals("QA_APPROVE_FINAL_FA_REQUEST", faRequest6.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper7 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper7.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper7.setParameter("reason","juhy i");

        famsService.qaRejectDocumentFa(multipartHttpServletRequestWrapper7);
        FaRequest faRequest7 = faRequestDao.findByPartNumber("qaRejectDocumentFaRequestTest");
        assertEquals("QA_REJECT_DOCUMENT_FA_REQUEST", faRequest7.getStatus());
    }

    @Test
    public void saleCoFollowFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","saleCoFollowFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("saleCoFollowFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("saleCoFollowFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("saleCoFollowFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("saleCoFollowFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("saleCoFollowFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper6 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper6.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper6.setParameter("reason","juhy i");
        multipartHttpServletRequestWrapper6.setParameter("file1","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper6.setParameter("file2","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.qaApproveFinalFa(multipartHttpServletRequestWrapper6);
        FaRequest faRequest6 = faRequestDao.findByPartNumber("saleCoFollowFaRequestTest");
        assertEquals("QA_APPROVE_FINAL_FA_REQUEST", faRequest6.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper7 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper7.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper7.setParameter("reason","juhy i");

        famsService.qaApproveDocumentFa(multipartHttpServletRequestWrapper7);
        FaRequest faRequest7 = faRequestDao.findByPartNumber("saleCoFollowFaRequestTest");
        assertEquals("QA_APPROVE_DOCUMENT_FA_REQUEST", faRequest7.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper8 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper8.setParameter("id","" + faRequest7.getId());
        multipartHttpServletRequestWrapper8.setParameter("contractName","kop k");
        multipartHttpServletRequestWrapper8.setParameter("invoice","123ed");

        famsService.saleCoFollowUpFa(multipartHttpServletRequestWrapper8);

        FaRequest faRequest8 = faRequestDao.findByPartNumber("saleCoFollowFaRequestTest");
        assertEquals("SALE_CO_FOLLOW_UP_FA_REQUEST", faRequest8.getStatus());
    }

    @Test
    public void saleOutApproveFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","saleOutApproveFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper6 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper6.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper6.setParameter("reason","juhy i");
        multipartHttpServletRequestWrapper6.setParameter("file1","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper6.setParameter("file2","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.qaApproveFinalFa(multipartHttpServletRequestWrapper6);
        FaRequest faRequest6 = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");
        assertEquals("QA_APPROVE_FINAL_FA_REQUEST", faRequest6.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper7 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper7.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper7.setParameter("reason","juhy i");

        famsService.qaApproveDocumentFa(multipartHttpServletRequestWrapper7);
        FaRequest faRequest7 = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");
        assertEquals("QA_APPROVE_DOCUMENT_FA_REQUEST", faRequest7.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper8 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper8.setParameter("id","" + faRequest7.getId());
        multipartHttpServletRequestWrapper8.setParameter("contractName","kop k");
        multipartHttpServletRequestWrapper8.setParameter("invoice","123ed");

        famsService.saleCoFollowUpFa(multipartHttpServletRequestWrapper8);

        FaRequest faRequest8 = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");
        assertEquals("SALE_CO_FOLLOW_UP_FA_REQUEST", faRequest8.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper9 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper9.setParameter("id","" + faRequest8.getId());

        famsService.saleOutApproveFa(multipartHttpServletRequestWrapper9);
        FaRequest faRequest9 = faRequestDao.findByPartNumber("saleOutApproveFaRequestTest");
        assertEquals("SALE_OUT_APPROVE_FA_REQUEST", faRequest9.getStatus());

    }

    @Test
    public void saleOutRejectFaRequestTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","saleOutRejectFaRequestTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper4 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper4.setParameter("id","" + faRequest3.getId());
        multipartHttpServletRequestWrapper4.setParameter("reason","haha");

        famsService.qaApproveFirstFa(multipartHttpServletRequestWrapper4);
        FaRequest faRequest4 = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper5 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper5.setParameter("id","" + faRequest4.getId());
        multipartHttpServletRequestWrapper5.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper5.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper5.setParameter("qtyFirst","50");

        famsService.engineerSendFinalFa(multipartHttpServletRequestWrapper5);
        FaRequest faRequest5 = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper6 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper6.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper6.setParameter("reason","juhy i");
        multipartHttpServletRequestWrapper6.setParameter("file1","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper6.setParameter("file2","/Users/apichat/Workspace/temp/01Test.pdf");

        famsService.qaApproveFinalFa(multipartHttpServletRequestWrapper6);
        FaRequest faRequest6 = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");
        assertEquals("QA_APPROVE_FINAL_FA_REQUEST", faRequest6.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper7 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper7.setParameter("id","" + faRequest5.getId());
        multipartHttpServletRequestWrapper7.setParameter("reason","juhy i");

        famsService.qaApproveDocumentFa(multipartHttpServletRequestWrapper7);
        FaRequest faRequest7 = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");
        assertEquals("QA_APPROVE_DOCUMENT_FA_REQUEST", faRequest7.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper8 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper8.setParameter("id","" + faRequest7.getId());
        multipartHttpServletRequestWrapper8.setParameter("contractName","kop k");
        multipartHttpServletRequestWrapper8.setParameter("invoice","123ed");

        famsService.saleCoFollowUpFa(multipartHttpServletRequestWrapper8);

        FaRequest faRequest8 = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");
        assertEquals("SALE_CO_FOLLOW_UP_FA_REQUEST", faRequest8.getStatus());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper9 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper9.setParameter("id","" + faRequest8.getId());
        multipartHttpServletRequestWrapper9.setParameter("reason","kanakana");

        famsService.saleOutRejectFa(multipartHttpServletRequestWrapper9);
        FaRequest faRequest9 = faRequestDao.findByPartNumber("saleOutRejectFaRequestTest");
        assertEquals("SALE_OUT_REJECT_FA_REQUEST", faRequest9.getStatus());

    }
}
