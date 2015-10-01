/****/
package org.zhiyan.console.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.zhiyan.security.security.SecurityUser;
import org.zhiyan.security.services.UserService;
import org.zhiyan.user.entity.User;

/******
 * 
 * @author zzy
 **/
@Controller
public class UserController {
    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        UserController.userService = userService;
    }

    public static User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User loginUser = userService.findUserByEmail(email);
            return new SecurityUser(loginUser);
        }

        return null;
    }
}
