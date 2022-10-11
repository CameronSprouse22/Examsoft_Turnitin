package web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import word_functions.Word_Split_And_Store;

@SpringBootApplication
@ComponentScan
public class Main {
	public static void main(String[] args){
		SpringApplication.run(Main.class, args);
	}
}