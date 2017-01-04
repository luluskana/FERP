package com.ferp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by apichat on 12/21/2016 AD.
 */
@Service
public class OtRequestService {

    public void createTemplate(MultipartHttpServletRequest multipartHttpServletRequest) {
        String data = multipartHttpServletRequest.getParameter("data");
        String[] array = data.split("\\[");
        for(String s : array) {
            String[] dataEmployees = s.split("\\]");
            System.out.println("ID = " + dataEmployees[0] + ", Description of work = " + dataEmployees[1]);
        }
    }
}
