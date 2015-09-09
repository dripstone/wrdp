/**
 * 
 */
package org.zhiyan.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zhiyan.security.security.SecurityUser;
import org.zhiyan.security.services.UserService;
import org.zhiyan.user.entities.User;

/**
 * 
 * @author zzy
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userService.findUserByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "UserName " + userName + " not found");
        }
        return new SecurityUser(user);
    }

}
