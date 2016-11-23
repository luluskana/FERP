package com.ferp.web;

import com.ferp.dao.AppUserDao;
import com.ferp.dao.FaRequestDao;
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

    @Autowired
    private FaRequestDao faRequestDao;

    @RequestMapping(value = "/fams", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addFaRequestStatusCreate(model);
        viewService.addFaRequestStatusEngineerApprove(model);
        viewService.addFaRequestStatusEngineerReject(model);
        viewService.addFaRequestStatusEngineerWaiting(model);
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

    @RequestMapping(value = "/fams/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("saleCo") || appUser.getRoleName().equals("saleOut") || appUser.getRoleName().equals("admin")) {
                model.addObject("faRequest", faRequestDao.findByIdAndCreateBy(id, appUser));
                model.setViewName("FAMS/update");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.addObject("faRequest", faRequestDao.findById(id));
            model.setViewName("FAMS/update");
        }
        return model;
    }

    @RequestMapping(value = "/fams/engineerView", method = RequestMethod.GET)
    public ModelAndView listForEngineerView(ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        viewService.addFaRequestStatusCreate(model);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("engineer") ||  appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/engineerView");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/engineerView");
        }
        return model;
    }

    @RequestMapping(value = "/fams/engineerReview/{id}", method = RequestMethod.GET)
    public ModelAndView engineerReviewFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faRequest", faRequestDao.findById(id));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("engineer") || appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/engineerReview");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/engineerReview");
        }
        return model;
    }
}
