package com.ferp.web;

import com.ferp.MultipartHttpServletRequestWrapper;
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
}
