package com.ferp.service;

import com.ferp.dao.AppUserDao;
import com.ferp.dao.CustomerDao;
import com.ferp.domain.AppUser;
import com.ferp.domain.Customer;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by apichat on 11/15/2016 AD.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AppUserDao appUserDao;

    public void create(MultipartHttpServletRequest multipartHttpServletRequest) {
        String customerName = multipartHttpServletRequest.getParameter("customerName");
        String groupType = multipartHttpServletRequest.getParameter("groupType");
        Principal principal = multipartHttpServletRequest.getUserPrincipal();
        AppUser appUser = appUserDao.findByUsername(principal.getName());
        Customer customer = new Customer();
        customer.setCreateDate(new Date());
        if(appUser != null) {
            customer.setCreateBy(appUser);
        }
        customer.setName(customerName);
        customer.setGroupType(groupType);
        customerDao.create(customer);
    }

    public void delete(MultipartHttpServletRequest multipartHttpServletRequest) {
        String id = multipartHttpServletRequest.getParameter("id");
        customerDao.delete(Long.parseLong(id));
    }

    public JSONArray findAllCustomer() {
        List<Customer> customers = customerDao.findAllCustomer();
        JSONArray jsonArray = new JSONArray();
        for (Customer c : customers) {
            jsonArray.put(c.getName());
        }
        return jsonArray;
    }
}
