package com.ferp.web;

import com.ferp.dao.AppUserDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.FileData;
import com.ferp.service.DownloadFileServiec;
import com.ferp.service.ViewService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private DownloadFileServiec downloadFileServiec;

    @RequestMapping(value = "/mtms", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addMaterialTypes(model);
        viewService.addMaterialWaitingApprove(model);
        viewService.addMaterialAdditionalOrReject(model);
        viewService.addMaterialApproveList(model);
        viewService.addMaterialsExpired(model);
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

    @RequestMapping(value = "/mtms/updateMaterial/{id}", method = RequestMethod.GET)
    public ModelAndView updateMaterial(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        viewService.addMaterial(model, id);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("purchase") || appUser.getRoleName().equals("qa") || appUser.getRoleName().equals("admin")) {
                model.setViewName("MTMS/updateMaterial");
            } else {
                model.setViewName("MTMS/404");
            }
        } catch (Exception e) {
            model.setViewName("MTMS/updateMaterial");
        }
        return model;
    }

    @RequestMapping(value = "/mtms/file/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFile(@PathVariable("id") Long id, HttpServletResponse response) {
        try {
            FileData fileData = downloadFileServiec.getFileName(id);
            response.setContentType(fileData.getContentType());
            response.setHeader("Content-Disposition", "inline;filename=" + fileData.getFileName());
            response.getOutputStream().write(fileData.getDataFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/mtms/detailMaterial/{id}", method = RequestMethod.GET)
    public ModelAndView detailMaterial(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addMaterial(model, id);
        model.setViewName("MTMS/detailMaterial");
        return model;
    }

    @RequestMapping(value = "/mtms/waitingApprove", method = RequestMethod.GET)
    public ModelAndView waitingApproveMaterial(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addMaterialWaitingApprove(model);
        model.setViewName("MTMS/waitingApprove");
        return model;
    }

    @RequestMapping(value = "/mtms/additionalMaterial", method = RequestMethod.GET)
    public ModelAndView AdditionalOrRejectMaterial(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addMaterialAdditionalOrReject(model);
        model.setViewName("MTMS/additionalMaterial");
        return model;
    }

    @RequestMapping(value = "/mtms/waitingApproveMaterial/{id}", method = RequestMethod.GET)
    public ModelAndView waitingApproveMaterial(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        viewService.addMaterial(model, id);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("qa") || appUser.getRoleName().equals("admin")) {
                model.setViewName("MTMS/waitingApproveMaterial");
            } else {
                model.setViewName("MTMS/404");
            }
        } catch (Exception e) {
            model.setViewName("MTMS/waitingApproveMaterial");
        }
        return model;
    }

    @RequestMapping(value = "/mtms/materialApprove", method = RequestMethod.GET)
    public ModelAndView materialApproveList(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addMaterialApproveList(model);
        model.setViewName("MTMS/materialApproveList");
        return model;
    }

    @RequestMapping(value = "/mtms/materialExpiredList", method = RequestMethod.GET)
    public ModelAndView materialExpiredList(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addMaterialsExpired(model);
        model.setViewName("MTMS/materialExpiredList");
        return model;
    }
}
