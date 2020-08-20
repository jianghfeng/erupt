package xyz.erupt.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.erupt.auth.interceptor.LoginInterceptor;
import xyz.erupt.core.constant.RestPath;

import javax.annotation.Resource;

/**
 * @author liyuepeng
 * @date 2018-12-20.
 */

@Configuration
public class MvcInterceptor implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns(RestPath.ERUPT_API + "/**");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(RestPath.ERUPT_ATTACHMENT + "/**")
//                .addResourceLocations("file:" + eruptProp.getUploadPath());
//    }
}
