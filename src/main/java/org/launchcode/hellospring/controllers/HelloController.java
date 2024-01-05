package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //handle request at path http://localhost:8080/hello

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }

    //handle request at path //http://localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

    //handle requests of the form http://localhost:8080/hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //handlesRequestsAt/hello?name=Coder&lang=english  ?????????
    @RequestMapping(value="hello", method = {RequestMethod.POST})
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String lang) {
        if (name == null) {
            name = "World!";
        }
        return createMessage(name, lang);
    }

    public static String createMessage(String name, String lang) {
        String output = "";

        if (lang == "english") {
            output = "Hello";
        } else if (lang == "spanish") {
            output = "Hola";
        } else if (lang == "french") {
            output = "Bonjour";
        } else if (lang == "german") {
            output = "Hallo";
        } else if (lang == "italian") {
            output = "Ciao";
        }

        return output + " " + name;
    }
    //handles requests for http://localhost:8080/hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post' id='form'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language' id='lang-select' form='form'>" +
                "<option value=''>--Please select an option--</option>" +
                "<option value='english' lang='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='italian'>Italian</option>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}