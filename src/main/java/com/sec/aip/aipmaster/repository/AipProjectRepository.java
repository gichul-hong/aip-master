package com.sec.aip.aipmaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.aip.aipmaster.model.AipProject;

public interface AipProjectRepository extends JpaRepository<AipProject, Integer>{

	Optional<AipProject> findByProjectName(String projectName);


}
