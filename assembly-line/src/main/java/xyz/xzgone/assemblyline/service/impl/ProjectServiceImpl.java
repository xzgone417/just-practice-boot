package xyz.xzgone.assemblyline.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.xzgone.assemblyline.pojo.Project;
import xyz.xzgone.assemblyline.service.ProjectService;
import xyz.xzgone.assemblyline.mapper.ProjectMapper;
import org.springframework.stereotype.Service;
import xyz.xzgone.assemblyline.utils.TheResult;

/**
 * @author Tencent_GO
 * @description 针对表【project】的数据库操作Service实现
 * @createDate 2024-11-11 21:08:45
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project>
        implements ProjectService {

    @Autowired
    private ProjectMapper ProjectMapper;

    @Override
    public TheResult<Project> publish(Project project) {
        ProjectMapper.insert(project);
        return TheResult.ok(null);
    }
}




