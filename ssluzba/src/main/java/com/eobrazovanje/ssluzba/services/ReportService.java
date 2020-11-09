package com.eobrazovanje.ssluzba.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.eobrazovanje.ssluzba.entities.Transaction;
import com.eobrazovanje.ssluzba.repository.TransactionRepository;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	TransactionRepository trRepo;
	
	@Autowired
	DocumentService documentService;
	
	public String exportReport(String reportFormat, Long id) throws FileNotFoundException, Exception {
		String path= "C:\\\\Users\\\\User\\\\StudentskaSluzbaReports";
		List<Transaction> transactions = trRepo.findByFinancialCardId(id);
		
		File file = ResourceUtils.getFile("classpath:transaction.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource =  new JRBeanCollectionDataSource(transactions);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy","Andrej Djapic");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path + "\\transaction.html");
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\transaction.pdf");
			
		}
		return "report generated in path C:\\\\Users\\\\User\\\\StudentskaSluzbaReports";
	}

}
