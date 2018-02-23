package fr.wotoyandi;

import fr.wotoyandi.configuration.JpaConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import org.springframework.boot.web.support.SpringBootServletInitializer;

import javax.ws.rs.ApplicationPath;


@Configuration
@EnableAutoConfiguration
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"fr.wotoyandi"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class ApiRunner extends SpringBootServletInitializer{

	private static final Class<ApiRunner> applicationClass = ApiRunner.class;

	private static final Logger LOG
			= LoggerFactory.getLogger(ApiRunner.class);

	public static void main(String[] args) {

		SpringApplication.run(ApiRunner.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}
}
