package com.jsfprohtml5.firstapplication.exceptions;

import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
  private ExceptionHandler wrapped;
 
  
  public CustomExceptionHandler(ExceptionHandler wrapped) {
    this.wrapped = wrapped;
  }
 
  @Override
  public ExceptionHandler getWrapped() {
    return wrapped;
  }
 
  @Override
  public void handle() throws FacesException {
    Iterator i = getUnhandledExceptionQueuedEvents().iterator();
    
    while (i.hasNext()) {
      ExceptionQueuedEvent event = (ExceptionQueuedEvent) i.next();
      ExceptionQueuedEventContext context = (ExceptionQueuedEventContext)event.getSource();
 
      Throwable t = context.getException();
      
      FacesContext fc = FacesContext.getCurrentInstance();
      
      try {
          NavigationHandler navigationHandler = fc.getApplication().getNavigationHandler();
          
          navigationHandler.handleNavigation(fc, null, "error?faces-redirect=true");
          
          fc.renderResponse();
      } finally {
        i.remove();
      }
    }
    
    // Let the parent handle the rest
    getWrapped().handle();
  }
}