package com.ferp.web;

import com.ferp.service.FamsService;
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
 * Created by apichat on 11/18/2016 AD.
 */
@Controller
public class FamsControllerJson {

    @Autowired
    private FamsService famsService;

    @RequestMapping(value = "/fams/create/fa", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> createFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.createFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/update/fa", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> updateFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.updateFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/cancel/fa", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> cancelFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.saleCancelFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/engineer/approve", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> engineerApproveFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.engineerApproveFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/engineer/waiting", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> engineerWaitingFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.engineerWaitingFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/engineer/reject", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> engineerRejectFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.engineerRejectFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/engineer/sendFirstShot", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> engineerSendFirstFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.engineerSendFirstFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/engineer/cancel", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> engineerCancelFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.engineerCancelFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/qa/approveFirst", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> qaApproveFirstFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.qaApproveFirstFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/qa/rejectFirst", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> qaRejectFirstFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.qaRejectFirstFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/engineer/sendFinal", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> engineerSendFinalFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.engineerSendFinalFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/qa/approveFinal", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> qaApproveFinalFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.qaApproveFinalFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/qa/waitingFinal", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> qaWaitingFinalFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.qaWaitingFinalFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/qa/rejectFinal", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> qaRejectFinalFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.qaRejectFinalFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/qaEngineer/approveDocument", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> qaEngineerApproveDocumentFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.qaApproveDocumentFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/qaEngineer/rejectDocument", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> qaEngineerRejectDocumentFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.qaRejectDocumentFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fams/saleCo/followUp", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> qsaleCoFollowUpFa(MultipartHttpServletRequest multipartHttpServletRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            famsService.saleCoFollowUpFa(multipartHttpServletRequest);
            return new ResponseEntity<String>("{\"process\":\"success\"}", headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"process\":\"fail\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
