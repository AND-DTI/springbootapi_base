package com.arjuncodes.studentsystem.configs.security;
//import io.swagger.models.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer.*;


@Configuration
@EnableWebSecurity /*To discard implicit defaults security spring configs*/ //@@@@@@@new
@EnableGlobalMethodSecurity(prePostEnabled = true) //orig comented!!!!
//@ComponentScan("com.baeldung.security")
//@EnableGlobalMethodSecurity                                                     //@@@@@@@@@new
public class WebSecurityConfig {




    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .and()
                .exceptionHandling()
                //.accessDeniedHandler(accessDeniedHandler)
                //.authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()

                /*.antMatchers("/api/csrfAttacker*")
                .permitAll()

                .antMatchers("/api/customer/**")
                .permitAll()
*/
                .antMatchers("/api/student/getAll2")
                .hasRole("USER")

                .antMatchers("/api/async/**")
                .permitAll()

                .antMatchers("/api/admin/**")
                .hasRole("ADMIN")

                //.anyRequest().authenticated()

                .and().formLogin()
                //.successHandler(mySuccessHandler)
                //.failureHandler(myFailureHandler)
                .and().httpBasic()
                .and().cors()
                .and().logout();
        return http.build();
    }

















    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .antMatcher(HttpMethod.GET, "/api").authorizeRequests().
                //.antMatcher(HttpMethod.GET).
                //.antMatcher(HttpMethod.GET, "/api/**").permitAll();


        return http.build();
    }*/




    /*@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }*/




    /*@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }



    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    } */


}
