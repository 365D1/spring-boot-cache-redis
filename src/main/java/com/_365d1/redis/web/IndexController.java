package com._365d1.redis.web;
// +----------------------------------------------------------------------
// | 官方网站: www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 
// +----------------------------------------------------------------------
// | 时　　间: 2020/6/8 20:28
// +----------------------------------------------------------------------
// | 代码创建: 朱荻 <292018748@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:（修改人 - 修改时间）
// +----------------------------------------------------------------------

import com._365d1.redis.model.User;
import com._365d1.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public Object query(@RequestParam(value = "id") Integer id) {
        return userService.query(id);
    }

    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public Object modify() {
        User user = new User();
        user.setId(1);
        user.setName("罗志祥");
        userService.modify(user);
        return user;
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public Object remove(@RequestParam(value = "id") Integer id) {
        userService.remove(id);
        return "";
    }

}
