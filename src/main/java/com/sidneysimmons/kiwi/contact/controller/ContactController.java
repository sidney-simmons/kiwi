package com.sidneysimmons.kiwi.contact.controller;

import com.sidneysimmons.kiwi.ViewNames;
import com.sidneysimmons.kiwi.property.service.PropertyService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Resource(name = "propertyService")
    private PropertyService propertyService;

    /**
     * Return the contact page.
     * 
     * @return the template name
     */
    @GetMapping(value = "")
    public String contact(Model model) {
        model.addAttribute("githubProfilePic", propertyService.getProperty("github.profile-pic"));
        model.addAttribute("githubProfileUrl", propertyService.getProperty("github.profile-url"));
        model.addAttribute("linkedInProfileUrl", propertyService.getProperty("linked-in.profile-url"));
        return ViewNames.CONTACT;
    }

}
