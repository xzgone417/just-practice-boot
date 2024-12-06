package xyz.xzgone.assemblyline.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.xzgone.assemblyline.pojo.AssemblyLine;
import xyz.xzgone.assemblyline.pojo.Machine;
import xyz.xzgone.assemblyline.service.MachineService;
import xyz.xzgone.assemblyline.utils.TheResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("machine")
@CrossOrigin
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/findAll")
    public TheResult<List<Machine>> findAll() {
        List<Machine> list = machineService.findAll();
        return TheResult.ok(list);
    }


    @PostMapping("/publish")
    public TheResult<?> publish(@RequestBody Machine machine) {
        return machineService.publish(machine);
    }

    @PostMapping("/findNames")
    public Page<Machine> findNames(@RequestBody Map<String, Object> params) {
        int pageNum = (int) params.getOrDefault("pageNum", 1);
        int pageSize = (int) params.getOrDefault("pageSize", 10);
        // 检查names是否为ArrayList，如果是，则转换为String[]
        Object namesObject = params.get("names");
        String[] names;
        if (namesObject instanceof ArrayList) {
            ArrayList<?> namesList = (ArrayList<?>) namesObject;
            names = namesList.toArray(new String[0]);
        } else {
            names = (String[]) namesObject;
        }
        return machineService.findNames(pageNum, pageSize, names);
    }

    @GetMapping("/findLink")
    public Page<Machine> findLink(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "docLink") String docLink) {
        return machineService.findLink(pageNum, pageSize, docLink);
    }

}
