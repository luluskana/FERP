package com.ferp.service;

import com.ferp.dao.MaterialDao;
import com.ferp.dao.MaterialTypeDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.Material;
import com.ferp.domain.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            model.addObject("materialsAdditionalOrReject",materialDao.findByMaterialStatus(new String[] {"UPDATE_MATERIAL_DOCUMENT_NOT_FULL", "CREATE_MATERIAL_DOCUMENT_NOT_FULL"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
