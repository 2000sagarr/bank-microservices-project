package com.sagar.accounts;

import com.sagar.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//https://springdoc.org/#getting-started
@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservice REST Api Documentation",
				description = "Bank Account microservice REST Api Documentation",
				version = "v1",
				contact = @Contact(
						name="Sagar Mahajan",
						email = "2000sagarr@gmail.com",
						url = "sagarmahajan.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Account microservice REST Api Documentation",
				url = "test.com"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
