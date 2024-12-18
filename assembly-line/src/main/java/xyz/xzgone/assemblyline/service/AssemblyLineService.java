package xyz.xzgone.assemblyline.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.xzgone.assemblyline.pojo.AssemblyLine;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.xzgone.assemblyline.utils.TheResult;

import java.util.List;

/**
* @author Tencent_GO
* @description 针对表【assembly_line】的数据库操作Service
* @createDate 2024-11-12 16:07:44
*/
public interface AssemblyLineService extends IService<AssemblyLine> {

    TheResult<?> publish(AssemblyLine assemblyLine);

    List<AssemblyLine> findAll();

    List<AssemblyLine> findProject(String projectId);

    Page<AssemblyLine> findNames(int pageNum, int pageSize, String[] names);
}
