package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@Controller
@RequestMapping("hello")
public class HelloController {

    // handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "goodbye, Spring!";
    }

    //handles request of the form /hello?name=LaunchCode

//    @GetMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryPram(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
    return "Hello, " + name + "!";
    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }




    // responds to get and post requests at "/hellogoodbye"
//    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
//    public String hellogoodbye() {
//        // method code here ...
//    }
}
