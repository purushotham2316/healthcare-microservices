package com.healthcare.api_gateway.config;




import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**").uri("http://localhost:8081"))
                .route("appointment-service", r -> r.path("/appointments/**").uri("http://localhost:8082"))
                .route("medical-records-service", r -> r.path("/medical-records/**").uri("http://localhost:8083"))
                .route("billing-service", r -> r.path("/billing/**").uri("http://localhost:8084"))
                .route("notification-service", r -> r.path("/notifications/**").uri("http://localhost:8085"))
                .build();
    }
}
