package com.paysafe.cinemareservationwebapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebConfiguration implements ServletContextInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfiguration.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

    }

    private void initH2Console(ServletContext servletContext) {

        LOGGER.info("Starting H2 Console");

//        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
//        h2ConsoleServlet.addMapping("/h2console/*");
//        h2ConsoleServlet.setLoadOnStartup(1);
    }
}
