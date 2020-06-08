package com.sidneysimmons.kiwi.home.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
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

    @GetMapping(value = "")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/software-engineer");
    }

}
