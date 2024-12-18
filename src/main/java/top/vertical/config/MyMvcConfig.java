package top.vertical.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.vertical.interceptor.TokenInterceptor;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new TokenInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/wx/login", "/", "/error")
            .excludePathPatterns("/api/**");

  }
}
