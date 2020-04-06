package io.eswarprojects.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.eswarprojects.ppmtool.Domain.Project;
import io.eswarprojects.ppmtool.exceptions.ProjectIdException;
import io.eswarprojects.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project ID "+project.getProjectIdentifier().toUpperCase()+" already exists");
		}
	}
	
	public Project findProjectByIdentifier(String projectIdentifier) {
		
		Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Project ID "+projectIdentifier.toUpperCase()+" does not exists");
		}
		
		return project;
	}
}
