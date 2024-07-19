package tn.esprit.msgatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MsGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGatewayServerApplication.class, args);
	}

	@Bean
	RouteLocator getewayRoutes(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(r -> r.path("/api/presences/**").uri("lb://Ms-Presence"))
				.route(r -> r.path("/api/justifications/**").uri("lb://Ms-Justification"))
				.build();

	}


}

