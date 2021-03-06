package com.ferp.service;

import com.ferp.dao.AppUserDao;
import com.ferp.dao.FaRequestDao;
import com.ferp.dao.LogHistoryDao;
import com.ferp.dao.ReferenceFaDao;
import com.ferp.domain.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileNotFoundException;
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

    @Autowired
    private DownloadFileServiec downloadFileServiec;

    @Autowired
    private LogHistoryDao logHistoryDao;

    @Autowired
    private ReferenceFaDao referenceFaDao;

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
            LogHistory logHistory = logHistoryDao.getNewLogHistory();

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

    public void createReferFa(MultipartHttpServletRequest multipartHttpServletRequest) {
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

            FaRequest faRequest = new FaRequest();
            Set<LogHistory> logHistories = faRequest.getLogHistories();
            LogHistory logHistory = logHistoryDao.getNewLogHistory();

            faRequestDao.create(faRequest);

            faRequest.setFaNumber("FA" + String.format("%06d", faRequest.getId()));
            faRequest.setCreateDate(new Date());

            FaRequest faRequestRefer = faRequestDao.findById(Long.parseLong(id));
            Set<ReferenceFa> fas = faRequest.getReferenceFas();

            Set<ReferenceFa> fasOld = faRequestRefer.getReferenceFas();
            for(ReferenceFa f : fasOld) {
                ReferenceFa referenceFaInfor = referenceFaDao.getReferenceFa();
                referenceFaInfor.setCreateDate(new Date());
                referenceFaInfor.setFaRequestRefer(faRequestDao.findById(f.getFaRequestRefer().getId()));
                referenceFaInfor.setFaRequest(faRequest);
                fas.add(referenceFaInfor);
                faRequest.setReferenceFas(fas);
                faRequestDao.update(faRequest);
            }
            ReferenceFa referenceFa = referenceFaDao.getReferenceFa();
            referenceFa.setCreateDate(new Date());
            referenceFa.setFaRequestRefer(faRequestRefer);
            referenceFa.setFaRequest(faRequest);
            fas.add(referenceFa);
            faRequest.setReferenceFas(fas);

            Set<LogHistory> logHistoriesFarefer = faRequestRefer.getLogHistories();
            LogHistory logHistoryFaRefer = logHistoryDao.getNewLogHistory();
            logHistoryFaRefer.setCreateDate(new Date());
            logHistoryFaRefer.setCreateBy(appUser);
            logHistoryFaRefer.setStatus("CREATE_FA_REQUEST_REFER");
            logHistoryFaRefer.setFaRequest(faRequest);
            logHistoriesFarefer.add(logHistoryFaRefer);
            faRequestRefer.setStatus("CREATE_FA_REQUEST_REFER");
            faRequestRefer.setLogHistories(logHistoriesFarefer);
            faRequestDao.update(faRequestRefer);

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
            LogHistory logHistory = logHistoryDao.getNewLogHistory();

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
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
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
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
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
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
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
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
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
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
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

    public void engineerCancelFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("ENGINEER_CANCEL_FA_REQUEST");
        logHistory.setStatus("ENGINEER_CANCEL_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void qaApproveFirstFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("QA_APPROVE_FIRST_FA_REQUEST");
        logHistory.setStatus("QA_APPROVE_FIRST_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void qaRejectFirstFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("QA_REJECT_FIRST_FA_REQUEST");
        logHistory.setStatus("QA_REJECT_FIRST_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void engineerSendFinalFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String method = multipartHttpServletRequest.getParameter("method");
        String materialSlip = multipartHttpServletRequest.getParameter("materialSlip");
        String qtyFirst = multipartHttpServletRequest.getParameter("qtyFirst");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("ENGINEER_SEND_FINAL_FA_REQUEST");
        logHistory.setStatus("ENGINEER_SEND_FINAL_FA_REQUEST");
        logHistory.setQtyFirst(Integer.parseInt(qtyFirst));
        logHistory.setSlipMatNo(materialSlip);
        logHistory.setMethodFirst(method);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void qaApproveFinalFa(MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        MultipartFile file1 = multipartHttpServletRequest.getFile("file1");
        MultipartFile file2 = multipartHttpServletRequest.getFile("file2");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }

        if(file1 != null) {
            Long idInsert = saveFile(file1.getBytes(), file1.getOriginalFilename(), file1.getContentType());
            faRequest.setFileData1(idInsert);
            logHistory.setFileData1(idInsert);
        }
        if(file2 != null) {
            Long idInsert = saveFile(file2.getBytes(), file2.getOriginalFilename(), file2.getContentType());
            faRequest.setFileData2(idInsert);
            logHistory.setFileData2(idInsert);
        }

        faRequest.setStatus("QA_APPROVE_FINAL_FA_REQUEST");
        logHistory.setStatus("QA_APPROVE_FINAL_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void qaWaitingFinalFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("QA_WAITING_FINAL_FA_REQUEST");
        logHistory.setStatus("QA_WAITING_FINAL_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void qaRejectFinalFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("QA_REJECT_FINAL_FA_REQUEST");
        logHistory.setStatus("QA_REJECT_FINAL_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void qaApproveDocumentFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("QA_APPROVE_DOCUMENT_FA_REQUEST");
        logHistory.setStatus("QA_APPROVE_DOCUMENT_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void qaRejectDocumentFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("QA_REJECT_DOCUMENT_FA_REQUEST");
        logHistory.setStatus("QA_REJECT_DOCUMENT_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void saleCoFollowUpFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String contractName = multipartHttpServletRequest.getParameter("contractName");
        String invoice = multipartHttpServletRequest.getParameter("invoice");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setContractName(contractName);
        faRequest.setInvoice(invoice);
        faRequest.setStatus("SALE_CO_FOLLOW_UP_FA_REQUEST");
        logHistory.setStatus("SALE_CO_FOLLOW_UP_FA_REQUEST");
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void saleOutApproveFa(MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
        String id = multipartHttpServletRequest.getParameter("id");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        MultipartFile file = multipartHttpServletRequest.getFile("inputFile1");
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        if(file != null) {
            Long idInsert = saveFile(file.getBytes(), file.getOriginalFilename(), file.getContentType());
            faRequest.setFileCustomerApprove(idInsert);
            logHistory.setFileCustomerApprove(idInsert);
        }
        faRequest.setStatus("SALE_OUT_APPROVE_FA_REQUEST");
        logHistory.setStatus("SALE_OUT_APPROVE_FA_REQUEST");
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void saleOutRejectFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("SALE_OUT_REJECT_FA_REQUEST");
        logHistory.setStatus("SALE_OUT_REJECT_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public void saleOutResubmitFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        String reason = multipartHttpServletRequest.getParameter("reason");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        FaRequest faRequest = faRequestDao.findById(Long.parseLong(id));
        Set<LogHistory> logHistories = faRequest.getLogHistories();
        LogHistory logHistory = logHistoryDao.getNewLogHistory();
        logHistory.setCreateDate(new Date());
        if(appUser != null) {
            faRequest.setUpdateBy(appUser);
            logHistory.setCreateBy(appUser);
        }
        faRequest.setStatus("SALE_OUT_RESUBMIT_FA_REQUEST");
        logHistory.setStatus("SALE_OUT_RESUBMIT_FA_REQUEST");
        logHistory.setRemark(reason);
        logHistory.setFaRequest(faRequest);
        logHistories.add(logHistory);
        faRequest.setLogHistories(logHistories);
        faRequestDao.update(faRequest);
    }

    public FileData getExcelFile(Date startDate, Date endDate) throws IOException {

        List<FaRequest> faRequestList = faRequestDao.findByStartDateAndEndDate(startDate, endDate);

        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row1 = sheet.createRow(0);

        row1.createCell(0).setCellValue("FA Number");
        row1.createCell(1).setCellValue("Request Date");
        row1.createCell(2).setCellValue("Customer");
        row1.createCell(3).setCellValue("Part Number");
        row1.createCell(4).setCellValue("Part Name");
        row1.createCell(5).setCellValue("Sale Out");
        row1.createCell(6).setCellValue("FA Approve");
        row1.createCell(7).setCellValue("FA For Sell");
        row1.createCell(8).setCellValue("Sample Test");
        row1.createCell(9).setCellValue("Sample Pcc");

        int rowIndex = 1;
        for(FaRequest faRequest: faRequestList) {
            Row row = sheet.createRow(rowIndex);

            row.createCell(0).setCellValue(faRequest.getFaNumber());
            row.createCell(1).setCellValue("'" + convertDateToString(faRequest.getCreateDate()));
            row.createCell(2).setCellValue(faRequest.getCustomer());
            row.createCell(3).setCellValue(faRequest.getPartNo());
            row.createCell(4).setCellValue(faRequest.getPartName());
            row.createCell(5).setCellValue(faRequest.getSaleOut());
            row.createCell(6).setCellValue(faRequest.getFaApproveQty());
            row.createCell(7).setCellValue(faRequest.getFaForSellQty());
            row.createCell(8).setCellValue(faRequest.getSamplTestQty());
            row.createCell(9).setCellValue(faRequest.getSamplePccQty());

            rowIndex = rowIndex + 1;
        }

        for (int i=0; i < 10; i++){
            sheet.autoSizeColumn(i);
        }

        String workingDir = System.getProperty("user.dir") + "/fileExcel/";
        File convFile = new File(workingDir + "workbook.xlsx");
        convFile.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(convFile);
        wb.write(fos);
        fos.close();
        return downloadFileServiec.getExcelFile();
    }

    public String convertDateToString(Date date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.format(date);
        } catch (Exception e) {
            return null;
        }
    }
}
