package com.sec.aip.aipmaster.v1.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/permitAll")
    public ResponseEntity<String> permitAll() {
        
        return ResponseEntity.ok("PermitAll");
    }
    
    @GetMapping(value = "/authenticated")
    public ResponseEntity<String> authenticated() {
        
        return ResponseEntity.ok("authenticated");
    }

    @GetMapping(value = "/user")
    public ResponseEntity<String> user(@RequestHeader String Authorization) {
        
        log.debug(Authorization);
        return ResponseEntity.ok("user");
    }

    @GetMapping(value = "/admin")
    public ResponseEntity<String> admin (@RequestHeader String Authorization) {
        
        log.debug(Authorization);
        return ResponseEntity.ok("admin");
    }

}
