package com.sec.aip.aipmaster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sec.aip.aipmaster.common.dto.AipResponseStatus;
import com.sec.aip.aipmaster.common.dto.DefaultResponse;
import com.sec.aip.aipmaster.model.AipUser;
import com.sec.aip.aipmaster.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    final private AuthService authService;
    
    
    @PostMapping("/authenticate")
    public ResponseEntity<DefaultResponse<String>> authenticate(@RequestParam(value = "userId") String userId,
            @RequestParam(value = "password") String password) {
        
        String authToken = authService.getAuthToken();
        
        return new ResponseEntity<DefaultResponse<String>>(DefaultResponse.of(AipResponseStatus.OK, null, new String(authToken)), HttpStatus.OK);
        
    }
    
    @GetMapping(path = "/users/{userId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<DefaultResponse<AipUser>> getUserInfo(@PathVariable(name = "userId") String userId) {
 
        return new ResponseEntity<DefaultResponse<AipUser>>(DefaultResponse.of(AipResponseStatus.NOT_FOUND, "message", authService.getUserInfo()), HttpStatus.OK);
        
    }
    
}
