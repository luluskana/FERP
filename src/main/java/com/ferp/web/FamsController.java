package com.ferp.web;

import com.ferp.dao.AppUserDao;
import com.ferp.dao.FaRequestDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.FaRequest;
import com.ferp.domain.FileData;
import com.ferp.service.FamsService;
import com.ferp.service.ViewService;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private FamsService famsService;

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

    @RequestMapping(value = "/fams/report", method = RequestMethod.GET)
    public ModelAndView famsReport(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addGraphSummary(model);
        model.setViewName("FAMS/report");
        return model;
    }

    @RequestMapping(value = "/fams/qareport", method = RequestMethod.GET)
    public ModelAndView qafamsReport(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        viewService.addGraphFa(model);
        model.setViewName("FAMS/faSummary");
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
            viewService.addFaByUserListAndStatusForUpdate(model, appUser);
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

    @RequestMapping(value = "/fams/listReferSubmit", method = RequestMethod.GET)
    public ModelAndView listForReferSubmit(ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            viewService.addFaByUserListReferSubmit(model, appUser);
            if(appUser.getRoleName().equals("saleCo") || appUser.getRoleName().equals("saleOut") || appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/listForResubmit");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/listForResubmit");
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

    @RequestMapping(value = "/fams/reference/{id}", method = RequestMethod.GET)
    public ModelAndView createReferFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("saleCo") || appUser.getRoleName().equals("saleOut") || appUser.getRoleName().equals("admin")) {
                model.addObject("faRequest", faRequestDao.findByIdAndCreateBy(id, appUser));
                model.setViewName("FAMS/referSubmitCreate");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.addObject("faRequest", faRequestDao.findById(id));
            model.setViewName("FAMS/referSubmitCreate");
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

    @RequestMapping(value = "/fams/listSaleOutFollow", method = RequestMethod.GET)
    public ModelAndView listSaleOutFollowView(ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            model.addObject("faStatusSaleCoFollowUp", faRequestDao.findByStatusAndUserSaleOut("SALE_CO_FOLLOW_UP_FA_REQUEST", appUser.getName()));
            if(appUser.getRoleName().equals("saleOut") ||  appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/listSaleOutFollow");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/listSaleOutFollow");
        }
        return model;
    }

    @RequestMapping(value = "/fams/saleOutFollow/{id}", method = RequestMethod.GET)
    public ModelAndView saleOutFollowFarequest(@PathVariable("id") Long id, ModelAndView model, Principal principal) {
        viewService.addMenuAndName(model, principal);
        model.addObject("faRequest", faRequestDao.findById(id));
        try {
            AppUser appUser = appUserDao.findByUsername(principal.getName());
            if(appUser.getRoleName().equals("saleOut") ||  appUser.getRoleName().equals("admin")) {
                model.setViewName("FAMS/saleOutFollow");
            } else {
                model.setViewName("404");
            }
        } catch (Exception e) {
            model.setViewName("FAMS/saleOutFollow");
        }
        return model;
    }

    @RequestMapping(value = "/fams/search", method = RequestMethod.GET)
    public ModelAndView search(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        model.addObject("faRequestAllList", faRequestDao.findAll());
        model.setViewName("FAMS/search");
        return model;
    }

    @RequestMapping(value = "/fams/approveList", method = RequestMethod.GET)
    public ModelAndView approveList(ModelAndView model, Principal principal) {
        try {
            principal.getName();
            viewService.addMenuAndName(model, principal);
        } catch (Exception e) {
            viewService.addLogin(model);
        }
        model.addObject("faRequestApproveList", faRequestDao.findByStatus(new String[] {"SALE_OUT_APPROVE_FA_REQUEST"}));
        model.setViewName("FAMS/approveList");
        return model;
    }

    @RequestMapping(value = "/fams/excelReport", method = RequestMethod.GET)
    @ResponseBody
    public void excelReport(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, HttpServletResponse response) {
        try {
            FileData fileData = famsService.getExcelFile(convertToDate(startDate), convertToDate(endDate));
            response.setContentType(fileData.getContentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + fileData.getFileName());
            response.getOutputStream().write(fileData.getDataFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/fams/createreport/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void downloadReport(@PathVariable("id") Long id, HttpServletResponse response) {
        try {
            FaRequest faRequest = faRequestDao.findById(id);
            JRCsvDataSource ds = new JRCsvDataSource(new File("Report/data.csv"));
            ds.setColumnNames(new String[] {"id", "name", "salary"});
            String fileName = "Report/statusCreate/report1.jasper";

            Map map = new HashMap();
            map.put("faNumber", faRequest.getFaNumber());
            map.put("customer", faRequest.getCustomer());
            map.put("partNo", faRequest.getPartNo());
            map.put("partName", faRequest.getPartName());
            map.put("revision", faRequest.getRevision());
            map.put("qwsNo", faRequest.getQwsNo());
            map.put("apqpNo", faRequest.getApqpNo());
            map.put("needDate", faRequest.getNeedDate());
            map.put("faApprove", faRequest.getFaApproveQty());
            map.put("faForSell", faRequest.getFaForSellQty());
            map.put("sampleTest", faRequest.getSamplTestQty());
            map.put("samplePCC", faRequest.getSamplePccQty());
            map.put("samplePCC", faRequest.getSamplePccQty());
            map.put("material1", faRequest.getMaterial1());
            map.put("material2", faRequest.getMaterial2());
            map.put("material3", faRequest.getMaterial3());
            map.put("material4", faRequest.getMaterial4());
            map.put("material5", faRequest.getMaterial5());
            map.put("documentRequest", faRequest.getDocumentRequest());
            map.put("tools", faRequest.getTool());
            String[] str = faRequest.getRemark().split("\n");
            int i = 1;
            for(String s : str) {
                map.put("remark" + i, s);
                i++;
            }
            map.put("saleOut", faRequest.getSaleOut());
            map.put("requestBy", faRequest.getCreateBy().getName());
            map.put("requestDate", faRequest.getCreateDate());
            JasperPrint jasperPrint = JasperFillManager.fillReport(fileName, map, ds);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline;filename=" + faRequest.getFaNumber() + ".pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date convertToDate(String dateString) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }
}
