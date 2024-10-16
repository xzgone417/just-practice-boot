package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.mapper.UserMapper;
import org.example.utils.Result;
import org.springframework.stereotype.Service;

/**
* @author Redmi
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-10-16 16:30:24
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public Result login(User user) {
        return null;
    }
}




