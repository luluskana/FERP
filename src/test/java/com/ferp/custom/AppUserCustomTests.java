package com.ferp.custom;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.domain.AppUser;
import com.ferp.service.AppUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by apichat on 11/1/2016 AD.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserCustomTests {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserCustomTests.class);

    @Autowired
    private AppUserCustom appUserCustom;

    @Autowired
    AppUserService appUserService;

    @Test
    public void createAppUserTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("username", "apichat");
        multipartHttpServletRequestWrapper.setParameter("password", "password");
        multipartHttpServletRequestWrapper.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper.setParameter("department", "MIS");
        multipartHttpServletRequestWrapper.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper.setParameter("roleName", "admin");

        AppUser appUser = appUserCustom.validateCreateAppUser(multipartHttpServletRequestWrapper);

        assertNotNull(appUser);
        assertEquals("apichat", appUser.getUsername());
        assertEquals("admin", appUser.getRoleName());
        assertNotNull(appUser.getCreateDate());
        assertNotNull(appUser.getCreateBy());
        assertEquals("admin", appUser.getCreateBy());
    }

    @Test
    public void updateAppUserTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("username", "apichatCu01");
        multipartHttpServletRequestWrapper.setParameter("password", "password");
        multipartHttpServletRequestWrapper.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper.setParameter("department", "MIS");
        multipartHttpServletRequestWrapper.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper.setParameter("roleName", "admin");

        AppUser appUser = appUserCustom.validateCreateAppUser(multipartHttpServletRequestWrapper);

        assertNotNull(appUser);
        assertEquals("apichatCu01", appUser.getUsername());
        assertEquals("admin", appUser.getRoleName());
        assertNotNull(appUser.getCreateDate());
        assertNotNull(appUser.getCreateBy());
        assertEquals("admin", appUser.getCreateBy());

        appUserService.create(appUser);

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id", appUserService.findByUsername("apichatCu01").getId()+"");
        multipartHttpServletRequestWrapper2.setParameter("username", "apichatCu01");
        multipartHttpServletRequestWrapper2.setParameter("password", "password001");
        multipartHttpServletRequestWrapper2.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper2.setParameter("department", "MISASS");
        multipartHttpServletRequestWrapper2.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper2.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper2.setParameter("roleName", "admin");

        AppUser appUser2 = appUserCustom.validateUpdateAppUser(multipartHttpServletRequestWrapper2);

        assertNotNull(appUser);
        assertEquals("password001", appUser2.getPassword());
        assertEquals("MISASS", appUser2.getDepartment());
    }
}
