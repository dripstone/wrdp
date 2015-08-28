/**
 * 
 */
package org.zhiyan.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zhiyan.entities.Resource;
import org.zhiyan.entities.Role;
import org.zhiyan.entities.User;

/**
 * 
 * @author zzy
 *
 */
public class SecurityUser extends User implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Map<String, List<Resource>> roleResources;

    public SecurityUser(User user) {
        if (user != null) {
            this.setId(user.getId());
            this.setName(user.getName());
            this.setEmail(user.getEmail());
            this.setPassword(user.getPassword());
            this.setDob(user.getDob());
            this.setRoles(user.getRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> userRoles = this.getRoles();

        if (userRoles != null) {
            for (Role role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
                        role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    /**
     * @return the roleResources
     */
    public Map<String, List<Resource>> getRoleResources() {
        // init roleResources for the first time
        if (this.roleResources == null) {
            this.roleResources = new HashMap<String, List<Resource>>();

            for (Role role : this.getRoles()) {
                String roleName = role.getName();
                Set<Resource> resources = role.getResources();
                for (Resource resource : resources) {
                    String key = roleName + "_" + resource.getName();
                    if (!this.roleResources.containsKey(key)) {
                        this.roleResources.put(key, new ArrayList<Resource>());
                    }
                    this.roleResources.get(key).add(resource);
                }
            }

        }
        return this.roleResources;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
