package xyz.xzgone.assemblyline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xzgone.assemblyline.pojo.Project;
import xyz.xzgone.assemblyline.utils.Result;

@RestController
@RequestMapping("project")
@CrossOrigin
public class ProjectController {

    @GetMapping("/gui")
    public String get() {
        return "cehsiyicdsdssssssssss";
    }

//    @PostMapping("publish")
//    public String publish(@RequestBody Project project) {
//        return "cehsiyic";
//    }
}
