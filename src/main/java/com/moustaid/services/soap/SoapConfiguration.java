package com.moustaid.services.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class SoapConfiguration {

@Bean
public SimpleJaxWsServiceExporter getSoapServiceExporter(){
SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
serviceExporter.setBaseAddress("http://localhost:8585/bourse");
return serviceExporter;
    }
}