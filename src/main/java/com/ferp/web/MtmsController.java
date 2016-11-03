package com.ferp.web;

import com.ferp.dao.AppUserDao;
import com.ferp.domain.AppUser;
import com.ferp.service.ViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by apichat on 11/1/2016 AD.
 */
@Controller
public class MtmsController {

    private final Logger logger = LoggerFactory.getLogger(MtmsController.class);

    @Autowired
    private ViewService viewService;

    @Autowired
    private AppUserDao appUserDao;

    @RequestMapping(value = "/mtms", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addMaterialTypes(model);
        model.setViewName("MTMS/home");
        return model;
    }

    @RequestMapping(value = "/mtms/{id}", method = RequestMethod.GET)
    public ModelAndView materialTypeGroupPage(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addMaterialType(model, id);
        model.setViewName("MTMS/materialTypeGroup");
        return model;
    }

    @RequestMapping(value = "/mtms/createMaterial/{id}", method = RequestMethod.GET)
    public ModelAndView createMaterial(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        viewService.addMaterialType(model, id);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("purchase") || appUser.getRoleName().equals("qa") || appUser.getRoleName().equals("admin")) {
                model.setViewName("MTMS/createMaterial");
            } else {
                model.setViewName("MTMS/404");
            }
        } catch (Exception e) {
            model.setViewName("MTMS/createMaterial");
        }
        return model;
    }
}
