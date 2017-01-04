package com.ferp.web;

import com.ferp.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by apichat on 12/16/2016 AD.
 */
@Controller
public class OtRequestController {

    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/ot", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        model.setViewName("OT/home");
        return model;
    }

    @RequestMapping(value = "/ot/template", method = RequestMethod.GET)
    public ModelAndView otTemplate(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        model.setViewName("OT/template");
        return model;
    }

    @RequestMapping(value = "/ot/createTemplate", method = RequestMethod.GET)
    public ModelAndView otCreateTemplate(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        model.setViewName("OT/createTemplate");
        return model;
    }

    @RequestMapping(value = "/ot/createOt", method = RequestMethod.GET)
    public ModelAndView otRequest(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        model.setViewName("OT/createOt");
        return model;
    }
}
