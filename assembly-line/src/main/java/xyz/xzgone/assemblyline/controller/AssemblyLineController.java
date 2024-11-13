package xyz.xzgone.assemblyline.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xzgone.assemblyline.pojo.AssemblyLine;
import xyz.xzgone.assemblyline.service.AssemblyLineService;
import xyz.xzgone.assemblyline.utils.TheResult;

import java.util.List;

@RestController
@RequestMapping("line")
@CrossOrigin
public class AssemblyLineController {

    @Autowired
    private AssemblyLineService assemblyLineService;

    @GetMapping("/findAll")
    public TheResult<List<AssemblyLine>> findAll() {
        List<AssemblyLine> list = assemblyLineService.findAll();
        return TheResult.ok(list);
    }

    @GetMapping("/findProject")
    public TheResult<List<AssemblyLine>> findProject(@RequestParam String projectId) {
        List<AssemblyLine> list = assemblyLineService.findProject(projectId);
        return TheResult.ok(list);
    }

    @PostMapping("publish")
    public TheResult<AssemblyLine> publish(@RequestBody AssemblyLine assemblyLine) {
        return assemblyLineService.publish(assemblyLine);
    }
}
