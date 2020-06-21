package com.demo.gateway.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;


@Configuration
public class PrefixPathConfig {
    @Value("${spring.cloud.gateway.api-prefix:/api/v1}")
    private String prefix;

    @Bean
    @Order(-1)
    public WebFilter apiPrefixFilter() {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            String path = request.getURI().getRawPath();
            if (!path.contains(prefix)) {
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.BAD_GATEWAY);

                DataBuffer buffer = response
                        .bufferFactory()
                        .wrap(HttpStatus.BAD_GATEWAY.getReasonPhrase().getBytes());
                return response.writeWith(Mono.just(buffer));
            }
            String newPath = path.replaceFirst(prefix, "");
            ServerHttpRequest newRequest = request.mutate().path(newPath).build();

            return chain.filter(exchange.mutate().request(newRequest).build());
        };
    }

}
