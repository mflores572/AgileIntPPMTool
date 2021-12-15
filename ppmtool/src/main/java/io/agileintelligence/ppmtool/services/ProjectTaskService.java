package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Backlog;
import io.agileintelligence.ppmtool.domain.ProjectTask;
import io.agileintelligence.ppmtool.repositories.BacklogRepository;
import io.agileintelligence.ppmtool.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {

	@Autowired
	private BacklogRepository backlogRepository;
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	public ProjectTask addProjectTask() {

		//PTs to be added to a specific project, project != null, backlog exists

		//bl = backlog, pt = project tast
		//set bl to pt
		
		//we want the sequence to be like IDPRO-1 IDPRO-2 ... 100 101
		//Update the BL SEQUENCE
		
		//INITIAL priority when priority null
		//INITIAL status when status is null
		
	}
}