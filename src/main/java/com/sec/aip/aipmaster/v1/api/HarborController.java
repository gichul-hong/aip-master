package com.sec.aip.aipmaster.v1.api;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sec.aip.aipmaster.common.dto.DefaultResponse;
import com.sec.aip.aipmaster.common.dto.AipResponseStatus;
import com.sec.aip.aipmaster.common.dto.harbor.HarborProject;
import com.sec.aip.aipmaster.service.HarborService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/harbor")
@RequiredArgsConstructor
public class HarborController {

    private HarborService harborService;
    
    @GetMapping(path = "/projects/{projectId}")
    public ResponseEntity<DefaultResponse<HarborProject>> getProjectInfo(@PathVariable(name = "projectId") int projectId) {
 
        return new ResponseEntity<DefaultResponse<HarborProject>>(DefaultResponse.of(AipResponseStatus.OK, harborService.getProject(projectId)), HttpStatus.OK);
        
    }
    
    @RolesAllowed({ "admin", "user" })
    @RequestMapping(value = "/all-user", method = RequestMethod.GET)
    public ResponseEntity<String> getAllUser(@RequestHeader String Authorization) {
        return ResponseEntity.ok("Hello All User");
    }
}
