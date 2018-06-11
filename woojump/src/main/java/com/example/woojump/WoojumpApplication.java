//package com.example.woojump;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class WoojumpApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(WoojumpApplication.class, args);
//	}
//}


package com.example.woojump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@ComponentScan(basePackages="controller")
@Configuration
@EnableAutoConfiguration
public class WoojumpApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoojumpApplication.class, args);
	}
	
	@Bean
    public InternalResourceViewResolver setupViewResolver() {
 
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
 
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}

