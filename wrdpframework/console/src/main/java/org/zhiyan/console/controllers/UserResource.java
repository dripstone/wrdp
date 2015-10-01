/****/
package org.zhiyan.console.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhiyan.security.services.UserService;
import org.zhiyan.user.entity.Role;
import org.zhiyan.user.entity.User;

/**
 * @Title:
 * @Description:
 * @Author:zzy
 * @Since:2015年10月1日
 * @Version:1.1.0
 */
@Controller
@RequestMapping("/rest/users/")
public class UserResource {
    private static Log logger = LogFactory.getLog(UserResource.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User findUser(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> createUser(
            @RequestBody User user) {
        User savedUser = userService.create(user);
        Role role = new Role();
        role.setId(1);
        role.setName("role123");
        savedUser.getRoles().add(role);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);

    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User savedUser = userService.update(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
