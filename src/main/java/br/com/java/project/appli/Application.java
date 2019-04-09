package br.com.java.project.appli;
  
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
  
@SpringBootApplication
@EntityScan(basePackages = { "br.com.java.project.entity" })
@EnableJpaRepositories(basePackages = { "br.com.java.project.repository" })
@ComponentScan(basePackages = {"br.com.java.project.controller"})
public class Application {
      public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
      }
}