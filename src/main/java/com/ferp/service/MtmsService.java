package com.ferp.service;

import com.ferp.dao.AppUserDao;
import com.ferp.dao.MaterialTypeDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.LogHistory;
import com.ferp.domain.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.security.Principal;
import java.util.Date;
import java.util.Set;

/**
 * Created by apichat on 11/2/2016 AD.
 */
@Service
public class MtmsService {

    @Autowired
    private MaterialTypeDao materialTypeDao;

    @Autowired
    private AppUserDao appUserDao;

    public MaterialType createMaterialType(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String typeName = multipartHttpServletRequest.getParameter("typeName");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            AppUser appUser = appUserDao.findByUsername(principal.getName());

            MaterialType materialType = new MaterialType();
            materialType.setCreateDate(new Date());
            materialType.setCreateBy(appUser);
            materialType.setTypeName(typeName);

            Set<LogHistory> logHistories = materialType.getLogHistories();
            LogHistory logHistory = new LogHistory();
            logHistory.setCreateDate(new Date());
            logHistory.setCreateBy(appUser);
            logHistory.setActionTYpe("Create Material Type");
            logHistory.setStatus("CREATE_MATERIAL_TYPE");
            logHistory.setMaterialType(materialType);
            logHistories.add(logHistory);

            materialType.setLogHistories(logHistories);
            materialTypeDao.create(materialType);

            return materialType;
        } catch (Exception e) {
            return null;
        }
    }

    public MaterialType updateMaterialType(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = multipartHttpServletRequest.getParameter("id");
            String typeName = multipartHttpServletRequest.getParameter("typeName");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            AppUser appUser = appUserDao.findByUsername(principal.getName());

            MaterialType materialType = materialTypeDao.findById(Long.parseLong(id));
            materialType.setUpdateDate(new Date());
            materialType.setUpdateBy(appUser);
            materialType.setTypeName(typeName);

            Set<LogHistory> logHistories = materialType.getLogHistories();
            LogHistory logHistory = new LogHistory();
            logHistory.setCreateDate(new Date());
            logHistory.setCreateBy(appUser);
            logHistory.setActionTYpe("Create Update Type");
            logHistory.setStatus("UPDATE_MATERIAL_TYPE");
            logHistory.setMaterialType(materialType);
            logHistories.add(logHistory);

            materialType.setLogHistories(logHistories);
            materialTypeDao.update(materialType);
            return materialType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteMaterialType(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = multipartHttpServletRequest.getParameter("id");
            materialTypeDao.delete(Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
