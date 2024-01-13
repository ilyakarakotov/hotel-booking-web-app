package edu.wgu.d387_sample_code.rest;


import edu.wgu.d387_sample_code.i18n.TimeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/timezone")
public class TimeZoneController {
    private final TimeConversion timeconversion;

    @Autowired
    public TimeZoneController(TimeConversion timeconversion) {
        this.timeconversion = timeconversion;
    }

    @GetMapping("/conversion")
    public ArrayList<String> getTimeConversion() {
        return timeconversion.getTimeConversion();
    }
}