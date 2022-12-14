package com.octopus.config;

import com.octopus.jwt.JwtAccessDeniedHandler;
import com.octopus.jwt.JwtAuthenticationEntryPoint;
import com.octopus.jwt.JwtSecurityConfig;
import com.octopus.jwt.JwtTokenProvider;
import com.octopus.oauth.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    private final OAuth2SuccessHandler successHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers("/api/login/**").permitAll()
                .antMatchers("/api/register/**").permitAll()
                .antMatchers("/api/mission/search/**").permitAll()
                .antMatchers("/api/email/**").permitAll()
                .antMatchers("/api/find-pw").permitAll()
                .antMatchers("/api/mission/hot").permitAll()
                .antMatchers("/api/mission/new").permitAll()
                .antMatchers("/api/test").permitAll()
                .antMatchers(HttpMethod.GET,"/api/mission/{missionNo}").permitAll()
                .antMatchers(HttpMethod.GET,"/api/mission/{missionNo}/mission-detail").permitAll()
                .anyRequest().authenticated()

                .and()
                .oauth2Login()
                .successHandler(successHandler)


                .and()
                .apply(new JwtSecurityConfig(jwtTokenProvider));

        return http.build();
    }
}
