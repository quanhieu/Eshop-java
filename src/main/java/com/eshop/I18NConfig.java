package com.eshop;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class I18NConfig implements WebMvcConfigurer {
	@Bean("messageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasenames("classpath:eshop/global", 
				"classpath:eshop/account/login");
		ms.setDefaultEncoding("utf-8");
		return ms;
	}
	
	@Bean("localeResolver")
	public CookieLocaleResolver getLocaleResolver() {
		CookieLocaleResolver  localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("vi", "VN"));
		localeResolver.setCookieMaxAge(10*24*60);
		return localeResolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor inter = new LocaleChangeInterceptor();
		inter.setParamName("lang");
		registry.addInterceptor(inter).addPathPatterns("/**");
	}
}
