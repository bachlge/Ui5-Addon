/**
 * https://sap.github.io/ui5-webcomponents/playground/components/SegmentedButton/
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
@Tag("ui5-segmented-button-item")
@NpmPackage(value = "@ui5/webcomponents", version = "^2.12.0")
@JsModule("@ui5/webcomponents/dist/SegmentedButtonItem.js")
public class Ui5SegmentedButtonItem extends Component implements HasComponents {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5SegmentedButtonItem.class);

	public Ui5SegmentedButtonItem() {
		LOGGER.info("constructor ...");
	}

	public void setAccessibleName(String accessibleName) {
		this.getElement().setProperty("accessibleName", accessibleName);
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	public void setDisabled(Boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setIcon(String value) {
		this.getElement().setProperty("icon", value);
	}

	public void setPressed(boolean value) {
		this.getElement().setProperty("pressed", value);
	}

	@DomEvent("click")
	public static class ClickEvent extends ComponentEvent<Ui5SegmentedButtonItem> {

		public ClickEvent(Ui5SegmentedButtonItem source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("Ui5SegmentedButtonItem ClickEvent ...");
			Notification.show("clicked on Ui5SegmentedButtonItem " + source.getElement().getProperty("text"));
		}
	}

	public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
		return addListener(ClickEvent.class, listener);
	}

}
