package com.ferp.service;

import com.ferp.dao.AppUserDao;
import com.ferp.dao.MaterialDao;
import com.ferp.dao.MaterialTypeDao;
import com.ferp.dao.SapCodeDao;
import com.ferp.domain.*;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by apichat on 11/2/2016 AD.
 */
@Service
public class MtmsService {

    @Autowired
    private MaterialTypeDao materialTypeDao;

    @Autowired
    private AppUserDao appUserDao;

    @Autowired
    private InformationFileDataService informationFileDataService;

    @Autowired
    private MaterialDao materialDao;

    @Autowired
    private SapCodeDao sapCodeDao;

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

    public Material createMaterial(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = multipartHttpServletRequest.getParameter("id");
            String materialName = multipartHttpServletRequest.getParameter("inputMaterialName");
            String manufacturing = multipartHttpServletRequest.getParameter("inputManufacturing");
            String ulNumber = multipartHttpServletRequest.getParameter("inputUlNumber");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            AppUser appUser = appUserDao.findByUsername(principal.getName());

            MultipartFile spec = multipartHttpServletRequest.getFile("inputSpec");
            MultipartFile rohs = multipartHttpServletRequest.getFile("inputRoHs");
            MultipartFile msds = multipartHttpServletRequest.getFile("inputMSDS");
            MultipartFile halogen = multipartHttpServletRequest.getFile("inputHalogen");
            MultipartFile guaranteeLetter = multipartHttpServletRequest.getFile("inputGuarantee");
            MultipartFile redPhosphorus = multipartHttpServletRequest.getFile("inputRedPhosphorus");

            String dateRohs = multipartHttpServletRequest.getParameter("inputDateRoHs");
            String dateHalogen = multipartHttpServletRequest.getParameter("inputDateHF");

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();

            MaterialType materialType = materialTypeDao.findById(Long.parseLong(id));
            Material material = new Material();

            Set<LogHistory> logHistories = material.getLogHistories();
            LogHistory logHistory = new LogHistory();

            material.setCreateDate(new Date());
            if(appUser != null) {
                material.setCreateBy(appUser);
            }
            material.setMaterialName(materialName);
            material.setManufacturing(manufacturing);
            material.setUlNumber(ulNumber);
            if(spec != null) {
                Long idSpec = saveFile(spec.getBytes(), spec.getOriginalFilename(), spec.getContentType());
                material.setSpec(idSpec);
                logHistory.setSpec(idSpec);
            }
            if(rohs != null) {
                Long idRohs = saveFile(rohs.getBytes(), rohs.getOriginalFilename(), rohs.getContentType());
                material.setRosh(idRohs);
                logHistory.setRosh(idRohs);

                Date date = df.parse(dateRohs);
                material.setRohsDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                material.setRohsEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                material.setRohsAlertDateTest(cal.getTime());
            }
            if(msds != null) {
                Long idMsds = saveFile(msds.getBytes(), msds.getOriginalFilename(), msds.getContentType());
                material.setMsds(idMsds);
                logHistory.setMsds(idMsds);
            }
            if(halogen != null) {
                Long idHalogen = saveFile(halogen.getBytes(), halogen.getOriginalFilename(), halogen.getContentType());
                material.setHalogen(idHalogen);
                logHistory.setHalogen(idHalogen);

                Date date = df.parse(dateHalogen);
                material.setHalogenDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                material.setHalogenEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                material.setHalogenAlertDateTest(cal.getTime());
            }
            if(guaranteeLetter != null) {
                Long idGuaranteeLetter = saveFile(guaranteeLetter.getBytes(), guaranteeLetter.getOriginalFilename(), guaranteeLetter.getContentType());
                material.setGuaranteeLetter(idGuaranteeLetter);
                logHistory.setGuaranteeLetter(idGuaranteeLetter);
            }

            if(redPhosphorus != null) {
                Long idRedPhosphorus = saveFile(redPhosphorus.getBytes(), redPhosphorus.getOriginalFilename(), redPhosphorus.getContentType());
                material.setRedPhosphorus(idRedPhosphorus);
                logHistory.setRedPhosphorus(idRedPhosphorus);
            }

            if(spec != null && msds != null && rohs != null && halogen != null) {
                material.setStatus("CREATE_MATERIAL_DOCUMENT_FULL");
                logHistory.setStatus("CREATE_MATERIAL_DOCUMENT_FULL");
                logHistory.setActionTYpe("User create material attach document full");
            } else {
                material.setStatus("CREATE_MATERIAL_DOCUMENT_NOT_FULL");
                logHistory.setStatus("CREATE_MATERIAL_DOCUMENT_NOT_FULL");
                logHistory.setActionTYpe("User create material attach document not full");
                logHistory.setRemark("User create material attach document not full");
            }

            if(appUser != null) {
                logHistory.setCreateBy(appUser);
            }
            logHistory.setCreateDate(new Date());
            logHistory.setMaterial(material);
            logHistories.add(logHistory);

            material.setLogHistories(logHistories);

            material.setMaterialType(materialType);

            Set<Material> materials = materialType.getMaterials();
            materials.add(material);

            materialType.setMaterials(materials);
            materialTypeDao.update(materialType);
            return material;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Material updateMaterial(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = multipartHttpServletRequest.getParameter("id");
            String materialName = multipartHttpServletRequest.getParameter("inputMaterialName");
            String manufacturing = multipartHttpServletRequest.getParameter("inputManufacturing");
            String ulNumber = multipartHttpServletRequest.getParameter("inputUlNumber");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            AppUser appUser = appUserDao.findByUsername(principal.getName());

            MultipartFile spec = multipartHttpServletRequest.getFile("inputSpec");
            MultipartFile rohs = multipartHttpServletRequest.getFile("inputRoHs");
            MultipartFile msds = multipartHttpServletRequest.getFile("inputMSDS");
            MultipartFile halogen = multipartHttpServletRequest.getFile("inputHalogen");
            MultipartFile guaranteeLetter = multipartHttpServletRequest.getFile("inputGuarantee");
            MultipartFile redPhosphorus = multipartHttpServletRequest.getFile("inputRedPhosphorus");

            String dateRohs = multipartHttpServletRequest.getParameter("inputDateRoHs");
            String dateHalogen = multipartHttpServletRequest.getParameter("inputDateHF");

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();

            Material material = materialDao.findById(Long.parseLong(id));
            material.setSpec(null);
            material.setMsds(null);
            material.setRosh(null);
            material.setHalogen(null);
            material.setGuaranteeLetter(null);
            material.setRedPhosphorus(null);
            material.setRohsDateTest(null);
            material.setRohsAlertDateTest(null);
            material.setRohsEndDateTest(null);
            material.setHalogenDateTest(null);
            material.setHalogenAlertDateTest(null);
            material.setHalogenEndDateTest(null);

            Set<LogHistory> logHistories = material.getLogHistories();
            LogHistory logHistory = new LogHistory();

            material.setUpdateDate(new Date());
            if(appUser != null) {
                material.setUpdateBy(appUser);
            }
            material.setMaterialName(materialName);
            material.setManufacturing(manufacturing);
            material.setUlNumber(ulNumber);

            if(spec != null) {
                Long idSpec = saveFile(spec.getBytes(), spec.getOriginalFilename(), spec.getContentType());
                material.setSpec(idSpec);
                logHistory.setSpec(idSpec);
            }
            if(rohs != null) {
                Long idRohs = saveFile(rohs.getBytes(), rohs.getOriginalFilename(), rohs.getContentType());
                material.setRosh(idRohs);
                logHistory.setRosh(idRohs);

                Date date = df.parse(dateRohs);
                material.setRohsDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                material.setRohsEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                material.setRohsAlertDateTest(cal.getTime());
            }
            if(msds != null) {
                Long idMsds = saveFile(msds.getBytes(), msds.getOriginalFilename(), msds.getContentType());
                material.setMsds(idMsds);
                logHistory.setMsds(idMsds);
            }
            if(halogen != null) {
                Long idHalogen = saveFile(halogen.getBytes(), halogen.getOriginalFilename(), halogen.getContentType());
                material.setHalogen(idHalogen);
                logHistory.setHalogen(idHalogen);

                Date date = df.parse(dateHalogen);
                material.setHalogenDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                material.setHalogenEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                material.setHalogenAlertDateTest(cal.getTime());
            }
            if(guaranteeLetter != null) {
                Long idGuaranteeLetter = saveFile(guaranteeLetter.getBytes(), guaranteeLetter.getOriginalFilename(), guaranteeLetter.getContentType());
                material.setGuaranteeLetter(idGuaranteeLetter);
                logHistory.setGuaranteeLetter(idGuaranteeLetter);
            }

            if(redPhosphorus != null) {
                Long idRedPhosphorus = saveFile(redPhosphorus.getBytes(), redPhosphorus.getOriginalFilename(), redPhosphorus.getContentType());
                material.setRedPhosphorus(idRedPhosphorus);
                logHistory.setRedPhosphorus(idRedPhosphorus);
            }

            if(spec != null && msds != null && rohs != null && halogen != null) {
                material.setStatus("UPDATE_MATERIAL_DOCUMENT_FULL");
                logHistory.setStatus("UPDATE_MATERIAL_DOCUMENT_FULL");
                logHistory.setActionTYpe("User update material attach document full");
            } else {
                material.setStatus("UPDATE_MATERIAL_DOCUMENT_NOT_FULL");
                logHistory.setStatus("UPDATE_MATERIAL_DOCUMENT_NOT_FULL");
                logHistory.setActionTYpe("User update material attach document not full");
                logHistory.setRemark("User update material attach document not full");
            }


            if(appUser != null) {
                logHistory.setCreateBy(appUser);
            }
            logHistory.setCreateDate(new Date());
            logHistory.setMaterial(material);
            logHistories.add(logHistory);

            material.setLogHistories(logHistories);

            materialDao.update(material);

            return material;
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

    public void deleteMaterial(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = multipartHttpServletRequest.getParameter("id");
            materialDao.delete(Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void approveMaterial(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = multipartHttpServletRequest.getParameter("id");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            AppUser appUser = appUserDao.findByUsername(principal.getName());

            Material material = materialDao.findById(Long.parseLong(id));

            Set<LogHistory> logHistories = material.getLogHistories();
            LogHistory logHistory = new LogHistory();

            material.setUpdateDate(new Date());
            if(appUser != null) {
                material.setUpdateBy(appUser);
            }

            material.setStatus("APPROVE_MATERIAL");
            logHistory.setStatus("APPROVE_MATERIAL");
            logHistory.setActionTYpe("QA approve material");

            if(appUser != null) {
                logHistory.setCreateBy(appUser);
            }
            logHistory.setCreateDate(new Date());
            logHistory.setMaterial(material);
            logHistories.add(logHistory);

            material.setLogHistories(logHistories);

            materialDao.update(material);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rejectMaterial(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = multipartHttpServletRequest.getParameter("id");
            String remark = multipartHttpServletRequest.getParameter("remark");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            AppUser appUser = appUserDao.findByUsername(principal.getName());

            Material material = materialDao.findById(Long.parseLong(id));

            Set<LogHistory> logHistories = material.getLogHistories();
            LogHistory logHistory = new LogHistory();

            material.setUpdateDate(new Date());
            if(appUser != null) {
                material.setUpdateBy(appUser);
            }

            material.setStatus("REJECT_MATERIAL");
            logHistory.setStatus("REJECT_MATERIAL");
            logHistory.setActionTYpe("QA reject material");

            if(appUser != null) {
                logHistory.setCreateBy(appUser);
            }
            logHistory.setCreateDate(new Date());
            logHistory.setMaterial(material);
            logHistory.setRemark(remark);
            logHistories.add(logHistory);

            material.setLogHistories(logHistories);

            materialDao.update(material);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSapCode(MultipartHttpServletRequest multipartHttpServletRequest) {
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        String id = multipartHttpServletRequest.getParameter("id");
        String name = multipartHttpServletRequest.getParameter("name");
        Material material = materialDao.findById(Long.parseLong(id));

        Set<SapCode> sapCodes = material.getSapCodes();
        SapCode sapCode = new SapCode();
        sapCode.setCreateBy(appUser);
        sapCode.setCreateDate(new Date());
        sapCode.setName(name);
        sapCode.setMaterial(material);
        sapCodes.add(sapCode);

        material.setSapCodes(sapCodes);
        materialDao.update(material);
    }

    public void deleteSapCode(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        sapCodeDao.delete(Long.parseLong(id));
    }

    public JSONArray findAllMaterial() {
        List<Material> materialList = materialDao.findAll();
        JSONArray jsonArray = new JSONArray();
        for (Material material : materialList) {
            jsonArray.put(material.getMaterialName());
            Set<SapCode> sapCodeSet = material.getSapCodes();
            for (SapCode sapCode : sapCodeSet) {
                jsonArray.put(sapCode.getName());
            }
        }
        return jsonArray;
    }
}
