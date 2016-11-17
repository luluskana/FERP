package com.ferp.service;

import com.ferp.dao.AppUserDao;
import com.ferp.domain.AppUser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by apichat on 10/26/2016 AD.
 */
@Service
public class AppUserService {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserService.class);

    @Autowired
    private AppUserDao appUserDao;

    public AppUser create(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String username = validateString(multipartHttpServletRequest.getParameter("username"));
            String password = validateString(multipartHttpServletRequest.getParameter("password"));
            String name = validateString(multipartHttpServletRequest.getParameter("name"));
            String department = validateString(multipartHttpServletRequest.getParameter("department"));
            String emailAddress = validateString(multipartHttpServletRequest.getParameter("emailAddress"));
            String phoneNumber = validateString(multipartHttpServletRequest.getParameter("phoneNumber"));
            String roleName = validateString(multipartHttpServletRequest.getParameter("roleName"));
            Principal principal = multipartHttpServletRequest.getUserPrincipal();

            AppUser appUser = new AppUser();
            appUser.setCreateDate(new Date());
            AppUser creator = appUserDao.findByUsername(principal.getName());
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
            appUserDao.create(appUser);
            return appUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AppUser findByUsername(String username) {
        try {
            return appUserDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = validateString(multipartHttpServletRequest.getParameter("id"));
            String username = validateString(multipartHttpServletRequest.getParameter("username"));
            String password = validateString(multipartHttpServletRequest.getParameter("password"));
            String name = validateString(multipartHttpServletRequest.getParameter("name"));
            String department = validateString(multipartHttpServletRequest.getParameter("department"));
            String emailAddress = validateString(multipartHttpServletRequest.getParameter("emailAddress"));
            String phoneNumber = validateString(multipartHttpServletRequest.getParameter("phoneNumber"));
            String roleName = validateString(multipartHttpServletRequest.getParameter("roleName"));
            Principal principal = multipartHttpServletRequest.getUserPrincipal();

            AppUser appUser = appUserDao.findById(Long.parseLong(id));
            appUser.setUpdateDate(new Date());
            AppUser creator = appUserDao.findByUsername(principal.getName());
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
            appUserDao.update(appUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AppUser findById(Long id) {
        try {
            return appUserDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<AppUser> findAll() {
        try {
            return appUserDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String validateString(String data) {
        if(data == null) {
            return "na";
        } else {
            return data;
        }
    }

    public JSONArray findInRoleName(MultipartHttpServletRequest multipartHttpServletRequest) {
        String roleName = multipartHttpServletRequest.getParameter("roleName");
        List<AppUser> appUsers = appUserDao.findInRoleName(new String[]{roleName});
        JSONArray jsonArray = new JSONArray();
        for (AppUser a : appUsers) {
            jsonArray.put(a.getName());
        }
        return jsonArray;
    }
}
