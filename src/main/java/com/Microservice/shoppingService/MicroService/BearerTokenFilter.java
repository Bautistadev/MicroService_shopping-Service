package com.Microservice.shoppingService.MicroService;




import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.Filter.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BearerTokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException, ServletException, IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authotizationHeader =  httpRequest.getHeader("Authorization");

        if(authotizationHeader != null && authotizationHeader.startsWith("Bearer ")){
            String token = authotizationHeader.substring(7);
            httpRequest.setAttribute("BearerToken",token);
        }
        chain.doFilter(request,response);
    }
}
