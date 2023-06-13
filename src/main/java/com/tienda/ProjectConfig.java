
package com.tienda;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class ProjectConfig implements WebMvcConfigurer{
    /* los siguientes metodos son para incorporar el tema de nacionalizacion en el proyecto */
    /* localResolver se utliza para crear una session en el cambio de idioma*/
    
    @Bean
   public SessionLocaleResolver localResolver (){
       var slr = new SessionLocaleResolver();
       slr.setDefaultLocale(Locale.getDefault());
       slr.setLocaleAttributeName("session.current.locale");
       slr.setLocaleAttributeName("session.current.timezone");
       
       
       return slr;
       
   }    
   
   /* LocaleChangeIntereptor se utiliza para crear un interceptor en el cambio de idioma */
   
   @Bean
   public LocaleChangeInterceptor  localeChangeInterceptor (){
       var lci = new LocaleChangeInterceptor();
       lci.setParamName("lang");
       return lci;
       
   }
   @Override
   
   public void addInterceptors(InterceptorRegistry registry){
       registry.addInterceptor(localeChangeInterceptor());
       
   }
   
  //Bean para poder acceder a los Messages.properties en código...

    @Bean("messageSource")

    public MessageSource messageSource() {

        ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();

        messageSource.setBasenames("messages");

        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;

    }
}
