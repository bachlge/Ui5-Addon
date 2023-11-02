/**
 * https://sap.github.io/ui5-webcomponents/playground/components/SegmentedButton/
 * 
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-segmentedbutton")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.19.0")
@JsModule("@ui5/webcomponents/dist/SegmentedButton.js")
public class Ui5SegmentedButton extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SegmentedButton.class);

	public Ui5SegmentedButton() {
		LOGGER.info("constructor ...");
		addListener(SelectionChangeEvent.class, null);
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	@DomEvent("selection-change")
	public static class SelectionChangeEvent extends ComponentEvent<Ui5SegmentedButton> {

		public SelectionChangeEvent(Ui5SegmentedButton source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("checked"));
			Notification.show("value changed to " + source.getElement().getProperty("checked"));
		}
	}

	public Registration addChangeListener(ComponentEventListener<SelectionChangeEvent> listener) {
		return addListener(SelectionChangeEvent.class, listener);
	}


}
