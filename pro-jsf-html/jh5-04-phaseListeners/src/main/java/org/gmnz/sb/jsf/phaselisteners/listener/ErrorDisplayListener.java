package org.gmnz.sb.jsf.phaselisteners.listener;


import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;


public class ErrorDisplayListener implements SystemEventListener {
	@Override
	public void processEvent(SystemEvent systemEvent) throws AbortProcessingException {
		UIComponent uiComponent = (UIComponent) systemEvent.getSource();
		if (uiComponent instanceof EditableValueHolder) {
			EditableValueHolder editableValueHolder = (EditableValueHolder) uiComponent;
			if (!editableValueHolder.isValid()) {
				uiComponent.getAttributes().put("styleClass", "invalid-input");
			} else {
				uiComponent.getAttributes().put("styleClass", "");
			}
		}

	}



	@Override
	public boolean isListenerForSource(Object o) {
		return o instanceof UIComponent;
	}
}
