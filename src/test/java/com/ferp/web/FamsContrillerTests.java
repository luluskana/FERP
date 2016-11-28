package com.ferp.web;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.dao.FaRequestDao;
import com.ferp.domain.FaRequest;
import com.ferp.service.FamsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by apichat on 11/16/2016 AD.
 */
public class FamsContrillerTests extends AbstractTestController {

    @Autowired
    private FamsService famsService;

    @Autowired
    private FaRequestDao faRequestDao;

    @Test
    public void homePageNoLoginTest() throws Exception {

        this.mockMvc.perform(get("/fams"))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/home"))
                .andExpect(model().attribute("name", nullValue()))
                .andExpect(model().attribute("logout", nullValue()))
                .andExpect(model().attribute("login", "on"))
                .andExpect(model().attribute("roleName", nullValue()));
    }

    @Test
    public void famsPageRequestFaTest() throws Exception {

        this.mockMvc.perform(get("/fams/request").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/requestFa"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageRequestDetailStatusCreateTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageRequestDetailStatusCreate");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageRequestDetailStatusCreate");

        this.mockMvc.perform(get("/fams/detail/create/" + faRequest.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/detailCreate"))
                .andExpect(model().attribute("faRequest", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageSaleListTest() throws Exception {

        this.mockMvc.perform(get("/fams/listSale").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/listSale"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageUpdateTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageUpdateTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageUpdateTest");

        this.mockMvc.perform(get("/fams/update/" + faRequest.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/update"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageEngineerViewListTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageEngineerViewListTest");
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

        this.mockMvc.perform(get("/fams/engineerView").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/engineerView"))
                .andExpect(model().attribute("faStatusCreateList", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageEngineerReviewTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageEngineerReviewTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageEngineerReviewTest");

        this.mockMvc.perform(get("/fams/engineerReview/" + faRequest.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/engineerReview"))
                .andExpect(model().attribute("faRequest", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageEngineerSendFirstTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageEngineerSendFirstTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageEngineerSendFirstTest");

        this.mockMvc.perform(get("/fams/engineerSendFirst/" + faRequest.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/engineerSendFirst"))
                .andExpect(model().attribute("faRequest", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageQaViewListTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageQaViewListTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageQaViewListTest");
        assertNotNull(faRequest);
        assertEquals("famsPageQaViewListTest", faRequest.getPartNo());
        assertEquals("CREATE_FA_REQUEST", faRequest.getStatus());
        assertEquals("gh", faRequest.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + faRequest.getId());
        multipartHttpServletRequestWrapper2.setParameter("commitDate","22/06/2016");
        multipartHttpServletRequestWrapper2.setParameter("process","test test");

        famsService.engineerApproveFa(multipartHttpServletRequestWrapper2);
        FaRequest faRequest2 = faRequestDao.findByPartNumber("famsPageQaViewListTest");

        assertNotNull(faRequest2);
        assertEquals("famsPageQaViewListTest", faRequest2.getPartNo());
        assertEquals("ENGINEER_APPROVE_FA_REQUEST", faRequest2.getStatus());
        assertEquals("test test", faRequest2.getProcess());
        assertEquals("gh", faRequest2.getDocumentRequest());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper3 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper3.setParameter("id","" + faRequest2.getId());
        multipartHttpServletRequestWrapper3.setParameter("method","KKUU ok");
        multipartHttpServletRequestWrapper3.setParameter("materialSlip","ASD12345");
        multipartHttpServletRequestWrapper3.setParameter("qtyFirst","50");

        famsService.engineerSendFirstFa(multipartHttpServletRequestWrapper3);
        FaRequest faRequest3 = faRequestDao.findByPartNumber("famsPageQaViewListTest");

        assertNotNull(faRequest3);
        assertEquals("famsPageQaViewListTest", faRequest3.getPartNo());
        assertEquals("ENGINEER_SEND_FIRST_FA_REQUEST", faRequest3.getStatus());
        assertEquals("test test", faRequest3.getProcess());
        assertEquals("gh", faRequest3.getDocumentRequest());

        this.mockMvc.perform(get("/fams/qaView").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/qaView"))
                .andExpect(model().attribute("faStatusFirst", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageQaFirstTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageQaFirstTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageQaFirstTest");

        this.mockMvc.perform(get("/fams/qaFirst/" + faRequest.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/qaFirstShot"))
                .andExpect(model().attribute("faRequest", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageEngineerSendFinalTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageEngineerSendFinalTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageEngineerSendFinalTest");

        this.mockMvc.perform(get("/fams/engineerSendFinal/" + faRequest.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/engineerSendFinal"))
                .andExpect(model().attribute("faRequest", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageQaFinalTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageQaFinalTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageQaFinalTest");

        this.mockMvc.perform(get("/fams/qaFinal/" + faRequest.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/qaFinal"))
                .andExpect(model().attribute("faRequest", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageQaEngineerViewListTest() throws Exception {

        this.mockMvc.perform(get("/fams/qaEngineerView").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/qaEngineerView"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void famsPageQaEngineerReviewDocumentTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customer","Canon");
        multipartHttpServletRequestWrapper.setParameter("partNo","famsPageQaEngineerReviewDocumentTest");
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

        FaRequest faRequest = faRequestDao.findByPartNumber("famsPageQaEngineerReviewDocumentTest");

        this.mockMvc.perform(get("/fams/reviewDoc/" + faRequest.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/reviewDoc"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }
}
