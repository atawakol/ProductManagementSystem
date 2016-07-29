package com.abdo.productapplication;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Comparator<String> test = (s1,s2) -> s1.compareTo(s2);
        
        SpringApplication.run(Application.class, args);
        LOG.info("Application Started ....... ");
    }
	
}
