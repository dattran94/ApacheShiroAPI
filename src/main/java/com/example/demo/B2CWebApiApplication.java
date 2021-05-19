package com.example.demo;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import com.example.demo.filter.B2CAuthenticationFilter;
import com.example.demo.shiro.realm.B2CMyCustomRealm;

@SpringBootApplication
@Configuration
@EnableResourceServer
@EnableCaching
public class B2CWebApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(B2CWebApiApplication.class, args);
  }

  @Bean
  public FilterRegistrationBean<B2CAuthenticationFilter> loggingFilter() {
    FilterRegistrationBean<B2CAuthenticationFilter> registrationBean =
        new FilterRegistrationBean<>();

    B2CAuthenticationFilter b2cAuthenticationFilter = new B2CAuthenticationFilter();
    b2cAuthenticationFilter.setSecurityManager(securityManager());

    registrationBean.setFilter(b2cAuthenticationFilter);
    registrationBean.addUrlPatterns("/user/*");
    registrationBean.addUrlPatterns("/admin/*");

    return registrationBean;
  }

  @Bean(name = "securityManager")
  public DefaultWebSecurityManager securityManager() {
    final DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(realm());
    return securityManager;
  }

  @Bean(name = "realm")
  public B2CMyCustomRealm realm() {
    final B2CMyCustomRealm realm = new B2CMyCustomRealm();
    return realm;
  }
}
