package com.ferp.service;

import com.ferp.dao.*;
import com.ferp.domain.*;
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

    @Autowired
    private LogHistoryDao logHistoryDao;

    @Autowired
    private SapCodeDao sapCodeDao;

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
            model.addObject("appUser", appUser);
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

    public void addSapCode(ModelAndView model) {
        try {
            model.addObject("sapCodes", sapCodeDao.findAll());
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
            model.addObject("faStatusCreateList", faRequestDao.findByStatus(new String[] {"CREATE_FA_REQUEST", "UPDATE_FA_REQUEST"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFaRequestStatusEngineerApprove(ModelAndView model) {
        try {
            model.addObject("faStatusEngineerApprove", faRequestDao.findByStatus(new String[] {"ENGINEER_APPROVE_FA_REQUEST"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFaRequestStatusEngineerWaiting(ModelAndView model) {
        try {
            model.addObject("faStatusEngineerWaiting", faRequestDao.findByStatus(new String[] {"ENGINEER_WAITING_FA_REQUEST"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFaRequestStatusEngineerReject(ModelAndView model) {
        try {
            model.addObject("faStatusEngineerReject", faRequestDao.findByStatus(new String[] {"ENGINEER_REJECT_FA_REQUEST"}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFaRequestStatusEngineerSendFirstShot(ModelAndView model) {
        try {
            model.addObject("faStatusEngineerSendFirstShot", faRequestDao.findByStatus(new String[] {"ENGINEER_SEND_FIRST_FA_REQUEST"}));
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

    public void addGraphSummary(ModelAndView model) {

        model.addObject("january", faRequestDao.findByStartDateAndEndDate(getDate("start", 0), getDate("end", 0)).size());
        model.addObject("february", faRequestDao.findByStartDateAndEndDate(getDate("start", 1), getDate("end", 1)).size());
        model.addObject("march", faRequestDao.findByStartDateAndEndDate(getDate("start", 2), getDate("end", 2)).size());
        model.addObject("april", faRequestDao.findByStartDateAndEndDate(getDate("start", 3), getDate("end", 3)).size());
        model.addObject("may", faRequestDao.findByStartDateAndEndDate(getDate("start", 4), getDate("end", 4)).size());
        model.addObject("june", faRequestDao.findByStartDateAndEndDate(getDate("start", 5), getDate("end", 5)).size());
        model.addObject("july", faRequestDao.findByStartDateAndEndDate(getDate("start", 6), getDate("end", 6)).size());
        model.addObject("august", faRequestDao.findByStartDateAndEndDate(getDate("start", 7), getDate("end", 7)).size());
        model.addObject("september", faRequestDao.findByStartDateAndEndDate(getDate("start", 8), getDate("end", 8)).size());
        model.addObject("october", faRequestDao.findByStartDateAndEndDate(getDate("start", 9), getDate("end", 9)).size());
        model.addObject("november", faRequestDao.findByStartDateAndEndDate(getDate("start", 10), getDate("end", 10)).size());
        model.addObject("december", faRequestDao.findByStartDateAndEndDate(getDate("start", 11), getDate("end", 11)).size());

    }

    public void addGraphFa(ModelAndView model) {

        model.addObject("qaRejectFirstShotJanuary", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 0), getDate("end", 0), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotFebruary", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 1), getDate("end", 1), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotMarch", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 2), getDate("end", 2), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotApril", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 3), getDate("end", 3), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotMay", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 4), getDate("end", 4), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotJune", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 5), getDate("end", 5), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotJuly", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 6), getDate("end", 6), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotAugust", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 7), getDate("end", 7), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotSeptember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 8), getDate("end", 8), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotOctober", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 9), getDate("end", 9), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotNovember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 10), getDate("end", 10), "QA_REJECT_FIRST_FA_REQUEST").size());
        model.addObject("qaRejectFirstShotDecember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 11), getDate("end", 11), "QA_REJECT_FIRST_FA_REQUEST").size());

        model.addObject("qaApproveFirstShotJanuary", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 0), getDate("end", 0), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotFebruary", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 1), getDate("end", 1), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotMarch", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 2), getDate("end", 2), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotApril", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 3), getDate("end", 3), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotMay", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 4), getDate("end", 4), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotJune", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 5), getDate("end", 5), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotJuly", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 6), getDate("end", 6), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotAugust", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 7), getDate("end", 7), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotSeptember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 8), getDate("end", 8), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotOctober", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 9), getDate("end", 9), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotNovember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 10), getDate("end", 10), "QA_APPROVE_FIRST_FA_REQUEST").size());
        model.addObject("qaApproveFirstShotDecember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 11), getDate("end", 11), "QA_APPROVE_FIRST_FA_REQUEST").size());

        model.addObject("qaRejectFinalJanuary", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 0), getDate("end", 0), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalFebruary", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 1), getDate("end", 1), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalMarch", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 2), getDate("end", 2), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalApril", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 3), getDate("end", 3), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalMay", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 4), getDate("end", 4), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalJune", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 5), getDate("end", 5), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalJuly", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 6), getDate("end", 6), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalAugust", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 7), getDate("end", 7), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalSeptember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 8), getDate("end", 8), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalOctober", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 9), getDate("end", 9), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalNovember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 10), getDate("end", 10), "QA_REJECT_FINAL_FA_REQUEST").size());
        model.addObject("qaRejectFinalDecember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 11), getDate("end", 11), "QA_REJECT_FINAL_FA_REQUEST").size());

        model.addObject("qaApproveFinalJanuary", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 0), getDate("end", 0), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalFebruary", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 1), getDate("end", 1), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalMarch", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 2), getDate("end", 2), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalApril", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 3), getDate("end", 3), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalMay", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 4), getDate("end", 4), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalJune", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 5), getDate("end", 5), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalJuly", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 6), getDate("end", 6), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalAugust", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 7), getDate("end", 7), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalSeptember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 8), getDate("end", 8), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalOctober", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 9), getDate("end", 9), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalNovember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 10), getDate("end", 10), "QA_APPROVE_FINAL_FA_REQUEST").size());
        model.addObject("qaApproveFinalDecember", logHistoryDao.findByStartDateEndDateAndStatus(getDate("start", 11), getDate("end", 11), "QA_APPROVE_FINAL_FA_REQUEST").size());

    }

    public Date getDate(String month, int m) {

        Calendar calCurrent = Calendar.getInstance();
        calCurrent.setTime(new Date());
        int year = calCurrent.get(Calendar.YEAR);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);

        if(month.equals("start")) {
            cal.set(Calendar.MONTH, m);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            return cal.getTime();
        } else if(month.equals("end")) {
            cal.set(Calendar.MONTH, m);
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            return cal.getTime();
        } else {
            return null;
        }
    }
}
