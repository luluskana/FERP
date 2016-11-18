package com.ferp.web;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.dao.FaRequestDao;
import com.ferp.domain.FaRequest;
import com.ferp.service.FamsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
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

}
