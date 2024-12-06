package xyz.xzgone.assemblyline.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import xyz.xzgone.assemblyline.pojo.AssemblyLine;
import xyz.xzgone.assemblyline.pojo.Machine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Tencent_GO
 * @description 针对表【machine】的数据库操作Mapper
 * @createDate 2024-12-06 14:41:22
 * @Entity xyz.xzgone.assemblyline.pojo.Machine
 */
public interface MachineMapper extends BaseMapper<Machine> {

    void publish(Machine machine);

    List<Machine> findAll();


    IPage<Machine> findNames(Page<Machine> page, @Param("names") String[] names);

    IPage<Machine> findLink(Page<Machine> page, @Param("docLink") String docLink);
}




