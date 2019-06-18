package com.marcskow.spring.bootstrap.java.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/some")
public class WatchController {

    @GetMapping("/{some}")
    public ResponseEntity getSome(@PathVariable String some) {
        System.out.println(some);
        return ResponseEntity.ok("");
    }
}
