package com.arjuncodes.studentsystem.configs.security;
import org.springframework.beans.factory.annotation.Autowired;
//import io.swagger.models.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.Customizer.*;

import com.arjuncodes.studentsystem.service.AuthenticationService;


@Configuration
@EnableWebSecurity /*To discard implicit defaults security spring configs*/ //@@@@@@@new
@EnableGlobalMethodSecurity(prePostEnabled = true) //orig comented!!!!
//@ComponentScan("com.baeldung.security")
//@EnableGlobalMethodSecurity                                                     //@@@@@@@@@new
public class WebSecurityConfig {//**** extends added 06.05.2023


    @Autowired
	private AuthenticationService authenticationService;

    //@Autowired
    //private AuthEntryPointJwt unauthorizedHandler;

    /*@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}*/



    @Bean
    public DaoAuthenticationProvider authenticationProvider() {        
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();         
        authProvider.setUserDetailsService(authenticationService);
        authProvider.setPasswordEncoder(passwordEncoder());     
        return authProvider;
    }
  

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
      return authConfig.getAuthenticationManager();
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable()
            //.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            //.antMatchers(HttpMethod.POST, "/api/auth").permitAll()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/api/test/**").permitAll()
            .antMatchers("/swagger-ui.html").permitAll()
            .antMatchers("/swagger-resources/**").permitAll()
            .antMatchers("/**.html").permitAll()
            .antMatchers("/api/ctpcomp/**").permitAll()
            //**** */.antMatchers("/api/ctpcomp/**").authenticated()
            //.anyRequest().authenticated()
            //.and()           
            //.exceptionHandling()
            //.and()
            //.httpBasic()                
            //.and()
            //.logout()
            ;                

        http.authenticationProvider(authenticationProvider());
        //http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


/* 
    @Autowired
	private AuthenticationService authenticationService;

    //Configurations for authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(authenticationService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }
*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /* ***causes a lot of warnings!!!!!!!!!!!!!
    @Bean //uncomented in 06.05.2023
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }
    */


    //@Bean ****original
    public SecurityFilterChain filterChain0(HttpSecurity http) throws Exception {
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
                .permitAll()*/
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
