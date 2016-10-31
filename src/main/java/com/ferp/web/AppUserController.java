package com.ferp.web;

import com.ferp.domain.AppUser;
import com.ferp.service.AppUserService;
import com.ferp.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/appuser", params = "form", method = RequestMethod.GET)
    public ModelAndView appUserPageCreate(ModelAndView model, Principal principal) {
        try {
            AppUser userLogin = appUserService.findByUsername(principal.getName());
            viewService.addMenuAndName(model, principal);
            if(userLogin.getRoleName().equals("admin")) {
                model.setViewName("APPUSER/create");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("APPUSER/create");
        }
        return model;
    }

    @RequestMapping(value = "/appuser", params = "list", method = RequestMethod.GET)
    public ModelAndView appUserPageList(ModelAndView model, Principal principal) {
        try {
            AppUser userLogin = appUserService.findByUsername(principal.getName());
            viewService.addMenuAndName(model, principal);
            viewService.addViewFindAllAppUser(model);
            if(userLogin.getRoleName().equals("admin")) {
                model.setViewName("APPUSER/list");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("APPUSER/list");
        }
        return model;
    }

    @RequestMapping(value = "/appuser/{id}", params = "update", method = RequestMethod.GET)
    public ModelAndView appUserPageUpdate(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        try {
            AppUser userLogin = appUserService.findByUsername(principal.getName());
            viewService.addMenuAndName(model, principal);
            if(userLogin.getRoleName().equals("admin")) {
                model.setViewName("APPUSER/update");
                model.addObject("appUser", appUserService.findById(id));
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("APPUSER/update");
            model.addObject("appUser", appUserService.findById(id));
        }
        return model;
    }
}
