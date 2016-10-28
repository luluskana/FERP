package com.ferp.service;

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

/**
 * Created by apichat on 10/26/2016 AD.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserServiceTests {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserServiceTests.class);

    @Autowired
    private AppUserService appUserService;

    @Test
    public void createAppUserTest() throws Exception {
        AppUser appUser = new AppUser();
        appUser.setCreateDate(new Date());
        appUser.setCreateBy("Apichat");
        appUser.setUsername("kopeeno");
        appUser.setPassword("password");
        appUser.setDepartment("MIS");
        appUser.setEmailAddress("apichat.kop@gmail.com");
        appUser.setEnabled(1);
        appUser.setName("Apichat Eakwongsa");
        appUser.setRoleName("admin");
        appUserService.create(appUser);
        AppUser appUserTest = appUserService.findByUsername("kopeeno");
        assertNotNull(appUserTest);
        assertEquals("kopeeno", appUserTest.getUsername());
    }

    @Test
    public void findByUsernameAppUserTest() throws Exception {
        AppUser appUser = new AppUser();
        appUser.setCreateDate(new Date());
        appUser.setCreateBy("Apichat");
        appUser.setUsername("kopeeno2");
        appUser.setPassword("password");
        appUser.setDepartment("MIS");
        appUser.setEmailAddress("apichat.kop@gmail.com");
        appUser.setEnabled(1);
        appUser.setName("Apichat Eakwongsa");
        appUser.setRoleName("admin");
        appUserService.create(appUser);

        AppUser appUserFindByUsernameTest = appUserService.findByUsername("kopeeno2");
        assertNotNull(appUserFindByUsernameTest);
        assertEquals("kopeeno2", appUserFindByUsernameTest.getUsername());
        assertEquals("admin", appUserFindByUsernameTest.getRoleName());

        appUserFindByUsernameTest = appUserService.findByUsername("kopeeno-");
        assertNull(appUserFindByUsernameTest);
    }

    @Test
    public void updateAppUserTest() throws Exception {
        AppUser appUser = new AppUser();
        appUser.setCreateDate(new Date());
        appUser.setCreateBy("Apichat");
        appUser.setUsername("kopeeno3");
        appUser.setPassword("password");
        appUser.setDepartment("MIS");
        appUser.setEmailAddress("apichat.kop@gmail.com");
        appUser.setEnabled(1);
        appUser.setName("Apichat Eakwongsa");
        appUser.setRoleName("admin");
        appUserService.create(appUser);

        AppUser appUserKopeeno3 = appUserService.findByUsername("kopeeno3");
        appUserKopeeno3.setName("AAAA");
        appUserKopeeno3.setDepartment("MK");
        appUserService.update(appUserKopeeno3);

        AppUser appUser1 = appUserService.findByUsername("kopeeno3");

        assertNotNull(appUser1);
        assertEquals("AAAA", appUser1.getName());
        assertEquals("MK", appUser1.getDepartment());
    }

    @Test
    public void findByIdAppUserTest() throws Exception {
        AppUser appUser = new AppUser();
        appUser.setCreateDate(new Date());
        appUser.setCreateBy("Apichat");
        appUser.setUsername("kopeeno4");
        appUser.setPassword("password");
        appUser.setDepartment("MIS");
        appUser.setEmailAddress("apichat.kop@gmail.com");
        appUser.setEnabled(1);
        appUser.setName("Apichat Eakwongsa");
        appUser.setRoleName("admin");
        appUserService.create(appUser);

        AppUser appUser1 = appUserService.findByUsername("kopeeno4");

        AppUser appUser2 = appUserService.findById(appUser1.getId());
        assertNotNull(appUser2);
        assertEquals("kopeeno4", appUser1.getUsername());
    }

}
