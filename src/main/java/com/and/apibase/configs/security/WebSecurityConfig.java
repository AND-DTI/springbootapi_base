package com.and.apibase.configs.security;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import io.swagger.models.HttpMethod;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//***import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//import org.springframework.security.config.Customizer.*;
import com.and.apibase.service.AuthenticationService;


@Configuration
@EnableWebSecurity /*To discard implicit defaults security spring configs*/ //@@@@@@@new
@EnableGlobalMethodSecurity(prePostEnabled = true) //orig comented!!!!                                        //@@@@@@@@@new
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
    InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("dvega")
                        .password("{noop}password")
                        .roles("USER")
                        .build()
        );
    }    



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
            .cors(Customizer.withDefaults()) // by default uses a Bean by the name of corsConfigurationSource
            .csrf((csrf) -> csrf
                .disable()
            )
            //.csrf(csrf -> csrf.disable())
            //.cors(cors -> cors.and())?? not tested
            .authorizeHttpRequests((authz) -> authz           
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/**.html").permitAll()
                .antMatchers("/api/ctpcomp/**").permitAll()
                //.anyRequest().authenticated()                                
            )            
            .httpBasic(Customizer.withDefaults())             
            //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)                                                     
                        
          ;

        
        http.authenticationProvider(authenticationProvider());
        return http.build();
    }


    /*@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3010"));
        //configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        //configuration.setAllowedHeaders(List.of("Authorization"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/







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
    /*public SecurityFilterChain filterChain0(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .and()
                .exceptionHandling()
                //.accessDeniedHandler(accessDeniedHandler)
                //.authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()

                //.antMatchers("/api/csrfAttacker*").permitAll()
                //.antMatchers("/api/customer/**").permitAll()
                .antMatchers("/api/student/getAll2").hasRole("USER")
                .antMatchers("/api/async/**").permitAll()
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                //.anyRequest().authenticated()
                .and().formLogin()
                //.successHandler(mySuccessHandler)
                //.failureHandler(myFailureHandler)
                .and().httpBasic()
                .and().cors()
                .and().logout();
        return http.build();
    }*/

















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
