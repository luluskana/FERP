package com.ferp.service;

import com.ferp.MultipartHttpServletRequestWrapper;
import com.ferp.dao.CustomerDao;
import com.ferp.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by apichat on 11/15/2016 AD.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTests {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void createCustomerTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customerName", "Foamtec");
        multipartHttpServletRequestWrapper.setParameter("groupType", "Electronics");
        customerService.create(multipartHttpServletRequestWrapper);

        Customer customer = customerDao.findByName("Foamtec");
        assertNotNull(customer);
        assertEquals("Foamtec", customer.getName());
        assertEquals("Electronics", customer.getGroupType());
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper.setParameter("customerName", "deleteCustomerTest");
        multipartHttpServletRequestWrapper.setParameter("groupType", "Electronics");
        customerService.create(multipartHttpServletRequestWrapper);

        Customer customer = customerDao.findByName("deleteCustomerTest");
        assertNotNull(customer);
        assertEquals("deleteCustomerTest", customer.getName());
        assertEquals("Electronics", customer.getGroupType());

        MultipartHttpServletRequestWrapper multipartHttpServletRequestWrapper2 = new MultipartHttpServletRequestWrapper();
        multipartHttpServletRequestWrapper2.setParameter("id", "" + customer.getId());

        customerService.delete(multipartHttpServletRequestWrapper2);

        Customer customer2 = customerDao.findByName("deleteCustomerTest");
        assertNull(customer2);
    }
}
