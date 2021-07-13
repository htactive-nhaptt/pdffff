package com.audit.demo.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws Exception {
		PDFGenerateFile flyingSaucerTest = new PDFGenerateFile();
		flyingSaucerTest.generatePdf();
		GenerateExcelFile generateExcelFile = new GenerateExcelFile();
		generateExcelFile.generate();
	}
}
