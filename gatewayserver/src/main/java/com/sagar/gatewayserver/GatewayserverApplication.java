package com.sagar.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

//	custom routing requirements;
	@Bean
	public RouteLocator bankRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder
				.routes()
				.route(p -> p
						.path("/bank/accounts/**")
						.filters(f -> f.rewritePath("/bank/accounts/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("accountsCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://ACCOUNTS"))
				.route(p -> p
						.path("/bank/loans/**")
						.filters(f -> f.rewritePath("/bank/loans/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("loansCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://LOANS"))
				.route(p -> p
						.path("/bank/cards/**")
						.filters(f -> f.rewritePath("/bank/cards/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("cardsCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://CARDS"))
				.build();

	}

}
