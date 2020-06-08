package com.demo.zuul.service.failback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: wch
 * @Description:
 * @Date: 2020/6/8 3:28 PM
 */
@Component
public class UserServiceFailBack implements FallbackProvider {

    @Override
    public String getRoute() {
        return "caller-demo";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse(){
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                String json="{\"data\":{\"id\":\"zuulfailback\",\"sex\":1,\"name\":\"危常焕\",\"flag\":true},\"code\":200,\"msg\":\"\"}";
                return new ByteArrayInputStream(json.getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders=new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
