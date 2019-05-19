package br.com.andre.processos.utils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.Map;

public class PDFReport {

	@Autowired
	ApplicationContext context;
	public byte[] reportGenarator(String fileName, Map<String, Object> params, JRBeanCollectionDataSource dataSource) {
		
		try {
			
			JasperPrint print = JasperFillManager.fillReport(
					ClassLoader.getSystemClassLoader().getResource("relatorios/processos.jasper").getPath(), params, dataSource);
			return JasperExportManager.exportReportToPdf(print);
		} catch (JRException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
