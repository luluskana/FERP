package com.ferp.custom;

import com.ferp.domain.AppUser;
import com.ferp.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.security.Principal;
import java.util.Date;

/**
 * Created by apichat on 11/1/2016 AD.
 */
@Service
public class AppUserCustom {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserCustom.class);

    @Autowired
    private AppUserService appUserService;

    public AppUser validateCreateAppUser(MultipartHttpServletRequest multipartHttpServletRequest) {
        String username = multipartHttpServletRequest.getParameter("username");
        String password = multipartHttpServletRequest.getParameter("password");
        String name = multipartHttpServletRequest.getParameter("name");
        String department = multipartHttpServletRequest.getParameter("department");
        String emailAddress = multipartHttpServletRequest.getParameter("emailAddress");
        String phoneNumber = multipartHttpServletRequest.getParameter("phoneNumber");
        String roleName = multipartHttpServletRequest.getParameter("roleName");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();

        AppUser appUser = new AppUser();
        appUser.setCreateDate(new Date());
        AppUser creator = appUserService.findByUsername(principal.getName());
        if(creator == null) {
            appUser.setCreateBy("admin");
        } else {
            appUser.setCreateBy(principal.getName());
        }
        appUser.setUsername(username);
        appUser.setPassword(password);
        appUser.setName(name);
        appUser.setDepartment(department);
        appUser.setEmailAddress(emailAddress);
        appUser.setPhoneNumber(phoneNumber);
        appUser.setEnabled(1);
        appUser.setRoleName(roleName);
        return appUser;
    }

    public AppUser validateUpdateAppUser(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String username = multipartHttpServletRequest.getParameter("username");
        String password = multipartHttpServletRequest.getParameter("password");
        String name = multipartHttpServletRequest.getParameter("name");
        String department = multipartHttpServletRequest.getParameter("department");
        String emailAddress = multipartHttpServletRequest.getParameter("emailAddress");
        String phoneNumber = multipartHttpServletRequest.getParameter("phoneNumber");
        String roleName = multipartHttpServletRequest.getParameter("roleName");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();

        AppUser appUser = appUserService.findById(Long.parseLong(id));
        appUser.setUpdateDate(new Date());
        AppUser creator = appUserService.findByUsername(principal.getName());
        if(creator == null) {
            appUser.setUpdateBy("admin");
        } else {
            appUser.setUpdateBy(principal.getName());
        }
        appUser.setUsername(username);
        appUser.setPassword(password);
        appUser.setName(name);
        appUser.setDepartment(department);
        appUser.setEmailAddress(emailAddress);
        appUser.setPhoneNumber(phoneNumber);
        appUser.setEnabled(1);
        appUser.setRoleName(roleName);
        return appUser;
    }
}
