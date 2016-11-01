package com.ferp.web;

import com.ferp.custom.AppUserCustom;
import com.ferp.domain.AppUser;
import com.ferp.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by apichat on 10/31/2016 AD.
 */
@Controller
public class AppUserJsonController {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserController.class);

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserCustom appUserCustom;

    @RequestMapping(value = "/appuser/create", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> appUserCreate(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            AppUser appUser = appUserCustom.validateCreateAppUser(multipartHttpServletRequest);
            appUserService.create(appUser);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/appuser/update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> appUserUpdate(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            AppUser appUser = appUserCustom.validateUpdateAppUser(multipartHttpServletRequest);
            appUserService.update(appUser);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
