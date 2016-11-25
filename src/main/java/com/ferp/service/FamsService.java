package com.ferp.service;

import com.ferp.dao.AppUserDao;
import com.ferp.dao.FaRequestDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.FaRequest;
import com.ferp.domain.InformationFileData;
import com.ferp.domain.LogHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by apichat on 11/17/2016 AD.
 */
@Service
public class FamsService {

    @Autowired
    private FaRequestDao faRequestDao;

    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private InformationFileDataService informationFileDataService;

    public void createFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String customer = validateString(multipartHttpServletRequest.getParameter("customer"));
            String partNo = validateString(multipartHttpServletRequest.getParameter("partNo"));
            String partName = validateString(multipartHttpServletRequest.getParameter("partName"));
            String revision = validateString(multipartHttpServletRequest.getParameter("revision"));
            String saleOut = validateString(multipartHttpServletRequest.getParameter("saleOut"));
            String qwsNo = validateString(multipartHttpServletRequest.getParameter("qwsNo"));
            String apqaNo = validateString(multipartHttpServletRequest.getParameter("apqaNo"));
            String needDate = validateString(multipartHttpServletRequest.getParameter("needDate"));
            String faApproveQty = multipartHttpServletRequest.getParameter("faApproveQty");
            String faForSellQty = multipartHttpServletRequest.getParameter("faForSellQty");
            String sampleTestQty = multipartHttpServletRequest.getParameter("sampleTestQty");
            String samplePccQty =  multipartHttpServletRequest.getParameter("samplePccQty");
            String material1 = validateString(multipartHttpServletRequest.getParameter("material1"));
            String material2 = validateString(multipartHttpServletRequest.getParameter("material2"));
            String material3 = validateString(multipartHttpServletRequest.getParameter("material3"));
            String material4 = validateString(multipartHttpServletRequest.getParameter("material4"));
            String material5 = validateString(multipartHttpServletRequest.getParameter("material5"));
            String material6 = validateString(multipartHttpServletRequest.getParameter("material6"));
            String documentRequest = validateString(multipartHttpServletRequest.getParameter("documentRequest"));
            String tools = validateString(multipartHttpServletRequest.getParameter("tools"));
            String remark = validateString(multipartHttpServletRequest.getParameter("remark"));
            MultipartFile drawingFile = multipartHttpServletRequest.getFile("drawingFile");
            MultipartFile otherFile = multipartHttpServletRequest.getFile("otherFile");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            AppUser appUser = appUserDao.findByUsername(principal.getName());

            FaRequest faRequest = new FaRequest();
            Set<LogHistory> logHistories = faRequest.getLogHistories();
            LogHistory logHistory = new LogHistory();

            faRequestDao.create(faRequest);

            faRequest.setFaNumber("FA" + String.format("%06d", faRequest.getId()));
            faRequest.setCreateDate(new Date());

            logHistory.setCreateDate(new Date());
            if(appUser != null) {
                faRequest.setCreateBy(appUser);
                logHistory.setCreateBy(appUser);
            }
            faRequest.setCustomer(customer);
            faRequest.setPartNo(partNo);
            faRequest.setPartName(partName);
            faRequest.setRevision(revision);
            faRequest.setSaleOut(saleOut);
            faRequest.setQwsNo(qwsNo);
            faRequest.setApqpNo(apqaNo);
            faRequest.setNeedDate(convertToDate(needDate));

            if(faApproveQty.length() > 0) {
                faRequest.setFaApproveQty(Integer.parseInt(faApproveQty));
            } else {
                faRequest.setFaApproveQty(0);
            }
            if(faForSellQty.length() > 0) {
                faRequest.setFaForSellQty(Integer.parseInt(faForSellQty));
            } else {
                faRequest.setFaForSellQty(0);
            }
            if(sampleTestQty.length() > 0) {
                faRequest.setSamplTestQty(Integer.parseInt(sampleTestQty));
            } else {
                faRequest.setSamplTestQty(0);
            }
            if(samplePccQty.length() > 0) {
                faRequest.setSamplePccQty(Integer.parseInt(samplePccQty));
            } else {
                faRequest.setSamplePccQty(0);
            }

