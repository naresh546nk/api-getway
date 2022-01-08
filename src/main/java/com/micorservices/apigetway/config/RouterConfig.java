package com.micorservices.apigetway.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {
	
	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/departments/**")
						.uri("lb://DEPARTMENT-SERVICE"))
				.route(p->p.path("/users/**")
					.uri("lb://USER-SERVICE"))
				.build();
	}

}
