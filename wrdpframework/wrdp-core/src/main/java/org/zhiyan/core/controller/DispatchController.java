package org.zhiyan.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title:公用控制器
 * @Description:
 * @Author:zzy
 * @Since:2015年8月24日
 * @Version:1.1.0
 */
@Controller
@RequestMapping("/dispatch/")
public class DispatchController {
    @RequestMapping
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws BeansException, Exception {
        System.out.println("aaa");
    }

    // @RequestMapping(value = "/save", method = RequestMethod.POST)
    // public @ResponseBody ResponseEntity<User> post(@RequestBody User user) {
    // User savedUser = userService.create(user);
    // Role role = new Role();
    // role.setId(1);
    // role.setName("role123");
    // savedUser.getRoles().add(role);
    // return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    //
    // }
}
