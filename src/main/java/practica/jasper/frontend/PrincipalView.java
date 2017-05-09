package practica.jasper.frontend;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import practica.jasper.backend.service.LogService;
import practica.jasper.reports.ReportLog;

@CDIView(PrincipalView.VIEW_NAME)
public class PrincipalView extends VerticalLayout implements View{
	private static final long serialVersionUID = 8380672256769000882L;
	public static final String VIEW_NAME = "Home";
	
	@Inject
	private LogService logService;
	private Button btnReport;
	public PrincipalView(){
		setSizeFull();
		btnReport = new Button("Generar reporte");
		addComponent(btnReport);
	}
	
	@PostConstruct
	public void init(){
		btnReport.addClickListener(event -> {
        	try{
        		ReportLog report = new ReportLog();
        		report.getReport(logService.findAll());
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        });
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}
}

