package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloSpringController {

    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    // Responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }
}
