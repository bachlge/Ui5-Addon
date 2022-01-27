/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Switch/
 * 
 * + Label (implements HasLabel)
 * + Data binding
 * + Value Change Event
 * 
 */
package com.gork.ui5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.notification.Notification;

@SuppressWarnings("serial")
@Tag("ui5-switch")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.1.2")
@JsModule("@ui5/webcomponents/dist/Switch.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5Switch extends AbstractSinglePropertyField<Ui5Switch, Boolean> implements HasLabel {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Switch.class);

	public Ui5Switch() {
		super("value", false, false);
		LOGGER.info("constructor ...");
		this.getElement().setProperty("textOn", "Yes");
		this.getElement().setProperty("textOff", "No");
		addListener(ValueChangeEvent.class, null);
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	public void setDesign(SwitchDesign value) {
		this.getElement().setProperty("design", value.toString());
	}

	// Convenience
	public void setGraphical(Boolean graphical) {
		if (graphical) {
			setDesign(SwitchDesign.Graphical);
		} else {
			setDesign(SwitchDesign.Textual);
		}
	}

	public boolean getChecked() {
		return Boolean.getBoolean(getElement().getProperty("checked"));
	}

	public void setChecked(Boolean checked) {
		this.getElement().setProperty("checked", checked);
	}

	@DomEvent("change")
	public static class ValueChangeEvent extends ComponentEvent<Ui5Switch> {

		public ValueChangeEvent(Ui5Switch source, boolean fromClient) {
			super(source, fromClient);
			LOGGER.info("value changed to " + source.getElement().getProperty("checked"));
			Notification.show("value changed to " + source.getElement().getProperty("checked"));
		}
		
	}

	public enum SwitchDesign { Textual, Graphical }

}
