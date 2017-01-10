package com.yourcompany.controller;

import com.yourcompany.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DataController {

    @Autowired
    @Qualifier("dataService")
    private DataService dataService;

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public String greetingSubmit(Model model, @RequestParam("prof") int prof, @RequestParam("soul") int soul, HttpServletRequest request) {
        if (prof == 0 || soul == 0) {
            model.addAttribute("error", "Вы ни за кого не проголосовали!");
            return "index";
        }
        if (dataService.vote(prof, soul, request.getRemoteAddr())) {
            model.addAttribute("success", "Спасибо за Ваш голос!");
            return "index";
        }
        model.addAttribute("result", "Вы уже проголосовали!");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getResult() {
        return "index";
    }

}