package com.ferp.service;

import com.ferp.dao.CustomerDao;
import com.ferp.dao.FaRequestDao;
import com.ferp.dao.MaterialDao;
import com.ferp.dao.MaterialTypeDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.Material;
import com.ferp.domain.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

/**
 * Created by apichat on 10/27/2016 AD.
 */
@Service
public class ViewService {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private MaterialTypeDao materialTypeDao;

    @Autowired
    private MaterialDao materialDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private FaRequestDao faRequestDao;

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

    public void addMaterialTypes(ModelAndView model) {
        model.addObject("materialTypes", materialTypeDao.findAllMaterialType());
    }

    public void addMaterialType(ModelAndView model, Long id) {
        model.addObject("materialType",materialTypeDao.findById(id));
    }

    public void addMaterial(ModelAndView model, Long id) {
        try {
            model.addObject("material",materialDao.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMaterialWaitingApprove(ModelAndView model) {
        try {
            model.addObject("materialsWaitingApprove",materialDao.findByMaterialStatus(new String[] {"CREATE_MATERIAL_DOCUMENT_FULL", "UPDATE_MATERIAL_DOCUMENT_FULL"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMaterialAdditionalOrReject(ModelAndView model) {
        try {
            model.addObject("materialsAdditionalOrReject",materialDao.findByMaterialStatus(new String[] {"UPDATE_MATERIAL_DOCUMENT_NOT_FULL", "CREATE_MATERIAL_DOCUMENT_NOT_FULL", "REJECT_MATERIAL"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMaterialApproveList(ModelAndView model) {
        try {
            model.addObject("materialsApproveList",materialDao.findByMaterialStatus(new String[] {"APPROVE_MATERIAL"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMaterialsExpired(ModelAndView model) {
        try {
            model.addObject("materialsExpiredList",materialDao.findAllMaterialGe(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCustomerList(ModelAndView model) {
        try {
            model.addObject("customers", customerDao.findAllCustomer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFaRequestStatusCreate(ModelAndView model) {
        try {
            model.addObject("faStatusCreateList", faRequestDao.findByStatus("CREATE_FA_REQUEST"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFaRequest(ModelAndView model, Long id) {
        try {
            model.addObject("faRequest", faRequestDao.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFaByUserList(ModelAndView model, AppUser appUser) {
        try {
            model.addObject("faByUserList", faRequestDao.findByCreateBy(appUser));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
