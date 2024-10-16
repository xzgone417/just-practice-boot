package org.example.mapper;

import org.example.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author Redmi
* @description 针对表【news_user】的数据库操作Mapper
* @createDate 2024-10-16 16:30:24
* @Entity org.example.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




