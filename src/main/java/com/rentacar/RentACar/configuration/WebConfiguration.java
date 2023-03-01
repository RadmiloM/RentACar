package com.rentacar.RentACar.configuration;

import com.rentacar.RentACar.user.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        var daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .ignoringAntMatchers("/**")
                .and()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/users/register").permitAll()
                .antMatchers("/users/login/{id}").permitAll()
                .antMatchers("/*").permitAll()
                .antMatchers("/users/{id}").hasAuthority("USER")
                .antMatchers(HttpMethod.POST,"/cars").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/cars").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/cars/search").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/cars/{carId}").hasAuthority("ADMIN")
                .antMatchers("/admin/update/{id}").hasAuthority("ADMIN")
                .antMatchers("/contracts").hasAuthority("ADMIN")
                .antMatchers("/contracts/sample").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


}
