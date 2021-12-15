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
	
	public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
		
		//EXCEPTIONS: Project not found 

		//PTs to be added to a specific project, project != null, backlog exists
		Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
		
		//bl = backlog, pt = project tast
		//set bl to pt
		projectTask.setBacklog(backlog);
		
		//we want the sequence to be like IDPRO-1 IDPRO-2 ... 100 101
		Integer BacklogSequence = backlog.getPTSequence();
		
		//Update the BL SEQUENCE
		BacklogSequence++;
		
		//Add Sequence to project task
		projectTask.setProjectSequence(projectIdentifier+"-"+BacklogSequence);
		projectTask.setProjectIdentifier(projectIdentifier);
		
		//INITIAL priority when priority null
		/*if(projectTask.getPriority()==0||projectTask.getPriority()==null) {
			projectTask.setPriority(3);
		}*/
		
		//INITIAL status when status is null
		if(projectTask.getStatus()==""||projectTask.getStatus()==null) {
			projectTask.setStatus("TO_DO");
		}
		
		return projectTaskRepository.save(projectTask);
	}
}