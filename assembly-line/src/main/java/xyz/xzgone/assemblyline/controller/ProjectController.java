package xyz.xzgone.assemblyline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xzgone.assemblyline.pojo.Project;
import xyz.xzgone.assemblyline.service.ProjectService;
import xyz.xzgone.assemblyline.utils.TheResult;

@RestController
@RequestMapping("project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/gui")
    public String get() {
        return "cehsiyicdsdssssssssss";
    }

    @PostMapping("publish")
    public TheResult<Project> publish(@RequestBody Project project) {
        TheResult<Project> theResult = projectService.publish(project);
        System.out.println("result = " + theResult);
        return theResult;
    }
}
