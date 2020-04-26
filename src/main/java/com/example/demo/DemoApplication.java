package com.example.demo;

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


@SpringBootApplication
@RestController
public class DemoApplication {
	@GetMapping(value="/hello")
	public String getMethodName(){
		return "hello";
	}

	public static void main(String[] args) throws FirebaseAuthException, InterruptedException, ExecutionException {
		
		FirebaseInitialize fb = new FirebaseInitialize();
		
		fb.initialize();
		fb.getUserById("5vU3ZNs9oZWJeNJINqwU31IMQ0G2");
		fb.getData();
}
}