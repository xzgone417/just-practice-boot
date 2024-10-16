package org.example.service;

import org.example.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.PortalVo;
import org.example.utils.Result;

/**
* @author Redmi
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-10-16 16:30:24
*/
public interface HeadlineService extends IService<Headline> {

    Result findNewPage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);
}
