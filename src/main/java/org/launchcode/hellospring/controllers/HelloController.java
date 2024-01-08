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

//    handle requests of the form http://localhost:8080/hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handle requests of the form http://localhost:8080/hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Ciao";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }
    //handles requests for http://localhost:8080/hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                    "<body>" +
                        "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                            "<input type = 'text' name = 'name' >" +
                            "<br>" +
                            "<select name='language' id='lang-select'>" +
                                "<option value=''>--Please select an option--</option>" +
                                "<option value='english' lang='english'>English</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='german'>German</option>" +
                                "<option value='italian'>Italian</option>" +
                            "<br>" +
                            "<input type = 'submit' value = 'Greet Me!' >" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}