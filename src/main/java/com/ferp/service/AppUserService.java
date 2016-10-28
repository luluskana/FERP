package com.ferp.service;

import com.ferp.dao.AppUserDao;
import com.ferp.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by apichat on 10/26/2016 AD.
 */
@Service
public class AppUserService {

    private final Logger LOGGER = LoggerFactory.getLogger(AppUserService.class);

    @Autowired
    private AppUserDao appUserDao;

    public void create(AppUser appUser) {
        try {
            appUserDao.create(appUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AppUser findByUsername(String username) {
        try {
            return appUserDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(AppUser appUser) {
        try {
            appUserDao.update(appUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AppUser findById(Long id) {
        try {
            return appUserDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
