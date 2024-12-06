package xyz.xzgone.assemblyline.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import xyz.xzgone.assemblyline.pojo.Machine;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.xzgone.assemblyline.utils.TheResult;

import java.util.List;

/**
 * @author Tencent_GO
 * @description 针对表【machine】的数据库操作Service
 * @createDate 2024-12-06 14:41:22
 */
public interface MachineService extends IService<Machine> {

    List<Machine> findAll();

    TheResult<?> publish(Machine machine);

    Page<Machine> findNames(int pageNum, int pageSize, String[] names);

    Page<Machine> findLink(int pageNum, int pageSize, String docLink);
}
