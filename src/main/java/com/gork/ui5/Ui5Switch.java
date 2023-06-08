/**
 * https://sap.github.io/ui5-webcomponents/playground/components/Switch/
 * 
 * + Label (implements HasLabel)
 * + Data binding
 * + Value Change Event
 * 
 */
package com.gork.ui5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("ui5-switch")
@NpmPackage(value = "@ui5/webcomponents", version = "^1.14.0")
@JsModule("@ui5/webcomponents/dist/Switch.js")
@JsModule("@ui5/webcomponents/dist/features/InputElementsFormSupport.js")
public class Ui5Switch extends AbstractSinglePropertyField<Ui5Switch, Boolean> implements HasLabel, HasSize {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Switch.class);

	public Ui5Switch() {
		super("value", false, false);
		LOGGER.info("constructor ...");
		setTextOn("Yes");
		setTextOff("No");
	}

	public void setAccessibleNameRef(String accessibleNameRef) {
		this.getElement().setProperty("accessibleNameRef", accessibleNameRef);
	}

	public boolean getChecked() {
		return Boolean.getBoolean(getElement().getProperty("checked"));
	}

	public void setChecked(boolean value) {
		this.getElement().setProperty("checked", value);
	}

	/**
	 * Default: Textual
	 * @param value
	 */
	public void setDesign(SwitchDesign value) {
		this.getElement().setProperty("design", value.toString());
	}

	public enum SwitchDesign { Textual, Graphical }

	public void setDisabled(boolean value) {
		this.getElement().setProperty("disabled", value);
	}

	public void setTextOff(String value) {
		this.getElement().setProperty("textOff", value);
	}

	public void setTextOn(String value) {
		this.getElement().setProperty("textOn", value);
	}

	// For the name property to have effect, you must add the following import to your project:
	// import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";
	public void setName(String value) {
		this.getElement().setProperty("name", value);
	}

	// Convenience
	public void setGraphical(Boolean graphical) {
		if (graphical) {
			setDesign(SwitchDesign.Graphical);
		} else {
			setDesign(SwitchDesign.Textual);
		}
	}

	public Registration addChangeListener(ComponentEventListener<ChangeEvent> listener) {
		return addListener(ChangeEvent.class, listener);
	}

	@DomEvent("change")
	public static class ChangeEvent extends ComponentEvent<Ui5Switch> {

		private final boolean value;

		public ChangeEvent(Ui5Switch source, boolean fromClient,
				@EventData("element.checked") boolean value) {
			super(source, fromClient);
			this.value = value;
//			Notification.show("Ui5Switch.ChangeEvent - value changed to " + value);
		}
		public boolean getChecked() {
			return value;
		}
	}

}
