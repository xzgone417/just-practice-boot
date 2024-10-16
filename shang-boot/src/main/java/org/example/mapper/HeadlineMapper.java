package org.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.PortalVo;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author Redmi
 * @description 针对表【news_headline】的数据库操作Mapper
 * @createDate 2024-10-16 16:30:24
 * @Entity org.example.pojo.Headline
 */
@Mapper
public interface HeadlineMapper extends BaseMapper<Headline> {

    //自定义分页查询方法
    @MapKey("hid")
    IPage<Map<Integer, PortalVo>> selectPageMap(IPage<Headline> page,
                                                @Param("portalVo") PortalVo portalVo);

    @MapKey("hid")
    Map selectDetailMap(Integer hid);
}




