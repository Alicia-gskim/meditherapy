package com.pkg.meditherapy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private static final String[] CLASS_PATH_RESOURCES_LOCATIONS = {
			"classpath:/reousrces/", "classpath:/static/"
	};
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(CLASS_PATH_RESOURCES_LOCATIONS);
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		
		registry.viewResolver(resolver);
		
		WebMvcConfigurer.super.configureViewResolvers(registry);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/js/**", "/css/**", "/fonts/**");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
