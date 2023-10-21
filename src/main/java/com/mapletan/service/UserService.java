package com.mapletan.service;

import com.mapletan.common.User;

/**
 * @author mapleTan
 * @Description
 * @date 2022/08/29
 **/


public interface UserService {
    // 客户端通过这个接口调用服务端的实现类
    User getUserByUserId(Integer id);
    // 给这个服务增加一个功能
    Integer insertUserId(User user);
}
