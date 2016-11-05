package com.ferp.web;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.domain.Material;
import com.ferp.domain.MaterialType;
import com.ferp.service.MtmsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by apichat on 11/3/2016 AD.
 */
public class MtmsControllerTests extends AbstractTestController {

    @Autowired
    private MtmsService mtmsService;

    @Test
    public void mtmsHomePageNoLoginTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","mtmsHomePageNoLogin");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        this.mockMvc.perform(get("/mtms"))
                .andExpect(status().isOk())
                .andExpect(view().name("MTMS/home"))
                .andExpect(model().attribute("materialTypes", notNullValue()))
                .andExpect(model().attribute("name", nullValue()))
                .andExpect(model().attribute("logout", nullValue()))
                .andExpect(model().attribute("login", "on"))
                .andExpect(model().attribute("roleName", nullValue()));
    }

    @Test
    public void mtmsHomePageLoginTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","mtmsHomePageLogin");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        this.mockMvc.perform(get("/mtms").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("MTMS/home"))
                .andExpect(model().attribute("materialTypes", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void mtmsMaterialTypeGroupPageNoLoginTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","mtmsMaterialTypeGroupPageNoLogin");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        this.mockMvc.perform(get("/mtms/" + materialType.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("MTMS/materialTypeGroup"))
                .andExpect(model().attribute("materialType", notNullValue()))
                .andExpect(model().attribute("name", nullValue()))
                .andExpect(model().attribute("logout", nullValue()))
                .andExpect(model().attribute("login", "on"))
                .andExpect(model().attribute("roleName", nullValue()));
    }

    @Test
    public void mtmsMaterialTypeGroupPageLoginTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","mtmsMaterialTypeGroupPageLoginTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        this.mockMvc.perform(get("/mtms/" + materialType.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("MTMS/materialTypeGroup"))
                .andExpect(model().attribute("materialType", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void mtmsCreateMaterialPageTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","mtmsCreateMaterialPageTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        this.mockMvc.perform(get("/mtms/createMaterial/" + materialType.getId()).principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("MTMS/createMaterial"))
                .andExpect(model().attribute("materialType", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void mtmsDownloadFileTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("typeName","mtmsDownloadFileTest");
        MaterialType materialType = mtmsService.createMaterialType(multipartHttpServletRequestWrapper);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id","" + materialType.getId());
        multipartHttpServletRequestWrapper2.setParameter("inputMaterialName","mtmsDownloadFileTest01");
        multipartHttpServletRequestWrapper2.setParameter("inputManufacturing","Thailand");
        multipartHttpServletRequestWrapper2.setParameter("inputUlNumber","Z1121");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputSpec","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputRoHs","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setParameter("inputDateRoHs","01/11/2016");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputMSDS","/Users/apichat/Workspace/temp/เทส.pdf");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputHalogen","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setParameter("inputDateHF","01/11/2016");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputGuarantee","/Users/apichat/Workspace/temp/01Test.pdf");
        multipartHttpServletRequestWrapper2.setMultipartFile("inputRedPhosphorus","/Users/apichat/Workspace/temp/เทส.pdf");

        Material material = mtmsService.createMaterial(multipartHttpServletRequestWrapper2);

        this.mockMvc.perform(get("/mtms/file/" + material.getSpec()))
                .andExpect(status().isOk());
    }
}
