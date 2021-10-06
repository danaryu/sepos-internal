package com.sinc.sepos.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
public class SeposIntApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeposIntApplication.class, args);
	}

}
