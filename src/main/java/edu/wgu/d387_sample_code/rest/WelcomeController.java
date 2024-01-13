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

    @GetMapping("/welcome")
    public ArrayList<String> getWelcomeMessage() {
        return welcomethread.getWelcomeMessage();
    }
}
