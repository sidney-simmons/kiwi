package com.sidneysimmons.kiwi.controller;

import com.sidneysimmons.kiwi.controller.domain.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Contact controller.
 * 
 * @author Sidney Simmons
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    /**
     * Return the contact page.
     * 
     * @return the template name
     */
    @GetMapping(value = "")
    public String contact() {
        return ViewNames.CONTACT;
    }

}
