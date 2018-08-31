package com.mitrais.carrot.config;

import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class BasicAuthenticationPoint extends BasicAuthenticationEntryPoint {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicAuthenticationPoint.class);

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        logger.error("Responding with unauthorized error. Message - {}", authEx.getMessage());
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(ApplicationConfig.REALM_NAME);
        super.afterPropertiesSet();
    }

}
