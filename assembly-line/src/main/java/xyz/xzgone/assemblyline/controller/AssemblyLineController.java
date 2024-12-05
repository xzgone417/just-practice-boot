package xyz.xzgone.assemblyline.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xzgone.assemblyline.pojo.AssemblyLine;
import xyz.xzgone.assemblyline.service.AssemblyLineService;
import xyz.xzgone.assemblyline.utils.TheResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public TheResult<?> publish(@RequestBody AssemblyLine assemblyLine) {
        return assemblyLineService.publish(assemblyLine);
    }

    @PostMapping("/findNames")
    public Page<AssemblyLine> findNames(@RequestBody Map<String, Object> params) {
        int pageNum = (int) params.getOrDefault("pageNum", 1);
        int pageSize = (int) params.getOrDefault("pageSize", 10);
        // 检查names是否为ArrayList，如果是，则转换为String[]
        Object namesObject = params.get("names");
        String[] names;
        if (namesObject instanceof ArrayList) {
            ArrayList<?> namesList = (ArrayList<?>) namesObject;
            names = namesList.toArray(new String[0]);
        } else {
            // 如果names不是ArrayList，假设它已经是String[]类型
            names = (String[]) namesObject;
        }
//        String[] names = (String[]) params.get("names");

        return assemblyLineService.findNames(pageNum, pageSize, names);
    }

}
