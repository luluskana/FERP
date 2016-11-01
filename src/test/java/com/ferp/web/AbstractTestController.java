package com.ferp.web;

import com.ferp.FerpApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.security.Principal;

/**
 * Created by apichat on 11/1/2016 AD.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FerpApplication.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AbstractTestController {

    private final Logger LOGGER = LoggerFactory.getLogger(AbstractTestController.class);

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    protected Principal principal;

    @Before
    public void setup() throws Exception {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        principal = new Principal() {
            @Override
            public String getName() {
                return "user";
            }

        };

        LOGGER.debug("-= test case stat =-");
    }

    @After
    public void after() {
        LOGGER.debug("-= test case stop =-");
    }
}
