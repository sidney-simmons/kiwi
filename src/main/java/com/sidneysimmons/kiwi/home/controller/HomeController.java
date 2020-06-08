package com.sidneysimmons.kiwi.home.controller;

import com.sidneysimmons.kiwi.ViewNames;
import com.sidneysimmons.kiwi.home.service.HomeService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home controller.
 * 
 * @author Sidney Simmons
 */
@Controller
@RequestMapping(value = "")
public class HomeController {

    @Resource(name = "homeService")
    private HomeService homeService;

    @GetMapping(value = "")
    public String home(Model model) {
        model.addAttribute("imageName", homeService.getRandomImageName());
        return ViewNames.HOME;
    }

}
