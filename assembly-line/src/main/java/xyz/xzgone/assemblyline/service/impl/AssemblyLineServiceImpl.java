package xyz.xzgone.assemblyline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.xzgone.assemblyline.pojo.AssemblyLine;
import xyz.xzgone.assemblyline.service.AssemblyLineService;
import xyz.xzgone.assemblyline.mapper.AssemblyLineMapper;
import org.springframework.stereotype.Service;
import xyz.xzgone.assemblyline.utils.TheResult;

import java.util.List;

/**
 * @author Tencent_GO
 * @description 针对表【assembly_line】的数据库操作Service实现
 * @createDate 2024-11-12 16:07:44
 */
@Service
public class AssemblyLineServiceImpl extends ServiceImpl<AssemblyLineMapper, AssemblyLine>
        implements AssemblyLineService {

    @Autowired
    private AssemblyLineMapper assemblyLineMapper;

    @Override
    public TheResult<AssemblyLine> publish(AssemblyLine assemblyLine) {
        assemblyLineMapper.publish(assemblyLine);
        return TheResult.ok(null);
    }

    @Override
    public List<AssemblyLine> findAll() {
        List<AssemblyLine> onceList = assemblyLineMapper.findAll();
        return onceList;
    }

    @Override
    public List<AssemblyLine> findProject(String projectId) {
        List<AssemblyLine> onceList = assemblyLineMapper.findProject(projectId);
        return onceList;
    }
}




