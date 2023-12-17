package com.scauzj.config;

import com.scauzj.interceptor.LoginCheckInterceptor;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 配置类，注册web层相关组件
 */
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    /**
     * 配置swagger3
     * @return
     */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("蛋糕商城接口文档")
                        .description("图书管理系统接口文档")
                        .version("v1.0")
                        .contact(new Contact().name("Alex009ghc").email("1972212424@qq.com"))
                        .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }

    /**
     * 设置跨域访问
     * @param registry
     */
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //是否发送Cookie
                .allowCredentials(true)
                //放行哪些原始域
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("*");
    }

    /**
     * 注册自定义拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器...");
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/api/admin/**") // 拦截管理员所有请求
                .addPathPatterns("/api/user/**") // 拦截用户所有请求
                .excludePathPatterns("/api/admin/login") // 放行管理员登录请求
                .excludePathPatterns("/api/admin/logout") // 放行管理员登出请求
                .excludePathPatterns("/api/user/register") // 放行用户注册请求
                .excludePathPatterns("/api/user/login") // 放行用户登录请求
                .excludePathPatterns("/api/user/logout") // 放行用户登出请求
                .excludePathPatterns("/api/user/banner/**") // 放行主页图片请求
                .excludePathPatterns("/api/user/types/**") // 放行商品分类请求
                .excludePathPatterns("/api/user/goods/**") // 放行商品请求
        ;
    }

    /**
     * 设置静态资源映射
     * @param registry
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始设置静态资源映射...");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
