package com.ferp.service;

import com.ferp.dao.AppUserDao;
import com.ferp.dao.MaterialDao;
import com.ferp.dao.MaterialTypeDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.LogHistory;
import com.ferp.domain.Material;
import com.ferp.domain.MaterialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MaterialDao materialDao;

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
                Long idInsert = selectIdInsert();
                saveFile(idInsert, spec.getBytes(), spec.getOriginalFilename(), spec.getContentType());
                material.setSpec(idInsert);
                logHistory.setSpec(idInsert);
            }
            if(rohs != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, rohs.getBytes(), rohs.getOriginalFilename(), rohs.getContentType());
                material.setRosh(idInsert);
                logHistory.setRosh(idInsert);

                Date date = df.parse(dateRohs);
                material.setRohsDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                material.setRohsEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                material.setRohsAlertDateTest(cal.getTime());
            }
            if(msds != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, msds.getBytes(), msds.getOriginalFilename(), msds.getContentType());
                material.setMsds(idInsert);
                logHistory.setMsds(idInsert);
            }
            if(halogen != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, halogen.getBytes(), halogen.getOriginalFilename(), halogen.getContentType());
                material.setHalogen(idInsert);
                logHistory.setHalogen(idInsert);

                Date date = df.parse(dateHalogen);
                material.setHalogenDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                material.setHalogenEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                material.setHalogenAlertDateTest(cal.getTime());
            }
            if(guaranteeLetter != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, guaranteeLetter.getBytes(), guaranteeLetter.getOriginalFilename(), guaranteeLetter.getContentType());
                material.setGuaranteeLetter(idInsert);
                logHistory.setGuaranteeLetter(idInsert);
            }

            if(redPhosphorus != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, redPhosphorus.getBytes(), redPhosphorus.getOriginalFilename(), redPhosphorus.getContentType());
                material.setRedPhosphorus(idInsert);
                logHistory.setRedPhosphorus(idInsert);
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
                Long idInsert = selectIdInsert();
                saveFile(idInsert, spec.getBytes(), spec.getOriginalFilename(), spec.getContentType());
                material.setSpec(idInsert);
                logHistory.setSpec(idInsert);
            }
            if(rohs != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, rohs.getBytes(), rohs.getOriginalFilename(), rohs.getContentType());
                material.setRosh(idInsert);
                logHistory.setRosh(idInsert);

                Date date = df.parse(dateRohs);
                material.setRohsDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                material.setRohsEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                material.setRohsAlertDateTest(cal.getTime());
            }
            if(msds != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, msds.getBytes(), msds.getOriginalFilename(), msds.getContentType());
                material.setMsds(idInsert);
                logHistory.setMsds(idInsert);
            }
            if(halogen != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, halogen.getBytes(), halogen.getOriginalFilename(), halogen.getContentType());
                material.setHalogen(idInsert);
                logHistory.setHalogen(idInsert);

                Date date = df.parse(dateHalogen);
                material.setHalogenDateTest(date);
                cal.setTime(date);
                cal.add(Calendar.YEAR, 1);
                material.setHalogenEndDateTest(cal.getTime());
                cal.add(Calendar.MONTH, -3);
                material.setHalogenAlertDateTest(cal.getTime());
            }
            if(guaranteeLetter != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, guaranteeLetter.getBytes(), guaranteeLetter.getOriginalFilename(), guaranteeLetter.getContentType());
                material.setGuaranteeLetter(idInsert);
                logHistory.setGuaranteeLetter(idInsert);
            }

            if(redPhosphorus != null) {
                Long idInsert = selectIdInsert();
                saveFile(idInsert, redPhosphorus.getBytes(), redPhosphorus.getOriginalFilename(), redPhosphorus.getContentType());
                material.setRedPhosphorus(idInsert);
                logHistory.setRedPhosphorus(idInsert);
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

    public Long selectIdInsert() {
        String sqlSelect = "SELECT ID FROM ITEM_FILE ORDER BY ID DESC LIMIT 1";
        List<Map<String, Object>> lists =  jdbcTemplate.queryForList(sqlSelect);
        if(lists.size() <= 0) {
            return 1L;
        } else {
            return (Long)lists.get(0).get("ID") + 1;
        }
    }

    public void saveFile(Long id, byte[] stream, String fileName, String contentType) {
        String sqlInsertFile = "INSERT INTO ITEM_FILE (id, dataFile, fileName, contentType) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsertFile, id, stream, fileName, contentType);
    }

    public void deleteMaterial(MultipartHttpServletRequest multipartHttpServletRequest) {
        try {
            String id = multipartHttpServletRequest.getParameter("id");
            Principal principal = multipartHttpServletRequest.getUserPrincipal();
            materialDao.delete(Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
