package xyz.xzgone.assemblyline.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import xyz.xzgone.assemblyline.mapper.AssemblyLineMapper;
import xyz.xzgone.assemblyline.pojo.AssemblyLine;
import xyz.xzgone.assemblyline.pojo.Machine;
import xyz.xzgone.assemblyline.service.MachineService;
import xyz.xzgone.assemblyline.mapper.MachineMapper;
import org.springframework.stereotype.Service;
import xyz.xzgone.assemblyline.utils.TheResult;

import java.util.List;

/**
* @author Tencent_GO
* @description 针对表【machine】的数据库操作Service实现
* @createDate 2024-12-06 14:41:22
*/
@Service
public class MachineServiceImpl extends ServiceImpl<MachineMapper, Machine>
    implements MachineService{

    @Autowired
    private MachineMapper machineMapper;

    @Override
    @Transactional
    public TheResult<?> publish(Machine machine) {
        try {
            machineMapper.publish(machine);
            return TheResult.ok(null);
        } catch (Exception e) {
            return TheResult.ok(e);
        }
    }

    @Override
    public List<Machine> findAll() {
        return machineMapper.findAll();
    }


    @Override
    public Page<Machine> findNames(int pageNum, int pageSize, String[] names) {
        Page<Machine> page = new Page<>(pageNum, pageSize);
        return (Page<Machine>) this.getBaseMapper().findNames(page, names);
    }

    @Override
    public Page<Machine> findLink(int pageNum, int pageSize, String docLink) {
        Page<Machine> page = new Page<>(pageNum, pageSize);
        return (Page<Machine>) this.getBaseMapper().findLink(page, docLink);
    }
}




