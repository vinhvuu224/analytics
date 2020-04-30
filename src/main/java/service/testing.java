package service;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.ExportedUserRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.ListUsersPage;

import service.FirebaseInitialize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
public class testing {
	private static final Logger log = 
	LoggerFactory.getLogger(testing.class);

	
	public static void main(String[] args) throws FirebaseAuthException, InterruptedException, ExecutionException {
		
        SpringApplication.run(testing.class, args);
        
        
		
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
            
			Email email = restTemplate.getForObject("https://community-housing-c73c2.firebaseio.com/housePosts/-Lzk2aDqh3R0WaiPJEqI.json", Email.class);
			log.info(email.toString());
		};
	}
}