package com.example.rentalcarspringmvc.config;

import com.example.rentalcarspringmvc.entities.Veicolo;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.ArrayList;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.rentalcarspringmvc")
public class WebApplicationContextConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.setBasename("messages");

        return resource;
    }

    @Bean
    public MessageSource messageSource4Validator() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        registry.addInterceptor(localeChangeInterceptor);
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver r = new CookieLocaleResolver();
        r.setCookieName("localeInfo");
        r.setCookieMaxAge(24 * 60 * 60);
        r.setDefaultLocale(new Locale("it"));
        return r;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource4Validator());
        return bean;
    }

    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
        return jsonView;
    }

    @Bean
    public MarshallingView xmlView() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Veicolo.class);
        MarshallingView xmlView = new MarshallingView(marshaller);
        return xmlView;
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        ArrayList<View> views = new ArrayList<>();
        views.add(jsonView()); // Formato JSON
        views.add(xmlView()); // Formato XML
        resolver.setDefaultViews(views);
        return resolver;
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
