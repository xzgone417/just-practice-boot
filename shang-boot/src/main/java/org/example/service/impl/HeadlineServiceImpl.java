package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.Headline;
import org.example.service.HeadlineService;
import org.example.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author Redmi
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-10-16 16:30:24
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




