/*
package tn.pi.appointment;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.List;

@Configuration
public class WebMvcConfig  implements Filter {

    private final List<String> allowedOrigins = List.of("http://localhost:3000");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String origin = httpRequest.getHeader("Origin");

        if (allowedOrigins.contains(origin)) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setHeader("Access-Control-Allow-Origin", origin);
            httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        }

        chain.doFilter(request, response);
    }
}


*/
