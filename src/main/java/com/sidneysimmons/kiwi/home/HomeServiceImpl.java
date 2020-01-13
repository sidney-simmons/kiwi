package com.sidneysimmons.kiwi.home;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

/**
 * Default implementation of the {@link HomeService} interface.
 * 
 * @author Sidney Simmons
 */
@CommonsLog
@Service("homeService")
public class HomeServiceImpl implements HomeService {

    @Override
    public String getRandomImageName() {
        String imageName = "lol";
        log.info("Chose random image: " + imageName);
        return imageName;
    }

}
