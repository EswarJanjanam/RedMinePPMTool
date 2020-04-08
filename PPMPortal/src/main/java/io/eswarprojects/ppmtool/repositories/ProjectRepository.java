package io.eswarprojects.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.eswarprojects.ppmtool.Domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
		
	Project findByProjectIdentifier(String projectIdentifier);
	
	@Override
	Iterable<Project> findAll();
	
	@Override
	void delete(Project project);
}
