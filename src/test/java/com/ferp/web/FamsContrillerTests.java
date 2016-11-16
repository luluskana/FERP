package com.ferp.web;

import com.ferp.MultipartHttpServletRequestWrapper;
import org.junit.Test;

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

    @Test
    public void homePageNoLogin() throws Exception {

        this.mockMvc.perform(get("/fams"))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/home"))
                .andExpect(model().attribute("name", nullValue()))
                .andExpect(model().attribute("logout", nullValue()))
                .andExpect(model().attribute("login", "on"))
                .andExpect(model().attribute("roleName", nullValue()));
    }

    @Test
    public void famsPageRequestFa() throws Exception {

        this.mockMvc.perform(get("/fams/request").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("FAMS/requestFa"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", notNullValue()))
                .andExpect(model().attribute("login", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

}
