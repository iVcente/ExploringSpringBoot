// Made with all the help from: https://youtu.be/9SGDpanrc8U

package com.vicente.exploringspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExploringSpringApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExploringSpringApplication.class, args);
	}

	// Change server default port: java -jar packageName.jar --server.port=portNumber
}