package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.Type;
import org.example.service.TypeService;
import org.example.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author Redmi
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-10-16 16:30:24
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




