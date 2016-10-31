package com.ferp.service;

import com.ferp.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by apichat on 10/27/2016 AD.
 */
@Service
public class ViewService {

    @Autowired
    private AppUserService appUserService;

    public void addLogin(ModelAndView model) {
        model.addObject("login", "on");
    }

    public void addMenuAndName(ModelAndView model, Principal principal) {
        if(principal.getName().equals("user")) {
            model.addObject("name", principal.getName());
            model.addObject("roleName", "user");
        } else {
            AppUser appUser = appUserService.findByUsername(principal.getName());
            model.addObject("name", appUser.getName());
            model.addObject("roleName", appUser.getRoleName());
        }
        model.addObject("logout", "on");
    }

    public void addViewFindAllAppUser(ModelAndView model) {
        model.addObject("appUsers", appUserService.findAll());
    }
}
