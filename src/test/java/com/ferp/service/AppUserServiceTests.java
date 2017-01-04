package com.ferp.service;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.dao.AppUserDao;
import com.ferp.domain.AppUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ferp.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

/**
 * Created by apichat on 10/26/2016 AD.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserServiceTests {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserServiceTests.class);

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserDao appUserDao;

    @Test
    public void createAppUserTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("employeeID", "createAppUserTest");
        multipartHttpServletRequestWrapper.setParameter("username", "apichat");
        multipartHttpServletRequestWrapper.setParameter("password", "password");
        multipartHttpServletRequestWrapper.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper.setParameter("sex", "Male");
        multipartHttpServletRequestWrapper.setParameter("department", "MIS");
        multipartHttpServletRequestWrapper.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper.setParameter("roleName", "admin");

        AppUser appUser = appUserService.create(multipartHttpServletRequestWrapper);
        assertNotNull(appUser);
        assertEquals("apichat", appUser.getUsername());
    }

    @Test
    public void findByUsernameAppUserTest() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("employeeID", "findByUsernameAppUserTest");
        multipartHttpServletRequestWrapper.setParameter("username", "kopeeno2");
        multipartHttpServletRequestWrapper.setParameter("password", "password");
        multipartHttpServletRequestWrapper.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper.setParameter("sex", "Male");
        multipartHttpServletRequestWrapper.setParameter("department", "MIS");
        multipartHttpServletRequestWrapper.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper.setParameter("roleName", "admin");

        appUserService.create(multipartHttpServletRequestWrapper);


        AppUser appUserFindByUsernameTest = appUserService.findByUsername("kopeeno2");
        assertNotNull(appUserFindByUsernameTest);
        assertEquals("kopeeno2", appUserFindByUsernameTest.getUsername());
        assertEquals("admin", appUserFindByUsernameTest.getRoleName());

        appUserFindByUsernameTest = appUserService.findByUsername("kopeeno-");
        assertNull(appUserFindByUsernameTest);
    }

    @Test
    public void updateAppUserTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("employeeID", "updateAppUserTest");
        multipartHttpServletRequestWrapper.setParameter("username", "kopeeno3");
        multipartHttpServletRequestWrapper.setParameter("password", "password");
        multipartHttpServletRequestWrapper.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper.setParameter("sex", "Male");
        multipartHttpServletRequestWrapper.setParameter("department", "MIS");
        multipartHttpServletRequestWrapper.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper.setParameter("roleName", "admin");

        appUserService.create(multipartHttpServletRequestWrapper);

        AppUser appUserKopeeno3 = appUserService.findByUsername("kopeeno3");

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id", "" + appUserKopeeno3.getId());
        multipartHttpServletRequestWrapper2.setParameter("employeeID", "updateAppUserTest");
        multipartHttpServletRequestWrapper2.setParameter("username", "kopeeno3");
        multipartHttpServletRequestWrapper2.setParameter("password", "password");
        multipartHttpServletRequestWrapper2.setParameter("name", "AAAA");
        multipartHttpServletRequestWrapper2.setParameter("sex", "Male");
        multipartHttpServletRequestWrapper2.setParameter("department", "MK");
        multipartHttpServletRequestWrapper2.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper2.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper2.setParameter("roleName", "admin");

        appUserService.update(multipartHttpServletRequestWrapper2);

        AppUser appUser1 = appUserService.findByUsername("kopeeno3");

        assertNotNull(appUser1);
        assertEquals("AAAA", appUser1.getName());
        assertEquals("MK", appUser1.getDepartment());
    }

    @Test
    public void findByIdAppUserTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("employeeID", "updateAppUserTest");
        multipartHttpServletRequestWrapper.setParameter("username", "kopeeno4");
        multipartHttpServletRequestWrapper.setParameter("password", "password");
        multipartHttpServletRequestWrapper.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper.setParameter("sex", "Male");
        multipartHttpServletRequestWrapper.setParameter("department", "MIS");
        multipartHttpServletRequestWrapper.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper.setParameter("roleName", "admin");

        appUserService.create(multipartHttpServletRequestWrapper);

        AppUser appUser1 = appUserService.findByUsername("kopeeno4");

        AppUser appUser2 = appUserService.findById(appUser1.getId());
        assertNotNull(appUser2);
        assertEquals("kopeeno4", appUser1.getUsername());
    }

    @Test
    public void findAppUserInRoleNameTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("employeeID", "findAppUserInRoleNameTest");
        multipartHttpServletRequestWrapper.setParameter("username", "find01");
        multipartHttpServletRequestWrapper.setParameter("password", "password");
        multipartHttpServletRequestWrapper.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper.setParameter("sex", "Male");
        multipartHttpServletRequestWrapper.setParameter("department", "MIS");
        multipartHttpServletRequestWrapper.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper.setParameter("roleName", "admin");

        AppUser appUser = appUserService.create(multipartHttpServletRequestWrapper);
        assertNotNull(appUser);
        assertEquals("find01", appUser.getUsername());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("employeeID", "findAppUserInRoleNameTest02");
        multipartHttpServletRequestWrapper2.setParameter("username", "find02");
        multipartHttpServletRequestWrapper2.setParameter("password", "password");
        multipartHttpServletRequestWrapper2.setParameter("name", "Apichat Eakwongsa");
        multipartHttpServletRequestWrapper2.setParameter("sex", "Male");
        multipartHttpServletRequestWrapper2.setParameter("department", "MIS");
        multipartHttpServletRequestWrapper2.setParameter("emailAddress", "apichat.kop@gmail.com");
        multipartHttpServletRequestWrapper2.setParameter("phoneNumber", "0800103329");
        multipartHttpServletRequestWrapper2.setParameter("roleName", "saleOut");

        AppUser appUser2 = appUserService.create(multipartHttpServletRequestWrapper2);
        assertNotNull(appUser2);
        assertEquals("find02", appUser2.getUsername());

        List<AppUser> appUsers = appUserDao.findInRoleName(new String[]{"saleOut"});
        assertNotNull(appUsers);
        assertEquals("saleOut", appUsers.get(0).getRoleName());
    }

}
