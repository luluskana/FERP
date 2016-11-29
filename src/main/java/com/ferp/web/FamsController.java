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
        viewService.addFaRequestStatusEngineerSendFirstShot(model);
        model.addObject("faStatusQaApproveFirst", faRequestDao.findByStatus(new String[] {"QA_APPROVE_FIRST_FA_REQUEST"}));
        model.addObject("faStatusQaRejectFirst", faRequestDao.findByStatus(new String[] {"QA_REJECT_FIRST_FA_REQUEST"}));
        model.addObject("faStatusEngineerSendFinal", faRequestDao.findByStatus(new String[] {"ENGINEER_SEND_FINAL_FA_REQUEST"}));
        model.addObject("faStatusQaApproveFinal", faRequestDao.findByStatus(new String[] {"QA_APPROVE_FINAL_FA_REQUEST"}));
        model.addObject("faStatusQaRejectFinal", faRequestDao.findByStatus(new String[] {"QA_REJECT_FINAL_FA_REQUEST"}));
        model.addObject("faStatusQaWaiting", faRequestDao.findByStatus(new String[] {"QA_WAITING_FINAL_FA_REQUEST"}));
        model.addObject("faStatusRejectDocument", faRequestDao.findByStatus(new String[] {"QA_REJECT_DOCUMENT_FA_REQUEST"}));
        model.addObject("faStatusApproveDocument", faRequestDao.findByStatus(new String[] {"QA_APPROVE_DOCUMENT_FA_REQUEST"}));
        model.addObject("faStatusSaleCoFollowUp", faRequestDao.findByStatus(new String[] {"SALE_CO_FOLLOW_UP_FA_REQUEST"}));
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
        viewService.addFaRequestStatusEngineerWaiting(model);
        viewService.addFaRequestStatusEngineerApprove(model);
        model.addObject("faStatusQaApproveFirst", faRequestDao.findByStatus(new String[] {"QA_APPROVE_FIRST_FA_REQUEST"}));
        model.addObject("faStatusQaRejectFirst", faRequestDao.findByStatus(new String[] {"QA_REJECT_FIRST_FA_REQUEST"}));
        model.addObject("faStatusQaRejectFinal", faRequestDao.findByStatus(new String[] {"QA_REJECT_FINAL_FA_REQUEST"}));
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

    @RequestMapping(value = "/fams/engineerSendFirst/{id}", method = RequestMethod.GET)
    public ModelAndView engineerSendFirstFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faRequest", faRequestDao.findById(id));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("engineer") || appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/engineerSendFirst");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/engineerSendFirst");
        }
        return model;
    }

    @RequestMapping(value = "/fams/qaView", method = RequestMethod.GET)
    public ModelAndView listForQaView(ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faStatusFirst", faRequestDao.findByStatus(new String[] {"ENGINEER_SEND_FIRST_FA_REQUEST"}));
        model.addObject("faStatusFinal", faRequestDao.findByStatus(new String[] {"ENGINEER_SEND_FINAL_FA_REQUEST"}));
        model.addObject("faStatusWaiting", faRequestDao.findByStatus(new String[] {"QA_WAITING_FINAL_FA_REQUEST"}));
        model.addObject("faStatusRejectDocument", faRequestDao.findByStatus(new String[] {"QA_REJECT_DOCUMENT_FA_REQUEST"}));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("qaEngineer") ||  appUser.getRoleName().equals("admin") ||  appUser.getRoleName().equals("qa")) {
                model.setViewName("FAMS/qaView");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/qaView");
        }
        return model;
    }

    @RequestMapping(value = "/fams/qaFirst/{id}", method = RequestMethod.GET)
    public ModelAndView qaFirstFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faRequest", faRequestDao.findById(id));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("qaEngineer") ||  appUser.getRoleName().equals("admin") ||  appUser.getRoleName().equals("qa")) {
                model.setViewName("FAMS/qaFirstShot");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/qaFirstShot");
        }
        return model;
    }

    @RequestMapping(value = "/fams/engineerSendFinal/{id}", method = RequestMethod.GET)
    public ModelAndView engineerSendFinalFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faRequest", faRequestDao.findById(id));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("engineer") || appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/engineerSendFinal");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/engineerSendFinal");
        }
        return model;
    }

    @RequestMapping(value = "/fams/qaFinal/{id}", method = RequestMethod.GET)
    public ModelAndView qaFinalFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faRequest", faRequestDao.findById(id));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("qaEngineer") ||  appUser.getRoleName().equals("admin") ||  appUser.getRoleName().equals("qa")) {
                model.setViewName("FAMS/qaFinal");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/qaFinal");
        }
        return model;
    }

    @RequestMapping(value = "/fams/qaEngineerView", method = RequestMethod.GET)
    public ModelAndView listForQaEngineerView(ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faStatusApproveFinal", faRequestDao.findByStatus(new String[] {"QA_APPROVE_FINAL_FA_REQUEST"}));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("qaEngineer") ||  appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/qaEngineerView");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/qaEngineerView");
        }
        return model;
    }

    @RequestMapping(value = "/fams/reviewDoc/{id}", method = RequestMethod.GET)
    public ModelAndView qaReviewDocumentFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faRequest", faRequestDao.findById(id));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("qaEngineer") ||  appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/reviewDoc");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/reviewDoc");
        }
        return model;
    }

    @RequestMapping(value = "/fams/listSaleCoFollow", method = RequestMethod.GET)
    public ModelAndView listSaleCoFollow(ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            model.addObject("faStatusApproveDocument", faRequestDao.findByStatusAndUser("QA_APPROVE_DOCUMENT_FA_REQUEST", appUser));
            if(appUser.getRoleName().equals("saleCo") || appUser.getRoleName().equals("saleOut") ||  appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/listSaleCoFollow");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/listSaleCoFollow");
        }
        return model;
    }

    @RequestMapping(value = "/fams/saleCoFollow/{id}", method = RequestMethod.GET)
    public ModelAndView saleCoFollowFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faRequest", faRequestDao.findById(id));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("saleCo") || appUser.getRoleName().equals("saleOut") ||  appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/saleCoFollow");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/saleCoFollow");
        }
        return model;
    }
}
