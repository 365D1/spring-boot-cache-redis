package com._365d1.redis.service.impl;
// +----------------------------------------------------------------------
// | 官方网站: www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 
// +----------------------------------------------------------------------
// | 时　　间: 2020/6/8 20:26
// +----------------------------------------------------------------------
// | 代码创建: 朱荻 <292018748@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:（修改人 - 修改时间）
// +----------------------------------------------------------------------

import com._365d1.redis.model.User;
import com._365d1.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements UserService {

    @Cacheable(key = "#id", unless = "#result == null")
    @Override
    public User query(Integer id) {
        log.info("执行查询");
        User user = new User();
        user.setId(id);
        user.setName("蔡徐坤");
        return user;
    }

    @CachePut(key = "#user.id")
    @Override
    public User modify(User user) {
        return user;
    }

    @CacheEvict(key = "#id")
    @Override
    public void remove(Integer id) {

    }

}
