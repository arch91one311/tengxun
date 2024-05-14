package com.arch.registry;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@EnableConfigurationProperties(RegisterProperties.class)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    RegisterProperties registerProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        if (registerProperties.getSecurity().getEnable()) {
            // 启用认证, 则所有endpoint都需要认证
            http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        } else {
            // 不启用认证, 则所有endpoint都允许访问
            http.authorizeRequests((requests) -> requests.anyRequest().permitAll());
        }
        http.formLogin();
        http.httpBasic();
    }

    /**
     * 自定义用户名密码, 统一配置的前缀
     *
     * <p>security 把默认的[spring.security.user]配置, 重写为[kyp.register.security.user]
     * @param auth the {@link AuthenticationManagerBuilder} to use
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        SecurityProperties.User user = registerProperties.getSecurity().getUser();

        auth.inMemoryAuthentication()
                .withUser(user.getName())
                .password(passwordEncoder().encode(user.getPassword()))
                .roles(StringUtils.toStringArray(user.getRoles()));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