            faRequest.setMaterial1(material1);
            faRequest.setMaterial2(material2);
            faRequest.setMaterial3(material3);
            faRequest.setMaterial4(material4);
            faRequest.setMaterial5(material5);
            faRequest.setMaterial6(material6);
            faRequest.setDocumentRequest(documentRequest);
            faRequest.setTool(tools);
            faRequest.setRemark(remark);
            faRequest.setStatus("CREATE_FA_REQUEST");

            if(drawingFile != null) {
                Long idInsert = saveFile(drawingFile.getBytes(), drawingFile.getOriginalFilename(), drawingFile.getContentType());
                faRequest.setDrawingFile(idInsert);
                logHistory.setDrawingFile(idInsert);
            }

            if(otherFile != null) {
                Long idInsert = saveFile(otherFile.getBytes(), otherFile.getOriginalFilename(), otherFile.getContentType());
                faRequest.setOtherFile(idInsert);
                logHistory.setOtherFile(idInsert);
            }

            logHistory.setStatus("CREATE_FA_REQUEST");
            logHistory.setFaRequest(faRequest);
            logHistories.add(logHistory);
            faRequest.setLogHistories(logHistories);
            faRequestDao.update(faRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = validateString(multipartHttpServletRequest.getParameter("id"));
            String customer = validateString(multipartHttpServletRequest.getParameter("customer"));
            String partNo = validateString(multipartHttpServletRequest.getParameter("partNo"));
            String partName = validateString(multipartHttpServletRequest.getParameter("partName"));
            String revision = validateString(multipartHttpServletRequest.getParameter("revision"));
            String saleOut = validateString(multipartHttpServletRequest.getParameter("saleOut"));
            String qwsNo = validateString(multipartHttpServletRequest.getParameter("qwsNo"));
            String apqaNo = validateString(multipartHttpServletRequest.getParameter("apqaNo"));
            String needDate = validateString(multipartHttpServletRequest.getParameter("needDate"));
            String faApproveQty = multipartHttpServletRequest.getParameter("faApproveQty");
            String faForSellQty = multipartHttpServletRequest.getParameter("faForSellQty");
            String sampleTestQty = multipartHttpServletRequest.getParameter("sampleTestQty");
            String samplePccQty =  multipartHttpServletRequest.getParameter("samplePccQty");
            String material1 = validateString(multipartHttpServletRequest.getParameter("material1"));
            String material2 = validateString(multipartHttpServletRequest.getParameter("material2"));
            String material3 = validateString(multipartHttpServletRequest.getParameter("material3"));
            String material4 = validateString(multipartHttpServletRequest.getParameter("material4"));
            String material5 = validateString(multipartHttpServletRequest.getParameter("material5"));
            String material6 = validateString(multipartHttpServletRequest.getParameter("material6"));
            String documentRequest = validateString(multipartHttpServletRequest.getParameter("documentRequest"));
            String tools = validateString(multipartHttpServletRequest.getParameter("tools"));
            String remark = validateString(multipartHttpServletRequest.getParameter("remark"));
            MultipartFile drawingFile = multipartHttpServletRequest.getFile("drawingFile");
            MultipartFile otherFile = multipartHttpServletRequest.getFile("otherFile");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            AppUser appUser = appUserDao.findByUsername(principal.getName());

            FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));

            Set<LogHistory> logHistories = faRequest.getLogHistories();
            LogHistory logHistory = new LogHistory();

            logHistory.setCreateDate(new Date());
            if(appUser != null) {
                faRequest.setUpdateBy(appUser);
                logHistory.setCreateBy(appUser);
            }
            faRequest.setCustomer(customer);
            faRequest.setPartNo(partNo);
            faRequest.setPartName(partName);
            faRequest.setRevision(revision);
            faRequest.setSaleOut(saleOut);
            faRequest.setQwsNo(qwsNo);
            faRequest.setApqpNo(apqaNo);
            faRequest.setNeedDate(convertToDate(needDate));

            if(faApproveQty.length() > 0) {
                faRequest.setFaApproveQty(Integer.parseInt(faApproveQty));
            } else {
                faRequest.setFaApproveQty(0);
            }
            if(faForSellQty.length() > 0) {
                faRequest.setFaForSellQty(Integer.parseInt(faForSellQty));
            } else {
                faRequest.setFaForSellQty(0);
            }
            if(sampleTestQty.length() > 0) {
                faRequest.setSamplTestQty(Integer.parseInt(sampleTestQty));
            } else {
                faRequest.setSamplTestQty(0);
            }
            if(samplePccQty.length() > 0) {
                faRequest.setSamplePccQty(Integer.parseInt(samplePccQty));
            } else {
                faRequest.setSamplePccQty(0);
            }

            faRequest.setMaterial1(material1);
            faRequest.setMaterial2(material2);
            faRequest.setMaterial3(material3);
            faRequest.setMaterial4(material4);
            faRequest.setMaterial5(material5);
            faRequest.setMaterial6(material6);
            faRequest.setDocumentRequest(documentRequest);
            faRequest.setTool(tools);
            faRequest.setRemark(remark);
            faRequest.setStatus("UPDATE_FA_REQUEST");

            if(drawingFile != null) {
                Long idInsert = saveFile(drawingFile.getBytes(), drawingFile.getOriginalFilename(), drawingFile.getContentType());
                faRequest.setDrawingFile(idInsert);
                logHistory.setDrawingFile(idInsert);
            } else {
                faRequest.setDrawingFile(null);
            }

            if(otherFile != null) {
                Long idInsert = saveFile(otherFile.getBytes(), otherFile.getOriginalFilename(), otherFile.getContentType());
                faRequest.setOtherFile(idInsert);
                logHistory.setOtherFile(idInsert);
            } else {
                faRequest.setOtherFile(null);
            }

            logHistory.setStatus("UPDATE_FA_REQUEST");
            logHistory.setFaRequest(faRequest);
            logHistories.add(logHistory);
            faRequest.setLogHistories(logHistories);
            faRequestDao.update(faRequest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String validateString(String data) {
        if(data == null || data.length() < 1) {
            return "na";
        } else {
            return data;
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

    public Long saveFile(byte[] stream, String fileName, String contentType) throws IOException {
        InformationFileData informationFileData = informationFileDataService.createFile(fileName, contentType);
        String workingDir = System.getProperty("user.dir") + "/fileData";
        File convFile = new File(workingDir + informationFileData.getUrl());
        convFile.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(stream);
        fos.close();
        return informationFileData.getId();
    }

    public void engineerApproveFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String commitDate = multipartHttpServletRequest.getParameter("commitDate");
        String process = multipartHttpServletRequest.getParameter("process");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        faRequest.setEngineerCommitDate(convertToDate(commitDate));
        faRequest.setProcess(process);
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = new LogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("ENGINEER_APPROVE_FA_REQUEST");
        logHistory.setStatus("ENGINEER_APPROVE_FA_REQUEST");
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void engineerWaitingFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = new LogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("ENGINEER_WAITING_FA_REQUEST");
        logHistory.setStatus("ENGINEER_WAITING_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void engineerRejectFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = new LogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("ENGINEER_REJECT_FA_REQUEST");
        logHistory.setStatus("ENGINEER_REJECT_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void saleCancelFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = new LogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("SALE_CANCEL_FA_REQUEST");
        logHistory.setStatus("SALE_CANCEL_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void engineerSendFirstFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String method = multipartHttpServletRequest.getParameter("method");
        String materialSlip = multipartHttpServletRequest.getParameter("materialSlip");
        String qtyFirst = multipartHttpServletRequest.getParameter("qtyFirst");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = new LogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("ENGINEER_SEND_FIRST_FA_REQUEST");
        logHistory.setStatus("ENGINEER_SEND_FIRST_FA_REQUEST");
        logHistory.setQtyFirst(Integer.parseInt(qtyFirst));
        logHistory.setSlipMatNo(materialSlip);
        logHistory.setMethodFirst(method);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }
}
