package xyz.xzgone.assemblyline.mapper;

import xyz.xzgone.assemblyline.pojo.AssemblyLine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Tencent_GO
* @description 针对表【assembly_line】的数据库操作Mapper
* @createDate 2024-11-12 16:07:44
* @Entity xyz.xzgone.assemblyline.pojo.AssemblyLine
*/
public interface AssemblyLineMapper extends BaseMapper<AssemblyLine> {

    List<AssemblyLine> findAll();

    List<AssemblyLine> findProject(String projectId);
}




