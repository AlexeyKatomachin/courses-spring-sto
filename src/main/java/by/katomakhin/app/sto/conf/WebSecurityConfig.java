package by.katomakhin.app.sto.conf;

import by.katomakhin.app.sto.security.StoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StoDetailService service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("user").password("user").roles("USER").and()
//                .withUser("admin").password("admin").roles("USER","ADMIN").and()
//                .withUser("adminchik").password("adminchik").roles("ADMIN");

        auth.userDetailsService(service).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/cert/**").hasAuthority("USER")
                .antMatchers("/points/**").hasAuthority("ADMIN")
                .and()
                .formLogin()
                .and()
                .httpBasic().realmName("STO")
                .and()
                .rememberMe()
                .tokenValiditySeconds(2419200)
                .key("StoKey")
                .and()
                .logout().logoutSuccessUrl("/");
    }
}
