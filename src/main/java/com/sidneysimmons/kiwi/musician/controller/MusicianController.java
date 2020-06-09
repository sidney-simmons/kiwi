package com.sidneysimmons.kiwi.musician.controller;

import com.sidneysimmons.kiwi.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Musician controller.
 * 
 * @author Sidney Simmons
 */
@Controller
@RequestMapping(value = "/musician")
public class MusicianController {

    /**
     * Return the musician page.
     * 
     * @return the template name
     */
    @GetMapping(value = "")
    public String musician() {
        return ViewNames.MUSICIAN;
    }

}
