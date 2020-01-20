package name.xu.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Maybe has infinite possibilities
 *
 * WebMvc适配器
 *
 * @author Created by Sugar on 2018/3/9
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 手动添加映射
     *
     * @param registry ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 可以设置欢迎页
     *
     * @param registry
     */
    //@Override
    //public void addViewControllers(ViewControllerRegistry registry) {
    //    registry.addViewController("/").setViewName("forward:/index.html");
    //    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    //    super.addViewControllers(registry);
    //}
}
