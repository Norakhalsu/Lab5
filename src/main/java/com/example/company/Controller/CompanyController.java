package com.example.company.Controller;

import com.example.company.Api.ApiResponse;
import com.example.company.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class CompanyController {

    List<Project> projects = new ArrayList<>();

    @PostMapping("/add") // creat new project
    public Project addProjects(@RequestBody Project project) {
        projects.add(project);
        return project;
    }

    @GetMapping("/get") // display all projects
    public List<Project> getProjects(){
        return projects;
    }

    @PutMapping("/update/{index}") // update project
    public Project updateProjects(@PathVariable int index ,@RequestBody Project project) {
        projects.set(index, project);
        return project;
    }

    @DeleteMapping("/delete/{index}") // delete project
   public ApiResponse deleteProjects(@PathVariable int index) {
        projects.remove(index);

        return new ApiResponse(" project Deleted ");
   }

   @PutMapping("/update-status/{index}") // status change done or not done
   public ApiResponse updateStatus(@PathVariable int index) {
        for (Project project : projects) {
            if (projects.get(index).getStatus().equals("not done")) {
                     project.setStatus("done");
            }        // projects.get(index).setStatus(status)
        }
        return new ApiResponse(" project Status Updated :");
   }

    @GetMapping("/search-projects/{search}") // search for project by title
    public Project searchProjects(@PathVariable String search) {
        for (Project project : projects) {
            if (project.getTitle().equals(search)) {
                return project;
            }
        } return null;
    }

    @GetMapping("/all-project/{companyName}") // display all project by company name
    public List<Project> displayProjects(@PathVariable String companyName) {

        List<Project> allProjects=new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equals(companyName)) {
                allProjects.add(project);
            }
        }
        return allProjects;
    }



    }


