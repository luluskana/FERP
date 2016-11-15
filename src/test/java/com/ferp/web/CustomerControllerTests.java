package com.ferp.web;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.dao.CustomerDao;
import com.ferp.domain.Customer;
import com.ferp.service.CustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by apichat on 11/15/2016 AD.
 */
public class CustomerControllerTests extends AbstractTestController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void homePage() throws Exception {

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customerName", "homePage");
        multipartHttpServletRequestWrapper.setParameter("groupType", "Electronics");
        customerService.create(multipartHttpServletRequestWrapper);

        Customer customer = customerDao.findByName("homePage");
        assertNotNull(customer);
        assertEquals("homePage", customer.getName());
        assertEquals("Electronics", customer.getGroupType());

        this.mockMvc.perform(get("/customer").principal(principal))
                .andExpect(status().isOk())
                .andExpect(view().name("CUSTOMER/home"))
                .andExpect(model().attribute("customers", notNullValue()))
                .andExpect(model().attribute("name", notNullValue()))
                .andExpect(model().attribute("logout", "on"))
                .andExpect(model().attribute("loin", nullValue()))
                .andExpect(model().attribute("roleName", notNullValue()));
    }
}
