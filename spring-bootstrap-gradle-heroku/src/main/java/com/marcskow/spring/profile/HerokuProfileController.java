package com.marcskow.spring.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("heroku")
public class HerokuProfileController {

    @GetMapping("/profile")
    public String index() {
        return "Heroku profile!";
    }
}
