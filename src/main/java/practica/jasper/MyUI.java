package practica.jasper;


import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import practica.jasper.frontend.PrincipalView;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@CDIUI("")
@Theme("mytheme")
public class MyUI extends UI {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1942573829228115622L;

	private Navigator navigator;
    
	@Inject
	private CDIViewProvider viewProvider;
	
	private VerticalLayout viewContainer;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        viewContainer = new VerticalLayout();
        viewContainer.setSizeFull();
    	
        navigator = new Navigator(MyUI.getCurrent(), viewContainer);
        navigator.addProvider(viewProvider); 
        
        showMainView();
    }

    public void showMainView() {
    	HorizontalLayout mainScreenLayout = new HorizontalLayout();
    	mainScreenLayout.setStyleName("main-screen");

    	
        mainScreenLayout.addComponent(viewContainer);
        mainScreenLayout.setExpandRatio(viewContainer, 1);
        mainScreenLayout.setSizeFull();
    	
        setContent(mainScreenLayout);
        
        getNavigator().navigateTo(PrincipalView.VIEW_NAME);
    }
    
}
