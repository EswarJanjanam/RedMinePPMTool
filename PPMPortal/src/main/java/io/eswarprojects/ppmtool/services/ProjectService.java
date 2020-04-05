package io.eswarprojects.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.eswarprojects.ppmtool.Domain.Project;
import io.eswarprojects.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		
		
		return projectRepository.save(project);
	}
}
