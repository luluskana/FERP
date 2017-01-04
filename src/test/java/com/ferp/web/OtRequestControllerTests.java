package com.ferp.web;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.domain.MaterialType;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by apichat on 12/16/2016 AD.
 */
public class OtRequestControllerTests extends AbstractTestController {

    @Test
    public void otHomePageNoLoginTest() throws Exception {

        this.mockMvc.perform(get("/ot"))
                .andExpect(status().isOk())
                .andExpect(view().name("OT/home"))
                .andExpect(model().attribute("name", nullValue()))
                .andExpect(model().attribute("logout", nullValue()))
                .andExpect(model().attribute("login", "on"))
                .andExpect(model().attribute("roleName", nullValue()));
    }

    @Test
    public void otTemplatePageTest() throws Exception {

        this.mockMvc.perform(get("/ot/template").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("OT/template"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));

    }

    @Test
    public void otCreatePageTest() throws Exception {

        this.mockMvc.perform(get("/ot/createTemplate").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("OT/createTemplate"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));

    }

    @Test
    public void otRequestPageTest() throws Exception {

        this.mockMvc.perform(get("/ot/createOt").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("OT/createOt"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));

    }
}
