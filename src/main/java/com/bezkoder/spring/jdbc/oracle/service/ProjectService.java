package com.bezkoder.spring.jdbc.oracle.service;
 import com.bezkoder.spring.jdbc.oracle.model.Project;
 import com.bezkoder.spring.jdbc.oracle.repository.ProjectRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public String createProject(Project project) {
        try {
           System.out.println("project service mapping");
         /* System.out.println("project name::" + project.getProjectName());
            System.out.println("project startdate::" + project.getStartDate());
            System.out.println("project target end date ::" + project.getTargetEndDate());
            System.out.println("project  actual end date ::" + project.getActualEndDate());
            System.out.println("project created by ::" + project.getCreatedBy());*/
            projectRepository.save(project);
            return ("project was created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return "fail to add project";
        }
    }

    public String updateProject(Project project) {
        try {
            System.out.println("project service update mapping");
            System.out.println("project id::" + project.getProjectId());
            projectRepository.update(project);
            return ("project was updated successfully.");
        } catch (Exception e) {
            return "can not update project";
        }
    }

    public String deleteById(Long id) {
        try {
            System.out.println("project service delete ");

            projectRepository.deleteById(id);
            return ("project was deleted successfully.");
        } catch (Exception e) {
            return "";
        }
    }



    public List<Project> findAll() {
        List<Project> list = null;
        try {
            System.out.println("project service find all mapping");
            list = projectRepository.findAll();
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }

    public List<Project> findProjectsByName(String name) {
        List<Project> list = null;
        try {
            System.out.println("project service findProject mapping" + name);
            list = projectRepository.findProjectByName(name);
        } catch (Exception e) {
            System.out.println("error");

        }
        return list;
    }

    public Project findProjectById(Long id) {
        Project project = null;
        try {
            System.out.println("project service findProjectById mapping" + id);
            project = projectRepository.findProjectById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");

        }
        return project;
    }

}


