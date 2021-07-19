package com.sec.aip.aipmaster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@EnableJpaRepositories
public class ProjectUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private AipProject project;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AipUser user;
}
