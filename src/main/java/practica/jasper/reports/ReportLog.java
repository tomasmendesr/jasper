package practica.jasper.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import practica.jasper.backend.model.LogAuditoria;

public class ReportLog {
	
	public FileInputStream getReport(List<LogAuditoria> datasource) throws JRException, IOException{
	  String jasperReport = "C:/Users/tribeiro/workspace/jasper/src/main/resources/jasper/reportLog.jasper";
		//String jasperReport = "C:/Users/PD/workspace/jasper/reportLog.jasper";
	  Map<String, Object> params = new HashMap<String, Object>();
      params.put("TITULO", "ESTE ES MI TITULO");
      params.put("USER", "TOMAS");
      
      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(datasource));
      
      File pdf = File.createTempFile("output.", ".pdf");
      JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
      JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/tribeiro/workspace/jasper/src/main/resources/jasper/reportes/ReportLog.pdf");
      //JasperExportManager.exportReportToPdfFile(jasperPrint,"C:/Users/PD/workspace/jasper/reportes/ReportLog.pdf");
      
      return new FileInputStream(pdf);
	}
}

