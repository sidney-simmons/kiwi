package com.sidneysimmons.kiwi.controller;

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

    /**
     * Redirect to the software engineer page when a user hits the home page.
     * 
     * @param response the servlet response
     * @throws IOException thrown if there is a problem sending the redirect
     */
    @GetMapping(value = "")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/software-engineer");
    }

}
