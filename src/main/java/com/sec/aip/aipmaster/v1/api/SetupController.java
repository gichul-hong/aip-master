package com.sec.aip.aipmaster.v1.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sec.aip.aipmaster.common.dto.AipResponseStatus;
import com.sec.aip.aipmaster.common.dto.DefaultResponse;
import com.sec.aip.aipmaster.model.AipProject;
import com.sec.aip.aipmaster.service.SetupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@Api(value = "SetupController V1")
@RequestMapping("/v1/api/setup")
@RequiredArgsConstructor
public class SetupController {
    
    final private SetupService setupService;

//    @GetMapping(path = "/projects/{projectId}")
//    public ResponseEntity<DefaultResponse<AipProject>> getProject(@PathVariable(name = "projectId") int projectId) {
// 
//        return new ResponseEntity<DefaultResponse<AipProject>>(DefaultResponse.of(AipResponseStatus.OK, setupService.getProjectByProjectId(projectId)), HttpStatus.OK);
//        
//    }

    @ApiOperation(value = "getProjectByName", notes = "프로젝트 상세 조회")
    @GetMapping(path = "/projects/{projectName}")
    public ResponseEntity<DefaultResponse<AipProject>> getProjectByName(@PathVariable(name = "projectName") String projectName) {
 
        return new ResponseEntity<DefaultResponse<AipProject>>(DefaultResponse.of(AipResponseStatus.OK, setupService.getProjectByProjectName(projectName)), HttpStatus.OK);
        
    }
    
    @ApiOperation(value = "createAipProject", notes = "Project 생성 API")
    @PostMapping("/projects")
    public ResponseEntity createAipProject(String projectName, String projectAdminId, String description) {
        
        setupService.canCreateProject(projectName);
        
        setupService.initializerProject(projectName, projectAdminId, description);
        
        return new ResponseEntity(DefaultResponse.of(AipResponseStatus.OK, null), HttpStatus.OK);
        
    }
    
    @ApiOperation(value = "addMemberToProject", notes = "Project 멤버 추가")
    @PostMapping("/projects/{projectId}/members")
    public ResponseEntity addMemberToProject(@PathVariable(name = "projectId") int projectId, String id) {
        
        setupService.addMemberToProject(projectId, id);
        
        return new ResponseEntity(DefaultResponse.of(AipResponseStatus.OK, null), HttpStatus.OK);
        
    }
    
    @ApiOperation(value = "removeMemberFromProject", notes = "Project 멤버 삭제")
    @DeleteMapping("/projects/{projectId}/members/{id}")
    public ResponseEntity removeMemberFromProject(@PathVariable(name = "projectId") int projectId, String id) {
        
        setupService.removeMemberFromProject(projectId, id);
        
        return new ResponseEntity(DefaultResponse.of(AipResponseStatus.OK, null), HttpStatus.OK);
        
    }
    
    @ApiOperation(value = "getProjectList", notes = "Project 목록 조회")
    @GetMapping("/projects")
    public ResponseEntity getProjectList() {
        
    	return new ResponseEntity<DefaultResponse<List<AipProject>>>(DefaultResponse.of(AipResponseStatus.OK, setupService.getProjectList()), HttpStatus.OK);
        
    }
    
}
