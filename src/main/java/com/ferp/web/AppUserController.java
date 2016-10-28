package com.ferp.web;

import com.ferp.domain.AppUser;
import com.ferp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

/**
 * Created by apichat on 10/27/2016 AD.
 */
@Controller
public class AppUserController {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserController.class);

    @Autowired
    private AppUserService appUserService;

    @RequestMapping(value = "/appuser", params = "form", method = RequestMethod.GET)
    public ModelAndView appUserPageCreate(ModelAndView model, Principal principal) {
        try {
            AppUser userLogin = appUserService.findByUsername(principal.getName());
            if(userLogin.getRoleName().equals("admin")) {
                model.setViewName("APPUSER/create");
            } else {
                model.setViewName("home");
            }
        } catch (Exception e) {
            model.setViewName("APPUSER/create");
        }
        return model;
    }
}
