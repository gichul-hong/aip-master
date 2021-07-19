package com.sec.aip.aipmaster.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "user")
@EnableJpaRepositories
@AllArgsConstructor
@NoArgsConstructor
public class AipUser {

	@Id
	private String userId;
    private String password;
    private String email;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ProjectUser> projectUser = new ArrayList<>();
}
