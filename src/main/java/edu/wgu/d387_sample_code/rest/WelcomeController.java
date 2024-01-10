package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.i18n.WelcomeThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/message")
public class WelcomeController {
    private final WelcomeThread welcomethread;

    @Autowired
    public WelcomeController(WelcomeThread welcomethread) {
        this.welcomethread = welcomethread;
    }

    // likely need a GET method, right? Since I am going to retrieve data from the resource bundle?
    // or do I do post to create the welcome text page/sign?
    @GetMapping("/welcome")
    public ArrayList<String> getWelcomeMessage() {
        //this.welcomethread.add("hello sparky");
        return welcomethread.getWelcomeMessage();
    }
}
