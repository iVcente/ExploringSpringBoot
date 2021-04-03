// Made with all the help from: https://youtu.be/9SGDpanrc8U

package com.exploringspring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExploringSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExploringSpringBootApplication.class, args);
	}

	// Change server default port: java -jar packageName.jar --server.port=portNumber
}