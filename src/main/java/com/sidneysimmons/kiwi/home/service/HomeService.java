package com.sidneysimmons.kiwi.home.service;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

/**
 * Home service class.
 * 
 * @author Sidney Simmons
 */
@CommonsLog
@Service("homeService")
public class HomeService {

    public String getRandomImageName() {
        String imageName = "lol";
        log.info("Chose random image: " + imageName);
        return imageName;
    }

}
