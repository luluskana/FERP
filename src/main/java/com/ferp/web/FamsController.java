package com.ferp.web;

import com.ferp.dao.AppUserDao;
import com.ferp.domain.AppUser;
import com.ferp.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by apichat on 11/16/2016 AD.
 */
@Controller
public class FamsController {

    @Autowired
    private ViewService viewService;

    @Autowired
    private AppUserDao appUserDao;

    @RequestMapping(value = "/fams", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addFaRequestStatusCreate(model);
        model.setViewName("FAMS/home");
        return model;
    }

    @RequestMapping(value = "/fams/detail/create/{id}", method = RequestMethod.GET)
    public ModelAndView famsStatusCreateDetail(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addFaRequest(model, id);
        model.setViewName("FAMS/detailCreate");
        return model;
    }

    @RequestMapping(value = "/fams/request", method = RequestMethod.GET)
    public ModelAndView createFarequest(ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("saleCo") || appUser.getRoleName().equals("saleOut") || appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/requestFa");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/requestFa");
        }
        return model;
    }

    @RequestMapping(value = "/fams/listSale", method = RequestMethod.GET)
    public ModelAndView listForSale(ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            viewService.addFaByUserList(model, appUser);
            if(appUser.getRoleName().equals("saleCo") || appUser.getRoleName().equals("saleOut") || appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/listSale");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/listSale");
        }
        return model;
    }
}
