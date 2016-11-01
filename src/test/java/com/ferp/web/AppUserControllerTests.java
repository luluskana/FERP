package com.ferp.web;

import com.ferp.dao.AppUserDao;
import com.ferp.domain.AppUser;
import com.ferp.service.AppUserService;
import org.slf4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by apichat on 11/1/2016 AD.
 */
public class AppUserControllerTests extends AbstractTestController {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserControllerTests.class);

    @Autowired
    private AppUserService appUserService;

    @Test
    public void appUserCreatePage() throws Exception {

        this.mockMvc.perform(get("/appuser").principal(principal).param("form",""))
                .andExpect(status().isOk())
                .andExpect(view().name("APPUSER/create"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", "on"))
                .andExpect(model().attribute("loin", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void appUserUpdatePage() throws Exception {

        AppUser appUser = new AppUser();
        appUser.setCreateDate(new Date());
        appUser.setCreateBy("Apichat");
        appUser.setUsername("kopeenoAppUserUpdatePage");
        appUser.setPassword("password");
        appUser.setDepartment("MIS");
        appUser.setEmailAddress("apichat.kop@gmail.com");
        appUser.setEnabled(1);
        appUser.setName("Apichat Eakwongsa");
        appUser.setRoleName("admin");
        appUserService.create(appUser);

        this.mockMvc.perform(get("/appuser/" + appUserService.findByUsername("kopeenoAppUserUpdatePage").getId()).principal(principal).param("update",""))
                .andExpect(status().isOk())
                .andExpect(view().name("APPUSER/update"))
                .andExpect(model().attribute("appUser", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", "on"))
                .andExpect(model().attribute("loin", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }

    @Test
    public void appUserListPage() throws Exception {

        AppUser appUser = new AppUser();
        appUser.setCreateDate(new Date());
        appUser.setCreateBy("Apichat");
        appUser.setUsername("kopeenoAppUserListPage");
        appUser.setPassword("password");
        appUser.setDepartment("MIS");
        appUser.setEmailAddress("apichat.kop@gmail.com");
        appUser.setEnabled(1);
        appUser.setName("Apichat Eakwongsa");
        appUser.setRoleName("admin");
        appUserService.create(appUser);

        this.mockMvc.perform(get("/appuser").principal(principal).param("list",""))
                .andExpect(status().isOk())
                .andExpect(view().name("APPUSER/list"))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", "on"))
                .andExpect(model().attribute("loin", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }
}
