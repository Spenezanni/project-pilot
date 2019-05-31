package br.com.java.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.java.project.controller.TokenFilter;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

	@Bean
	public FilterRegistrationBean filtroJwt() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin");

		return frb;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	} 
}
