package com.audit.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws Exception {
		FlyingSaucerTest flyingSaucerTest = new FlyingSaucerTest();
		flyingSaucerTest.generatePdf();
	}
}
