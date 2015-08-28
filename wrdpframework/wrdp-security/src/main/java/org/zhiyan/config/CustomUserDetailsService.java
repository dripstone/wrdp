/**
 * 
 */
package org.zhiyan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zhiyan.entities.User;
import org.zhiyan.security.SecurityUser;
import org.zhiyan.services.UserService;

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
