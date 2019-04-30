package com.marcskow.spring.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("prod")
public class ProdProfileController {

    @GetMapping("/profile")
    public String index() {
        return "Prod profile!";
    }
}
