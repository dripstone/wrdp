/**
 * 
 */
package org.zhiyan.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Title:安全框架配置
 * @Description:配置spring安全框架
 * @Author:zzy
 * @Since:2015年8月27日
 * @Version:1.1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder registry)
            throws Exception {
        /*
         * registry .inMemoryAuthentication() .withUser("siva") // #1
         * .password("siva") .roles("USER") .and() .withUser("admin") // #2
         * .password("admin") .roles("ADMIN","USER");
         */

        // registry.jdbcAuthentication().dataSource(dataSource);
        registry.userDetailsService(customUserDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**"); // #3
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login", "/login/form**", "/register", "/logout")
                .permitAll()
                // #4
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
                // #6
                .anyRequest().authenticated()
                // 7
                .and().formLogin()
                // #8
                .loginPage("/login/form").defaultSuccessUrl("/welcome", true)
                // #9
                .loginProcessingUrl("/login").failureUrl("/login/form?error")
                .permitAll(); // #5

        http.csrf().disable().authorizeRequests().antMatchers("").permitAll();
    }
}
