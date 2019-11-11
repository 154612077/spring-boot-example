package springboot.example.system;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.example.system.filter.SystemContextFilter;
import springboot.example.system.filter.TestFilter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean userInfoFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TestFilter());
        registration.addUrlPatterns("/cs/*");
        registration.setName("testFilter");
        return registration;
    }

    @Bean
    public FilterRegistrationBean systemContextFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SystemContextFilter());
        registration.addUrlPatterns("/*");
        registration.setName("systemContextFilter");
        return registration;
    }
}
