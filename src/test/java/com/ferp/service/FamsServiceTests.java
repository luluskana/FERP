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
}
