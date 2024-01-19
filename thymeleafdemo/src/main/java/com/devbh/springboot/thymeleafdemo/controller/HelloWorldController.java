package com.devbh.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // need a controller method to show initial HTML form

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }
    //need a controller method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShout(HttpServletRequest request, Model model) {
        // read request param from HTML form
        String theName = request.getParameter("studentName");
        // convert data to uppercase
        theName = theName.toUpperCase();
        // create the msg
        String result = "Yo! " + theName;
        // add msg to model
        model.addAttribute("message", result);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
        // convert data to uppercase
        theName = theName.toUpperCase();
        // create the msg
        String result = "Hey My Friend from the World  " + theName;
        // add msg to model
        model.addAttribute("message", result);
        return "helloworld";
    }




}
